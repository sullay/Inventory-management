import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/home.vue'
import Documents from '../views/base/documents.vue'
import Unit from '../views/base/unit.vue'
import Warehouse from '../views/base/warehouse.vue'
import GoodsType from '../views/base/goodsType.vue'
import Goods from '../views/base/goods.vue'
import PurchaseOrder from '../views/purchase/order.vue'
import PurchaseReceipt from '../views/purchase/receipt.vue'
import PurchaseDelivery from '../views/purchase/delivery.vue'
import SaleOrder from '../views/sale/order.vue'
import SaleReceipt from '../views/sale/receipt.vue'
import SaleDelivery from '../views/sale/delivery.vue'
// import Transfer from '../views/other/transfer.vue'
// import InReceipt from '../views/other/inReceipt.vue'
// import InDelivery from '../views/other/inDelivery.vue'
// import OtherReceipt from '../views/other/receipt.vue'
// import OtherDelivery from '../views/other/delivery.vue'
import StockDetail from '../views/stock/detail.vue'
import Warning from '../views/stock/warning.vue'
import Water from '../views/stock/water.vue'
import Daily from '../views/finance/daily.vue'
import FinnanceReceipt from '../views/finance/receipt.vue'
import Pay from '../views/finance/pay.vue'
import Receivables from '../views/finance/receivables.vue'
import Payable from '../views/finance/payable.vue'
import FinanceDetail from '../views/finance/detail.vue'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/home'
    },
    {
      path: '/home',
      name: 'home',
      component: Home
    },
    {
      path: '/home',
      name: '基础数据',
      component: Home,
      meta: {
        index: '1'
      },
      children: [
        {
          path: '/home/base/documents',
          name: '单据信息',
          component: Documents,
          meta: {
            index: '1-1'
          }
        },
        {
          path: '/home/base/unit',
          name: '单位设置',
          component: Unit,
          meta: {
            index: '1-2'
          }
        },
        {
          path: '/home/base/warehouse',
          name: '仓库信息',
          component: Warehouse,
          meta: {
            index: '1-3'
          }
        },
        {
          path: '/home/base/goodsType',
          name: '货物类别',
          component: GoodsType,
          meta: {
            index: '1-4'
          }
        },
        {
          path: '/home/base/goods',
          name: '货物信息',
          component: Goods,
          meta: {
            index: '1-5'
          }
        }
      ]
    },
    {
      path: '/home',
      name: '采购单据',
      component: Home,
      meta: {
        index: '2'
      },
      children: [
        {
          path: '/home/purchase/order',
          name: '采购订单',
          component: PurchaseOrder,
          meta: {
            index: '2-1'
          }
        },
        {
          path: '/home/purchase/receipt',
          name: '采购入库单',
          component: PurchaseReceipt,
          meta: {
            index: '2-2'
          }
        },
        {
          path: '/home/purchase/delivery',
          name: '采购退货单',
          component: PurchaseDelivery,
          meta: {
            index: '2-3'
          }
        }
      ]
    },
    {
      path: '/home',
      name: '销售单据',
      component: Home,
      meta: {
        index: '3'
      },
      children: [
        {
          path: '/home/sale/order',
          name: '销售订单',
          component: SaleOrder,
          meta: {
            index: '3-1'
          }
        },
        {
          path: '/home/sale/delivery',
          name: '销售出库单',
          component: SaleDelivery,
          meta: {
            index: '3-2'
          }
        },
        {
          path: '/home/sale/receipt',
          name: '销售退货单',
          component: SaleReceipt,
          meta: {
            index: '3-3'
          }
        }
      ]
    },
    // {
    //   path: '/home',
    //   name: '其他出入库',
    //   component: Home,
    //   meta: {
    //     index: '4'
    //   },
    //   children: [
    //     {
    //       path: '/home/other/transfer',
    //       name: '转仓单',
    //       component: Transfer,
    //       meta: {
    //         index: '4-1'
    //       }
    //     },
    //     {
    //       path: '/home/other/inDelivery',
    //       name: '内部领用单',
    //       component: InDelivery,
    //       meta: {
    //         index: '4-2'
    //       }
    //     },
    //     {
    //       path: '/home/other/inReceipt',
    //       name: '内部反退单',
    //       component: InReceipt,
    //       meta: {
    //         index: '4-3'
    //       }
    //     },
    //     {
    //       path: '/home/other/inReceipt',
    //       name: '其他入库单',
    //       component: OtherReceipt,
    //       meta: {
    //         index: '4-4'
    //       }
    //     },
    //     {
    //       path: '/home/other/otherDelivery',
    //       name: '其他出库单',
    //       component: OtherDelivery,
    //       meta: {
    //         index: '4-5'
    //       }
    //     }
    //   ]
    // },
    {
      path: '/home',
      name: '库存管理',
      component: Home,
      meta: {
        index: '5'
      },
      children: [
        {
          path: '/home/stock/warning',
          name: '库存预警',
          component: Warning,
          meta: {
            index: '5-1'
          }
        },
        {
          path: '/home/stock/detail',
          name: '库存明细',
          component: StockDetail,
          meta: {
            index: '5-2'
          }
        },
        {
          path: '/home/stock/water',
          name: '流水账单',
          component: Water,
          meta: {
            index: '5-3'
          }
        }
      ]
    },
    {
      path: '/home',
      name: '财务管理',
      component: Home,
      meta: {
        index: '6'
      },
      children: [
        {
          path: '/home/finance/daily',
          name: '日常收支',
          component: Daily,
          meta: {
            index: '6-1'
          }
        },
        {
          path: '/home/finance/receipt',
          name: '收款记录',
          component: FinnanceReceipt,
          meta: {
            index: '6-2'
          }
        },
        {
          path: '/home/finance/pay',
          name: '付款记录',
          component: Pay,
          meta: {
            index: '6-3'
          }
        },
        {
          path: '/home/finance/receivables',
          name: '应收款记录',
          component: Receivables,
          meta: {
            index: '6-4'
          }
        },
        {
          path: '/home/finance/payable',
          name: '应付款记录',
          component: Payable,
          meta: {
            index: '6-5'
          }
        },
        {
          path: '/home/finance/detail',
          name: '收支明细',
          component: FinanceDetail,
          meta: {
            index: '6-6'
          }
        }
      ]
    }
  ]
})
