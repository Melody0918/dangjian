<template>
  <div style="padding: 10px 0">
    <i class="el-icon-caret-left"></i>
    <el-button type="" @click="reBack">返回</el-button>
    <div style="text-align: center">
      <h1 style="font-size: 30px">专题活动</h1>
    </div>
      <div style="padding: 20px">
        <div align="center">
          <el-image :src="src5" style="padding: 0 20px"></el-image>
          <el-image :src="src6" style="padding: 0 20px"></el-image>
          <el-image :src="src7" style="padding: 0 20px"></el-image>
        </div>
        <div>
          <span style="padding: 5px 180px">参观基层党群服务中心</span>
          <span style="padding: 5px 0px">"因为有你，所以精彩"主题活动</span>
          <span style="padding: 5px 170px">"喜迎二十大"主题活动</span>
        </div>
        <div style="padding-top: 10px" align="center">
          <el-image :src="src1" style="width: 304px;height: 180px;padding: 0 20px"></el-image>
          <el-image :src="src2" style="width: 304px;height: 180px;padding: 0 20px"></el-image>
          <el-image :src="src3" style="width: 304px;height: 180px;padding: 0 20px"></el-image>
          <el-image :src="src4" style="width: 304px;height: 180px;padding: 0 20px"></el-image>
        </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Activities",
  data() {
    return {
      src1:require('../assets/zhuanti1.png'),
      src2:require('../assets/zhuanti2.png'),
      src3:require('../assets/zhuanti3.png'),
      src4:require('../assets/zhuanti4.png'),
      src5:'https://preview.qiantucdn.com/58pic/43/75/94/30z58PIC958PIC84bXqD8Q1bs_PIC2018.jpg!qt324_nowater_jpg',
      src6:'https://preview.qiantucdn.com/58pic/41/38/89/03w58PICm9r0tCeIPf0c3_PIC2018.jpg!qt324_nowater_jpg',
      src7:'https://preview.qiantucdn.com/58pic/42/77/09/7458PIC58PICcEbxcbNe0Nf6r_PIC2018.jpg!qt324_nowater_jpg',
    }
  },
  methods: {
    reBack() {
      this.$router.push("/home")
    }
  }
}
</script>

<style scoped>

</style>