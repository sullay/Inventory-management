<template>
  <div>
    <el-dialog
    :visible.sync="receiptDialogVisible"
    width="50%"
    :before-close="Rclose" title="采购入库单">
      <el-form :model="purchaseReceipt" label-width="100px" size="small">
        <el-row>
          <el-col :span="12">
          <el-form-item label="采购订单编号:">
            <el-input placeholder="请输入采购订单编号" v-model="purchaseReceipt.purchaseOrder.code" disabled>
              <template slot="prepend">{{this.prefix}}</template>
            </el-input>
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="采购入库单编号:">
            <el-input placeholder="请输入采购入库单编号" v-model="purchaseReceipt.code" autofocus>
              <template slot="prepend">{{this.receiptPrefix}}</template>
            </el-input>
          </el-form-item>
          </el-col>
        </el-row>
        <div v-for="purchaseInfo in purchaseReceipt.purchaseOrder.purchaseInfos" :key="purchaseInfo.id">
          <el-form-item label="商品信息:">
            <el-row>
            <el-col :span="12">
              <el-select v-model="purchaseInfo.goods.id" filterable placeholder="请选择商品" disabled>
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
                placeholder="选择到货日期" disabled>
              </el-date-picker>
            </el-col>
            </el-row>
            <el-row>
            <el-col :span="8">
              <el-input placeholder="请输入订单数量" v-model.number="purchaseInfo.number" disabled>
                <template slot="prepend">订单数量</template>
              </el-input>
            </el-col>
            <el-col :span="8" :offset="4">
              <el-input placeholder="请输入到货数量" v-model.number="purchaseInfo.arrivals" disabled>
                <template slot="prepend">到货数量</template>
              </el-input>
            </el-col>
            <el-col :span="8">
              <el-input placeholder="请输入入库数量" v-model.number="purchaseInfo.num">
                <template slot="prepend">入库数量</template>
              </el-input>
            </el-col>
            <el-col :span="8" :offset="4">
              <el-select v-model="purchaseInfo.wid" filterable placeholder="请选择仓库">
                <el-option
                  v-for="item in warehouses"
                  :key="item.id"
                  :label="item.code+'-'+item.name"
                  :value="item.id">
                </el-option>
              </el-select>
            </el-col>
            </el-row>
          </el-form-item>
        </div>
        <el-form-item label="备注">
          <el-input placeholder="请输入备注" v-model="purchaseReceipt.extend"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer">
        <el-button @click="Rclose">取 消</el-button>
        <el-button type="primary" @click="receipt_confirm">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog
    :visible.sync="dialogVisible"
    width="50%"
    :before-close="close" title="采购订单信息">
    <el-form :model="purchaseOrder" label-width="100px" size="small">
    <el-row>
    <el-col :span="12">
    <el-form-item label="采购订单编号:">
      <el-input placeholder="请输入采购订单编号" v-model="purchaseOrder.code" autofocus>
        <template slot="prepend">{{this.prefix}}</template>
      </el-input>
    </el-form-item>
    </el-col>
    <el-col :span="12">
    <el-form-item label="供应商名称:">
      <el-input placeholder="请输入供应商名称" v-model="purchaseOrder.supplier"></el-input>
    </el-form-item>
    </el-col>
    <el-col :span="12">
    <el-form-item label="采购员名称:">
      <el-input placeholder="请输入采购员名称" v-model="purchaseOrder.buyer"></el-input>
    </el-form-item>
    </el-col>
    <el-col :span="12">
    <el-form-item label="备注:">
      <el-input placeholder="请输入备注" v-model="purchaseOrder.extend"></el-input>
    </el-form-item>
    </el-col>
    </el-row>
    <div v-for="purchaseInfo in purchaseOrder.purchaseInfos" :key="purchaseInfo.id">
    <el-form-item label="商品信息:">
      <el-row>
      <el-col :span="12">
        <el-select v-model="purchaseInfo.goods.id" filterable placeholder="请选择商品">
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
        <el-input placeholder="请输入订单数量" v-model.number="purchaseInfo.number">
          <template slot="prepend">数量</template>
        </el-input>
      </el-col>
      <el-col :span="8" :offset="4">
        <el-input placeholder="请输入采购价格" v-model.number="purchaseInfo.price">
          <template slot="prepend">价格</template>
        </el-input>
      </el-col>
      <el-col :span="20">
        <el-input placeholder="请输入备注" v-model="purchaseInfo.extend">
          <template slot="prepend">备注</template>
        </el-input>
      </el-col>
      <el-col :span="8" :offset="8">
        <el-button @click.prevent="removepurchaseInfo(purchaseInfo)" type="danger">删除</el-button>
      </el-col>
      </el-row>
    </el-form-item>
    </div>
      <el-button @click.prevent="addpurchaseInfo" type="success">新增采购信息</el-button>
    </el-form>
    <span slot="footer">
      <el-button @click="close">取 消</el-button>
      <el-button type="primary" @click="confirm" v-if="isAdd">确 定</el-button>
      <el-button type="primary" @click="edit_confirm" v-else>确 定</el-button>
    </span>
    </el-dialog>
    <el-button type="success" @click="add"><i class="fa fa-plus"></i>新增</el-button>
    <el-table
    :data="purchaseOrders"
    border
    style="width: 100%"
    size="small">
    <el-table-column
      fixed
      align="center"
      prop="code"
      label="订单编号"
      :formatter="code_formatter">
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
          <el-button  type="text" size="small" @click="receipt(scope)">入库</el-button>
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
      receiptDialogVisible: false,
      dialogVisible: false,
      // 全部数量
      totalElements: null,
      data: {page: 0, size: 10},
      purchaseOrders: [],
      purchaseOrder: {
        purchaseInfos: []
      },
      isAdd: true,
      prefix: '',
      receiptPrefix: '',
      goodsAll: [],
      warehouses: [],
      goods: {id: 0, code: '', name: '', specification: '', goodsType: {id: '', code: '', name: '', codingPrefix: ''}, unit: {id: '', code: '', description: ''}, brand: '', price: '', max: null, min: null},
      purchaseReceipt: {
        purchaseOrder: {
          purchaseInfos: []
        },
        waters: []
      }
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
          this.purchaseOrders = resp.data.extend.pageInfo.content
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
      getRequest('/documentsAPI/', {name: '采购入库单'})
        .then(resp => {
          this.receiptPrefix = resp.data.extend.pageInfo.prefix
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
      getRequest('/warehouseAPI/all_NoPage')
        .then(resp => {
          this.warehouses = resp.data.extend.pageInfo
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
      this.purchaseOrder = {purchaseInfos: [{goods: {id: null}}]}
      this.dialogVisible = true
    },
    close () {
      this.dialogVisible = false
      this.jump()
    },
    Rclose () {
      this.receiptDialogVisible = false
      this.jump()
    },
    confirm () {
      this.purchaseOrder.id = 0
      this.purchaseOrder.date = new Date()
      this.purchaseOrder.state = 'INCOMPLETE'
      this.purchaseOrder.payable = {
        id: 0,
        code: this.prefix + this.purchaseOrder.code,
        amountPaid: 0,
        amount: 0,
        state: 'INCOMPLETE',
        extend: this.purchaseOrder.extend,
        date: new Date(),
        dealer: this.purchaseOrder.supplier}
      this.purchaseOrder.purchaseInfos.forEach(purchaseInfo => {
        this.purchaseOrder.payable.amount += purchaseInfo.price * purchaseInfo.number
      })
      postRequest('/purchaseOrderAPI/', this.purchaseOrder)
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
      this.purchaseOrder.payable.code = this.prefix + this.purchaseOrder.code
      this.purchaseOrder.payable.extend = this.purchaseOrder.extend
      this.purchaseOrder.payable.dealer = this.purchaseOrder.supplier
      this.purchaseOrder.payable.amount = 0
      this.purchaseOrder.purchaseInfos.forEach(purchaseInfo => {
        this.purchaseOrder.payable.amount += purchaseInfo.price * purchaseInfo.number
      })
      if (this.purchaseOrder.payable.amountPaid >= this.purchaseOrder.payable.amount) {
        this.purchaseOrder.payable.state = 'COMPLETE'
      } else {
        this.purchaseOrder.payable.state = 'INCOMPLETE'
      }
      putRequest('/purchaseOrderAPI/', this.purchaseOrder)
        .then(resp => {
          this.jump()
          this.dialogVisible = false
        })
        .catch(error => {
          console.log(error)
          this.$message.error('修改采购订单失败')
        })
    },
    receipt_confirm () {
      this.purchaseReceipt.date = new Date()
      this.purchaseReceipt.waters = []
      this.purchaseReceipt.purchaseOrder.purchaseInfos.forEach(purchaseInfo => {
        purchaseInfo.arrivals += purchaseInfo.num
        this.purchaseReceipt.waters.push({
          documentName: '采购入库单',
          documentCode: this.receiptPrefix + this.purchaseReceipt.code,
          date: this.purchaseReceipt.date,
          receiptNum: purchaseInfo.num,
          deliveryNum: 0,
          stock: {
            goods: {id: purchaseInfo.goods.id, code: '', name: '', specification: '', goodsType: {id: '', code: '', name: '', codingPrefix: ''}, unit: {id: '', code: '', description: ''}, brand: '', price: '', max: null, min: null},
            warehouse: {id: purchaseInfo.wid, code: '', name: '', place: '', extend: ''}
          }
        })
      })
      this.purchaseReceipt.purchaseOrder.state = 'COMPLETE'
      this.purchaseReceipt.purchaseOrder.purchaseInfos.forEach(purchaseInfo => {
        if (purchaseInfo.arrivals < purchaseInfo.number) {
          this.purchaseReceipt.purchaseOrder.state = 'INCOMPLETE'
        }
      })
      putRequest('/purchaseOrderAPI/', this.purchaseReceipt.purchaseOrder)
        .then(resp => {
          console.log(this.purchaseReceipt)
          postRequest('/purchaseReceiptAPI/', this.purchaseReceipt)
            .then(resp => {
              this.jump()
              this.receiptDialogVisible = false
            })
            .catch(error => {
              console.log(error)
              this.$message.error('创建采购入库单失败,请检查单号是否重复')
            })
        })
        .catch(error => {
          console.log(error)
          this.$message.error('修改采购订单失败，请检查单号是否重复')
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
      this.purchaseOrder = scope.row
      this.dialogVisible = true
    },
    receipt (scope) {
      this.purchaseReceipt.purchaseOrder = scope.row
      this.receiptDialogVisible = true
    },
    formatter (row, column, cellValue) {
      return formatDate(cellValue)
    },
    code_formatter (row, column, cellValue) {
      return this.prefix + cellValue
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
    removepurchaseInfo (item) {
      var index = this.purchaseOrder.purchaseInfos.indexOf(item)
      if (index !== -1) {
        this.purchaseOrder.purchaseInfos.splice(index, 1)
      }
    },
    addpurchaseInfo () {
      this.purchaseOrder.purchaseInfos.push({
        goods: {id: null}
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
</style>