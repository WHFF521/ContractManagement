<template>
  <el-container style="height:100%; background-color: rgba(64,158,255,0.2)">
    <el-header>
      <el-row>
        <el-col :span="6">
          <div class="title">周报评分</div>
        </el-col>
      </el-row>
    </el-header>
    <el-main >
      <div class="main-container" >
        <div class="table-container">
          <el-table ref="singleTable"
                    :data="tableData"
                    highlight-current-row style="width: 100%"
                    @current-change="handleCurrentChange"
                    class="review-table">
            <el-table-column prop="reportId" label="周报序号" width="800"></el-table-column>
            <el-table-column prop="reportDate" label="提交时间" width="200" align="center"></el-table-column>
            <el-table-column prop="managerAccount" label="汇报人" width="180" align="center"></el-table-column>
            <el-table-column prop="score" label="评分" align="center"></el-table-column>
            <el-table-column prop="operate" fixed="right" label="操作" align="center">
              <template slot-scope="scope">
                <el-button type="success" @click="showDialog(scope.row)">评分
                </el-button>
                <el-button type="danger" >删除
                </el-button>
              </template>
            </el-table-column>
          </el-table>
          <div style="text-align: center;">
            <el-pagination @current-change="handleCurrentChange" :current-page="pageNum" :page-size="pageSize" layout="total, prev, pager, next" :total="total"></el-pagination>
          </div>
          <el-dialog :visible="dialogVisible" title="评分" style="width: 100%;" @close="closeDialog">
            <el-form :model="Score" class="demo-ruleForm">
              <el-row :gutter="20" >
                <el-col :span="6" align="middle">
                  <el-form-item label="汇报人:" >
                    <el-input
                        :readonly="true"
                        v-model="Score.huibaoren"
                        class="demo-ruleForm">
                    </el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="8" align="middle">
                  <el-form-item label="提交时间:" align="middle">
                    <el-input
                        :readonly="true"
                        v-model="Score.puttime"
                        class="demo-ruleForm">
                    </el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row :gutter="20"  >
                <el-col :span="10">
                  <el-form-item label="一周出勤情况"  align="middle" >
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row :gutter="20"  >
                <el-col :span="24">
                  <el-input
                      type="textarea"
                      :rows="3"
                      :readonly="true"
                      v-model="Score.attendance">
                  </el-input>
                </el-col>
              </el-row>
              <el-row :gutter="20"  >
                <el-col :span="10">
                  <el-form-item label="本周工作情况"  align="middle">
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row :gutter="20"  >
                <el-col :span="24">
                  <el-input
                      type="textarea"
                      :rows="3"
                      :readonly="true"
                      v-model="Score.this_week_work">
                  </el-input>
                </el-col>
              </el-row>
              <el-row :gutter="20"  >
                <el-col :span="10">
                  <el-form-item label="下周工作计划"  align="middle">
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row :gutter="20"  >
                <el-col :span="24">
                  <el-input
                      type="textarea"
                      :rows="3"
                      :readonly="true"
                      v-model="Score.next_week_work">
                  </el-input>
                </el-col>
              </el-row>
              <el-row :gutter="20"  >
                <el-col :span="4">
                  <el-form-item label="评分"  style="font-size: 35px" prop="scoring">
                  </el-form-item>
                </el-col>
                <el-col :span="15">
                  <el-rate
                      v-model="Score.scoring"
                      show-score
                      text-color="#ff9900"
                      style="font-size: 30px"
                      score-template="{value}">
                  </el-rate>
                </el-col>
              </el-row>
              <el-row :gutter="20"  >
                <el-col :span="4">
                  <el-form-item label="评语" align="middle" prop="comments">
                  </el-form-item>
                </el-col>
                <el-col :span="15">
                  <el-input
                      type="textarea"
                      :rows="3"
                      v-model="Score.comments">
                  </el-input>
                </el-col>
              </el-row>
            </el-form>

            <span slot="footer" class="dialog-footer">
              <!--                <el-button type="danger">删除客户</el-button>-->
              <el-button @click="closeDialog">取 消</el-button>
              <el-button type="primary" @click="saveDialog">保 存</el-button>
            </span>
          </el-dialog>
        </div>
      </div>
    </el-main>
  </el-container>
</template>

<script>
import request from "@/utils/request";


export default {
  name: "template",
  data(){
    return{
      tableData:[],
      dialogVisible: false,
      total: 0,
      pageNum: 1,
      pageSize: 10,
      currentPage1: 1,
      Score:{
        reportId:'',
        huibaoren:'',
        puttime:'',
        attendance:'',
        this_week_work:'',
        next_week_work:'',
        scoring:'',
        comments:'',
      }
    }
  },
  mounted() {
    this.load();
  },
  methods: {
    showDialog(row){
      this.Score.reportId = row.reportId;
      this.Score.huibaoren = row.managerAccount;
      this.Score.puttime = row.reportDate;
      this.Score.attendance = row.attendanceStatus;
      this.Score.this_week_work = row.workThisWeek;
      this.Score.next_week_work = row.workNextWeek;
      if(row.score != null){
        this.Score.scoring = row.score;
      }
      if(row.comments != null){
        this.Score.comments = row.comments;
      }
      this.dialogVisible = true;
    },
    closeDialog() {
      this.dialogVisible = false;
    },
    handleCurrentChange(pageNum) {
      this.pageNum = pageNum;
    },
    load(){
       request.get("http://localhost:8888/api/weekly-reports/findall").then(res => {
         this.tableData = res;
       })
    },
    saveDialog(){
      const weeklyReportDTO={
        reportComment:this.Score.comments,
        score: this.Score.scoring
      }
      request.put("http://localhost:8888/api/weekly-reports/setScore/"+this.Score.reportId,weeklyReportDTO).then(res => {
        console.log(res)
        this.load()
        this.dialogVisible = false;
      })
    }

  }
}
</script>

<style lang="scss" scoped>
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


.el-main{
  padding-top: 0;
  .main-container {
    padding:  10px 20px;
    height: 100%;
    background-color: #ffffff;
  }
  .table-container {
    margin-top: 10px;
    box-shadow: 0 5px 12px #e3e3e3;
    padding: 10px;
  }
}

.custom-table .el-table__header-wrapper th {
  background-color: transparent;
}

.title-font {
  display: flex;
  font-size: 20px;
  font-weight: 350;
  margin-top: 0;
  margin-left: 0;
}

.custom-divider {
  margin-top: 0;
  margin-bottom: 0;
}

.headerBg {
  background: #e3e3e3 !important;
}

.demo-ruleForm{
  margin-right:20px;
}
</style>