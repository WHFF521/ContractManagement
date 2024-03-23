<template>
  <el-container style="height: 100%; background-color: #409eff20">
    <el-main class="left" wight=50%>
      <div
        style="
          height: 100%;
          background-color: white;
          padding: 10px;
          box-sizing: border-box;
        "
      >
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
                <router-link to="/myBoard">
                  更多
                </router-link>
                
              </div>
            </div>
          </el-col>
          <el-col :span="3">
            <div style="text-align: center; height: 100%; line-height: 40px">
              <el-button type="primary" size="small">
                <router-link to="/addContract">新建合同</router-link>
              </el-button>
            </div>
          </el-col>
        </el-row>
        <el-row :gutter="20" style="margin-top: 20px;">
          <el-col :span="18" :offset="2">
            <ul>
              <li v-for="contract in contracts" :key="contract.contractName" style="margin-bottom: 30px;border-bottom-style: solid; border-width: 2px; border-color: #e3e3e3;">
                <div style="margin: 10px;">
                  <div style="display: flex;  margin:5px">
                    <i class="el-icon-s-check" style="color: #409eff; font-size: 25px;font-weight: bold;margin-right: 5px; line-height: 35px;"></i>
                    <p style="float: left; margin-right: 10px; font-size: 20px; color: #666666; font-weight: bold;line-height: 35px;">{{ contract.contractName }}</p>
                    <el-button type="text" style="float: left;margin-right: 10px;" @click="findFileByName(contract.contractContent)">合同正文预览</el-button>
                    <el-button type="text" style="float: left;margin-right: 10px;">查看付款节点</el-button>
                    <el-button type="text" style="float: left;margin-right: 10px;">进入项目</el-button>
                    <!-- <a href="javascripe:;" style="float: left; margin-right: 15px;color: #409eff;">合同正文预览</a> -->
                    <!-- <a href="javascripe:;" style="float: left; margin-right: 15px;color: #409eff;">查看付款节点</a>
                    <a href="javascripe:;" style="float: left;color: #409eff;">进入项目</a> -->
                  </div>
                  <div style="display: flex;line-height: 20px; margin: 5px;">
                    <p style="float: left; margin-right: 15px; color: #999999;">
                      签订时间 {{ contract.signDate }}
                    </p>
                    <p style="float: left;color: #999999;margin-right: 5px;">合同额</p>
                    <p style="float: left;color: #333333;font-size: 20px;font-weight: bold;margin-right: 5px;line-height: 15px;">{{ contract.contractTotal }}</p>
                    <p style="float: left;color: #999999;">万</p>
                  </div>
                </div>
              </li>
            </ul>
          </el-col>
        </el-row>
      </div>
    </el-main>
    <el-main class="right">
      <div
        style="
          height: 100%;
          background-color: white;
          padding: 10px;
          box-sizing: border-box;
        "
      >
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
                <router-link to="/myBoard">
                  更多
                </router-link>
              </div>
            </div>
          </el-col>
          <el-col :span="3">
            <div
              style="text-align: center; height: 100%; line-height: 40px"
            ></div>
          </el-col>
        </el-row>
        <el-row :gutter="20" style="margin-top: 20px;">
          <el-col :span="18" :offset="2">
            <ul>
              <li v-for="contract in contracts1" :key="contract.contractName" style="margin-bottom: 30px;border-bottom-style: solid; border-width: 2px; border-color: #e3e3e3;">
                <div style="margin: 10px;">
                  <div style="display: flex;  margin:5px">
                    <i class="el-icon-s-check" style="color: #409eff; font-size: 25px;font-weight: bold;margin-right: 5px; line-height: 35px;"></i>
                    <p style="float: left; margin-right: 10px; font-size: 20px; color: #666666; font-weight: bold;line-height: 35px;">{{ contract.contractName }}</p>
                    <el-button type="text" style="float: left;margin-right: 10px;" @click="findFileByName(contract.contractContent)">合同正文预览</el-button>
                    <el-button type="text" style="float: left;margin-right: 10px;">查看付款节点</el-button>
                    <el-button type="text" style="float: left;margin-right: 10px;">进入项目</el-button>
                    <!-- <a href="javascripe:;" style="float: left; margin-right: 15px;color: #409eff;">合同正文预览</a> -->
                    <!-- <a href="javascripe:;" style="float: left; margin-right: 15px;color: #409eff;">查看付款节点</a>
                    <a href="javascripe:;" style="float: left;color: #409eff;">进入项目</a> -->
                  </div>
                  <div style="display: flex;line-height: 20px; margin: 5px;">
                    <p style="float: left; margin-right: 15px; color: #999999;">
                      签订时间 {{ contract.signDate }}
                    </p>
                    <p style="float: left;color: #999999;margin-right: 5px;">合同额</p>
                    <p style="float: left;color: #333333;font-weight: bold;font-size: 20px;line-height: 15px; margin-right: 5px;">{{ contract.contractTotal }}</p>
                    <p style="float: left;color: #999999;">万</p>
                  </div>
                </div>
              </li>
            </ul>
          </el-col>
        </el-row>
      </div>
    </el-main>
  </el-container>
</template>

<script>
import request from '@/utils/request';

export default {
  data() {
    return {
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

<style lang="scss">

.el-tabs__nav-wrap::after {
  background-color: #ffffff;
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
  }
  .more:hover{
    color: #409eff;
  }
}
</style>