<template>
  <div style="padding: 10px 0">
    <i class="el-icon-caret-left"></i>
    <el-button type="" @click="reBack">返回</el-button>
    <div style="text-align: center">
      <h1 style="font-size: 30px">{{this.$route.query.textContent}}</h1>
    </div>
  </div>
</template>

<script>
export default {
  name: "Papers",
  methods: {
    reBack() {
      this.$router.push("/home")
    }
  }
}
</script>

<style scoped>

</style>