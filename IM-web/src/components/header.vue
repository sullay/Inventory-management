<template>
  <el-row>
      <el-col :span="3"><span>仓库管理系统</span></el-col>
      <el-col :span="3" :offset="18"><button class="button button-large button-plain button-borderless" @click="logout"><i class="fa fa-power-off   "></i></button></el-col>
  </el-row>
</template>
<script>
import axios from 'axios'
export default {
  methods: {
    logout () {
      axios.post('http://localhost:4001/logout')
        .then(resp => {
          window.location.href = '/'
        })
    }
  }
}
</script>

<style scoped>
  .button {
    margin-top: 10px;
  }
</style>
