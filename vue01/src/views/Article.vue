<template>
  <div style="padding: 10px 0">
    <i class="el-icon-caret-left"></i>
    <el-button type="" @click="reBack">返回</el-button>
    <div style="text-align: center">
      <h1 style="font-size: 30px">党组织构架展示图</h1>
    </div>
    <el-divider></el-divider>
    <div style="padding-top: 5px" align="center">
      <img src="../assets/dangjiangoujian.jpg" alt="党组织构架" width="900px" height="563px">
    </div>
  </div>
</template>

<script>
export default {
  name:"article",
  methods:{
    reBack(){
      this.$router.push("/home")
    }
  }
}


</script>