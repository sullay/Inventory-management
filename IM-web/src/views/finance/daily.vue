<template>
  <div>
    <el-dialog
    :visible.sync="dialogVisible"
    width="30%"
    :before-close="close" title="仓库信息">
    <el-form :model="daily" label-width="100px">
    <el-form-item label="收支类型:">
      <el-select v-model="daily.type" filterable placeholder="请输入收支类型" autofocus>
        <el-option
          v-for="item in type"
          :key="item"
          :label="item"
          :value="item">
        </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="交易商:">
      <el-input placeholder="请输入交易商" v-model="daily.trader"></el-input>
    </el-form-item>
    <el-form-item label="金额:">
      <el-input placeholder="请输入金额" v-model.number="daily.amount"></el-input>
    </el-form-item>
    <el-form-item label="备注:">
      <el-input placeholder="请输入仓库备注" v-model="daily.extend"  @keyup.native.enter="confirm" v-if="isAdd"></el-input>
      <el-input placeholder="请输入仓库备注" v-model="daily.extend"  @keyup.native.enter="edit_confirm" v-else></el-input>
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
    :data="dailys"
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
      prop="type"
      label="收支类型">
    </el-table-column>
    <el-table-column
      align="center"
      prop="trader"
      label="交易商">
    </el-table-column>
    <el-table-column
      align="center"
      prop="amount"
      label="金额">
    </el-table-column>
     <el-table-column
      align="center"
      prop="extend"
      label="备注">
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
import {formatDateTime} from '../../utils/formatDateTime.js'
export default {
  data () {
    return {
      dialogVisible: false,
      // 全部数量
      totalElements: null,
      data: {page: 0, size: 10},
      dailys: [],
      daily: {id: 0, type: '', trader: '', amount: '', extend: '', date: 0, detail: {id: 0, date: 0, code: '', trader: '', income: 0, pay: 0, type: '', extend: ''}},
      isAdd: true,
      type: ['收入', '支出']
    }
  },
  methods: {
    init () {
      this.data.page = 0
      this.jump()
    },
    jump () {
      getRequest('/dailyAPI/all', this.data)
        .then(resp => {
          this.dailys = resp.data.extend.pageInfo.content
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
      this.daily.id = 0
      this.daily.date = new Date()
      this.daily.detail.id = 0
      this.daily.detail.date = this.daily.date
      this.daily.detail.code = ''
      this.daily.detail.trader = this.daily.trader
      this.daily.detail.type = '日常收支'
      this.daily.detail.extend = this.daily.extend
      if (this.daily.type === '收入') {
        this.daily.detail.income = this.daily.amount
        this.daily.detail.pay = 0
      } else {
        this.daily.detail.pay = this.daily.amount
        this.daily.detail.income = 0
      }
      postRequest('/dailyAPI/', this.daily)
        .then(resp => {
          this.jump()
          this.dialogVisible = false
        })
        .catch(error => {
          console.log(error)
          this.$message.error('新增日常收支失败')
        })
    },
    edit_confirm () {
      this.daily.date = new Date()
      this.daily.detail.date = this.daily.date
      this.daily.detail.code = ''
      this.daily.detail.trader = this.daily.trader
      this.daily.detail.type = '日常收支'
      this.daily.detail.extend = this.daily.extend
      if (this.daily.type === '收入') {
        this.daily.detail.income = this.daily.amount
        this.daily.detail.pay = 0
      } else {
        this.daily.detail.pay = this.daily.amount
        this.daily.detail.income = 0
      }
      putRequest('/dailyAPI/', this.daily)
        .then(resp => {
          this.jump()
          this.dialogVisible = false
        })
        .catch(error => {
          console.log(error)
          this.$message.error('修改日常收支失败')
        })
    },
    del (scope) {
      this.$confirm('此操作将永久删除, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'error'
      }).then(() => {
        deleteRequest('/dailyAPI/', scope.row)
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
      this.daily = scope.row
      this.dialogVisible = true
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