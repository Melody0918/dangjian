<template>
<div class="wrapper">
  <div style="margin: 80px auto;background-color: #fff;width: 350px;height: 550px;padding: 20px;border-radius: 10px">
    <div style="margin: 20px 0;text-align: center;font-size: 24px">
      <b>注 册</b></div>
      <el-form :model="user" :rules="rules" ref="userForm">
        <el-form-item prop="username" >
          <el-input placeholder="请输入注册用户名" size="medium" style="margin: 6px 0" prefix-icon="el-icon-user" v-model="user.username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input placeholder="请输入注册密码" size="medium" style="margin: 6px 0" prefix-icon="el-icon-lock" show-password v-model="user.password"></el-input>
        </el-form-item>
        <el-form-item prop="confirmPassword">
          <el-input placeholder="请确认密码" size="medium" style="margin: 6px 0" prefix-icon="el-icon-finished" show-password v-model="user.confirmPassword"></el-input>
        </el-form-item>
        <el-form-item prop="nickname">
          <el-input placeholder="请输入您的政治面貌，后期我们会审核" size="medium" style="margin: 6px 0" prefix-icon="el-icon-info" v-model="user.nickname"></el-input>
        </el-form-item>
        <el-form-item prop="email">
          <el-input placeholder="请输入注册邮箱" size="medium" style="margin: 6px 0" prefix-icon="el-icon-message" v-model="user.email"></el-input>
        </el-form-item>
        <el-form-item prop="phone">
          <el-input placeholder="请输入注册电话" size="medium" style="margin: 6px 0" prefix-icon="el-icon-phone" v-model="user.phone"></el-input>
        </el-form-item>

        <el-form-item style="margin: 10px 0;text-align: center;">
        <el-button type="primary" size="small" autocomplete="off" @click="login"style="margin-right: 20px">注册</el-button>
        <el-button type="warning" size="small" autocomplete="off" @click="$router.push('/login')">返回登录</el-button>
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
        ],
        confirmPassword:[
          {required:true,message:'请确认密码',trigger:'blur'},
          {min:5,max:12,message: '长度在 5 到 12 个字符',trigger: 'blur'}
        ],
        nickname:[
          {required:true,message:'请输入您的政治面貌',trigger:'blur'},
          {min:2,max:8,message: '长度在 2 到 8 个字符',trigger: 'blur'}
        ],
        email:[
          {required:true,message:'请输入邮箱',trigger:'blur'},
          {min:8,max:25,message: '长度在 8 到 25 个字符',trigger: 'blur'}
        ],
        phone:[
          {required:true,message:'请输入电话',trigger:'blur'},
          {min:11,max:11,message: '长度为11个字符',trigger: 'blur'}
        ]
      }
    }
  },
  methods:{
    login(){
      this.$refs['userForm'].validate((valid) =>{
        if (valid){ //表单校验合法,合法才发送请求
          if (this.user.password !== this.user.confirmPassword){
            this.$message.error("两次输入的密码不一致")
            return false;
          }
          this.request.post("/user/register",this.user).then(res =>{
            if (res.code === '200' ){
              this.$message.success("注册成功！")
            }else {
              this.$message.error(res.msg)
            }
          })
        }
      });
    }
  }
}
</script>

<style>
  .wrapper{
    height: 100vh;
    background-image: linear-gradient(to bottom left,#FC4668,#3F5EF8); /*从左下角到右上角渐变色*/
    overflow: hidden;
  }

</style>