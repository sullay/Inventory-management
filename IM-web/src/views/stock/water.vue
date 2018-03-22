<template>
  <div>
    <el-table
    :data="waters"
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
      prop="documentCode"
      label="单据编号">
    </el-table-column>
    <el-table-column
      align="center"
      prop="documentName"
      label="单据名称">
    </el-table-column>
    <el-table-column
      align="center"
      prop="stock.goods.name"
      label="商品名称">
    </el-table-column>
    <el-table-column
      align="center"
      prop="stock.warehouse.name"
      label="仓库名称">
    </el-table-column>
    <el-table-column
      align="center"
      prop="receiptNum"
      label="入库数量">
    </el-table-column>
    <el-table-column
      align="center"
      prop="deliveryNum"
      label="出库数量">
    </el-table-column>
    <el-table-column
      align="center"
      prop="stock.number"
      label="当前数量">
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
      waters: []
    }
  },
  methods: {
    init () {
      this.data.page = 0
      this.jump()
    },
    jump () {
      getRequest('/waterAPI/all', this.data)
        .then(resp => {
          this.waters = resp.data.extend.pageInfo.content
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