<template>
  <el-container style="height: 730px; background-color: #409eff20">
    <el-header>
      <el-row>
        <el-col :span="6">
          <div class="title">新建周报</div>
        </el-col>
        <el-col :span="4" :offset="14">
          <div class="button">
            <router-link to>
              <el-button @click="$router.back(-1)" icon="el-icon-back" style="color: #409eff;margin-right: 5px;">返回</el-button>
            </router-link>
          </div>
        </el-col>
      </el-row>
    </el-header>
    <el-main>
      <div class="main">
        <div class="block" style="margin-top: 10px">
          <el-form style="margin-left: 40px; display: flex; align-items: center;">
            <el-form-item label="提交时间" :required="true" style="width: 400px; margin-right: 20px;display: flex">
              <el-date-picker
                  type="date"
                  placeholder="选择日期"
                  v-model="signingData.Data"
                  value-format="yyyy-MM-dd"
                  style="width: 270%;"
                  size="large"
                  :rules="[
          { required: true, message: '请选择提交时间', trigger: 'change' }
        ]"
              ></el-date-picker>
            </el-form-item>
          </el-form>
        </div>
        <div class="block">
          <el-form style="margin-left: 40px; display: flex; align-items: center;">
            <el-form-item label="交付主管" :required="true" style="width: 400px; margin-right: 20px; display: flex;">
              <el-select
                  v-model="supervisorName.Name"
                  placeholder="请选择"
                  style="width: 288%;"
                  :rules="[{ required: true, message: '请选择交付主管', trigger: 'change' }]">
                <el-option
                    v-for="item in supervisorName.supervisorNameOpinions"
                    :key="item.name"
                    :label="item.name"
                    :value="item.name"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-form>
        </div>
        <div class="block">
          <el-form style="margin-left: 13px;">
            <el-form-item label="一周出勤情况" :required="true" style="align-items: flex-start;">
              <el-input
                  type="textarea"
                  :rows="3"
                  placeholder="请输入内容"
                  v-model="attendanceStatus.attendanceStatusTextarea"
                  style="width: 1400px; margin-top: 15px;"
                  :rules="[{ required: true, message: '请输入一周出勤情况', trigger: 'blur' }]">
              </el-input>
            </el-form-item>
          </el-form>
        </div>
        <div class="block">
          <el-form style="margin-left: 13px;">
            <el-form-item label="本周工作情况" :required="true" style="align-items: flex-start;">
              <el-input
                  type="textarea"
                  :rows="3"
                  placeholder="请输入内容"
                  v-model="workThisWeek.workThisWeekTextarea"
                  style="width: 1400px; margin-top: 15px;"
                  :rules="[{ required: true, message: '请输入本周工作情况', trigger: 'blur' }]">
              </el-input>
            </el-form-item>
          </el-form>
        </div>
        <div class="block">
          <el-form style="margin-left: 13px;">
            <el-form-item label="下周工作计划" :required="true" style="align-items: flex-start;">
              <el-input
                  type="textarea"
                  :rows="3"
                  placeholder="请输入内容"
                  v-model="workNextWeek.workNextWeekTextarea"
                  style="width: 1400px; margin-top: 15px;"
                  :rules="[{ required: true, message: '请输入下周工作计划', trigger: 'blur' }]">
              </el-input>
            </el-form-item>
          </el-form>
        </div>
        <div class="block" style="display: flex; justify-content: center; margin-top: 20px;">
          <el-button type="primary" size="medium" @click="insertWeeklyReportData">提交</el-button>
        </div>
      </div>
    </el-main>
  </el-container>
</template>
<style scoped lang="scss">
.el-header {
  align-items: center;
  padding: 0 20px;
  height: 60px;
}

.title {
  font-size: 25px;
  font-weight: bold;
  line-height: 60px;
}

.button {
  display: flex;
  align-items: center;
  justify-content: flex-end;
  height: 100%;
  line-height: 60px;
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
</style>
<script>

import request from "@/utils/request";
import {Message} from "element-ui";

export default {
  created: function(){
    request.get("/sys/users/userName").then(res =>{
      this.supervisorName.supervisorNameOpinions = res
    })
  },
  data() {
    return {
      signingData: {
        Data: "",
      },
      supervisorName:{
        Name:"",
        supervisorNameOpinions:[],
      },
      attendanceStatus:{
        attendanceStatusTextarea:"",
      },
      workThisWeek:{
        workThisWeekTextarea:"",
      },
      workNextWeek:{
        workNextWeekTextarea:"",
      },
      userAccount:{
        userAccount:"",
      }
    }
  },
  mounted() {
    this.getUserAccount()
  },
  methods: {
    getUserAccount(){
      let userData = localStorage.getItem("userData");
      let user = JSON.parse(userData);
      this.userAccount.userAccount=user.userAccount;
      // console.log(user)
    },
    insertWeeklyReportData() {
      return new Promise((resolve, reject) => {
        const weeklyReportData = {
          reportDate: this.signingData.Data,
          supervisorName: this.supervisorName.Name,
          attendanceStatus: this.attendanceStatus.attendanceStatusTextarea,
          workThisWeek: this.workThisWeek.workThisWeekTextarea,
          workNextWeek: this.workNextWeek.workNextWeekTextarea,
          managerAccount: this.userAccount.userAccount,
        };

        request.post('/api/weekly-reports/addWeeklyReport', weeklyReportData)
            .then(response => {
              console.log(response);
              Message.success('插入周报成功'); // 显示成功提示框
              resolve();
            })
            .catch(error => {
              console.error(error);
              Message.error('插入周报失败'); // 显示失败提示框
              reject('插入周报失败');
            });
      });
    },

  }
}
</script>