<template>
  <el-container>
  <el-header><Header></Header></el-header>
  <el-container>
    <el-aside width="150px"><SideBar></SideBar></el-aside>
    <el-main>Main</el-main>
  </el-container>
</el-container>
</template>
<script>
import Header from '../components/header'
import SideBar from '../components/sideBar'
export default {
  components: {
    Header,
    SideBar
  }
}
</script>

<style>
  .el-header{
    background-color: #44484B;
    color: #E9EEF3;
    text-align: center;
    line-height: 60px;
  }
  
  .el-aside {
    text-align: center;
  }
  
  .el-main {
    text-align: center;
  }
  .el-container{
      height: 100%;
      width: 100%;
  }
  
</style>