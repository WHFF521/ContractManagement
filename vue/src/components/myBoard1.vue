<template>
    <el-container style="height: 100%; background-color: #409eff20">
      <el-header>
        <el-row>
          <el-col :span="6">
            <div class="title">我的合同</div>
          </el-col>
          <el-col :span="4" :offset="14">
            <div class="button">
              <el-button type="primary" icon="el-icon-plus" style="margin-right: 10px;">
                <router-link to="/addContract">新增</router-link>
              </el-button>
              <router-link to>
                <el-button @click="$router.back(-1)" icon="el-icon-back" style="color: #409eff;margin-right: 5px;">返回</el-button>
              </router-link>
            </div>
          </el-col>
        </el-row>
      </el-header>
      <el-main>
        <div class="main">
          <div class="up">
            <el-row>
              <el-col :span="12">
                <div class="nav">
                  <el-tabs v-model="activeName" @tab-click="handleClick">
                    <el-tab-pane label="履约合同" name="first"></el-tab-pane>
                    <el-tab-pane label="已交付合同" name="second"></el-tab-pane>
                  </el-tabs>
                </div>
              </el-col>
              <el-col :span="12">
                <div class="search">
                  <el-input placeholder="请输入合同名称" prefix-icon="el-icon-search" v-model="input1" style="width: 200px; margin-right: 10px;"></el-input>
                  <el-date-picker v-model="value1" type="year" placeholder="选择年" style="width: 200px; margin-right: 10px;"></el-date-picker>
                  <el-button type="primary" style="margin-right: 20px;" @click="searchButton">查询</el-button>
                </div>
              </el-col>
            </el-row>
          </div>
          <div class="down">
            <el-table :data="tableData" style="width: 100%" :header-cell-class-name="headerBg">
              <el-table-column prop="contractName" label="合同名称" width="800"></el-table-column>
              <el-table-column prop="contractTotal" label="合同额（单位:万元）" width="200" align="center" sortable></el-table-column>
              <el-table-column prop="customerName" label="客户名称" width="200" align="center"></el-table-column>
              <el-table-column prop="signDate" label="签订日期" width="180" align="center" sortable></el-table-column>
              <el-table-column label="操作" fixed="right" align="center">
                <template slot-scope="scope">
                  <el-button type="text"><router-link to="/enterProjectView">进入项目</router-link></el-button>
                  <el-button type="text" @click="showPaymentPopUp(scope.row)">查看付款节点</el-button>
                  <el-button type="text" @click="previewContract(scope.row)">合同正文预览</el-button>

                  <el-button type="text" v-show="isVisible" @click="handleCloseContract(scope.row)">关闭合同</el-button>
                </template>
              </el-table-column>
            </el-table>

            <div style="text-align: center;">
              <el-pagination @current-change="handleCurrentChange" :current-page="pageNum" :page-size="pageSize" layout="total, prev, pager, next" :total="total"></el-pagination>
            </div>
          </div>
        </div>
      </el-main>
      <PaymentNodePopup ref="paymentNodePopup" @close="hidePaymentPopUp"></PaymentNodePopup>
    </el-container>
  </template>
  
  <script>
  import request from "@/utils/request";
  import PaymentNodePopup from "@/components/PaymentNodePopup.vue";
  export default {
    components:{
      PaymentNodePopup
    },
    data() {
      return {
        payPopVisable:false,
        activeName: "first",
        total: 0,
        pageNum: 1,
        pageSize: 10,
        input1: "",
        value1: null,
        headerBg: "headerBg",
        tableData: [],
        currentState: 0,
        isVisible: true
      };
    },
    mounted() {
      this.load()
    },
    computed: {
      yearValue() {
        if (this.value1) {
          const date = new Date(this.value1);
          return date.getFullYear().toString();
        }
        return '';
      },
    },
    methods: {
      showPaymentPopUp(row){
        this.$refs.paymentNodePopup.showPayDialog(row.contractName);
      },
      hidePaymentPopUp(){
        this.payPopVisable=false;
      },
      handleClick(tab) {
        switch(tab.label) {
          case '履约合同':
            this.currentState = 0
            this.isVisible = true
            this.load()
            break;
          case '已交付合同':
            this.currentState = 1
            this.isVisible = false
            this.load()
            break;
        }
      },
      load() {
        let getData;
        const params = {
          state: this.currentState,
          year: this.yearValue,
          contractName: this.input1,
          pageNum: this.pageNum,
          pageSize: this.pageSize
        }
        request.get("http://localhost:8888/sys/contractsAndUrlDTO/getContracts",{params}).then(res =>{
          getData = res.data
          this.tableData = getData.records
          this.total = getData.total
        })
      },
      handleCurrentChange(pageNum) {
        this.pageNum = pageNum
        this.load();
      },
      searchButton(){
        let getData
        const params = {
          state: this.currentState,
          year: this.yearValue,
          contractName: this.input1,
          pageNum: 1,
          pageSize: 10
        }
        request.get("http://localhost:8888/sys/contractsAndUrlDTO/getContracts",{params}).then(res =>{
          getData = res.data
          this.tableData = getData.records
          this.total = getData.total
        })
      },
      previewContract(row) {
        const contractContent = row.contractContent;
        // console.log(contractContent)
        let fileData;
        request.get("http://localhost:8888/sys/file/getFileByName?fileName="+contractContent).then(res =>{
          fileData = res.data
          window.open(fileData.url)
        });
      },
      handleCloseContract(row) {
      this.$confirm('是否确定关闭合同？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      })
        .then(() => {
          const contractName = row.contractName;
          console.log(contractName)
          this.closeContract(contractName)
        })
        .catch(() => {
          // 用户点击取消按钮，不执行任何操作
        });
    },
    closeContract(contractName) {
        // 发送PUT请求到后端接口
        request.put("http://localhost:8888/sys/contracts/"+contractName).then(res =>{
          console.log(res)
          this.load()
        })
      },
    },
  };
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
  