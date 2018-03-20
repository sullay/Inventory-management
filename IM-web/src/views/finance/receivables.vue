<template>
  <div>
   <el-dialog
    :visible.sync="dialogVisible"
    width="30%"
    :before-close="close" title="收款信息">
    <el-form :model="receipt" label-width="100px">
    <el-form-item label="应收款单号:">
      <el-input placeholder="请输入应收款单号" v-model="receipt.receivable.code" disabled></el-input>
    </el-form-item>
    <el-form-item label="付款金额:">
      <el-input placeholder="请输入付款金额" v-model.number="receipt.amount" autofocus></el-input>
    </el-form-item>
    <el-form-item label="备注:">
      <el-input placeholder="请输入备注" v-model="receipt.extend"  @keyup.native.enter="confirm"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer">
      <el-button @click="close">取 消</el-button>
      <el-button type="primary" @click="confirm">确 定</el-button>
    </span>
    </el-dialog>
    <el-table
    :data="receivables"
    border
    style="width: 100%"
    size="small">
    <el-table-column
      fixed
      align="center"
      prop="date"
      label="日期"
      :formatter="dateFormatter">
    </el-table-column>
    <el-table-column
      align="center"
      prop="code"
      label="应收款单号">
    </el-table-column>
    <el-table-column
      align="center"
      prop="dealer"
      label="交易商">
    </el-table-column>
    <el-table-column
      align="center"
      prop="amount"
      label="总金额">
    </el-table-column>
    <el-table-column
      align="center"
      prop="amountReceived"
      label="已收金额">
    </el-table-column>
    <el-table-column
      align="center"
      prop="state"
      label="账单状态"
      :formatter="stateFormatter">
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
          <el-button  type="text" size="small" @click="toReceive(scope)">收款</el-button>
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
import {getRequest, postRequest} from '../../utils/axios.js'
import {formatDateTime} from '../../utils/formatDateTime.js'
export default {
  data () {
    return {
      dialogVisible: false,
      // 全部数量
      totalElements: null,
      data: {page: 0, size: 10},
      receivables: [],
      receivable: {id: 0,
        code: '',
        amountReceived: 0,
        amount: 0,
        state: '',
        extend: '',
        date: 0,
        dealer: ''},
      receipt: {
        id: 0,
        receivable: {id: 0,
          code: '',
          amountReceived: 0,
          amount: 0,
          state: '',
          extend: '',
          date: 0,
          dealer: ''},
        detail: {id: 0, date: 0, code: '', trader: '', income: 0, pay: 0, type: '', extend: ''},
        date: 0,
        amount: 0,
        extend: ''
      }
    }
  },
  methods: {
    init () {
      this.data.page = 0
      this.jump()
    },
    jump () {
      getRequest('/receivableAPI/all', this.data)
        .then(resp => {
          this.receivables = resp.data.extend.pageInfo.content
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
    toReceive (scope) {
      this.receivable = scope.row
      this.receipt.receivable = this.receivable
      this.dialogVisible = true
    },

    dateFormatter (row, column, cellValue) {
      return formatDateTime(cellValue)
    },
    stateFormatter (row, column, cellValue) {
      if (cellValue === 'INVALID') {
        return '报废'
      } else if (cellValue === 'INCOMPLETE') {
        return '未付清'
      } else {
        return '已付清'
      }
    },
    confirm () {
      this.receipt.id = 0
      this.receipt.receivable.amountReceived = this.receipt.receivable.amountReceived + this.receipt.amount
      this.receipt.date = new Date()
      if (this.receipt.receivable.amountReceived >= this.receipt.receivable.amount) {
        this.receipt.receivable.state = 'COMPLETE'
      } else {
        this.receipt.receivable.state = 'INCOMPLETE'
      }
      this.receipt.detail.id = 0
      this.receipt.detail.code = this.receipt.receivable.code
      this.receipt.detail.date = this.receipt.date
      this.receipt.detail.extend = this.receipt.extend
      this.receipt.detail.income = this.receipt.amount
      this.receipt.detail.pay = 0
      this.receipt.detail.type = '收款'
      this.receipt.detail.trader = this.receipt.receivable.dealer
      postRequest('/financeReceiptAPI/', this.receipt)
        .then(resp => {
          this.jump()
          this.dialogVisible = false
        })
        .catch(error => {
          console.log(error)
          this.$message.error('收款失败')
        })
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