<template>
    <el-container style="height: 100%;width: 100%; background-color: #409eff20">
      <el-main>
        <div class="left">
            <div class="left-content">
          <el-row>
            <el-col :span="21">
              <div class="head">
                <div class="title">履约合同</div>
                <div class="nav">
                  <el-tabs
                    v-model="activeName"
                    @tab-click="handleClick"
                    class="leftBoard"
                  >
                    <el-tab-pane label="今年" name="first"></el-tab-pane>
                    <el-tab-pane label="去年" name="second"></el-tab-pane>
                    <el-tab-pane label="2021年" name="third"></el-tab-pane>
                    <el-tab-pane label="2020年" name="fourth"></el-tab-pane>
                  </el-tabs>
                </div>
                <div class="more">
                  <router-link to="/myBoard">更多</router-link>
                </div>
              </div>
            </el-col>
            <el-col :span="3">
              <div class="add-contract">
                <el-button type="primary" size="small">
                  <router-link to="/addContract">新建合同</router-link>
                </el-button>
              </div>
            </el-col>
          </el-row>
          <el-row :gutter="20" style="margin-top: 20px;">
            <el-col :span="18" :offset="2">
              <ul>
                <li
                  v-for="contract in contracts"
                  :key="contract.contractName"
                  class="contract-item"
                >
                  <div class="contract-details">
                    <div class="contract-header">
                      <i class="el-icon-s-check"></i>
                      <p class="contract-name">{{ contract.contractName }}</p>
                      <el-button type="text" class="preview-button" @click="findFileByName(contract.contractContent)">合同正文预览</el-button>
                      <el-button type="text" @click="showPaymentPopUp(contract.contractName)">查看付款节点</el-button>
                      <el-button type="text"><router-link to="/enterProjectView">进入项目</router-link></el-button>
                    </div>
                    <div class="contract-info">
                      <p class="sign-date">签订时间 {{ contract.signDate }}</p>
                      <p class="contract-amount-text">合同额</p>
                      <p class="contract-amount"> {{ contract.contractTotal }} </p>
                      <p class="contract-amount-text">万</p>
                    </div>
                  </div>
                </li>
              </ul>
            </el-col>
          </el-row>
        </div>
          <PaymentNodePopup v-if="payPopVisable" @close="hidePaymentPopUp"></PaymentNodePopup>
        </div>
        <div class="right">
            <div class="right-content">
          <el-row>
            <el-col :span="21">
              <div class="head">
                <div class="title">已交付合同</div>
                <div class="nav">
                  <el-tabs
                    v-model="activeName1"
                    @tab-click="handleClick1"
                    class="leftBoard"
                  >
                    <el-tab-pane label="今年" name="first"></el-tab-pane>
                    <el-tab-pane label="去年" name="second"></el-tab-pane>
                    <el-tab-pane label="2021年" name="third"></el-tab-pane>
                    <el-tab-pane label="2020年" name="fourth"></el-tab-pane>
                  </el-tabs>
                </div>
                <div class="more">
                  <router-link to="/myBoard">更多</router-link>
                </div>
              </div>
            </el-col>
            <el-col :span="3">
              <div class="empty-div"></div>
            </el-col>
          </el-row>
          <el-row :gutter="20" style="margin-top: 20px;">
            <el-col :span="18" :offset="2">
              <ul>
                <li
                  v-for="contract in contracts1"
                  :key="contract.contractName"
                  class="contract-item"
                >
                  <div class="contract-details">
                    <div class="contract-header">
                      <i class="el-icon-s-check"></i>
                      <p class="contract-name">{{ contract.contractName }}</p>
                      <el-button type="text" class="preview-button" @click="findFileByName(contract.contractContent)">合同正文预览</el-button>
                      <el-button type="text" @click="showPaymentPopUp(contract.contractName)">查看付款节点</el-button>
                      <el-button type="text">进入项目</el-button>
                    </div>
                    <div class="contract-info">
                      <p class="sign-date">签订时间 {{ contract.signDate }}</p>
                      <p class="contract-amount-text">合同额</p>
                      <p class="contract-amount"> {{ contract.contractTotal }} </p>
                      <p class="contract-amount-text">万</p>
                    </div>
                  </div>
                </li>
              </ul>
            </el-col>
          </el-row>
        </div>

        </div>
        
      </el-main>

      <PaymentNodePopup ref="paymentNodePopup" @close="hidePaymentPopUp"></PaymentNodePopup>
      
    </el-container>
  </template>

<script>
import request from '@/utils/request';
import PaymentNodePopup from "@/components/PaymentNodePopup.vue";

export default {
  components: {PaymentNodePopup},
  data() {
    return {
      payPopVisable:false,
      activeName: "first",
      activeName1: "first",
      contracts: [],
      contracts1: []
    };
  },
  mounted() {
    this.load(1,2023);
    this.load(0,2023);
  },
  methods: {
    showPaymentPopUp(contractName){
      console.log("!!!!!!");
      // this.payPopVisable=true;
      this.$refs.paymentNodePopup.showPayDialog(contractName);
    },
    hidePaymentPopUp(){
      this.payPopVisable=false;
    },
    handleClick(tab) {
      switch (tab.label) {
        case '今年':
          this.load(0,2023)
          break;
        case '去年':
          this.load(0,2022);
          break;
        case '2021年':
          this.load(0,2021);
          break;
        case '2020年':
          this.load(0,2020);
          break;
        default:
          break;
      }
    },
    handleClick1(tab) {
      switch (tab.label) {
        case '今年':
          this.load(1,2023)
          break;
        case '去年':
          this.load(1,2022);
          break;
        case '2021年':
          this.load(1,2021);
          break;
        case '2020年':
          this.load(1,2020);
          break;
        default:
          break;
      }
    },
    load(state, year) {
    request.get("http://localhost:8888/sys/contracts/getContractByYear?state="+state+"&year="+year).then(res => {
      if(state==0){
        this.contracts=res.data
      }
      else{
        this.contracts1=res.data
      }
    })
  },
  findFileByName(fileName){
    // console.log("fileName",fileName)
    let fileData;
    request.get("http://localhost:8888/sys/file/getFileByName?fileName="+fileName).then(res =>{
      fileData = res.data
      window.open(fileData.url)
    });
  }
  },
};
</script>
  
<style lang="scss" scoped>

  .left{
    float: left;
    width: 50%;
    height: 100%;
    padding: 0 20px;
  }
  .right{
    float: left;
    width: 50%;
    height: 100%;
    padding: 0 20px;
  }
    
  .left-content {
    
    height: 100%;
   
    background-color: white;
    padding: 10px;
    // margin: 20px;
    // margin-right: 50px;
    
    box-sizing: border-box;
  }
  .right-content {
    
    height: 100%;
    
    background-color: white;
    padding: 10px;
    // margin: 20px;
    // margin-left: 50px;
    box-sizing: border-box;
  }
  
  .head {
    text-align: center;
    height: 100%;
  
    .title {
      float: left;
      line-height: 35px;
      margin-right: 40px;
      font-size: medium;
      font-weight: 900;
      color: #333333;
    }
  
    .nav {
      float: left;
      margin-right: 20px;
    }
  
    .more {
      line-height: 40px;
      color: #666666;
      float: left;
  
      &:hover {
        color: #409eff;
      }
    }
  }
  
  .add-contract {
    text-align: center;
    height: 100%;
    line-height: 40px;
  }
  
  .contract-item {
    margin-bottom: 30px;
    border-bottom-style: solid;
    border-width: 2px;
    border-color: #e3e3e3;
  }
  
  .contract-details {
    margin: 10px;
  }
  
  .contract-header {
    display: flex;
    margin: 5px;
  
    i {
      color: #409eff;
      font-size: 25px;
      font-weight: bold;
      margin-right: 5px;
      line-height: 35px;
    }
  
    .contract-name {
      float: left;
      margin-right: 10px;
      font-size: 20px;
      color: #666666;
      font-weight: bold;
      line-height: 35px;
    }
  
    .preview-button {
      float: left;
      margin-right: 10px;
    }
  }
  
  .contract-info {
    display: flex;
    line-height: 20px;
    margin: 5px;
  
    .sign-date {
      float: left;
      margin-right: 15px;
      color: #999999;
    }
    
    .contract-amount-text {
        float: left;
        color: #999999;
        margin-right: 5px;

    }
    
    .contract-amount {
      float: left;
      color: #333333;
      font-size: 20px;
      font-weight: bold;
      margin-right: 5px;
      line-height: 18px;
    }
  }
  
  .empty-div {
    text-align: center;
    height: 100%;
    line-height: 40px;
  }
</style>
  