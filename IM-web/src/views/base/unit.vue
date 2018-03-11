<template>
  <div>
  <el-dialog
    :visible.sync="dialogVisible"
    width="50%"
    :before-close="close" title="新增计量单位">
    <el-form :model="unit" label-width="100px">
    <el-form-item label="库存单位代号:">
      <el-input placeholder="请输入库存单位代号" v-model="unit.code" autofocus></el-input>
    </el-form-item>
    <el-form-item label="库存单位说明:">
      <el-input placeholder="请输入库存单位说明" v-model="unit.description" @keyup.native.enter="confirm"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer">
      <el-button @click="close">取 消</el-button>
      <el-button type="primary" @click="confirm">确 定</el-button>
    </span>
  </el-dialog>
  <el-button type="success" @click="add"><i class="fa fa-plus"></i>新增</el-button>
  <el-table
    :data="units"
    border
    style="width: 100%"
    size="small">
    <el-table-column
      fixed
      align="center"
      prop="code"
      label="库存单位代号">
    </el-table-column>
    <el-table-column
      align="center"
      prop="description"
      label="库存单位说明">
    </el-table-column>
    <el-table-column
      align="center"
      fixed="right"
      label="删除"
      width="200">
      <template slot-scope="scope">
        <el-button @click="del(scope)" type="text" size="small">删除</el-button>
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
 import {getRequest, postRequest, deleteRequest} from '../../utils/axios.js'
 export default {
   methods: {
     init () {
       this.data.page = 0
       this.jump()
     },
     jump () {
       getRequest('/unitAPI/all', this.data)
         .then(resp => {
           this.units = resp.data.extend.pageInfo.content
           this.totalElements = resp.data.extend.pageInfo.totalElements
         })
         .catch(error => {
           console.log(error)
           this.$message.error('数据请求失败')
         })
     },
     add () {
       this.dialogVisible = true
     },
     close () {
       this.dialogVisible = false
     },
     confirm () {
       postRequest('/unitAPI/', this.unit)
         .then(resp => {
           this.jump()
           this.dialogVisible = false
         })
         .catch(error => {
           console.log(error)
           this.$message.error('新增单位失败')
         })
     },
     del (scope) {
       this.$confirm('此操作将永久删除, 是否继续?', '提示', {
         confirmButtonText: '确定',
         cancelButtonText: '取消',
         type: 'error'
       }).then(() => {
         deleteRequest('/unitAPI/', scope.row)
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
     currentChange (currentPage) {
       this.data.page = currentPage - 1
       this.jump()
     }
   },

   data () {
     return {
       dialogVisible: false,
       // 全部数量
       totalElements: null,
       data: {page: 0, size: 10},
       units: [],
       unit: {id: 0, code: '', description: ''}
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
</style>
