import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/home.vue'
import Documents from '../views/base/documents.vue'
import Unit from '../views/base/unit.vue'
import Warehouse from '../views/base/warehouse.vue'
import GoodsType from '../views/base/goodsType.vue'
import Goods from '../views/base/goods.vue'
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
          path: '/home/documents',
          name: '单据信息',
          component: Documents,
          meta: {
            index: '1-1'
          }
        },
        {
          path: '/home/unit',
          name: '单位设置',
          component: Unit,
          meta: {
            index: '1-2'
          }
        },
        {
          path: '/home/warehouse',
          name: '仓库信息',
          component: Warehouse,
          meta: {
            index: '1-3'
          }
        },
        {
          path: '/home/goodsType',
          name: '货物类别',
          component: GoodsType,
          meta: {
            index: '1-4'
          }
        },
        {
          path: '/home/goods',
          name: '货物信息',
          component: Goods,
          meta: {
            index: '1-5'
          }
        }
      ]
    }

  ]
})
