<template>
  <div class="page-container">
    <div class="header">
      <div class="title">项目详情</div>
      <el-button type="primary" icon="el-icon-back" @click="$router.back(-1)" plain>返回</el-button>
    </div>
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
</template>

<script>
export default {
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

<style scoped>
.page-container {
  position: fixed;
  height: 100%;
  width: 100%;
  background-color: rgba(64, 158, 255, 0.2);
  padding: 20px;
  display: flex;
  flex-direction: column;
}

.header {
  display: flex;
  justify-content: space-between;
  padding: 20px;
  align-items: center;
  border-bottom: 1px solid #ebeef5;
}

.title {
  font-size: 24px;
  font-weight: bold;
}

.back-button {
  margin-left: 20px;
}

.content {
  padding: 20px;
  background-color: #ffffff;
  border: 1px solid #ebeef5;
  border-radius: 4px;
  margin-top: 20px;
}
</style>
