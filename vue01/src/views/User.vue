<template>
  <div>

    <div style="padding: 10px 0">
      <el-input style="width: 200px" placeholder="请输入党员姓名查找" suffix-icon="el-icon-search" v-model="username"  @keyup.enter.native="triggerClick"></el-input>
      <el-button class="ml-5" type="primary" @click="load" ref="btn">搜索</el-button>
      <el-button class="ml-5" type="warning" @click="reset">重置</el-button>
    </div><!--搜索框-->

    <div style="margin: 10px 0">
      <el-button type="primary" @click="handleAdd">新增 <i class="el-icon-circle-plus-outline"></i> </el-button>
      <el-popconfirm
          class="ml-5"
          confirm-button-text='确定'
          cancel-button-text='取消'
          icon="el-icon-info"
          icon-color="red"
          title="您确定批量删除这些数据吗？"
          @confirm="delBatch">
        <el-button type="danger" slot="reference">批量删除 <i class="el-icon-remove-outline"></i> </el-button>
      </el-popconfirm>
      <el-upload action="http://localhost:9090/user/import" :show-file-list="false" :on-success="handleExcelImportSuccess" accept="xlsx" style="display: inline-block">
      <el-button type="primary" class="ml-5">导入 <i class="el-icon-bottom"></i> </el-button>
      </el-upload>
      <el-button type="primary" @click="exp" class="ml-5">导出 <i class="el-icon-top"></i> </el-button>
    </div>

    <el-table :data="tableData" border stripe :header-cell-class-name="headerBg" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55">
      </el-table-column>
      <el-table-column prop="id" label="党员编号" width="80" align="center">
      </el-table-column>
      <el-table-column prop="username" label="姓名" width="140" align="center">
      </el-table-column>
      <el-table-column prop="nickname" label="政治面貌" width="120" align="center">
      </el-table-column>
      <el-table-column prop="email" label="邮箱" align="center">
      </el-table-column>
      <el-table-column prop="phone" label="电话" align="center">
      </el-table-column>
      <el-table-column prop="address" label="地址" align="center">
      </el-table-column>
      <el-table-column label="修改操作" align="center">
        <template slot-scope="scope">
          <el-button type="success" @click="handleEdit(scope.row)">编辑 <i class="el-icon-edit"></i></el-button>
          <el-popconfirm
              class="ml-5"
              confirm-button-text='确定'
              cancel-button-text='取消'
              icon="el-icon-info"
              icon-color="red"
              title="确定删除吗？"
              @confirm="del(scope.row.id)">
            <el-button type="danger" slot="reference" >删除 <i class="el-icon-remove-outline"></i></el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="padding: 10px 0">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[5, 10, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination><!--分页栏-->
    </div>

    <el-dialog title="用户信息" :visible.sync="dialogFormVisible" width="30%">
      <el-form label-width="80px" size="small">
        <el-form-item label="姓名">
          <el-input v-model="form.username" autocomplete="off"></el-input>
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
          <el-input v-model="form.address" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
export default {
  name: "User",
  data(){
    return {
      tableData:[],
      total:0,
      pageNum:1,
      pageSize:10,
      phone:"",
      username:"",
      nickname:"",
      form:{},
      dialogFormVisible:false,
      multipleSelection:[],
      headerBg:'headerBg'
    }
  },
  created() {
    //请求分页查询数据
    this.load()
  },
  methods:{
    load(){
      this.request.get("/user/page",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize,
          username:this.username
        }

      }).then(res =>{

        this.tableData = res.data.records
        this.total = res.data.total

      })

    },

    save(){
      this.request.post("/user",this.form).then(res => {
        if (res.code === '200'){
          this.$message.success("保存成功！")
          this.dialogFormVisible = false
          this.load()
        }else {
          this.$message.error("保存失败！")
        }
      })
    },

    del(id){
      this.request.delete("/user/"+id).then(res => {
        if (res.code === '200'){
          this.$message.success("删除成功！")
          this.dialogFormVisible = false
          this.load()
        }else {
          this.$message.error("删除失败！")
        }
      })
    },

    handleSelectionChange(val){
      console.log(val)
      this.multipleSelection = val
    },

    delBatch(){
      let ids = this.multipleSelection.map(v => v.id) //将多选获取的对象扁平化处理，即[{},{},{}] => [1,2,3]
      this.request.post("/user/del/batch",ids).then(res => {
        if (res.code === '200'){
          this.$message.success("批量删除成功！")
          this.load()
        }else {
          this.$message.error("批量删除失败！")
        }
      })
    },

    reset(){
      this.name = ""
      this.load()
    },

    triggerClick(){ //用于回车键触发搜索功能

      this.$refs.btn.$emit('click')

      // this.$refs.select.blur()//解决选择框回车后展示下拉列表问题

    },

    handleAdd(){
      this.dialogFormVisible = true //打开弹窗
      this.form = {}  //把form对象置空
    },

    handleEdit(row){
      this.form = row
      this.dialogFormVisible = true

    },


    handleSizeChange(pageSize){
      console.log(pageSize)
      this.pageSize=pageSize
      this.load()
    },
    handleCurrentChange(pageNum){
      console.log(pageNum)
      this.pageNum=pageNum
      this.load()
    },
    exp(){
      window.open("http://localhost:9090/user/export")
    },
    handleExcelImportSuccess(){
      this.$message.success("文件导入成功！")
      this.load()
    }
  }
}
</script>

<style>
.headerBg{
  background-color: #eee!important;
}
</style>