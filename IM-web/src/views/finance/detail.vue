<template>
  <div>
    <el-table
    :data="details"
    border
    style="width: 100%"
    size="small">
    <el-table-column
      fixed
      align="center"
      prop="date"
      label="日期"
      :formatter="formatter">
    </el-table-column>
    <el-table-column
      fixed
      align="center"
      prop="code"
      label="交易单号">
    </el-table-column>
    <el-table-column
      align="center"
      prop="trader"
      label="交易商">
    </el-table-column>
    <el-table-column
      align="center"
      prop="income"
      label="收入金额">
    </el-table-column>
    <el-table-column
      align="center"
      prop="pay"
      label="支出金额">
    </el-table-column>
    <el-table-column
      align="center"
      prop="type"
      label="交易类型">
    </el-table-column>
    <el-table-column
      align="center"
      prop="extend"
      label="备注">
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
import {getRequest} from '../../utils/axios.js'
import {formatDateTime} from '../../utils/formatDateTime.js'
export default {
  data () {
    return {
      // 全部数量
      totalElements: null,
      data: {page: 0, size: 10},
      details: []
    }
  },
  methods: {
    init () {
      this.data.page = 0
      this.jump()
    },
    jump () {
      getRequest('/detailAPI/all', this.data)
        .then(resp => {
          this.details = resp.data.extend.pageInfo.content
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
    formatter (row, column, cellValue) {
      return formatDateTime(cellValue)
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