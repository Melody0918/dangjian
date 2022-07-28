<template>
<el-card style="width: 500px">
  <el-form label-width="80px" size="small">
    <el-upload
      action="https://localhost:9090/file/upload"
      :show-file-list="false">
    </el-upload>

    <el-form-item label="姓名">
      <el-input v-model="form.username" disabled autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="政治面貌">
      <el-input v-model="form.nickname" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="邮箱">
      <el-input v-model="form.email" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="电话">
      <el-input v-model="form.phone" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="地址">
      <el-input type="textarea" v-model="form.address" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="save">确 定</el-button>
      <el-button type="warning" @click="reBack" style="margin-left: 180px">返 回</el-button>
    </el-form-item>
  </el-form>
</el-card>
</template>

<script>
export default {
  name: "Person",
  data(){
    return{
      form:{},
      user:localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    }
  },
  created() {
    this.getUser().then(res => {
      console.log(res)
      this.form = res
    })
  },

  methods:{
    async getUser(){
      return (await this.request.get("/user/username/"+this.user.username)).data
    },
    save(){
      this.request.post("/user",this.form).then(res => {
        if (res.code === '200'){
          this.$message.success("保存成功！")

          //触发父级更新User的方法
          this.$emit("refreshUser")

          //更新浏览器存储用户信息
          this.getUser().then(res => {
            res.token = JSON.parse(localStorage.getItem("user")).token
            localStorage.setItem("user",JSON.stringify(res))
          })

        }else {
          this.$message.error("保存失败！")
        }
      })
    },
    reBack(){
      this.$router.push("/home")
    }
  }
}
</script>

<style scoped>

</style>