<template>
<div class="wrapper">
  <div style="margin: 200px auto;background-color: #fff;width: 350px;height: 300px;padding: 20px;border-radius: 10px">
    <div style="margin: 20px 0;text-align: center;font-size: 24px">
      <b>党建管理系统登录</b></div>
      <el-form :model="user" :rules="rules" ref="userForm">
        <el-form-item prop="username" >
          <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-user" v-model="user.username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-lock" show-password v-model="user.password" @keyup.enter.native="triggerClick"></el-input>
        </el-form-item>

      <el-form-item style="margin: 10px 0;text-align: center;">
        <el-button type="primary" size="small" autocomplete="off" @click="login"style="margin-right: 20px" ref="btn">登录</el-button>
        <el-button type="warning" size="small" autocomplete="off" @click="$router.push('/register')">注册</el-button>
      </el-form-item>
      </el-form>
  </div>
</div>
</template>

<script>
export default {
  name: "Login",
  data(){
    return{
      user:{},
      rules:{
        username:[
          {required:true,message:'请输入用户名',trigger:'blur'},
          {min:2,max:8,message: '长度在 2 到 8 个字符',trigger: 'blur'}
        ],
        password:[
          {required:true,message:'请输入密码',trigger:'blur'},
          {min:5,max:12,message: '长度在 5 到 12 个字符',trigger: 'blur'}
        ]
      }
    }
  },
  methods:{
    login(){
      this.$refs['userForm'].validate((valid) =>{
        if (valid){ //表单校验合法,合法才发送请求
          this.request.post("/user/login",this.user).then(res =>{
            if (res.code === '200' ){
              localStorage.setItem("user",JSON.stringify(res.data)) //存储用户信息到浏览器
              this.$router.push("/")
              this.$message.success("登录成功！")
            }else {
              this.$message.error(res.msg)
            }
          })
        }
      })
    },

    triggerClick(){ //用于回车键触发搜索功能

      this.$refs.btn.$emit('click')

    },
  }
}
</script>

<style>
  .wrapper{
    height: 100vh;
    background-image: linear-gradient(to bottom right,#FC4668,#3F5EF8); /*从左上角到右上角渐变色*/
    overflow: hidden;
  }

</style>