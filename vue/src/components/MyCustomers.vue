<template>
  <el-container style="height:100%; background-color: rgba(64,158,255,0.2)">
    <el-header>
      <el-row>
          <el-col :span="6">
            <div class="title">客户信息</div>
          </el-col>
          <el-col :span="4" :offset="14">
            <div class="button">
              <el-button type="primary" icon="el-icon-plus"  @click="showDialog" style="margin-right: 10px;">
                新增
              </el-button>
              <router-link to>
                <el-button @click="$router.back(-1)" icon="el-icon-back" style="color: #409eff;margin-right: 5px;">返回</el-button>
              </router-link>
            </div>
          </el-col>
        </el-row>
      <!-- <div style="display: flex; justify-content: space-between; align-items: center;">
        <span style="font-weight: bold;">我的客户</span>
        <el-button type="primary" @click="showDialog" icon="el-icon-plus">新建</el-button> -->
        <el-dialog :visible="dialogVisible" title="新增客户" width="65%" @close="closeDialog">
          <h1 class="title-font" style="margin-top: 0; margin-bottom: 0">基础信息</h1>
          <el-divider class="custom-divider"></el-divider>
          <!-- 添加的客户名称         -->
          <el-form :model="Customers" :rules="rules_customername" label-width="100px" class="demo-ruleForm">
            <el-form-item label="新增客户" prop="name" style="margin-top: 0; margin-bottom: 0">
              <el-input v-model="Customers.customerName" placeholder="请输入客户名称" size="mini"
                style="margin-top: 0; margin-bottom: 0"></el-input>
            </el-form-item>
          </el-form>
          <el-form :inline="true" label-width="100px" label-position="right">
            <el-form-item label="客户级别" prop="region" size="mini" style="width: 33%;margin-top: 0; margin-bottom: 0">
              <el-select v-model="Customers.customerLevel" placeholder="请选择客户级别" style="margin-top: 15px;">
                <el-option label="客户级别1" value="level 1"></el-option>
                <el-option label="客户级别2" value="level 2"></el-option>
                <el-option label="客户级别3" value="level 3"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="行业" prop="region" size="mini" style="width: 33%;margin-top: 0; margin-bottom: 0">
              <el-select v-model="Customers.industry" placeholder="请选择行业" style="margin-top: 15px;">
                <el-option label="行业1" value="shanghai"></el-option>
                <el-option label="行业2" value="beijing"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="邮政编码" prop="name" size="mini" style="width: 30%;margin-top: 0; margin-bottom: 0">
              <el-input style="width: 110%;margin-top: 15px;" v-model="Customers.postalCode" placeholder="请输入邮政编码">
              </el-input>
            </el-form-item>
          </el-form>
          <el-form :inline="true" label-width="100px" label-position="right">
            <el-form-item label="所在省" prop="region" size="mini" style="width: 33%;margin-top: 0; margin-bottom: 0">
              <el-select v-model="Customers.province" placeholder="请选择省份" style="margin-top: 15px;">
                <el-option v-for="province in provinces" :key="province.value" :label="province.label"
                  :value="province.value"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="所在市" prop="region" size="mini" style="width: 33%;margin-top: 0; margin-bottom: 0">
              <el-select v-model="Customers.city" placeholder="请选择市" style="margin-top: 15px;">
                <el-option v-for="city in cities" :key="city.value" :label="city.label" :value="city.value"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="所在县" prop="region" size="mini"
              style="width: 30%; margin-left: 3px;margin-top: 0; margin-bottom: 0">
              <el-select v-model="Customers.county" placeholder="请选择县" style="margin-top: 15px;">
                <el-option v-for="county in counties" :key="county.value" :label="county.label"
                  :value="county.value"></el-option>
              </el-select>
            </el-form-item>
          </el-form>
          <el-form :model="Customers" :rules="rules_customername" label-width="100px" class="demo-ruleForm">
            <el-form-item label="地址" prop="address">
              <el-input v-model="Customers.address" placeholder="请输入客户地址" size="mini"></el-input>
            </el-form-item>
          </el-form>

          <el-divider class="custom-divider"></el-divider>
          <h1 class="title-font" style="margin-top: 0; margin-bottom: 0">发票信息</h1>
          <el-divider class="custom-divider"></el-divider>

          <el-form :inline="true" label-width="100px" label-position="right" style="margin-top: 0;margin-bottom: 0">
            <el-form-item label="单位" prop="company_name" size="mini" style="width: 33%;margin-top: 0; margin-bottom: 0">
              <el-input style="width: 110%;margin-top: 15px;" v-model="Invoice_info.companyName" placeholder="请输入单位">
              </el-input>
            </el-form-item>
            <el-form-item label="税号" prop="tax_number" size="mini" style="width: 33%;margin-top: 0; margin-bottom: 0">
              <el-input style="width: 110%;margin-top: 15px;" v-model="Invoice_info.taxNumber" placeholder="请输入税号">
              </el-input>
            </el-form-item>
            <el-form-item label="电话" prop="phone" size="mini" style="width: 30%;margin-top: 0; margin-bottom: 0">
              <el-input style="width: 110%;margin-top: 15px;" v-model="Invoice_info.phone" placeholder="请输入电话">
              </el-input>
            </el-form-item>
          </el-form>
          <el-form :inline="true" label-width="100px" label-position="right" style="margin-top: 0;margin-bottom: 0">
            <el-form-item label="地址" prop="address" size="mini" style="width: 33%;margin-top: 0; margin-bottom: 0">
              <el-input style="width: 110%;margin-top: 15px;" v-model="Invoice_info.address" placeholder="请输入地址">
              </el-input>
            </el-form-item>
            <el-form-item label="开户行" prop="bank_name" size="mini" style="width: 33%;margin-top: 0; margin-bottom: 0">
              <el-input style="width: 110%;margin-top: 15px;" v-model="Invoice_info.bankName" placeholder="请输入开户行">
              </el-input>
            </el-form-item>
            <el-form-item label="账号" prop="bank_account" size="mini" style="width: 30%;margin-top: 0; margin-bottom: 0">
              <el-input style="width: 110%;margin-top: 15px;" v-model="Invoice_info.bankAccount" placeholder="请输入账号">
              </el-input>
            </el-form-item>
          </el-form>
          <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="submitData">提交</el-button>
          </span>
        </el-dialog>
    </el-header>
    <el-main >
      <div class="main-container" >
        <div class="table-container">
          <el-table ref="singleTable" :data="tableData" highlight-current-row style="width: 100%" :header-cell-class-name="headerBg" @current-change="handleCurrentChange"
            class="custom-table">
            <el-table-column prop="customerName" label="客户名称" width="800"></el-table-column>
            <el-table-column prop="customerLevel" label="客户级别" width="200" align="center">
            </el-table-column>
            <el-table-column prop="industry" label="行业" width="180" align="center"></el-table-column>
            <el-table-column prop="postalCode" label="邮政编码" align="center"></el-table-column>
            <el-table-column prop="operate" fixed="right" label="操作" align="center">
              <template slot-scope="scope">
                <el-button type="text" @click="showDialog2(scope.row)">查看详情/编辑
                </el-button>
              </template>
            </el-table-column>
          </el-table>
          
          <!--          查看修改窗口-->
          <el-dialog :visible="dialogVisible2" title="客户信息" style="width: 100%;" @close="closeDialog">
            <h1 class="title-font" style="margin-top: 0; margin-bottom: 0">基础信息</h1>
            <el-divider class="custom-divider"></el-divider>
            <!-- 添加的客户名称         -->
            <el-form :model="Customers2" label-width="100px" class="demo-ruleForm">
              <el-form-item label="客户名称" prop="name" style="margin-top: 0; margin-bottom: 0">
                <el-input v-model="Customers2.customerName" placeholder="请输入客户名称" :disabled="true" size="mini"
                  style="margin-top: 0; margin-bottom: 0"></el-input>
              </el-form-item>
            </el-form>
            <el-form :inline="true" label-width="100px" label-position="right">
              <el-form-item label="客户级别" prop="region" size="mini" style="width: 33%;margin-top: 0; margin-bottom: 0">
                <el-select v-model="Customers2.customerLevel" placeholder="请选择客户级别" style="margin-top: 15px;">
                  <el-option label="客户级别1" value="level 1"></el-option>
                  <el-option label="客户级别2" value="level 2"></el-option>
                  <el-option label="客户级别3" value="level 3"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="行业" prop="region" size="mini" style="width: 33%;margin-top: 0; margin-bottom: 0">
                <el-select v-model="Customers2.industry" placeholder="请选择行业" style="margin-top: 15px;">
                  <el-option label="行业1" value="shanghai"></el-option>
                  <el-option label="行业2" value="beijing"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="邮政编码" prop="name" size="mini" style="width: 30%;margin-top: 0; margin-bottom: 0">
                <el-input style="width: 110%;margin-top: 15px;" v-model="Customers2.postalCode" placeholder="请输入邮政编码">
                </el-input>
              </el-form-item>
            </el-form>
            <el-form :inline="true" label-width="100px" label-position="right">
              <el-form-item label="所在省" prop="region" size="mini" style="width: 33%;margin-top: 0; margin-bottom: 0">
                <el-select v-model="Customers2.province" placeholder="请选择省份" style="margin-top: 15px;">
                  <el-option v-for="province in provinces" :key="province.value" :label="province.label"
                    :value="province.value"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="所在市" prop="region" size="mini" style="width: 33%;margin-top: 0; margin-bottom: 0">
                <el-select v-model="Customers2.city" placeholder="请选择市" style="margin-top: 15px;">
                  <el-option v-for="city in cities" :key="city.value" :label="city.label" :value="city.value"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="所在县" prop="region" size="mini"
                style="width: 30%; margin-left: 3px;margin-top: 0; margin-bottom: 0">
                <el-select v-model="Customers2.county" placeholder="请选择县" style="margin-top: 15px;">
                  <el-option v-for="county in counties" :key="county.value" :label="county.label"
                    :value="county.value"></el-option>
                </el-select>
              </el-form-item>
            </el-form>
            <el-form :model="Customers2" label-width="100px" class="demo-ruleForm">
              <el-form-item label="地址" prop="address">
                <el-input v-model="Customers2.address" placeholder="请输入客户地址" size="mini"></el-input>
              </el-form-item>
            </el-form>

            <el-divider class="custom-divider"></el-divider>
            <h1 class="title-font" style="margin-top: 0; margin-bottom: 0">发票信息</h1>
            <el-divider class="custom-divider"></el-divider>

            <el-form :inline="true" label-width="100px" label-position="right" style="margin-top: 0;margin-bottom: 0">
              <el-form-item label="单位" prop="company_name" size="mini" style="width: 33%;margin-top: 0; margin-bottom: 0">
                <el-input style="width: 110%;margin-top: 15px;" v-model="Invoice_info2.companyName" placeholder="请输入单位">
                </el-input>
              </el-form-item>
              <el-form-item label="税号" prop="tax_number" size="mini" style="width: 33%;margin-top: 0; margin-bottom: 0">
                <el-input style="width: 110%;margin-top: 15px;" v-model="Invoice_info2.taxNumber" placeholder="请输入税号">
                </el-input>
              </el-form-item>
              <el-form-item label="电话" prop="phone" size="mini" style="width: 30%;margin-top: 0; margin-bottom: 0">
                <el-input style="width: 110%;margin-top: 15px;" v-model="Invoice_info2.phone" placeholder="请输入电话">
                </el-input>
              </el-form-item>
            </el-form>
            <el-form :inline="true" label-width="100px" label-position="right" style="margin-top: 0;margin-bottom: 0">
              <el-form-item label="地址" prop="address" size="mini" style="width: 33%;margin-top: 0; margin-bottom: 0">
                <el-input style="width: 110%;margin-top: 15px;" v-model="Invoice_info2.address" placeholder="请输入地址">
                </el-input>
              </el-form-item>
              <el-form-item label="开户行" prop="bank_name" size="mini" style="width: 33%;margin-top: 0; margin-bottom: 0">
                <el-input style="width: 110%;margin-top: 15px;" v-model="Invoice_info2.bankName" placeholder="请输入开户行">
                </el-input>
              </el-form-item>
              <el-form-item label="账号" prop="bank_account" size="mini" style="width: 30%;margin-top: 0; margin-bottom: 0">
                <el-input style="width: 110%;margin-top: 15px;" v-model="Invoice_info2.bankAccount" placeholder="请输入账号">
                </el-input>
              </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
              <!--                <el-button type="danger">删除客户</el-button>-->
              <el-button @click="canceldialog2">取 消</el-button>
              <el-button type="primary" @click="updateData">保存</el-button>
            </span>
          </el-dialog>

          <div style="text-align: center;">
              <el-pagination @current-change="handleCurrentChange" :current-page="pageNum" :page-size="pageSize" layout="total, prev, pager, next" :total="total">
              </el-pagination>
          </div>
        </div>
      </div>
    </el-main>
  </el-container>
</template>


<script>
import { provincedata } from "@/assets/data/provincedata";
import request from "@/utils/request";
export default {

  // 我的客户中寻找所有客户
  created: function () {
    let getData;
    const params = {
      pageNum: 1,
      pageSize: this.pageSize
    }
    request.get("http://localhost:8888/sys/customers/findallcustomers",{params}).then((response) => {
      console.log(response);
      getData = response.data
      this.tableData = getData.records
      this.total = getData.total
    })
  },
  mounted: function () {
    console.log("MyClient被挂载了")
  },
  data() {
    ``
    return {
      total: 0,
      pageNum: 1,
      pageSize: 9,
      headerBg: "headerBg",
      Customers: {
        customerName: '', // 设置初始值
        customerLevel: '',
        industry: '',
        postalCode: '',
        province: '',
        city: '',
        county: '',
        address: ''
      },
      Customers2: {
        customerName: '', // 设置初始值
        customerLevel: '',
        industry: '',
        postalCode: '',
        province: '',
        city: '',
        county: '',
        address: ''
      },
      Invoice_info: {
        customerName: '',
        companyName: '',
        taxNumber: '',
        phone: '',
        address: '',
        bankName: '',
        bankAccount: ''
      },
      Invoice_info2: {
        customerName: '',
        companyName: '',
        taxNumber: '',
        phone: '',
        address: '',
        bankName: '',
        bankAccount: ''
      },
      provincedata: provincedata,
      rules_customername: {
        name: [{ required: true, message: '请输入客户名称', trigger: 'blur' }],
      }, // 假设有规则定义
      provinces: provincedata,
      cities: [],
      counties: [],
      dialogVisible: false,
      dialogVisible2: false,
      activeIndex: "1",
      tableData: [],
      currentRow: null,
      selectedRow: null,
    }
  },
  computed: {
    selectedProvince() {
      return this.Customers.province;
    },
    selectedCity() {
      return this.Customers.city;
    },
    selectedProvince2() {
      return this.Customers2.province;
    },
    selectedCity2() {
      return this.Customers2.city;
    }
  },
  watch: {
    selectedProvince(newValue) {
      // 根据选择的省，更新可选的市数据
      const selectedProvince = this.provinces.find(province => province.value === newValue);
      this.cities = selectedProvince ? selectedProvince.children : [];

      // 重置市和县的选择
      this.Customers.city = '';
      this.Customers.county = '';
    },
    selectedCity(newValue) {
      // 根据选择的市，更新可选的县数据
      const selectedProvince = this.provinces.find(province => province.value === this.Customers.province);
      if (selectedProvince) {
        const selectedCity = selectedProvince.children.find(city => city.value === newValue);
        this.counties = selectedCity ? selectedCity.children : [];
      } else {
        this.counties = [];
      }

      // 重置县的选择
      this.Customers.county = '';
    },

    selectedProvince2(newValue) {
      // 根据选择的省，更新可选的市数据
      if (newValue && this.Customers2.province) {
        const selectedProvince2 = this.provinces.find(province => province.value === newValue);
        this.cities = selectedProvince2 ? selectedProvince2.children : [];

        // 重置市和县的选择
        this.$nextTick(() => {
          // this.Customers2.city = '';
          // this.Customers2.county = '';
        });
      }
    },
    selectedCity2(newValue) {
      // 根据选择的市，更新可选的县数据
      if (newValue && this.Customers2.province) {
        const selectedProvince2 = this.provinces.find(province => province.value === this.Customers2.province);
        if (selectedProvince2) {
          const selectedCity2 = selectedProvince2.children.find(city => city.value === newValue);
          this.counties = selectedCity2 ? selectedCity2.children : [];
        } else {
          this.counties = [];
        }

        // 重置县的选择
        this.$nextTick(() => {
          // this.Customers2.county = '';
        });
      }
    }
  },
  methods: {
    load() {
    let getData;
    let number;
    if(!this.pageNum){
      console.log("null")
      return;
    }
    else{
      number=this.pageNum
    }
    
    const params = {
      pageNum: number,
      pageSize: this.pageSize
    }
    request.get("http://localhost:8888/sys/customers/findallcustomers",{params}).then((response) => {
      console.log(response);
      getData = response.data
      this.tableData = getData.records
      this.total = getData.total
    })
    },
    canceldialog2() {
      this.dialogVisible2 = false;
      Object.keys(this.Customers2).forEach(key => {
        this.Customers2[key] = '';
      });
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      if(!val){
        val=1;
      }
      
      this.pageNum = parseInt(val);
      this.load();
    },
    showDialog() {
      this.dialogVisible = true;
    },
    closeDialog() {
      this.dialogVisible = false;
      this.dialogVisible2 = false;
    },
    showDialog2(row) {
      
      request.get("http://localhost:8888/sys/customers/getcustomer?name=" + row.customerName).then((response) => {
        
        this.Customers2 = response;
      });
      request.get("http://localhost:8888/sys/invoiceInfo/getInvoice?name=" + row.customerName).then((response) => {
        this.Invoice_info2 = response;
      })
      this.dialogVisible2 = true;
    },
    closeDialog2() {
      this.dialogVisible2 = false;
    },
    open2() {
      this.$message({
        message: '插入成功！',
        type: 'success'
      });
    },

    open3() {
      this.$message({
        message: '警告哦，这是一条警告消息',
        type: 'warning'
      });
    },

    open4() {
      this.$message.error('基本信息插入错误');
    },
    open5() {
      this.$message.error('发票信息插入错误');
    },
    submitData() {
      this.submitCustomersData().then(() => {
        this.submitInvoiceInfoData().then(() => {
          this.open2();
          this.dialogVisible = false;
        }).catch(() => {
          this.open5();
        });

      }).catch(() => {
        this.open4();
      });
    },
    updateData() {
      this.updateCustomersData().then(() => {
        this.updateInvoiceInfoData().then(() => {
          this.open2();
          // this.dialogVisible = false;
        }).catch(() => {
          this.open5();
        });

      }).catch(() => {
        this.open4();
      });
    },
    submitCustomersData() {
      return new Promise((resolve, reject) => {
        const requestData = {
          customerName: this.Customers.customerName,
          customerLevel: this.Customers.customerLevel,
          industry: this.Customers.industry,
          postalCode: this.Customers.postalCode,
          province: this.Customers.province,
          city: this.Customers.city,
          county: this.Customers.county,
          address: this.Customers.address
        };
        request.post('/sys/customers/addCustomer', requestData)
          .then(response => {
            console.log(response.data);
            resolve(); // 请求成功时解决Promise
          })
          .catch(error => {
            console.error(error);
            reject(); // 请求失败时拒绝Promise
          });
      });

    },
    updateCustomersData() {
      return new Promise((resolve, reject) => {
        const requestData = {
          customerName: this.Customers2.customerName,
          customerLevel: this.Customers2.customerLevel,
          industry: this.Customers2.industry,
          postalCode: this.Customers2.postalCode,
          province: this.Customers2.province,
          city: this.Customers2.city,
          county: this.Customers2.county,
          address: this.Customers2.address
        };
        request.post("/sys/customers/updateCustomer", requestData)
          .then(() => {
            // console.log(response);
            resolve(); // 请求成功时解决Promise
          })
          .catch(error => {
            console.error(error);
            reject(error); // 请求失败时拒绝Promise
          });
      });

    },
    submitInvoiceInfoData() {
      return new Promise((resolve, reject) => {
        const requestData = {
          customerName: this.Customers.customerName,
          companyName: this.Invoice_info.companyName,
          taxNumber: this.Invoice_info.taxNumber,
          phone: this.Invoice_info.phone,
          address: this.Invoice_info.address,
          bankName: this.Invoice_info.bankName,
          bankAccount: this.Invoice_info.bankAccount
        };

        request.post('/sys/invoiceInfo/addInvoiceInfo', requestData)
          .then(response => {
            console.log(response);
            resolve(); // 请求成功时解决Promise
          })
          .catch(error => {
            console.error(error);
            reject(); // 请求失败时拒绝Promise
          });
      });
    },
    updateInvoiceInfoData() {
      return new Promise((resolve, reject) => {
        const requestData = {
          customerName: this.Customers2.customerName,
          companyName: this.Invoice_info2.companyName,
          taxNumber: this.Invoice_info2.taxNumber,
          phone: this.Invoice_info2.phone,
          address: this.Invoice_info2.address,
          bankName: this.Invoice_info2.bankName,
          bankAccount: this.Invoice_info2.bankAccount
        };

        request.post('/sys/invoiceInfo/updateInvoice', requestData)
          .then(response => {
            console.log(response);
            console.log("!!!!!!!!!!");
            resolve(); // 请求成功时解决Promise
          })
          .catch(error => {
            console.error(error);
            console.log("????????");

            reject(); // 请求失败时拒绝Promise
          });
      });
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
</style>


