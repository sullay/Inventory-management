<template>
<div>
<el-menu  class="el-menu-vertical-demo">

    <el-submenu :index="route.meta.index" v-for="route in router" :key='route.meta.index'>
       <template slot="title">
          <span>{{route.name}}</span>
        </template>
      <el-menu-item :index="item.meta.index" v-for="item in route.children" :key="item.meta.index"><router-link :to="item.path">{{item.name}}</router-link></el-menu-item>
    </el-submenu>
</el-menu>
  </div>
</template>

<style scoped>
  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 150px;
    min-height: 400px;
    text-align: left;
  }
  a {
    text-decoration: none;
    color: black;
  }
  .router-link-active {
    text-decoration: none;
  }
</style>

<script>
  export default {
    data () {
      return {
        router: []
      }
    },
    created () {
      for (let route in this.$router.options.routes) {
        if (typeof (this.$router.options.routes[route].children) !== 'undefined') {
          this.router.push(this.$router.options.routes[route])
        }
      }
    },
    methods: {
      handleOpen (key, keyPath) {
        console.log(key, keyPath)
      },
      handleClose (key, keyPath) {
        console.log(key, keyPath)
      }
    }
  }
</script>