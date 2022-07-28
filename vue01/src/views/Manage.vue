<template>
    <el-container style="min-height:100vh /*border: 1px solid #eee*/">
      <el-aside width="sideWidth + 'px'" style="background-color: rgb(238, 241, 246);box-shadow: 1px 0 6px rgb(205 133 63)">
        <Aside :isCollapse="isCollapse" :logoTextShow="logoTextShow"/>  <!--给组件传值-->
      </el-aside>

      <el-container>
        <el-header style="border-bottom: 1px solid #ccc">
        <Header :collapse-btn-class="collapseBtnClass" v-on:click="collapse" :user="user"/>
        </el-header>

        <el-main style="padding: 0px 10px 0px 10px">
<!--          表示当前页面的子路由会在 <router-view /> 里面显示-->
          <router-view @refreshUser="getUser"/>
        </el-main>

      </el-container>
    </el-container>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
// import request from "../utils/request";

import Aside from "../components/Aside";
import Header from "../components/Header";

export default {
  name: 'Home',

  data(){
    return {
      collapseBtnClass:'el-icon-s-fold',
      isCollapse:false,
      sideWidth:200,
      logoTextShow:true,
      user:{}
    }
  },


  components:{
    Header,
    Aside
  },

  created() {
    //从后台获取最新的User数据
    this.getUser()
  },

  methods:{
    collapse(){   //点击收缩按钮触发
      this.isCollapse = !this.isCollapse
      if (this.isCollapse){
        this.sideWidth = 64
        this.collapseBtnClass='el-icon-s-unfold'
        this.logoTextShow = false
      }else{  //展开
        this.sideWidth = 200
        this.collapseBtnClass = 'el-icon-s-fold'
        this.logoTextShow = true
      }
    },

    getUser() {
      let username =localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")).username : ""
      //从后台获取user数据
      this.request.get("/user/username/" + username).then(res => {
        //重新赋值后台的最新User数据
        this.user=res.data
      })
    }
  }
}
</script>

