<template>
  <el-container style="height: 100%; background-color: #409eff20">
    <el-header>
      <el-row>
        <el-col :span="6">
          <div class="title">专题分析</div>
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
      <el-input v-model="search" placeholder="搜索你想要的">
        <el-button slot="append" icon="el-icon-search"></el-button>
      </el-input>
      <el-table
          :data="tableData.filter(data => !search || data.project_name.toLowerCase().includes(search.toLowerCase()))"
          height="530px"
          border
          style="width: 100%"
      >
        <el-table-column prop="project_name" label="项目名称" width="250"></el-table-column>
        <el-table-column prop="contract_money" label="合同签订金额（单位：万）" width="180"></el-table-column>
        <el-table-column prop="create_date" label="合同创建日期" width="180"></el-table-column>
        <el-table-column prop="accept_date" label="项目验收日期" width="180"></el-table-column>
        <el-table-column prop="subcompany" label="归属子公司" width="300"></el-table-column>
        <el-table-column prop="client" label="客户" width="180"></el-table-column>
        <el-table-column label="详细情况" width="180">
          <template slot-scope="scope">
            <el-button type="primary" @click="showDetails(scope.$index)">
              查看详情
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>


<script>
    export default {
      data() {
        return {
          tableData: [{
            project_name:'人工智能助手',
            contract_money:500,
            create_date:'2023-01-03',
            accept_date:'2023-04-03',
            subcompany:'海克斯股份有限公司',
            client:'客户1',
        
          }, {
            project_name:'网络安全解决方案',
            contract_money:470,
            create_date:'2022-12-12',
            accept_date:'2023-03-13',
            subcompany:'风铃网络安全保护',
            client:'客户2',
            
          }, {
            project_name:'区块链技术',
            contract_money:550,
            create_date:'2022-10-19',
            accept_date:'2023-02-17',
            subcompany:'赛博科技',
            client:'客户3',
            
          }, {
            project_name:'软件测试自动化工具',
            contract_money:300,
            create_date:'2022-06-16',
            accept_date:'2022-10-18',
            subcompany:'代码天才',
            client:'客户4',
            
          },{
            project_name:'虚拟现实游戏',
            contract_money:350,
            create_date:'2022-05-12',
            accept_date:'2022-09-13',
            subcompany:'赛博科技',
            client:'客户5',
           
          },
          {
            project_name:'人脸识别系统',
            contract_money:150,
            create_date:'2022-02-14',
            accept_date:'2022-05-12',
            subcompany:'数据堡垒',
            client:'客户6',
            
          },
          {
            project_name:'云存储服务',
            contract_money:400,
            create_date:'2021-11-03',
            accept_date:'2022-04-06',
            subcompany:'字节守护者',
            client:'客户7',
           
          }
          ],
          search: ''
        }
      },
  
      methods: {
    showDetails(index) {

      if (index === 0) {
        this.$router.push({ name: 'details1' });
      }
      else if (index ===1){
        this.$router.push({ name: 'details2' });
      }
      else if (index ===2){
        this.$router.push({ name: 'details3' });
      }
      else if (index ===3){
        this.$router.push({ name: 'details4' });
      }
      else if (index ===4){
        this.$router.push({ name: 'details5' });
      }
      else if (index ===5){
        this.$router.push({ name: 'details6' });
      }
      else if (index ===6){
        this.$router.push({ name: 'details7' });
      }
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