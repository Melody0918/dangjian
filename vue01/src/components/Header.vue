<template>
  <div style="line-height: 60px;display: flex">
  <div style="flex: 1;font-size: 18px">
    <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>

      <el-breadcrumb separator="/" style="display: inline-block;margin-left: 10px">
        <el-breadcrumb-item :to="'/'">首页</el-breadcrumb-item>
        <el-breadcrumb-item>{{ currentPathName }}</el-breadcrumb-item>
      </el-breadcrumb>
  </div>
  <el-dropdown style="width: 160px;cursor: pointer;text-align: right">
    <div style="display: inline-block">
      <img src="../assets/Avatar.png" alt="" style="width: 30px;border-radius: 50%;position: relative;top: 10px;right: 5px">
    <!--            <i class="el-icon-setting" style="margin-right: 15px"></i>-->
    <span>{{ user.username }} {{ getTimeState() }}</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
    </div>
    <el-dropdown-menu slot="dropdown" style="width: 100px;text-align: center">
      <el-dropdown-item style="font-size: 14px;padding: 5px 0">
        <span style="text-decoration: none" @click="personInfo">个人信息</span>
      </el-dropdown-item>
<!--      <el-dropdown-item style="font-size: 14px;padding: 5px">——</el-dropdown-item>-->
      <el-dropdown-item style="font-size: 14px;padding: 5px 0">
        <span style="text-decoration: none" @click="logout">退出</span>
      </el-dropdown-item>
    </el-dropdown-menu>
  </el-dropdown>
  </div>
</template>

<script>
export default {
  name: "Header",
  props: {
    collapseBtnClass: String,
    user:Object
  },
  computed:{
    currentPathName(){
      return this.$store.state.currentPathName; //需要监听的数据
    }
  },
  data(){
    return{
      }
    },


  watch:{ // 百度搜出的结果，监听路由变化
    currentPathName(newVal,oldVal){
      console.log(newVal)
    }
  },

  methods:{
    collapse(){
      this.$emit('click')
    },
    logout(){ //退出时的方法：清除数据，导向登录界面
      this.$router.push("/login")
      localStorage.removeItem("user")
      this.$message.success("退出成功！")
    },
    personInfo(){
      this.$router.push("/person")
    },
    getTimeState(){
      // 获取当前时间
      let timeNow = new Date();
      // 获取当前小时
      let hours = timeNow.getHours();
      // 设置默认文字
      let state= ``;
      // 判断当前时间段
      if (hours >= 0 && hours <= 10) {
        state = `早上好!`;
      } else if (hours > 10 && hours <= 14) {
        state= `中午好!`;
      } else if (hours > 14 && hours <= 18) {
        state= `下午好!`;
      } else if (hours > 18 && hours <= 24) {
        state= `晚上好!`;
      }
      return state;
    },
  }
}
</script>

<style scoped>

</style>