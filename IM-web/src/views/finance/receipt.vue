<template>
  <div>
    <el-dialog
    :visible.sync="dialogVisible"
    width="50%"
    :before-close="close" title="收款信息">
    <el-form :model="receipt" label-width="100px">
    <el-form-item label="应收款单号:">
      <el-input placeholder="请输入应收款单号" v-model="receipt.receivables.code" disabled></el-input>
    </el-form-item>
    <el-form-item label="付款金额:">
      <el-input placeholder="请输入收款金额" v-model.number="receipt.amount" autofocus></el-input>
    </el-form-item>
    <el-form-item label="备注:">
      <el-input placeholder="请输入备注" v-model="receipt.extend"  @keyup.native.enter="edit_confirm"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer">
      <el-button @click="close">取 消</el-button>
      <el-button type="primary" @click="edit_confirm">确 定</el-button>
    </span>
    </el-dialog>
    <el-table
    :data="receipts"
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
      prop="receivables.code"
      label="应收款单号">
    </el-table-column>
    <el-table-column
      align="center"
      prop="amount"
      label="收款金额">
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
import {getRequest, deleteRequest, putRequest} from '../../utils/axios.js'
import {formatDateTime} from '../../utils/formatDateTime.js'
export default {
  data () {
    return {
      dialogVisible: false,
      // 全部数量
      totalElements: null,
      data: {page: 0, size: 10},
      receipts: [],
      receipt: {
        id: 0,
        receivables: {id: 0,
          code: '',
          amountReceived: 0,
          amount: 0,
          state: '',
          extend: ''},
        detail: {id: 0, date: 0, code: '', trader: '', income: 0, pay: 0, type: '', extend: ''},
        date: 0,
        amount: 0,
        extend: ''
      },
      price: 0
    }
  },
  methods: {
    init () {
      this.data.page = 0
      this.jump()
    },
    jump () {
      getRequest('/financeReceiptAPI/all', this.data)
        .then(resp => {
          this.receipts = resp.data.extend.pageInfo.content
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
    close () {
      this.dialogVisible = false
      this.jump()
    },
    edit_confirm () {
      this.receipt.receivables.amountReceived = this.receipt.receivables.amountReceived - this.price + this.receipt.amount
      this.receipt.date = new Date()
      if (this.receipt.receivables.amountReceived >= this.receipt.receivables.amount) {
        this.receipt.receivables.state = 'COMPLETE'
      } else {
        this.receipt.receivables.state = 'INCOMPLETE'
      }
      this.receipt.detail.date = this.receipt.date
      this.receipt.detail.extend = this.receipt.extend
      this.receipt.detail.pay = 0
      this.receipt.detail.income = this.receipt.amount
      putRequest('/financeReceiptAPI/', this.receipt)
        .then(resp => {
          this.jump()
          this.dialogVisible = false
        })
        .catch(error => {
          console.log(error)
          this.$message.error('修改支付记录失败')
        })
    },
    del (scope) {
      this.$confirm('此操作将永久删除, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'error'
      }).then(() => {
        scope.row.receivables.amountReceived = scope.row.receivables.amountReceived - scope.row.amount
        if (scope.row.receivables.amountReceived >= scope.row.receivables.amount) {
          scope.row.receivables.state = 'COMPLETE'
        } else {
          scope.row.receivables.state = 'INCOMPLETE'
        }
        putRequest('/financeReceiptAPI/', scope.row)
          .then(resp => {
            deleteRequest('/financeReceiptAPI/', scope.row)
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
          })
          .catch(error => {
            console.log(error)
            this.$message.error('修改收款记录失败')
          })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    edit (scope) {
      this.receipt = scope.row
      this.price = this.receipt.amount
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