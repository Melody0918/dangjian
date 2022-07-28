<template>
  <el-menu :default-openeds="['2']" style="min-height: 100%;overflow-x: hidden"
           background-color="#D91517"
           text-color="#fff"
           active-text-color="#ffd04b"
           :collapse-transition="false"
           :collapse="isCollapse"
            router
            @select="handleSelect"><!--isCollapse关掉菜单本身动画-->

    <div style="height: 60px;line-height: 60px;text-align: center">
      <img src="../assets/logo.png" alt="" style="width: 20px;position: relative;top: 5px;margin-right: 4px;border-radius: 50%">
      <b style="color: white" v-show="logoTextShow">党建管理系统</b>

    </div>

    <el-menu-item index="/">
      <template slot="title">
      <i class="el-icon-s-home"></i>
      <span slot="title" style="margin-left: 5px">首页</span>
    </template>
    </el-menu-item>

    <el-submenu index="2">
      <template slot="title">
        <i class="el-icon-menu"></i>
        <span slot="title" style="margin-left: 5px">系统管理</span>
      </template>
        <el-menu-item index="/user">
            <i class="el-icon-s-custom"></i>
            <span slot="title" style="margin-left: 5px">党员管理</span>
        </el-menu-item>
      <el-menu-item index="/file">
        <i class="el-icon-document"></i>
        <span slot="title" style="margin-left: 5px">文件管理</span>
      </el-menu-item>
<!--      <el-menu-item index="/article">-->
<!--        <i class="el-icon-paperclip"></i>-->
<!--        <span slot="title" style="margin-left: 5px">文章管理</span>-->
<!--      </el-menu-item>-->
      </el-submenu>
  </el-menu>

</template>

<script>
export default {
  name: "Aside",
  props:{
    isCollapse:Boolean,
    logoTextShow:Boolean
  },
  methods:{
    handleSelect(index){
    }
  }
}
</script>

<style scoped>

</style>