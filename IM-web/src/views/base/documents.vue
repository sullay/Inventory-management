<template>
  <div>
  <el-dialog
    :visible.sync="dialogVisible"
    width="30%"
    :before-close="init()">
    <el-input v-model="document.prefix" :placeholder="document.name" @keyup.native.enter="confirm"></el-input>
    <span slot="footer" class="dialog-footer">
      <el-button @click="dialogVisible = false">取 消</el-button>
      <el-button type="primary" @click="confirm">确 定</el-button>
    </span>
  </el-dialog>

  <el-table
    :data="documents"
    border
    style="width: 100%"
    size="small">
    <el-table-column
      fixed
      align="center"
      prop="name"
      label="单据名称">
    </el-table-column>
    <el-table-column
      align="center"
      prop="prefix"
      label="单据字头">
    </el-table-column>
    <el-table-column
      align="center"
      fixed="right"
      label="字头修改"
      width="200">
      <template slot-scope="scope">
        <el-button @click="edit(scope)" type="text" size="small">修改</el-button>
      </template>
    </el-table-column>
  </el-table>
  </div>
</template>

<script>
 import {getRequest, putRequest} from '../../utils/axios.js'
 export default {
   methods: {
     edit (scope) {
       this.document = scope.row
       this.dialogVisible = true
     },
     init () {
       getRequest('/documentsAPI/all', '')
         .then(resp => {
           this.documents = resp.data.extend.pageInfo
         })
         .catch(error => {
           console.log(error)
           this.$message.error('数据请求失败')
         })
     },
     confirm () {
       putRequest('/documentsAPI/', this.document)
         .then(resp => {
           this.dialogVisible = false
         })
         .catch(error => {
           console.log(error)
           this.$message.error('修改失败')
           this.dialogVisible = false
         })
     }
   },

   data () {
     return {
       documents: [],
       dialogVisible: false,
       document: {id: '', name: '', prefix: ''}
     }
   },

   created () {
     this.init()
   }
}
</script>
<style scoped>

</style>
