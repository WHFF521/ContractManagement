<template>
  <el-container style="height: 100%; background-color: #409eff20">
    <el-header>
      <el-row>
        <el-col :span="6">
          <div class="title">我的周报</div>
        </el-col>
        <el-col :span="4" :offset="14">
          <div class="button">
            <el-button type="primary" icon="el-icon-plus" >
              <router-link to="/addWeeklyReport">
                新建
              </router-link>
            </el-button>
          </div>
        </el-col>
      </el-row>
    </el-header>
    <el-main>
      <div class="main">

        <div class="down">
          <el-table :data="tableData" style="width: 100%" :header-cell-class-name="headerBg">
            <el-table-column prop="number" label="序号" width="600"></el-table-column>
            <el-table-column prop="start_time" label="提交时间" width="200" align="center" sortable></el-table-column>
            <el-table-column prop="state" label="状态" width="200" align="center"></el-table-column>
            <el-table-column prop="score" label="评分" width="180" align="center" sortable></el-table-column>
            <el-table-column label="操作">
              <template #default="scope">
                <el-button type="primary" size="small" @click="showDialog(scope.row)">查看/修改</el-button>
                <el-button type="success" size="small" @click="submitweek(scope.row)">提交</el-button>
                <el-button type="warning" size="small" @click="showDialog2(scope.row)">查看评价</el-button>
                <el-button type="danger" size="small">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </div>
    </el-main>
    <el-dialog title="周报内容" :visible="dialogFormVisible" style="font-size: 50px" top="10px" @close="closeDialog">
      <div style="margin-bottom: 30px;display: flex">
        <div class="block">
          <span class="demonstration" style="margin-right: 20px">提交时间</span>
          <el-date-picker v-model="todayDate" type="date" placeholder="选择日期" readonly></el-date-picker>
        </div>
        <div style="margin-left: 30px">
          <el-form>
            <el-form-item label="交付主管" :required="true" style="display: flex">
              <el-select v-model="supervisorName.Name" placeholder="请选择">
                <el-option
                    v-for="item in supervisorName.supervisorNameOpinions"
                    :key="item.name"
                    :label="item.name"
                    :value="item.name">
                </el-option>
              </el-select>
            </el-form-item>
          </el-form>
        </div>
      </div>
      <div>
        <el-form>
          <el-form-item label="一周出勤情况">
            <el-input
                type="textarea"
                :rows="3"
                placeholder="请输入内容"
                v-model="attendance_status">
            </el-input>
          </el-form-item>
        </el-form>
        <el-form>
          <el-form-item label="本周工作情况">
            <el-input
                type="textarea"
                :rows="3"
                placeholder="请输入内容"
                v-model="work_this_week">
            </el-input>
          </el-form-item>
        </el-form>
        <el-form>
          <el-form-item label="下周工作计划">
            <el-input
                type="textarea"
                :rows="3"
                placeholder="请输入内容"
                v-model="work_next_week">
            </el-input>
          </el-form-item>
        </el-form>
      </div>
      <div style="text-align: right;">
        <el-button @click="closeDialog">取 消</el-button>
        <el-button type="primary" @click="save">保 存</el-button>
      </div>
    </el-dialog>
    <el-dialog title="评分" :visible="dialogFormVisible2" style="font-size: 50px" top="10px" @close="closeDialog2">
      <div style="margin-bottom: 30px;display: flex">
        <div style="margin-right: 30px">
          <el-form>
            <el-form-item label="评价人：" style="display: flex">
              <el-input v-model="value" disabled></el-input>
            </el-form-item>
          </el-form>
        </div>
        <div class="block">
          <span class="demonstration" style="margin-right: 20px">评价时间</span>
          <el-date-picker v-model="todayDate" type="date" placeholder="选择日期" readonly></el-date-picker>
        </div>
      </div>
      <el-form>
        <el-form-item label="评分" style="display: flex;align-items: center;">
          <el-rate
              v-model="Ratevalue"
              disabled
              show-score
              text-color="#ff9900"
              score-template="{value}">
          </el-rate>
        </el-form-item>
      </el-form>

      <el-form>
        <el-form-item label="评语：">
          <el-input
              type="textarea"
              :rows="3"
              placeholder="请输入内容"
              v-model="weekComment">
          </el-input>
        </el-form-item>

      </el-form>
    </el-dialog>
  </el-container>
</template>

<script>
import request from "@/utils/request";

export default {
  created: function () {
    request.get("http://localhost:8888/api/weekly-reports/findall") .then(response => {
      const fetchedData = response;
      request.get("/sys/users/userName").then(res =>{
        this.supervisorName.supervisorNameOpinions = res
      })
      // 对返回的列表数据进行映射和转换
      const adaptedData = fetchedData.map(item => ({
        number: item.reportId,
        start_time: item.reportDate,
        state: item.reportStatus === 0 ? "未提交" : "已提交",
        score: item.score,
        // 其他字段的映射...
      }));

      // 将适配后的数据赋值给 tableData
      this.tableData = adaptedData;
    })
        .catch(error => {
          console.error(error);
        });
  },
  data() {

    return {
      userAccount:{
        userAccount:"",
      },
      chosenNumber:'',
      attendance_status:'',
      work_this_week:'',
      work_next_week:'',
      weekComment:'',
      Ratevalue:'',
      weekAttendance:'',
      todayDate:new Date(),
      dialogFormVisible:false,
      dialogFormVisible2:false,
      activeName: "first",
      total: 0,
      pageNum: 1,
      pageSize: 10,
      input1: "",
      value1: null,
      headerBg: "headerBg",
      supervisorName:{
        Name:"",
        supervisorNameOpinions:[],
      },
      value: '',
      tableData: [],
      currentState: 0,
      isVisible: true,
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
        shortcuts: [{
          text: '今天',
          onClick(picker) {
            picker.$emit('pick', new Date());
          }
        }, {
          text: '昨天',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24);
            picker.$emit('pick', date);
          }
        }, {
          text: '一周前',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', date);
          }
        }]
      },
      value2: '',
    };
  },
  mounted() {
    this.getUserAccount()
  },
  computed: {

  },
  methods: {
    submitweek(row){
      this.$message.success("提交成功！");
      row.state="已提交";
      this.closeDialog();
    },
    getUserAccount(){
      let userData = localStorage.getItem("userData");
      let user = JSON.parse(userData);
      this.userAccount.userAccount=user.userAccount;
      console.log(user.userAccount.userAccount);
      // console.log(user)
    },
    save(){
      const todayDate = new Date();
      const year = todayDate.getFullYear();
      const month = String(todayDate.getMonth() + 1).padStart(2, '0');
      const day = String(todayDate.getDate()).padStart(2, '0');

      const formattedDate = `${year}-${month}-${day}`;
      console.log(formattedDate);
      const report={
        reportId:this.chosenNumber,
        managerAccount:this.userAccount.userAccount,
        supervisorName:this.supervisorName.Name,
        reportStatus:0,
        reportComment:'1',
        reportDate:formattedDate,
        attendanceStatus:this.attendance_status,
        workThisWeek:this.work_this_week,
        workNextWeek:this.work_next_week,
        deleteControl:0,
        score:1
      };
      console.log(report);
      // request.post("http://localhost:8888/sys/weekDTO/updto",report).then((resonse)=>{
      //       this.$message("保存成功！");
      //       console.log(resonse);
      //       this.closeDialog();
      //     }).catch(error => {
      //       console.error(error);
      //       this.$message.error("发生了错误");
      //     });
      this.$message.success("保存成功");
      this.closeDialog();
    },
    showDialog(row) {
      this.chosenNumber=row.number;
      request.get("http://localhost:8888/api/weekly-reports/" + row.number)
          .then(res => {
            this.attendance_status = res.attendanceStatus;
            this.supervisorName.Name = res.supervisorName;
            this.work_this_week = res.workThisWeek;
            this.work_next_week = res.workNextWeek;
          })
          .catch(error => {
            console.error(error);
            this.$message.error("发生了错误");
          });
      this.dialogFormVisible=true;

    },
    closeDialog(){
      this.dialogFormVisible=false;
    },
    showDialog2(row) {
      request.get("http://localhost:8888/api/weekly-reports/" + row.number)
          .then(res => {
            this.value=res.supervisorName;
            this.Ratevalue=res.score;
            this.weekComment=res.reportComment;
          })
          .catch(error => {
            console.error(error);
            this.$message.error("发生了错误");
          });
      this.dialogFormVisible2=true;
    },
    closeDialog2(){
      this.dialogFormVisible2=false;
    },
    submitWeeklyReport(){

    }
  }
}
</script>


<style lang="scss" scoped>

.el-header {
  align-items: center;
  padding: 0 20px;
  height: 60px;
  .title {
    font-size: 25px;
    font-weight: bold;
    line-height: 60px;
  }

  .button {
    line-height: 60px;
    display: flex;
    align-items: center;
    justify-content: flex-end;
    height: 100%;
    margin-top: 10px;
    margin-right: 10px;
  }
}



.el-main {
  padding-top: 0;
  .main {
    padding: 10px 20px;
    height: 100%;
    background-color: #ffffff;

    .up {
      // display: flex;
      // justify-content: space-between;
      align-items: center;
      height: 60px;
      padding: 5px;
      box-sizing: border-box;

      .nav {
        margin-left: 20px;
      }

      .search {
        display: flex;
        align-items: center;
        justify-content: flex-end;
      }
    }

    .down {
      box-shadow: 0 5px 12px #e3e3e3;
      padding: 10px;
    }
  }
}

.headerBg {
  background: #e3e3e3 !important;
}
</style>
