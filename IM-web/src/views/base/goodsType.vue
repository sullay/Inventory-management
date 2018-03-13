<template>
  <div>
    <el-dialog
    :visible.sync="dialogVisible"
    width="50%"
    :before-close="close" title="商品种类信息">
    <el-form :model="goodsType" label-width="100px">
    <el-form-item label="商品种类代号:">
      <el-input placeholder="请输入商品种类代号" v-model="goodsType.code" autofocus></el-input>
    </el-form-item>
    <el-form-item label="商品种类名称:">
      <el-input placeholder="请输入商品种类名称" v-model="goodsType.name"></el-input>
    </el-form-item>
    <el-form-item label="编码前缀:">
      <el-input placeholder="请输入编码前缀" v-model="goodsType.codingPrefix"  @keyup.native.enter="confirm" v-if="isAdd"></el-input>
      <el-input placeholder="请输入编码前缀" v-model="goodsType.codingPrefix"  @keyup.native.enter="edit_confirm" v-else></el-input>
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
    :data="goodsTypes"
    border
    style="width: 100%"
    size="small">
    <el-table-column
      fixed
      align="center"
      prop="code"
      label="商品种类代号">
    </el-table-column>
    <el-table-column
      align="center"
      prop="name"
      label="商品种类名称">
    </el-table-column>
    <el-table-column
      align="center"
      prop="codingPrefix"
      label="编码前缀">
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
      goodsTypes: [],
      goodsType: {id: 0, code: '', name: '', codingPrefix: ''},
      isAdd: true
    }
  },
  methods: {
    init () {
      this.data.page = 0
      this.jump()
    },
    jump () {
      getRequest('/goodsTypeAPI/all', this.data)
        .then(resp => {
          this.goodsTypes = resp.data.extend.pageInfo.content
          this.totalElements = resp.data.extend.pageInfo.totalElements
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
      this.goodsType.id = 0
      postRequest('/goodsTypeAPI/', this.goodsType)
        .then(resp => {
          this.jump()
          this.dialogVisible = false
        })
        .catch(error => {
          console.log(error)
          this.$message.error('新增商品种类失败，请检查商品种类代号与编码前缀是否重复')
        })
    },
    edit_confirm () {
      putRequest('/goodsTypeAPI/', this.goodsType)
        .then(resp => {
          this.dialogVisible = false
        })
        .catch(error => {
          console.log(error)
          this.$message.error('修改商品种类信息失败，请检查商品种类代号与编码前缀是否重复')
        })
    },
    del (scope) {
      this.$confirm('此操作将永久删除, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'error'
      }).then(() => {
        deleteRequest('/goodsTypeAPI/', scope.row)
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
      this.goodsType = scope.row
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