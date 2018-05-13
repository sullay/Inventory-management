<template>
  <div>
    <el-dialog
    :visible.sync="deliveryDialogVisible"
    width="50%"
    :before-close="Dclose" title="销售出库单">
      <el-form :model="saleDelivery" label-width="100px" size="small">
        <el-row>
          <el-col :span="12">
          <el-form-item label="销售订单编号:">
            <el-input placeholder="请输入销售订单编号" v-model="saleDelivery.saleOrder.code" disabled>
              <template slot="prepend">{{this.prefix}}</template>
            </el-input>
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="销售出库单编号:">
            <el-input placeholder="请输入销售出库单编号" v-model="saleDelivery.code" autofocus>
              <template slot="prepend">{{this.deliveryPrefix}}</template>
            </el-input>
          </el-form-item>
          </el-col>
        </el-row>
        <div v-for="saleInfo in saleDelivery.saleOrder.saleInfos" :key="saleInfo.id">
          <el-form-item label="商品信息:">
            <el-row>
            <el-col :span="12">
              <el-select v-model="saleInfo.goods.id" filterable placeholder="请选择商品" disabled>
                <el-option
                  v-for="item in goodsAll"
                  :key="item.id"
                  :label="item.code+'-'+item.name"
                  :value="item.id">
                </el-option>
              </el-select>
            </el-col>
            <el-col :span="12">
              <el-date-picker
                v-model="saleInfo.date"
                type="date"
                placeholder="选择到货日期" disabled>
              </el-date-picker>
            </el-col>
            </el-row>
            <el-row>
            <el-col :span="8">
              <el-input placeholder="请输入订单数量" v-model.number="saleInfo.number" disabled>
                <template slot="prepend">订单数量</template>
              </el-input>
            </el-col>
            <el-col :span="8" :offset="4">
              <el-input placeholder="请输入到货数量" v-model.number="saleInfo.shipment" disabled>
                <template slot="prepend">到货数量</template>
              </el-input>
            </el-col>
            <el-col :span="8">
              <el-select v-model="saleInfo.stock" filterable placeholder="请选择仓库" @click.native="getWarehouse(saleInfo.goods.id)">
                <el-option
                  v-for="item in stocks"
                  :key="item.id"
                  :label="item.warehouse.code+'-'+item.warehouse.name+':'+item.number"
                  :value="item.id">
                </el-option>
              </el-select>
            </el-col>
            <el-col :span="8" :offset="4">
              <el-input placeholder="请输入出库数量" v-model.number="saleInfo.num">
                <template slot="prepend">出库数量</template>
              </el-input>
            </el-col>
            </el-row>
          </el-form-item>
        </div>
        <el-form-item label="备注">
          <el-input placeholder="请输入备注" v-model="saleDelivery.extend"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer">
        <el-button @click="Dclose">取 消</el-button>
        <el-button type="primary" @click="delivery_confirm">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog
    :visible.sync="receiptDialogVisible"
    width="50%"
    :before-close="Rclose" title="销售退货单">
      <el-form :model="saleReceipt" label-width="100px" size="small">
        <el-row>
          <el-col :span="12">
          <el-form-item label="销售订单编号:">
            <el-input placeholder="请输入销售订单编号" v-model="saleReceipt.saleOrder.code" disabled>
              <template slot="prepend">{{this.prefix}}</template>
            </el-input>
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="销售退货编号:">
            <el-input placeholder="请输入销售退货单编号" v-model="saleReceipt.code" autofocus>
              <template slot="prepend">{{this.receiptPrefix}}</template>
            </el-input>
          </el-form-item>
          </el-col>
        </el-row>
        <div v-for="saleInfo in saleReceipt.saleOrder.saleInfos" :key="saleInfo.id">
          <el-form-item label="商品信息:">
            <el-row>
            <el-col :span="12">
              <el-select v-model="saleInfo.goods.id" filterable placeholder="请选择商品" disabled>
                <el-option
                  v-for="item in goodsAll"
                  :key="item.id"
                  :label="item.code+'-'+item.name"
                  :value="item.id">
                </el-option>
              </el-select>
            </el-col>
            <el-col :span="12">
              <el-date-picker
                v-model="saleInfo.date"
                type="date"
                placeholder="选择到货日期" disabled>
              </el-date-picker>
            </el-col>
            </el-row>
            <el-row>
            <el-col :span="8">
              <el-input placeholder="请输入退货数量" v-model.number="saleInfo.number" disabled>
                <template slot="prepend">退货数量</template>
              </el-input>
            </el-col>
            <el-col :span="8" :offset="4">
              <el-input placeholder="请输入到货数量" v-model.number="saleInfo.shipment" disabled>
                <template slot="prepend">到货数量</template>
              </el-input>
            </el-col>
            <el-col :span="8">
              <el-input placeholder="请输入退货数量" v-model.number="saleInfo.num">
                <template slot="prepend">退货数量</template>
              </el-input>
            </el-col>
            <el-col :span="8" :offset="4">
              <el-select v-model="saleInfo.wid" filterable placeholder="请选择仓库">
                <el-option
                  v-for="item in warehouses"
                  :key="item.id"
                  :label="item.code+'-'+item.name"
                  :value="item.id">
                </el-option>
              </el-select>
            </el-col>
            </el-row>
          </el-form-item>
        </div>
        <el-form-item label="备注">
          <el-input placeholder="请输入备注" v-model="saleReceipt.extend"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer">
        <el-button @click="Rclose">取 消</el-button>
        <el-button type="primary" @click="receipt_confirm">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog
    :visible.sync="dialogVisible"
    width="50%"
    :before-close="close" title="销售订单信息">
    <el-form :model="saleOrder" label-width="100px" size="small">
    <el-row>
    <el-col :span="12">
    <el-form-item label="销售订单编号:">
      <el-input placeholder="请输入销售订单编号" v-model="saleOrder.code" autofocus>
        <template slot="prepend">{{this.prefix}}</template>
      </el-input>
    </el-form-item>
    </el-col>
    <el-col :span="12">
    <el-form-item label="客户名称:">
      <el-input placeholder="请输入供应商名称" v-model="saleOrder.customer"></el-input>
    </el-form-item>
    </el-col>
    <el-col :span="12">
    <el-form-item label="备注:">
      <el-input placeholder="请输入备注" v-model="saleOrder.extend"></el-input>
    </el-form-item>
    </el-col>
    </el-row>
    <div v-for="saleInfo in saleOrder.saleInfos" :key="saleInfo.id">
    <el-form-item label="商品信息:">
      <el-row>
      <el-col :span="12">
        <el-select v-model="saleInfo.goods.id" filterable placeholder="请选择商品">
          <el-option
            v-for="item in goodsAll"
            :key="item.id"
            :label="item.code+'-'+item.name"
            :value="item.id">
          </el-option>
        </el-select>
      </el-col>
      <el-col :span="12">
        <el-date-picker
          v-model="saleInfo.date"
          type="date"
          placeholder="选择到货日期">
        </el-date-picker>
      </el-col>
      </el-row>
      <el-row>
      <el-col :span="8">
        <el-input placeholder="请输入订单数量" v-model.number="saleInfo.number">
          <template slot="prepend">数量</template>
        </el-input>
      </el-col>
      <el-col :span="8" :offset="4">
        <el-input placeholder="请输入采购价格" v-model.number="saleInfo.price">
          <template slot="prepend">价格</template>
        </el-input>
      </el-col>
      <el-col :span="20">
        <el-input placeholder="请输入备注" v-model="saleInfo.extend">
          <template slot="prepend">备注</template>
        </el-input>
      </el-col>
      <el-col :span="8" :offset="8">
        <el-button @click.prevent="removesaleInfo(saleInfo)" type="danger">删除</el-button>
      </el-col>
      </el-row>
    </el-form-item>
    </div>
      <el-button @click.prevent="addsaleInfo" type="success">新增销售信息</el-button>
    </el-form>
    <span slot="footer">
      <el-button @click="close">取 消</el-button>
      <el-button type="primary" @click="confirm" v-if="isAdd">确 定</el-button>
      <el-button type="primary" @click="edit_confirm" v-else>确 定</el-button>
    </span>
    </el-dialog>
    <el-button type="success" @click="add"><i class="fa fa-plus"></i>新增</el-button>
    <el-table
    :data="saleOrders"
    border
    style="width: 100%"
    size="small">
    <el-table-column
      fixed
      align="center"
      prop="code"
      label="订单编号"
      :formatter="code_formatter">
    </el-table-column>
    <el-table-column
      align="center"
      prop="customer"
      label="客户名称">
    </el-table-column>
    <el-table-column
      align="center"
      prop="date"
      label="单据日期"
      :formatter="formatter">
    </el-table-column>
     <el-table-column
      align="center"
      prop="extend"
      label="备注">
    </el-table-column>
     <el-table-column
      align="center"
      prop="state"
      label="订单状态"
      :formatter="stateFormatter">
    </el-table-column>
    <el-table-column
      align="center"
      fixed="right"
      label="操作"
      width="200">
      <template slot-scope="scope">
        <el-button-group>
          <el-button  type="text" size="small" @click="delivery(scope)">出库</el-button>
          <el-button  type="text" size="small" @click="receipt(scope)">退货</el-button>
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
import {formatDate} from '../../utils/formatDateTime.js'
import {getRequest, postRequest, deleteRequest, putRequest} from '../../utils/axios.js'
export default {
  data () {
    return {
      deliveryDialogVisible: false,
      receiptDialogVisible: false,
      dialogVisible: false,
      // 全部数量
      totalElements: null,
      data: {page: 0, size: 10},
      saleOrders: [],
      saleOrder: {
        saleInfos: []
      },
      isAdd: true,
      prefix: '',
      receiptPrefix: '',
      deliveryPrefix: '',
      goodsAll: [],
      warehouses: [],
      stocks: [],
      goods: {id: 0, code: '', name: '', specification: '', goodsType: {id: '', code: '', name: '', codingPrefix: ''}, unit: {id: '', code: '', description: ''}, brand: '', price: '', max: null, min: null},
      saleReceipt: {
        saleOrder: {
          saleInfos: []
        },
        waters: []
      },
      saleDelivery: {
        saleOrder: {
          saleInfos: []
        },
        waters: [],
        receivable: {id: 0,
          code: '',
          amountReceived: 0,
          amount: 0,
          state: '',
          extend: '',
          date: 0,
          dealer: ''}
      }
    }
  },
  methods: {
    init () {
      this.data.page = 0
      this.jump()
    },
    jump () {
      getRequest('/saleOrderAPI/all', this.data)
        .then(resp => {
          this.saleOrders = resp.data.extend.pageInfo.content
          this.totalElements = resp.data.extend.pageInfo.totalElements
        })
        .catch(error => {
          console.log(error)
          this.$message.error('数据请求失败')
        })
      getRequest('/documentsAPI/', {name: '销售订单'})
        .then(resp => {
          this.prefix = resp.data.extend.pageInfo.prefix
        })
        .catch(error => {
          console.log(error)
          this.$message.error('数据请求失败')
        })
      getRequest('/documentsAPI/', {name: '销售退货单'})
        .then(resp => {
          this.receiptPrefix = resp.data.extend.pageInfo.prefix
        })
        .catch(error => {
          console.log(error)
          this.$message.error('数据请求失败')
        })
      getRequest('/documentsAPI/', {name: '销售出库单'})
        .then(resp => {
          this.deliveryPrefix = resp.data.extend.pageInfo.prefix
        })
        .catch(error => {
          console.log(error)
          this.$message.error('数据请求失败')
        })
      getRequest('/goodsAPI/all_NoPage')
        .then(resp => {
          this.goodsAll = resp.data.extend.pageInfo
        })
        .catch(error => {
          console.log(error)
          this.$message.error('数据请求失败')
        })
      getRequest('/warehouseAPI/all_NoPage')
        .then(resp => {
          this.warehouses = resp.data.extend.pageInfo
        })
        .catch(error => {
          console.log(error)
          this.$message.error('数据请求失败')
        })
    },
    getWarehouse (goodId) {
      getRequest('/stockAPI/listByGoods', {gid: goodId})
        .then(resp => {
          this.stocks = resp.data.extend.pageInfo
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
      this.saleOrder = {saleInfos: [{goods: {id: null}}]}
      this.dialogVisible = true
    },
    close () {
      this.dialogVisible = false
      this.jump()
    },
    Rclose () {
      this.receiptDialogVisible = false
      this.jump()
    },
    Dclose () {
      this.deliveryDialogVisible = false
      this.jump()
    },
    confirm () {
      this.saleOrder.id = 0
      this.saleOrder.date = new Date()
      this.saleOrder.state = 'INCOMPLETE'
      this.saleOrder.receivable = {
        id: 0,
        code: this.prefix + this.saleOrder.code,
        amountReceived: 0,
        amount: 0,
        state: 'INCOMPLETE',
        extend: this.saleOrder.extend,
        date: new Date(),
        dealer: this.saleOrder.customer}
      this.saleOrder.saleInfos.forEach(saleInfo => {
        this.saleOrder.receivable.amount += saleInfo.price * saleInfo.number
      })
      postRequest('/saleOrderAPI/', this.saleOrder)
        .then(resp => {
          this.jump()
          this.dialogVisible = false
        })
        .catch(error => {
          console.log(error)
          this.$message.error('新增采购订单失败')
        })
    },
    edit_confirm () {
      this.saleOrder.receivable.code = this.prefix + this.saleOrder.code
      this.saleOrder.receivable.extend = this.saleOrder.extend
      this.saleOrder.receivable.dealer = this.saleOrder.customer
      this.saleOrder.receivable.amount = 0
      this.saleOrder.saleInfos.forEach(saleInfo => {
        this.saleOrder.receivable.amount += saleInfo.price * saleInfo.number
      })
      if (this.saleOrder.receivable.amountReceived >= this.saleOrder.receivable.amount) {
        this.saleOrder.receivable.state = 'COMPLETE'
      } else {
        this.saleOrder.receivable.state = 'INCOMPLETE'
      }
      this.saleOrder.state = 'COMPLETE'
      this.saleOrder.saleInfos.forEach(saleInfo => {
        if (saleInfo.arrivals < saleInfo.number) {
          this.saleOrder.state = 'INCOMPLETE'
        }
      })
      putRequest('/saleOrderAPI/', this.saleOrder)
        .then(resp => {
          this.jump()
          this.dialogVisible = false
        })
        .catch(error => {
          console.log(error)
          this.$message.error('修改采购订单失败')
        })
    },
    receipt_confirm () {
      this.saleReceipt.payable = {
        id: '',
        code: this.receiptPrefix + this.saleReceipt.code,
        amountPaid: 0,
        amount: 0,
        state: 'INCOMPLETE',
        extend: this.saleReceipt.extend,
        date: new Date(),
        dealer: this.saleReceipt.saleOrder.customer
      }
      this.saleReceipt.date = new Date()
      this.saleReceipt.waters = []
      this.saleReceipt.saleOrder.saleInfos.forEach(saleInfo => {
        this.saleReceipt.payable.amount += saleInfo.price * saleInfo.num
        saleInfo.shipment -= saleInfo.num
        this.saleReceipt.waters.push({
          documentName: '销售退货单',
          documentCode: this.receiptPrefix + this.saleReceipt.code,
          date: this.saleReceipt.date,
          receiptNum: saleInfo.num,
          deliveryNum: 0,
          stock: {
            goods: {id: saleInfo.goods.id, code: '', name: '', specification: '', goodsType: {id: '', code: '', name: '', codingPrefix: ''}, unit: {id: '', code: '', description: ''}, brand: '', price: '', max: null, min: null},
            warehouse: {id: saleInfo.wid, code: '', name: '', place: '', extend: ''}
          }
        })
      })
      this.saleReceipt.saleOrder.state = 'COMPLETE'
      this.saleReceipt.saleOrder.saleInfos.forEach(saleInfo => {
        if (saleInfo.shipment < saleInfo.number) {
          this.saleReceipt.saleOrder.state = 'INCOMPLETE'
        }
      })
      putRequest('/saleOrderAPI/', this.saleReceipt.saleOrder)
        .then(resp => {
          postRequest('/saleReceiptAPI/', this.saleReceipt)
            .then(resp => {
              this.jump()
              this.receiptDialogVisible = false
            })
            .catch(error => {
              console.log(error)
              this.$message.error('创建销售退货单失败,请检查单号是否重复')
            })
        })
        .catch(error => {
          console.log(error)
          this.$message.error('修改销售订单失败，请检查单号是否重复')
        })
    },
    delivery_confirm () {
      this.saleDelivery.date = new Date()
      this.saleDelivery.waters = []
      this.saleDelivery.saleOrder.saleInfos.forEach(saleInfo => {
        saleInfo.shipment += saleInfo.num
        this.saleDelivery.waters.push({
          documentName: '销售出库单',
          documentCode: this.deliveryPrefix + this.saleDelivery.code,
          date: this.saleDelivery.date,
          receiptNum: 0,
          deliveryNum: saleInfo.num,
          stock: {
            id: saleInfo.stock,
            goods: {id: 0, code: '', name: '', specification: '', goodsType: {id: '', code: '', name: '', codingPrefix: ''}, unit: {id: '', code: '', description: ''}, brand: '', price: '', max: null, min: null},
            warehouse: {id: 0, code: '', name: '', place: '', extend: ''}
          }
        })
      })
      this.saleDelivery.saleOrder.state = 'COMPLETE'
      this.saleDelivery.saleOrder.saleInfos.forEach(saleInfo => {
        if (saleInfo.shipment < saleInfo.number) {
          this.saleDelivery.saleOrder.state = 'INCOMPLETE'
        }
      })
      putRequest('/saleOrderAPI/', this.saleDelivery.saleOrder)
        .then(resp => {
          postRequest('/saleDeliveryAPI/', this.saleDelivery)
            .then(resp => {
              this.jump()
              this.deliveryDialogVisible = false
            })
            .catch(error => {
              console.log(error)
              this.$message.error('创建销售出库单失败,请检查单号是否重复')
            })
        })
        .catch(error => {
          console.log(error)
          this.$message.error('修改销售订单失败，请检查单号是否重复')
        })
    },
    del (scope) {
      this.$confirm('此操作将永久删除, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'error'
      }).then(() => {
        deleteRequest('/saleOrderAPI/', scope.row)
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
      this.saleOrder = scope.row
      this.dialogVisible = true
    },
    receipt (scope) {
      this.saleReceipt.saleOrder = scope.row
      this.receiptDialogVisible = true
    },
    delivery (scope) {
      this.saleDelivery.saleOrder = scope.row
      this.deliveryDialogVisible = true
    },
    formatter (row, column, cellValue) {
      return formatDate(cellValue)
    },
    code_formatter (row, column, cellValue) {
      return this.prefix + cellValue
    },
    stateFormatter (row, column, cellValue) {
      if (cellValue === 'INVALID') {
        return '报废'
      } else if (cellValue === 'INCOMPLETE') {
        return '未完成'
      } else {
        return '已完成'
      }
    },
    removesaleInfo (item) {
      var index = this.saleOrder.saleInfos.indexOf(item)
      if (index !== -1) {
        this.saleOrder.saleInfos.splice(index, 1)
      }
    },
    addsaleInfo () {
      this.saleOrder.saleInfos.push({
        goods: {id: null}
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