<template>
  <div>
    <el-dialog
    :visible.sync="dialogVisible"
    width="30%"
    :before-close="close" title="商品信息">
    <el-form :model="goods" label-width="100px" size="small">
    <el-form-item label="商品编号:">
      <el-input placeholder="请输入商品编号" v-model="goods.code" autofocus></el-input>
    </el-form-item>
    <el-form-item label="商品名称:">
      <el-input placeholder="请输入商品名称" v-model="goods.name"></el-input>
    </el-form-item>
    <el-form-item label="商品规格:">
      <el-input placeholder="请输入商品规格" v-model="goods.specification"></el-input>
    </el-form-item>
    <el-form-item label="商品种类:">
      <el-select v-model="goods.goodsType.id" filterable placeholder="请选择">
        <el-option
          v-for="item in goodsTypes"
          :key="item.id"
          :label="item.name"
          :value="item.id">
        </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="库存单位:">
      <el-select v-model="goods.unit.id" filterable placeholder="请选择">
        <el-option
          v-for="item in units"
          :key="item.id"
          :label="item.code"
          :value="item.id">
        </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="品牌:">
      <el-input placeholder="请输入品牌" v-model="goods.brand"></el-input>
    </el-form-item>
    <el-form-item label="最大数量:">
    <el-input placeholder="请输入最大数量" v-model.number="goods.max"></el-input>
    </el-form-item>
    <el-form-item label="最小数量:">
    <el-input placeholder="请输入最小数量" v-model.number="goods.min"></el-input>
    </el-form-item>
    <el-form-item label="商品单价:">
      <el-input placeholder="请输入商品单价" v-model.number="goods.price"  @keyup.native.enter="confirm" v-if="isAdd"></el-input>
      <el-input placeholder="请输入商品单价" v-model.number="goods.price"  @keyup.native.enter="edit_confirm" v-else></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer">
      <el-button @click="close">取 消</el-button>
      <el-button type="primary" @click="confirm" v-if="isAdd">确 定</el-button>
      <el-button type="primary" @click="edit_confirm" v-else>确 定</el-button>
    </span>
    </el-dialog>
    <el-button type="success" @click="add"><i class="fa fa-plus"></i>新增</el-button>
    <el-table
    :data="allGoods"
    border
    style="width: 100%"
    size="small">
    <el-table-column
      fixed
      align="center"
      prop="code"
      label="商品编号">
    </el-table-column>
    <el-table-column
      align="center"
      prop="name"
      label="商品名称">
    </el-table-column>
    <el-table-column
      align="center"
      prop="specification"
      label="商品规格">
    </el-table-column>
    <el-table-column
      align="center"
      prop="goodsType.name"
      label="商品种类">
    </el-table-column>
    <el-table-column
      align="center"
      prop="unit.code"
      label="库存单位">
    </el-table-column>
     <el-table-column
      align="center"
      prop="brand"
      label="品牌">
    </el-table-column>
     <el-table-column
      align="center"
      prop="price"
      label="商品单价">
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
import {getRequest, postRequest, deleteRequest, putRequest} from '../../utils/axios.js'
export default {
  data () {
    return {
      dialogVisible: false,
      // 全部数量
      totalElements: null,
      data: {page: 0, size: 10},
      allGoods: [],
      goods: {id: 0, code: '', name: '', specification: '', goodsType: {id: '', code: '', name: '', codingPrefix: ''}, unit: {id: '', code: '', description: ''}, brand: '', price: '', max: null, min: null},
      isAdd: true,
      goodsTypes: [],
      units: []
    }
  },
  methods: {
    init () {
      this.data.page = 0
      this.jump()
    },
    jump () {
      getRequest('/goodsAPI/all', this.data)
        .then(resp => {
          this.allGoods = resp.data.extend.pageInfo.content
          this.totalElements = resp.data.extend.pageInfo.totalElements
        })
        .catch(error => {
          console.log(error)
          this.$message.error('数据请求失败')
        })
      getRequest('/goodsTypeAPI/all_NoPage')
        .then(resp => {
          this.goodsTypes = resp.data.extend.pageInfo
        })
        .catch(error => {
          console.log(error)
          this.$message.error('数据请求失败')
        })
      getRequest('/unitAPI/all_NoPage')
        .then(resp => {
          this.units = resp.data.extend.pageInfo
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
      this.dialogVisible = true
    },
    close () {
      this.dialogVisible = false
      this.jump()
    },
    confirm () {
      if (this.goods.min > this.goods.max) {
        this.$message.error('商品最小数量不能大于最大数量')
      } else {
        this.goods.id = 0
        postRequest('/goodsAPI/', this.goods)
          .then(resp => {
            this.jump()
            this.dialogVisible = false
          })
          .catch(error => {
            console.log(error)
            this.$message.error('新增商品失败，商品编号不能重复')
          })
      }
    },
    edit_confirm () {
      if (this.goods.min > this.goods.max) {
        this.$message.error('商品最小数量不能大于最大数量')
      } else {
        putRequest('/goodsAPI/', this.goods)
          .then(resp => {
            this.jump()
            this.dialogVisible = false
          })
          .catch(error => {
            console.log(error)
            this.$message.error('修改商品失败，商品编号不能重复')
          })
      }
    },
    del (scope) {
      this.$confirm('此操作将永久删除, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'error'
      }).then(() => {
        deleteRequest('/goodsAPI/', scope.row)
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
      this.goods = scope.row
      this.dialogVisible = true
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