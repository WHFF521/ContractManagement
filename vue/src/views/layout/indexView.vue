 <template>
  <div class="wrap" >
    <div class="top">
      <el-row>
        <el-col :span="10">
          <div class="top-left">
            <p>CVA项目管理系统</p>
            
          </div>
        </el-col>
        <el-col :span="12">
          <div class="top-middle">
        <el-menu
          :default-active="activeIndex"
          class="el-menu-1"
          mode="horizontal"
          @select="handleSelect"
          text-color="#ffffff"
          active-text-color="#ffffff"
        >
          <el-menu-item index="1" disabled>工作台</el-menu-item>
          <el-menu-item index="2">合同</el-menu-item>
          <el-menu-item index="3" disabled>项目</el-menu-item>
          <el-menu-item index="4" disabled>需求</el-menu-item>
          <el-menu-item index="5" disabled>缺陷</el-menu-item>
          <el-menu-item index="6" disabled>PMO</el-menu-item>
        </el-menu>
      </div>
        </el-col>
        <el-col :span="2">
          <div class="top-right">
        <el-dropdown @command="handleLogout" trigger="click">
          <span class="el-dropdown-link">
            <i class="el-icon-user-solid"></i>
            {{this.userName}}
            <i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="a">登出</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
        </el-col>
      </el-row>
    </div>
    <div class="secondSelector">
      <div class="left"></div>
      <div class="right">
        <el-menu
          :default-active="activeIndex1"
          class="el-menu-2"
          mode="horizontal"
          @select="handleSelect"
          text-color="#A0CFFF"
          active-text-color="#409eff"
          router
        >
          <el-menu-item index="/contractBoard">合同看板</el-menu-item>
          <el-menu-item index="/myCustomers">客户</el-menu-item>
          <el-menu-item index="/myWeeklyReport">周报</el-menu-item>
          <el-menu-item index="/contractAnalyze" v-if="isContractAnalyzeVisible">专题分析</el-menu-item>
        </el-menu>
      </div>
    </div>
    <el-container>
      <el-main >
        <router-view> </router-view>
      </el-main>
    </el-container>
    <!-- <div class="main" style=" height: calc(100vh - 125px); overflow: hidden;">
      <div class="main-view" style="height: 100%;overflow-y: auto;">
        
      </div>
    </div> -->
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeIndex: "2",
      activeIndex1: "/contractBoard",
      isContractAnalyzeVisible: false,
      userName: ""
    };
  },
  mounted() {
    let userData = localStorage.getItem("userData");
    if (userData) {
      let user = JSON.parse(userData);
      this.userName = user.userName;
    } else {
      this.userName = "未登入"
    }
    this.checkContractAnalyzeVisibility(); // 在组件挂载时调用检查函数的可见性
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleLogout(command) {
      if (command === "a"){
        console.log("12313131");
        // 执行登出操作，比如清除 localStorage 中的用户信息
        localStorage.removeItem('userData');
        // 导航到登录页，比如使用路由跳转
        this.$router.push('/login');
      }
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClick(tab, event) {
      console.log(tab, event);
    },
    checkContractAnalyzeVisibility(){
      const userData = JSON.parse(localStorage.getItem("userData"));
      const userRole = userData ? userData.userRole : null;
      if(!userRole){
        this.isContractAnalyzeVisible = false;
        return;
      }
      console.log(userRole)
      if(userRole === 1){
        this.isContractAnalyzeVisible = false;
      }
      else {
        this.isContractAnalyzeVisible = true;
      }
    }
  },
};
</script>
<style lang="scss" scoped>
.wrap {
  height: 100%;
  
  .top {
    height: 60px;
    background: #ffffff;
    border-bottom-style: solid;
    border-width: 1px;
    border-color: #e3e3e3;
    background-color: #409eff;
    box-shadow: 0 5px 12px #999999;
    .el-menu-1{
      background-color: #409eff;
      .el-menu-item:hover{
        background-color: #409eff;
      }
      .el-menu-item:focus{
        background-color: #409eff;
      }
    }
    .top-left {
      width: 220px;
      height: 100%;
      text-align: center;
      line-height: 60px;
      font-size: large;
      color: #ffffff;
    }
    .top-middle {
      height: 100%;
      
    }
    .top-right {
      text-align: center;
      height: 100%;
      line-height: 60px;
      .el-dropdown-link {
            cursor: pointer;
            color: #ffffff;
          }
      .el-icon-arrow-down {
            font-size: 12px;
          }
    }
  }
  .secondSelector {
    height: 62px;
    border-bottom-style: solid;
    border-width: 2px;
    border-color: #e3e3e3;
    box-sizing: border-box;
    .left {
      float: left;
      width: 100px;
      height: 100%;
    }
    .right {
      height: 100%;
    }
  }
  .el-main{
    // style="height: calc(100vh - 125px);overflow-y: hidden;padding: 0;"
    height: calc(100vh - 125px);
    //overflow-y: hidden;
    padding: 0;
  }
  // .main {
  //   height: calc(100vh - 125px);
  //   overflow: hidden;
  //   .main-view{
  //     height: 100%;
  //     overflow-y: auto;
  //   }
  // }
}
</style>