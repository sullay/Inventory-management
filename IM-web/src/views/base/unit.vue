<template>
  <div>
  <el-button-group>
    <el-button type="success"><i class="fa fa-plus"></i>新增</el-button>
    <el-button type="danger"><i class="fa fa-times"></i>删除</el-button>
  </el-button-group>
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
  </el-table>
  </div>
</template>

<script>
 import {getRequest} from '../../utils/axios.js'
 export default {
   methods: {
     init () {
       this.data = {page: 1, size: 10}
       this.jump()
     },
     jump () {
       getRequest('/unitAPI/all', this.data)
         .then(resp => {
           this.units = resp.data.extend.pageInfo.content
           this.totalPages = resp.data.extend.pageInfo.totalPages
           this.totalElements = resp.data.extend.pageInfo.totalElements
         })
         .catch(error => {
           console.log(error)
           this.$message.error('数据请求失败')
         })
     }
   },

   data () {
     return {
       // 总页数
       totalPages: '',
       // 全部数量
       totalElements: '',
       data: {page: 1, size: 10},
       units: []
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
</style>
