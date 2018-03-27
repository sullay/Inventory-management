<template>
  <div>
    <el-dialog
    :visible.sync="dialogVisible"
    width="50%"
    :before-close="close" title="采购订单信息">
    <el-form :model="PurchaseOrder" label-width="100px" size="small">
    <el-row>
    <el-col :span="12">
    <el-form-item label="采购订单编号:">
      <el-input placeholder="请输入采购订单编号" v-model="PurchaseOrder.code" autofocus>
        <template slot="prepend">{{this.prefix}}</template>
      </el-input>
    </el-form-item>
    </el-col>
    <el-col :span="12">
    <el-form-item label="供应商名称:">
      <el-input placeholder="请输入供应商名称" v-model="PurchaseOrder.supplier"></el-input>
    </el-form-item>
    </el-col>
    <el-col :span="12">
    <el-form-item label="采购员名称:">
      <el-input placeholder="请输入采购员名称" v-model="PurchaseOrder.buyer"></el-input>
    </el-form-item>
    </el-col>
    <el-col :span="12">
    <el-form-item label="备注:">
      <el-input placeholder="请输入备注" v-model="PurchaseOrder.extend"></el-input>
    </el-form-item>
    </el-col>
    </el-row>
    <el-form-item label="商品信息:" v-for="(purchaseInfo, index) in PurchaseOrder.purchaseInfos" :key="index">
      <el-row>
      <el-col :span="12">
        <el-select v-model="purchaseInfo.gid" filterable placeholder="请选择商品">
          <el-option
            v-for="item in goodsAll"
            :key="item.id"
            :label="item.code+'-'+item.name"
            :value="item.id">
          </el-option>
        </el-select>
      </el-col>
      <el-col :span="12">
        <el-date-picker
          v-model="purchaseInfo.date"
          type="date"
          placeholder="选择到货日期">
        </el-date-picker>
      </el-col>
      </el-row>
      <el-row>
      <el-col :span="8">
        <el-input placeholder="请输入订单数量" v-model="purchaseInfo.number"></el-input>
      </el-col>
      <el-col :span="8" :offset="4">
        <el-input placeholder="请输入采购价格" v-model="purchaseInfo.price"></el-input>
      </el-col>
      <el-col :span="20">
        <el-input placeholder="请输入备注" v-model="purchaseInfo.extend"></el-input>
      </el-col>
      <el-col :span="8" :offset="8">
        <el-button @click.prevent="removePurchaseInfo(purchaseInfo)" type="danger">删除</el-button>
      </el-col>
      </el-row>
    </el-form-item>
      <el-button @click.prevent="addPurchaseInfo">新增采购信息</el-button>
    </el-form>
    <span slot="footer">
      <el-button @click="close">取 消</el-button>
      <el-button type="primary" @click="confirm" v-if="isAdd">确 定</el-button>
      <el-button type="primary" @click="edit_confirm" v-else>确 定</el-button>
    </span>
    </el-dialog>
    <el-button type="success" @click="add"><i class="fa fa-plus"></i>新增</el-button>
    <el-table
    :data="PurchaseOrders"
    border
    style="width: 100%"
    size="small">
    <el-table-column
      fixed
      align="center"
      prop="code"
      label="订单编号">
    </el-table-column>
    <el-table-column
      align="center"
      prop="supplier"
      label="供应商名称">
    </el-table-column>
    <el-table-column
      align="center"
      prop="buyer"
      label="采购员">
    </el-table-column>
    <el-table-column
      align="center"
      prop="date"
      label="单据日期"
      :formatter="formatter">
    </el-table-column>
     <el-table-column
      align="center"
      prop="extend"
      label="备注">
    </el-table-column>
     <el-table-column
      align="center"
      prop="state"
      label="订单状态"
      :formatter="stateFormatter">
    </el-table-column>
    <el-table-column
      align="center"
      fixed="right"
      label="操作"
      width="200">
      <template slot-scope="scope">
        <el-button-group>
          <el-button  type="text" size="small" @click="edit(scope)">修改</el-button>
          <el-button  type="text" size="small" @click="del(scope)">删除</el-button>
        </el-button-group>
      </template>
    </el-table-column>
  </el-table>
  <el-pagination
  background
  layout="prev, pager, next"
  :total="totalElements"
  @current-change="currentChange">
  </el-pagination>
  </div>
</template>
<script>
import {formatDate} from '../../utils/formatDateTime.js'
import {getRequest, postRequest, deleteRequest, putRequest} from '../../utils/axios.js'
export default {
  data () {
    return {
      dialogVisible: false,
      // 全部数量
      totalElements: null,
      data: {page: 0, size: 10},
      PurchaseOrders: [],
      PurchaseOrder: {
        purchaseInfos: []
      },
      isAdd: true,
      prefix: '',
      goodsAll: [],
      goods: {id: 0, code: '', name: '', specification: '', goodsType: {id: '', code: '', name: '', codingPrefix: ''}, unit: {id: '', code: '', description: ''}, brand: '', price: '', max: null, min: null}
    }
  },
  methods: {
    init () {
      this.data.page = 0
      this.jump()
    },
    jump () {
      getRequest('/purchaseOrderAPI/all', this.data)
        .then(resp => {
          this.PurchaseOrders = resp.data.extend.pageInfo.content
          this.totalElements = resp.data.extend.pageInfo.totalElements
        })
        .catch(error => {
          console.log(error)
          this.$message.error('数据请求失败')
        })
      getRequest('/documentsAPI/', {name: '采购订单'})
        .then(resp => {
          this.prefix = resp.data.extend.pageInfo.prefix
        })
        .catch(error => {
          console.log(error)
          this.$message.error('数据请求失败')
        })
      getRequest('/goodsAPI/all_NoPage')
        .then(resp => {
          this.goodsAll = resp.data.extend.pageInfo
        })
        .catch(error => {
          console.log(error)
          this.$message.error('数据请求失败')
        })
    },
    currentChange (currentPage) {
      this.data.page = currentPage - 1
      this.jump()
    },
    add () {
      this.isAdd = true
      this.PurchaseOrder = {purchaseInfos: []}
      this.dialogVisible = true
    },
    close () {
      this.dialogVisible = false
      this.jump()
    },
    confirm () {
      this.PurchaseOrder.id = 0
      this.PurchaseOrder.date = new Date()
      this.PurchaseOrder.state = 'INCOMPLETE'
      this.PurchaseOrder.purchaseInfos.forEach(purchaseInfo => {
        purchaseInfo.goods = this.goods
        purchaseInfo.goods.id = purchaseInfo.gid
      })
      postRequest('/purchaseOrderAPI/', this.PurchaseOrder)
        .then(resp => {
          this.jump()
          this.dialogVisible = false
        })
        .catch(error => {
          console.log(error)
          this.$message.error('新增采购订单失败')
        })
    },
    edit_confirm () {
      putRequest('/purchaseOrderAPI/', this.PurchaseOrder)
        .then(resp => {
          this.jump()
          this.dialogVisible = false
        })
        .catch(error => {
          console.log(error)
          this.$message.error('修改采购订单失败')
        })
    },
    del (scope) {
      this.$confirm('此操作将永久删除, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'error'
      }).then(() => {
        deleteRequest('/purchaseOrderAPI/', scope.row)
          .then(resp => {
            this.jump()
            this.$message({
              type: 'success',
              message: '删除成功!'
            })
          })
          .catch(error => {
            console.log(error)
            this.$message.error('删除失败')
          })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    edit (scope) {
      this.isAdd = false
      this.PurchaseOrder = scope.row
      this.dialogVisible = true
    },
    formatter (row, column, cellValue) {
      return formatDate(cellValue)
    },
    stateFormatter (row, column, cellValue) {
      if (cellValue === 'INVALID') {
        return '报废'
      } else if (cellValue === 'INCOMPLETE') {
        return '未完成'
      } else {
        return '已完成'
      }
    },
    removePurchaseInfo (item) {
      var index = this.PurchaseOrder.purchaseInfos.indexOf(item)
      if (index !== -1) {
        this.PurchaseOrder.purchaseInfos.splice(index, 1)
      }
    },
    addPurchaseInfo () {
      this.PurchaseOrder.purchaseInfos.push({

      })
    }
  },
  mounted () {
    this.init()
  }
}
</script>
<style scoped>
  div{
    text-align: left
  }
  .el-pagination{
    margin-top: 30px;
    text-align: center;
  }
  .el-button-group .el-button{
    margin-left: 15px;
    margin-right: 15px
  }
  .el-input{}
</style>