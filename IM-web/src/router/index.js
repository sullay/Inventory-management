import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/home.vue'
import Documents from '../views/base/documents.vue'
import Unit from '../views/base/unit.vue'
import Warehouse from '../views/base/warehouse.vue'
import GoodsType from '../views/base/goodsType.vue'
import Goods from '../views/base/goods.vue'
import purchaseReceipt from '../views/purchase/receipt.vue'
import purchaseDelivery from '../views/purchase/delivery.vue'
import saleReceipt from '../views/sale/receipt.vue'
import saleDelivery from '../views/sale/delivery.vue'
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
          path: '/home/purchase/receipt',
          name: '采购入库单',
          component: purchaseReceipt,
          meta: {
            index: '2-1'
          }
        },
        {
          path: '/home/purchase/delivery',
          name: '采购出库单',
          component: purchaseDelivery,
          meta: {
            index: '2-2'
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
          path: '/home/sale/receipt',
          name: '销售入库单',
          component: saleReceipt,
          meta: {
            index: '3-1'
          }
        },
        {
          path: '/home/sale/delivery',
          name: '销售出库单',
          component: saleDelivery,
          meta: {
            index: '3-2'
          }
        }
      ]
    }
  ]
})
