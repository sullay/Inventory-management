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
      <el-input placeholder="请输入备注" v-model="pay.extend"  @keyup.native.enter="edit_confirm"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer">
      <el-button @click="close">取 消</el-button>
      <el-button type="primary" @click="edit_confirm">确 定</el-button>
    </span>
    </el-dialog>
    <el-table
    :data="pays"
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
      prop="payable.code"
      label="应付款单号">
    </el-table-column>
    <el-table-column
      align="center"
      prop="amount"
      label="付款金额">
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
      pays: [],
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
      getRequest('/payAPI/all', this.data)
        .then(resp => {
          this.pays = resp.data.extend.pageInfo.content
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
      this.pay.payable.amountPaid = this.pay.payable.amountPaid - this.price + this.pay.amount
      this.pay.date = new Date()
      if (this.pay.payable.amountPaid >= this.pay.payable.amount) {
        this.pay.payable.state = 'COMPLETE'
      } else {
        this.pay.payable.state = 'INCOMPLETE'
      }
      this.pay.detail.date = this.pay.date
      this.pay.detail.extend = this.pay.extend
      this.pay.detail.income = 0
      this.pay.detail.pay = this.pay.amount
      putRequest('/payAPI/', this.pay)
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
        scope.row.payable.amountPaid = scope.row.payable.amountPaid - scope.row.amount
        if (scope.row.payable.amountPaid >= scope.row.payable.amount) {
          scope.row.payable.state = 'COMPLETE'
        } else {
          scope.row.payable.state = 'INCOMPLETE'
        }
        putRequest('/payAPI/', scope.row)
          .then(resp => {
            deleteRequest('/payAPI/', scope.row)
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
            this.$message.error('修改支付记录失败')
          })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    edit (scope) {
      this.pay = scope.row
      this.price = this.pay.amount
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