<template>
  <div>
   <el-dialog
    :visible.sync="dialogVisible"
    width="30%"
    :before-close="close" title="付款信息">
    <el-form :model="pay" label-width="100px">
    <el-form-item label="应付款单号:">
      <el-input placeholder="请输入应付款单号" v-model="pay.payable.code" disabled></el-input>
    </el-form-item>
    <el-form-item label="付款金额:">
      <el-input placeholder="请输入付款金额" v-model.number="pay.amount" autofocus></el-input>
    </el-form-item>
    <el-form-item label="备注:">
      <el-input placeholder="请输入备注" v-model="pay.extend"  @keyup.native.enter="confirm"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer">
      <el-button @click="close">取 消</el-button>
      <el-button type="primary" @click="confirm">确 定</el-button>
    </span>
    </el-dialog>
    <el-table
    :data="payables"
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
      label="应付款单号">
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
      prop="amountPaid"
      label="已付金额">
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
          <el-button  type="text" size="small" @click="toPay(scope)">支付</el-button>
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
      payables: [],
      payable: {id: 0,
        code: '',
        amountPaid: 0,
        amount: 0,
        state: '',
        extend: '',
        date: 0,
        dealer: ''},
      pay: {
        id: 0,
        payable: {id: 0,
          code: '',
          amountPaid: 0,
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
      getRequest('/payableAPI/all', this.data)
        .then(resp => {
          this.payables = resp.data.extend.pageInfo.content
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
    toPay (scope) {
      this.payable = scope.row
      this.pay.payable = this.payable
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
      this.pay.id = 0
      this.pay.payable.amountPaid = this.pay.payable.amountPaid + this.pay.amount
      this.pay.date = new Date()
      if (this.pay.payable.amountPaid >= this.pay.payable.amount) {
        this.pay.payable.state = 'COMPLETE'
      } else {
        this.pay.payable.state = 'INCOMPLETE'
      }
      this.pay.detail.id = 0
      this.pay.detail.code = this.pay.payable.code
      this.pay.detail.date = this.pay.date
      this.pay.detail.extend = this.pay.extend
      this.pay.detail.income = 0
      this.pay.detail.pay = this.pay.amount
      this.pay.detail.type = '付款'
      this.pay.detail.trader = this.pay.payable.dealer
      postRequest('/payAPI/', this.pay)
        .then(resp => {
          this.jump()
          this.dialogVisible = false
        })
        .catch(error => {
          console.log(error)
          this.$message.error('支付失败')
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