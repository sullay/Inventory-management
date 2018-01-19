<template>
  <el-form :model="loginForm" :rules="rules" class="login-container" label-position="left"
           label-width="0px" v-loading="loading" ref="loginForm">
    <h3 class="login_title">系统登录</h3>
    <el-form-item prop="username">
      <el-input type="text" v-model="loginForm.username" placeholder="账号" autofocus="true"></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input type="password" v-model="loginForm.password" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" @click="submitClick" style="width: 100%">登录</el-button>
    </el-form-item>
  </el-form>
</template>
<script>
  import {postRequest} from '../utils/axios'
  import cookies from '../utils/cookies'
  export default{
    data () {
      return {
        rules: {
          username: [{required: true, message: '请输入用户名', trigger: 'blur'}],
          password: [{required: true, message: '请输入密码', trigger: 'blur'}]
        },
        loginForm: {
          username: '',
          password: ''
        },
        loading: false
      }
    },
    created () {
      this.loginForm.username = cookies.getCookie('username')
      this.loginForm.password = cookies.getCookie('password')
      document.onkeyup = () => {
        if (window.event.keyCode === 13) {
          this.submitClick()
        }
      }
    },
    methods: {
      submitClick () {
        this.$refs.loginForm.validate((valid) => {
          if (valid) {
            this.loading = true
            postRequest('/login', this.loginForm)
              .then(resp => {
                this.loading = false
                cookies.setCookie('username', this.loginForm.username, 3)
                cookies.setCookie('password', this.loginForm.password, 3)
                window.location.href = 'http://localhost:4001/'
              })
              .catch(error => {
                this.loading = false
                console.log(error)
                this.$message.error('登录失败')
              })
          } else {
            return false
          }
        })
      }
    }
  }
</script>
<style>
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }

  .login_remember {
    margin: 0px 0px 35px 0px;
    text-align: left;
  }
</style>
