<template>
  <el-container>
  <el-header><Header></Header></el-header>
  <el-container>
    <el-aside width="160px"><div class="noScroll"><SideBar></SideBar></div></el-aside>
    <el-main>
      <HomeMain v-if="this.$route.path=='/home'"></HomeMain>
      <router-view v-else/>
    </el-main>
  </el-container>
</el-container>
</template>
<script>
import Header from '../components/header'
import SideBar from '../components/sideBar'
import HomeMain from '../components/homeMain'
export default {
  components: {
    Header,
    SideBar,
    HomeMain
  }
}
</script>

<style scoped>
  .el-header{
    background-color: #44484B;
    color: #E9EEF3;
    text-align: center;
    line-height: 60px;
  }
  
  .el-aside {
    text-align: left;
    overflow-x: hidden;
    overflow-y: hidden;
  }
  
  .el-main {
    text-align: center;
  }
  .el-container {
      height: 100%;
      width: 100%;
  }
  .noScroll{
    width: 180px;
    height: 100%;
    overflow-x: hidden;
    overflow-y: scroll;
  }
</style>