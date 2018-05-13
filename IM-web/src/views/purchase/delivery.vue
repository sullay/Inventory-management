<template>
  <div>
    <el-table
    :data="deliverys"
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
      align="center"
      prop="code"
      label="退货单号"
      :formatter="Dcode_formatter">
    </el-table-column>
    <el-table-column
      align="center"
      prop="purchaseOrder.code"
      label="采购订单号"
      :formatter="code_formatter">
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
      deliverys: [],
      prefix: '',
      deliveryPrefix: ''
    }
  },
  methods: {
    init () {
      this.data.page = 0
      this.jump()
    },
    jump () {
      getRequest('/purchaseDeliveryAPI/all', this.data)
        .then(resp => {
          this.deliverys = resp.data.extend.pageInfo.content
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
      getRequest('/documentsAPI/', {name: '采购退货单'})
        .then(resp => {
          this.deliveryPrefix = resp.data.extend.pageInfo.prefix
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
    },
    code_formatter (row, column, cellValue) {
      return this.prefix + cellValue
    },
    Dcode_formatter (row, column, cellValue) {
      return this.deliveryPrefix + cellValue
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