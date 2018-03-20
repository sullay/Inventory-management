<template>
  <div>
    <el-table
    :data="stocks"
    border
    style="width: 100%"
    size="small">
    <el-table-column
      fixed
      align="center"
      prop="goods.code"
      label="商品编号">
    </el-table-column>
    <el-table-column
      align="center"
      prop="goods.name"
      label="商品名称">
    </el-table-column>
    <el-table-column
      align="center"
      prop="warehouse.name"
      label="仓库名称">
    </el-table-column>
    <el-table-column
      align="center"
      prop="goods.specification"
      label="商品规格">
    </el-table-column>
    <el-table-column
      align="center"
      prop="goods.brand"
      label="商品品牌">
    </el-table-column>
    <el-table-column
      align="center"
      prop="goods.price"
      label="商品单价">
    </el-table-column>
    <el-table-column
      align="center"
      prop="number"
      label="当前库存">
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
export default {
  data () {
    return {
      // 全部数量
      totalElements: null,
      data: {page: 0, size: 10},
      stocks: []
    }
  },
  methods: {
    init () {
      this.data.page = 0
      this.jump()
    },
    jump () {
      getRequest('/stockAPI/all', this.data)
        .then(resp => {
          this.stocks = resp.data.extend.pageInfo.content
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