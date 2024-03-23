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
      <div class="main">
        <div class="up">
          <el-row>
            <el-col :span="12">
              <div class="nav">
                <el-tabs v-model="activeName" @tab-click="handleClick">
                  <el-tab-pane label="在途合同专题" name="first"></el-tab-pane>
                  <el-tab-pane label="已交付项目专题" name="second"></el-tab-pane>
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
            <el-table-column prop="pr" label="当前进度"  align="center">
              <template #default="scope">
                <el-progress :percentage="calculateProgress(scope.row)"></el-progress>
              </template>
              
            </el-table-column>
          </el-table>
          <div style="text-align: center;">
            <el-pagination @current-change="handleCurrentChange" :current-page="pageNum" :page-size="pageSize" layout="total, prev, pager, next" :total="total"></el-pagination>
          </div>
        </div>
        <div style="display: flex">
          <div ref="chartContainer" style="width: 800px;height: 400px; margin-left: 50px;;margin-top: 30px"></div>
          <div id="pie-chart-container" style="width: 800px; height: 400px; margin-left: 130px;margin-top: 30px"></div>
        </div>
      </div>


    </el-main>
  </el-container>
</template>

<script>
import request from "@/utils/request";
import echarts from 'echarts'
export default {
  data() {
    return {
      // chart:null,
      activeName: "first",
      total: 0,
      pageNum: 1,
      pageSize: 2,
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
    this.startProgress();
    this.initChart();
    this.initPieChart();
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
    initPieChart() {
      // 获取图表容器
      const chartContainer = document.getElementById('pie-chart-container');
      // 初始化图表
      const chart = echarts.init(chartContainer);

      // 设置饼状图的数据和配置项
      request.get('http://localhost:8888/sys/CustomersLevelDTO/getLevelDistribution')
          .then(response => {
            // 在请求成功后处理数据
            const data = response;
            console.log(data)
            const colors = ['#f56c6c', '#67c23a','#409eff', '#e6a23c','#909399'];

            // 构造图表配置项
            const option = {
              title: {
                text: '客户等级分布', // 图表标题
                x: 'center' // 标题位置（可选值：'left'、'center'、'right'）
              },
              series: [
                {
                  name: '数据名称', // 系列名称
                  type: 'pie', // 图表类型（饼状图）
                  roseType:'radius',
                  radius: '80%', // 饼状图半径（可设置为百分比或像素值）
                  center: ['50%', '50%'], // 饼状图中心位置
                  data: data.map((item,index)=>({
                    value:item.count,
                    name:item.customerLevel,
                    itemStyle: {
                      color: colors[index % colors.length] // 指定颜色
                    }
                  })),
                  itemStyle: {
                    emphasis: {
                      shadowBlur: 10,
                      shadowOffsetX: 0,
                      shadowColor: 'rgba(0, 0, 0, 0.5)' // 鼠标悬停时的阴影效果
                    }
                  },
                  label: {
                    show: true, // 显示标签
                    formatter: '{b} ({d}%)' // 标签内容格式化，{b} 表示饼状图扇区名称，{d} 表示饼状图扇区的百分比
                  },
                  labelLine: {
                    show: true // 显示标签的引导线
                  }
                }
              ]
            };

            // 渲染图表
            chart.setOption(option);
          })
          .catch(error => {
            // 处理请求错误
            console.error(error);
          });
    },
    initChart() {
      // 获取图表容器
      const chartContainer = this.$refs.chartContainer;
      // 初始化图表
      const chart = echarts.init(chartContainer)

      // 使用 Axios 发起请求，获取后端接口数据
      request.get('http://localhost:8888/sys/ContractTypesInfoDTO/getCustomersAndMoney')
          .then(response => {
            // 在请求成功后处理数据
            const data = response;
            console.log(data)
            // 对数据按照总合同额进行排序，确保总合同额最多的客户排在上面
            data.sort((a, b) => a.totalAmount - b.totalAmount);
            const colors = ['#f56c6c', '#67c23a','#409eff', '#e6a23c','#909399'];
            // 构造图表配置项
            const option = {
              tooltip: {
                trigger: 'axis',
                axisPointer: {
                  type: 'shadow'
                }
              },
              xAxis: {
                type: 'value',
                name: '总合同额'
              },
              yAxis: {
                type: 'category',
                name: '客户名',
                data: data.map(item => item.customerName)
              },
              series: [{
                type: 'bar',
                data: data.map((item,index) => {
                  return {
                    value: item.totalAmount,
                    itemStyle: {
                      normal: {
                        color: colors[index % colors.length] // 使用自定义颜色数组
                      }
                    }
                  }

                }),
                // barWidth: 20
              }]
            };

            // 渲染图表
            chart.setOption(option);
          })
          .catch(error => {
            // 处理请求错误
            console.error(error);
          });

    },
    handleClick(tab) {
      switch(tab.label) {
        case '履约合同':
          this.currentState = 0
          this.isVisible = true
          this.load()
          break;
      }
    },
    calculateProgress(row) {
      let contractTotal=row.contractTotal;
      while(contractTotal>=100){
        contractTotal/=10;
      }
      return Math.round(contractTotal);
      // return Math.floor(Math.random() * 101); // 生成 0 到 100 之间的随机数
    },
    load() {
      let getData
      const params = {
        state: this.currentState,
        year: this.yearValue,
        contractName: this.input1,
        pageNum: this.pageNum,
        pageSize: 2
      }
      request.get("http://localhost:8888/sys/contractsAndUrlDTO/getContracts",{params}).then(res =>{
        getData = res.data
        this.tableData = getData.records
        this.total = getData.total
      })
      this.tableData.forEach(row => {
        row.progress = this.calculateProgress(row);
      })
    },
    handleCurrentChange(pageNum) {
      this.pageNum = pageNum
      this.load();
    },
    searchButton(){
      // console.log(this.input1)
      // console.log(this.yearValue)
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
    startProgress() {
      this.progress = Math.floor(Math.random() * 101);
    }
  },
};
</script>


<style lang="scss" scoped>
.el-header {
  // display: flex;
  // justify-content: space-between;
  align-items: center;
  // background-color: #ffffff;
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
