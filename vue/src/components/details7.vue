<template>
  <el-container style="height: 100%; background-color: #409eff20">
    <el-header>
      <el-row>
        <el-col :span="6">
          <div class="title" style="font-size: 20px;">已验收项目：云存储服务</div>
        </el-col>
        <el-col :span="4" :offset="14">
          <div class="button" style="margin-top: 10px;">
            <el-button @click="$router.back(-1)" icon="el-icon-back" style="color: #409eff; margin-right: 5px;">返回</el-button>
          </div>
        </el-col>
      </el-row>
    </el-header>
    <el-main>
      <div class="main">
        <el-table :data="tableData" border style="width: 100%">
          <el-table-column prop="create_date" label="合同创建日期" width="180px"></el-table-column>
          <el-table-column prop="accept_date" label="项目验收日期" width="180"></el-table-column>
          <el-table-column prop="subcompany" label="归属子公司" width="300"></el-table-column>
          <el-table-column prop="client" label="客户" width="180"></el-table-column>
          <el-table-column prop="contract_money" label="合同签订金额(单位：万)" width="200"></el-table-column>
          <el-table-column prop="client_valuation" label="客户满意度（星级）">
            <el-rate v-model="value"
                     disabled
                     show-score
                     text-color="#ff9900"
                     score-template="{value}">>
            </el-rate>
          </el-table-column>
        </el-table>
        <div class="container">
          <div class="chart-wrapper" style="margin: 50px;">
            <h4>项目执行情况</h4>
            <canvas ref="chart"></canvas>
          </div>
          <div class="chart-wrapper" style="margin: 50px;">
            <h4>成本变动情况</h4>
            <canvas ref="lineChart"></canvas>
          </div>
        </div>
        <div>
          <h3>当前合同绩效评估：</h3>
          <h4>时间绩效：</h4> <el-progress :text-inside="true" :stroke-width="22" :percentage="85"></el-progress>
          <h4>成本绩效：</h4> <el-progress :text-inside="true" :stroke-width="22" :percentage="90" status="success"></el-progress>
          <h4>质量绩效：</h4> <el-progress :text-inside="true" :stroke-width="22" :percentage="97" status="success"></el-progress>
        </div>
      </div>
    </el-main>
  </el-container>
</template>
  
  
  <script>
  import Chart from 'chart.js/auto';
  export default
  {
      data() {
          return {
            tableData: [{
              create_date:'2021-11-03',
              accept_date:'2022-04-06',
              subcompany:'字节守护者',
              client:'客户7',
              contract_money:400,
          
            }],
            value: 4.8,
            inputValue: ''
          }
      },
      mounted() {
      this.$nextTick(() => {
        this.drawChart();
        this.drawLineChart();
        this.restoreInputValue();
      });
    },
      methods: {
      goBack() {
        this.$router.push({ name: 'accepted' });
      },
      huibao() {
          this.$message({
          message: '汇报成功！',
          duration: 5000,
          type: 'success', 
          showClose: true, 
          customClass: 'custom-message',
          center: true, 
          offset: 80, 
          iconClass: 'el-icon-message-solid', 
          })
        },
        saveInputValue() {
      localStorage.setItem('inputValue', this.inputValue);
    },
    restoreInputValue() {
      const savedValue = localStorage.getItem('inputValue');
      if (savedValue) {
        this.inputValue = savedValue;
      }
    },
      drawChart() {
        const canvas = this.$refs.chart;
  
        // 模拟柱状图数据
        const data = {
          labels: ['2021-11', '2021-12', '2022-01','2022-02','2022-03','2022-04'],
          datasets: [
            {
              label: '预期值',
              data: [70,85,75,80,90,95],
              backgroundColor: 'rgba(54, 162, 235, 0.5)',
              borderColor: 'rgb(54, 162, 235)',
              borderWidth: 0.1,
            },
            {
              label: '实际值',
              data: [80, 90, 85,97,85,95],
              backgroundColor: 'rgba(255, 99, 132, 0.5)',
              borderColor: 'rgb(255, 99, 132)',
              borderWidth: 1,
            },
          ],
        };
  
        // 创建柱状图图表实例
        new Chart(canvas, {
          type: 'bar',
          data: data,
          options: {
            scales: {
              x: {
                display: true,
                title: {
                  display: true,
                  text: '日期',
                },
              },
              y: {
                display: true,
                title: {
                  display: true,
                  text: '进度（百分比）',
                },
              },
            },
          },
        });
      },
      drawLineChart() {
        const canvas = this.$refs.lineChart;
  
        // 折线图数据
        const data = {
          labels: ['2021-11', '2021-12', '2022-01','2022-02','2022-03','2022-04'],
          datasets: [
          {
              label: '预期值',
              data: [100,120,90,80,100,110],
              backgroundColor: 'rgba(54, 162, 235, 0.5)',
              borderColor: 'rgb(54, 162, 235)',
              borderWidth: 1,
              fill: false,
            },
            {
              label: '实际值',
              data: [138,123,86,88,84,97],
              backgroundColor: 'rgba(255, 99, 132, 0.5)',
              borderColor: 'rgb(255, 99, 132)',
              borderWidth: 1,
              fill: false,
            },
          ],
        };
  
        // 创建折线图实例
        new Chart(canvas, {
          type: 'line',
          data: data,
          options: {
            responsive: true,
            scales: {
              x: {
                display: true,
                title: {
                  display: true,
                  text: '日期',
                },
              },
              y: {
                display: true,
                title: {
                  display: true,
                  text: '值(单位：千)',
                },
              },
            },
          },
        });
      },
    }
  }
  </script>


<style lang="scss" scoped>
.container{
  display:flex;
  flex-direction: row;
}
.chart-container, .line-chart-container {
  width: 50%;
  height: 400px;
}

.chart-wrapper {
  border: 1px solid #ccc;
  padding: 20px;
  position: relative;
  width :40%;
}

.chart-wrapper h2 {
  position: absolute;
  top: 0;
  left: 0;
  margin: 0;
  padding: 10px;
  background-color: rgba(64,158,255,0.2);
  font-size: 18px;
  font-weight: bold;
}
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
    height: 130%;
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
  