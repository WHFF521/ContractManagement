<template>
  <el-container style="height: 100%; background-color: #409eff20">
    <el-header>
      <el-row>
        <el-col :span="6">
          <div class="title">项目详情</div>
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
  <div class="page-container">

    <div class="content">
      <el-table :data="tableData1" border stripe>
        <el-table-column prop="name" label="项目名称"></el-table-column>
        <el-table-column prop="contractAmount" label="合同额（万）"></el-table-column>
        <el-table-column prop="importance" label="重要程度"></el-table-column>
        <el-table-column prop="category" label="项目分类"></el-table-column>
        <el-table-column prop="type" label="项目类型"></el-table-column>
      </el-table>

      <el-table :data="tableData2" border stripe>
        <el-table-column prop="time" label="项目时间"></el-table-column>
        <el-table-column prop="status" label="项目状态"></el-table-column>
        <el-table-column prop="client" label="客户名"></el-table-column>
        <el-table-column label="项目进度">
          <template slot-scope="scope">
            <el-progress :text-inside="true" :stroke-width="15" :percentage="scope.row.progress" ></el-progress>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
      <template>
        <div style="display: flex">
          <ve-gauge-chart class="chart" :data="chartData" :width="800" :height="600" />
          <ve-radar-chart class="chart" :data="chartData2" :width="800" :height="600" :legend="legend" :settings="settings" />
        </div>
      </template>
    </el-main>
  </el-container>
</template>

<script>
export default {
  created () {
    this.chartData = {
      measures: [{
        name: '业务指标',
        data: [
          {
            name: '完成率',
            value: 70
          }
        ]
      }]
    },
        this.legend = { show: false };
    this.settings = {
      itemStyle: { normal: { areaStyle: { type: 'default' } } }   // 面积
    };
    this.chartData2 = {
      dimensions: [
        { name: '成本', max: 6000 },
        { name: '时间', max: 16000 },
        { name: '质量', max: 30000 },
        { name: '风险', max: 35000 },
        { name: '交付', max: 50000 },
        { name: '沟通', max: 25000 }],
      measures: [{name: '2018', data: [5000, 7000, 12000, 11000, 15000, 14000]}]
    }
  },
  data() {
    return {
      tableData1: [
        {
          name: "项目1",
          contractAmount: 100,
          importance: "高",
          category: "分类1",
          type: "类型1"
        }
      ],
      tableData2: [
        {
          time: "2022-01-01",
          status: "进行中",
          client: "客户A",
          progress: 70
        }
      ]
    };
  },
  methods: {
    goBack() {
      // 返回按钮点击事件处理
    }
  }
};
</script>

<style lang="scss" scoped>

.chart {
  flex: 1;
  margin-right: 10px; /* 可根据需要调整图表之间的间距 */
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
