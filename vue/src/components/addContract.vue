<template>
<!--背景板-->
<el-container class="newContract">
  <el-main>
  <!--头部内容 -->
  <div class="header">
    <!-- <div class="header-content">
      <div class="header-lcontent">
        <div class="header-lcontent-text">新增合同</div>
      </div>
      <div class="header-rcontent">
        <div class="header-rcontent-text">
         
          <el-button icon="el-icon-back">返回</el-button>
        </div>
      </div>
    </div> -->
    <el-row>
          <el-col :span="6">
            <div class="title">新增合同</div>
          </el-col>
          <el-col :span="4" :offset="14">
            <div class="button">
              <!-- <el-button type="primary" icon="el-icon-plus" style="margin-right: 10px;">新增</el-button> -->
              <router-link to>
                <el-button @click="$router.back(-1)" icon="el-icon-back" style="color: #409eff;margin-right: 5px;">返回</el-button>
              </router-link>
            </div>
          </el-col>
        </el-row>
  </div>
  <!--中间内容-->
  <div class="center">
    <span class="tip-font">填写前请阅读以下注意事项（为共建真实可信的销售财务服务平台，请勿发布虚假、错误信息，否则影响相关统计数据哦~）
      请填写当年未归档的合同（包含已归档的合同）</span><br>
    <!--基础信息-->
    <h1 class="title-font">基础信息</h1>
    <el-divider></el-divider>
    <div class="form-style">
      <el-form :model="contract_name" :rules="rules_contractName" label-width="100px" class="demo-ruleForm">
        <el-form-item label="合同名称" prop="name">
          <el-input v-model="contract_name.name" placeholder="请输入合同名称" size="mini"></el-input>
        </el-form-item>
      </el-form>
    </div>
    <div class="form-style">
      <el-form :model="contractID"  :rules="rules_contractID" label-width="100px" class="demo-ruleForm">
        <el-form-item label="合同编号" prop="id">
          <el-input v-model="contractID.ID" placeholder="请输入合同编号" size="mini"></el-input>
        </el-form-item>
      </el-form>
    </div>
    <div class="form-style">
      <div class="form-style-parent">
        <div class="form-style-left">
          <el-form :model="customerName" :rules="rules_customerName" label-width="100px">
            <el-form-item label="客户名称" prop="region">
              <el-select v-model="customerName.region" placeholder="请选择客户姓名" style="width: 100%" size="mini" :required="true">
                <el-option v-for="customer in customersName" :key="customer.customerName" :label="customer.customerName" :value="customer.customerName"></el-option>
              </el-select>
            </el-form-item>
          </el-form>
        </div>
        <div class="form-style-right">
          <el-button type="primary" @click="dialogVisible = true" style="float: left; margin-left: 30px; margin-bottom: 20px" size="mini">增加新用户</el-button>
          <el-dialog
              title="新增客户"
              :visible.sync="dialogVisible"
              width="65%"
              :before-close="handleClose">
            <h1 class="title-font">基础信息</h1>
            <el-divider></el-divider>
            <el-form :model="newcustomer_name" :rules="rules_newcustomername" label-width="100px" >
              <el-form-item label="客户名称" prop="newCustomerName" :required="true">
                <el-input v-model="newcustomer_name.newCustomerName"  placeholder="请输入客户名称" size="mini"></el-input>
              </el-form-item>
            </el-form>
            <el-form :model="Level_Industry_ZipCode" :inline="true" label-width="100px" label-position="right">
              <el-form-item label="客户级别" prop="region" size="mini" style="width: 32%">
                <el-select v-model= "Level_Industry_ZipCode.customerLevel" placeholder="请选择客户级别" >
                  <el-option label="A" value="A"></el-option>
                  <el-option label="B" value="B"></el-option>
                  <el-option label="C" value="C"></el-option>
                  <el-option label="D" value="D"></el-option>
                  <el-option label="E" value="E"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="行业" prop="region" size="mini" style="width: 32%">
                <el-select  v-model="Level_Industry_ZipCode.newCustomerIndustry" placeholder="请选择行业" >
                  <el-option label="汽车制造业" value="汽车制造业"></el-option>
                  <el-option label="互联网" value="互联网"></el-option>
                  <el-option label="金融" value="金融"></el-option>
                  <el-option label="医疗" value="医疗"></el-option>
                  <el-option label="能源" value="能源"></el-option>
                  <el-option label="房地产" value="房地产"></el-option>
                  <el-option label="教育" value="教育"></el-option>
                  <el-option label="航空航天" value="航空航天"></el-option>
                  <el-option label="化工" value="化工"></el-option>
                  <el-option label="农业" value="农业"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="邮政编码" prop="name" size="mini" style="width: 32%">
                <el-input style="width: 110%" v-model="Level_Industry_ZipCode.customerZipcode" placeholder="请输入邮政编码"> </el-input>
              </el-form-item>
            </el-form>
            <el-form :model="Province_City_County" :inline="true" label-width="100px" label-position="right">
              <el-form-item label="所在省" prop="region" size="mini" style="width: 32%">
                <el-select  v-model="Province_City_County.newCustomerProvince" placeholder="请选择所在省">
                  <el-option  v-for="province in provinces" :key="province.value" :label="province.label" :value="province.value"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="所在市" prop="region" size="mini" style="width: 32%">
                <el-select  v-model="Province_City_County.customerCity" placeholder="请选择所在市">
                  <el-option  v-for="city in cities" :key="city.value" :label="city.label" :value="city.value"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="所在县"  prop="region" size="mini" style="width: 32%; margin-left: 3px;">
                <el-select  v-model="Province_City_County.customerCounty" placeholder="请选择所在县">
                  <el-option v-for="county in counties" :key="county.value" :label="county.label" :value="county.value"></el-option>
                </el-select>
              </el-form-item>
            </el-form>
            <el-form :model="newcustomer_address" :rules="rules_newcustomername" label-width="100px" class="demo-ruleForm">
              <el-form-item label="地址" prop="name">
                <el-input v-model="newcustomer_address.newCustomerAddress" placeholder="请输入客户地址" size="mini"></el-input>
              </el-form-item>
            </el-form>
            <el-divider></el-divider>
            <h1 class="title-font" style="margin-top: 10px;margin-bottom: 10px;">发票信息</h1>
            <el-divider></el-divider>
            <el-form :model="Unit_taxnumber_telephone" :inline="true" label-width="100px" label-position="right">
              <el-form-item label="单位" size="mini" style="width: 32%">
                <el-input style="width: 110%" v-model="Unit_taxnumber_telephone.customerUnit" placeholder="请输入单位"> </el-input>
              </el-form-item>
              <el-form-item label="税号" size="mini" style="width: 32%">
                <el-input style="width: 110%" v-model="Unit_taxnumber_telephone.customerTaxnumber" placeholder="请输入税号"> </el-input>
              </el-form-item>
              <el-form-item label="电话" size="mini" style="width: 32%">
                <el-input style="width: 110%" v-model="Unit_taxnumber_telephone.customerTelephone" placeholder="请输入电话"> </el-input>
              </el-form-item>
            </el-form>
            <el-form :model="Address_Bank_Account" :inline="true" label-width="100px" label-position="right">
              <el-form-item label="地址" size="mini" style="width: 32%">
                <el-input style="width: 110%" v-model="Address_Bank_Account.customerAddress" placeholder="请输入地址"> </el-input>
              </el-form-item>
              <el-form-item label="开户行" size="mini" style="width: 32%">
                <el-input style="width: 110%" v-model="Address_Bank_Account.customerBank" placeholder="请输入开户行"> </el-input>
              </el-form-item>
              <el-form-item label="账号" size="mini" style="width: 32%">
                <el-input style="width: 110%" v-model="Address_Bank_Account.customerAccount" placeholder="请输入账号"> </el-input>
              </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
              <el-button @click="resetForm">取 消</el-button>
              <el-button type="primary" @click="onSubmit">提交</el-button>
            </span>
          </el-dialog>
        </div>
      </div>
    </div>
    <div class="form-style">
      <el-form :model="BG_BU_Industry" :rules="rules_BG_BU_Industry" :inline="true" label-width="100px" label-position="right">
        <el-form-item label="BG" :required="true" prop="customerBG" size="mini" style="width: 33%">
          <el-select  v-model="BG_BU_Industry.customerBG" placeholder="请选择BG">
            <el-option label="汽车产业BG" value="汽车产业BG"></el-option>
            <el-option label="电子商务BG" value="电子商务BG"></el-option>
            <el-option label="金融BG" value="金融BG"></el-option>
            <el-option label="医疗BG" value="医疗BG"></el-option>
            <el-option label="能源BG" value="能源BG"></el-option>
            <el-option label="房地产BG" value="教育BG"></el-option>
            <el-option label="教育BG" value="教育BG"></el-option>
            <el-option label="航空航天BG" value="航空航天BG"></el-option>
            <el-option label="化工BG" value="化工BG"></el-option>
            <el-option label="农业BG" value="农业BG"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="BU" :required="true" prop="customerBU" size="mini" style="width: 33%">
            <el-select  v-model="BG_BU_Industry.customerBU" placeholder="请选择BU">
              <el-option label="电动汽车事业部" value="电动汽车事业部"></el-option>
              <el-option label="电商平台事业部" value="电商平台事业部"></el-option>
              <el-option label="银行业务事业部" value="银行业务事业部"></el-option>
              <el-option label="医疗设备事业部" value="医疗设备事业部"></el-option>
              <el-option label="太阳能事业部" value="太阳能事业部"></el-option>
              <el-option label="住宅开发事业部" value="住宅开发事业部"></el-option>
              <el-option label="在线教育事业部" value="在线教育事业部"></el-option>
              <el-option label="客机事业部" value="客机事业部"></el-option>
              <el-option label="石油化工事业部" value="石油化工事业部"></el-option>
              <el-option label="农产品种植事业部" value="农产品种植事业部"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="行业" :required="true" prop="customerIndustry" size="mini" style="width: 30%">
          <el-select  v-model="BG_BU_Industry.customerIndustry" placeholder="请选择行业">
            <el-option label="汽车制造业" value="汽车制造业"></el-option>
            <el-option label="互联网" value="互联网"></el-option>
            <el-option label="金融" value="金融"></el-option>
            <el-option label="医疗" value="医疗"></el-option>
            <el-option label="能源" value="能源"></el-option>
            <el-option label="房地产" value="房地产"></el-option>
            <el-option label="教育" value="教育"></el-option>
            <el-option label="航空航天" value="航空航天"></el-option>
            <el-option label="化工" value="化工"></el-option>
            <el-option label="农业" value="农业"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
    </div>
    <div class="form-style">
      <el-form :model="Subsector_ProjectType_Area" :rules="rules_Subsector_ProjectType_Area" :inline="true" label-width="100px" label-position="right">
        <el-form-item label="子行业" :required="true" prop="customerSubsector" size="mini" style="width: 33%">
          <el-select  v-model="Subsector_ProjectType_Area.customerSubsector" placeholder="请选择子行业" >
            <el-option label="新能源汽车制造业" value="新能源汽车制造业"></el-option>
            <el-option label="电子商务" value="电子商务"></el-option>
            <el-option label="银行" value="银行"></el-option>
            <el-option label="医疗设备" value="医疗设备"></el-option>
            <el-option label="太阳能发电" value="太阳能发电"></el-option>
            <el-option label="住宅开发" value="住宅开发"></el-option>
            <el-option label="在线教育" value="在线教育"></el-option>
            <el-option label="飞机制造" value="飞机制造"></el-option>
            <el-option label="石油化工" value="石油化工"></el-option>
            <el-option label="农产品种植" value="农产品种植"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="项目类型" :required="true" prop="customerProjectType" size="mini" style="width: 33%">
            <el-select  v-model="Subsector_ProjectType_Area.customerProjectType" placeholder="请选择项目类型" >
              <el-option label="电动汽车生产线建设" value="电动汽车生产线建设"></el-option>
              <el-option label="在线购物平台开发" value="在线购物平台开发"></el-option>
              <el-option label="核心银行系统升级" value="核心银行系统升级"></el-option>
              <el-option label="医疗影像设备供应" value="医疗影像设备供应"></el-option>
              <el-option label="太阳能光伏电站建设" value="太阳能光伏电站建设"></el-option>
              <el-option label="高端住宅楼盘开发" value="高端住宅楼盘开发"></el-option>
              <el-option label="在线学习平台开发" value="在线学习平台开发"></el-option>
              <el-option label="客机生产线建设" value="客机生产线建设"></el-option>
              <el-option label="炼油厂建设" value="炼油厂建设"></el-option>
              <el-option label="水稻种植项目" value="水稻种植项目"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="区域" :required="true" prop="customerArea" size="mini" style="width: 30%">
          <el-select  v-model="Subsector_ProjectType_Area.customerArea" placeholder="请选择区域">
            <el-option label="中国" value="中国"></el-option>
            <el-option label="美国" value="美国"></el-option>
            <el-option label="欧洲" value="欧洲"></el-option>
            <el-option label="印度" value="印度"></el-option>
            <el-option label="法国" value="法国"></el-option>
            <el-option label="巴西" value="巴西"></el-option>
            <el-option label="全球" value="全球"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
    </div>
    <div class="form-style">
      <el-form :model="Institution_Province_AccountManager" :rules="rules_Institution_Province_AccountManager" :inline="true" label-width="100px" label-position="right">
        <el-form-item label="机构"  prop="customerInstitution" size="mini" style="width: 33%">
          <el-select  v-model="Institution_Province_AccountManager.customerInstitution" placeholder="请选择机构" >
            <el-option label="上海汽车制造厂" value="上海汽车制造厂"></el-option>
            <el-option label="阿里巴巴集团" value="阿里巴巴集团"></el-option>
            <el-option label="摩根大通银行" value="摩根大通银行"></el-option>
            <el-option label="西门子医疗系统有限公司" value="西门子医疗系统有限公司"></el-option>
            <el-option label="印度能源发展局" value="印度能源发展局"></el-option>
            <el-option label="万科集团" value="万科集团"></el-option>
            <el-option label="Coursera公司" value="Coursera公司"></el-option>
            <el-option label="空中客车公司" value="空中客车公司"></el-option>
            <el-option label="巴西石油公司" value="巴西石油公司"></el-option>
            <el-option label="农业农村部" value="农业农村部"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="省份"  prop="customerProvince" size="mini" style="width: 33%">
            <el-select  v-model="Institution_Province_AccountManager.customerProvince" placeholder="请选择省份" >
              <el-option v-for="province in provinces" :key="province.value" :label="province.label" :value="province.value"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="客户经理" prop="customerAccountManager" size="mini" style="width: 30%">
          <el-input v-model="Institution_Province_AccountManager.customerAccountManager" style="width: 110%" placeholder="请完善客户经理"> </el-input>
        </el-form-item>
      </el-form>
    </div>
    <div class="form-style">
      <el-form :model="ProductLine_PartyB" :rules="rules_ProductLine_PartyB" :inline="true" label-width="100px" label-position="right">
        <el-form-item label="产品线" :required="true" prop="customerProductLine" size="mini" style="width: 33%">
          <el-select  v-model="ProductLine_PartyB.customerProductLine" placeholder="请选择产品线" >
            <el-option label="电动汽车生产设备" value="电动汽车生产设备"></el-option>
            <el-option label="电商平台" value="电商平台"></el-option>
            <el-option label="核心银行系统" value="核心银行系统"></el-option>
            <el-option label="医疗影像设备" value="医疗影像设备"></el-option>
            <el-option label="太阳能光伏设备" value="太阳能光伏设备"></el-option>
            <el-option label="高端住宅" value="高端住宅"></el-option>
            <el-option label="在线学习平台" value="在线学习平台"></el-option>
            <el-option label="客机生产设备" value="客机生产设备"></el-option>
            <el-option label="炼油设备" value="炼油设备"></el-option>
            <el-option label="农业机械" value="农业机械"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="乙方单位" :required="true" prop="customerPartyB" size="mini" style="width: 33%">
            <el-select  v-model="ProductLine_PartyB.customerPartyB" placeholder="请选择乙方单位" >
              <el-option label="上海电机有限公司" value="上海电机有限公司"></el-option>
              <el-option label="淘宝商城有限公司" value="淘宝商城有限公司"></el-option>
              <el-option label="IBM公司" value="IBM公司"></el-option>
              <el-option label="飞利浦医疗设备有限公司" value="飞利浦医疗设备有限公司"></el-option>
              <el-option label="特斯拉能源有限公司" value="特斯拉能源有限公司"></el-option>
              <el-option label="中国建筑股份有限公司" value="中国建筑股份有限公司"></el-option>
              <el-option label="腾讯教育科技有限公司" value="腾讯教育科技有限公司"></el-option>
              <el-option label="波音公司" value="波音公司"></el-option>
              <el-option label="壳牌石油化工有限公司" value="壳牌石油化工有限公司"></el-option>
              <el-option label="中国一拖集团" value="中国一拖集团"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="签订时间" :required="true" prop="region" size="mini" style="width: 30%">
          <el-col :span="11">
            <el-form-item prop="date1">
              <el-date-picker type="date"
                              placeholder="选择日期"
                              v-model="ruleForm.date1"
                              value-format="yyyy-MM-dd"
                              style="width: 200%;"
                              size="mini">
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-form-item>
      </el-form>
    </div>

    <div class="form-style">
      <el-form :model="SigningStatus_MaintenancePeriod" :rules="rules_SigningStatus_MaintenancePeriod" :inline="true" label-width="100px" label-position="right">
        <el-form-item label="签单状态" :required="true" prop="customerSigningStatus" size="mini" style="width: 33%">
          <el-select  v-model="SigningStatus_MaintenancePeriod.customerSigningStatus" placeholder="请选择签单状态" >
            <el-option label="未签单" value="未签单"></el-option>
            <el-option label="已签单" value="已签单"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="维保期" :required="true" prop="customerMaintenancePeriod" size="mini" style="width: 33%">
          <el-select  v-model="SigningStatus_MaintenancePeriod.customerMaintenancePeriod" placeholder="请选择维保期" >
            <el-option label="1年" value="1年"></el-option>
            <el-option label="2年" value="2年"></el-option>
            <el-option label="3年" value="3年"></el-option>
            <el-option label="4年" value="4年"></el-option>
            <el-option label="5年" value="5年"></el-option>
            <el-option label="6年" value="6年"></el-option>
            <el-option label="7年" value="7年"></el-option>
            <el-option label="8年" value="8年"></el-option>
            <el-option label="9年" value="9年"></el-option>
            <el-option label="10年" value="10年"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="约定货币" size="mini" style="display: inline-block;">
          <el-radio-group v-model="contractCurrency.radio1" size="mini">
            <el-radio-button label="人民币"></el-radio-button>
            <el-radio-button label="美元"></el-radio-button>
            <el-radio-button label="日元"></el-radio-button>
            <el-radio-button label="英镑"></el-radio-button>
          </el-radio-group>
        </el-form-item>
      </el-form>
    </div>

    <!--合同类型-->
    <h1 class="title-font">合同类型</h1>
    <el-divider></el-divider>
    <div class="tableType">
      <div class="tableHead">
        <span style="color: #F56C6C">*</span>
        <span class="tablefont">合同类型</span>
      </div>
      <div class="tableHead">
        <span style="color: #F56C6C">*</span>
        <span class="tablefont">合同金额</span>
      </div>
      <div class="tableHead">
        <span style="color: #F56C6C">*</span>
        <span class="tablefont">税率</span>
      </div>
      <div class="tableHead">
        <span class="tablefont">税率额</span>
      </div>
    </div>
    <div class="Table">
      <template>
        <el-form :inline="true" style="display: flex; flex-wrap: wrap;" :model="softwareDevelop" :rules="softwareDeveloprules">
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;">
            <el-checkbox v-model="softwareDevelop.checked" >软件开发</el-checkbox>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;" prop="input1">
            <el-input v-model="softwareDevelop.input1" placeholder="请输入合同额" size="mini" :disabled="!softwareDevelop.checked"></el-input>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;" prop="value">
            <el-select v-model="softwareDevelop.value" placeholder="请选择" size="mini" :disabled="!softwareDevelop.checked">
              <el-option
                  v-for="item in softwareDevelopoptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;">
            <el-input v-model="softwareDevelop.input2" placeholder="请输入税率额" size="mini" style="width: 98%" :disabled="!softwareDevelop.checked"></el-input>
          </el-form-item>
        </el-form>
      </template>
      <template>
        <el-form :inline="true" style="display: flex; flex-wrap: wrap;" :model="thirdPartyHardware" :rules="thirdPartyHardwarerules">
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;">
            <el-checkbox v-model="thirdPartyHardware.checked" >第三方硬件</el-checkbox>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;" prop="input1">
            <el-input v-model="thirdPartyHardware.input1" placeholder="请输入合同额" size="mini" :disabled="!thirdPartyHardware.checked"></el-input>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;" prop="value">
            <el-select v-model="thirdPartyHardware.value" placeholder="请选择" size="mini" :disabled="!thirdPartyHardware.checked">
              <el-option
                  v-for="item in thirdPartyHardwareoptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;">
            <el-input v-model="thirdPartyHardware.input2" placeholder="请输入税率额" size="mini" style="width: 98%" :disabled="!thirdPartyHardware.checked"></el-input>
          </el-form-item>
        </el-form>
      </template>
      <template>
        <el-form :inline="true" style="display: flex; flex-wrap: wrap;" :model="thirdPartySoftware" :rules="thirdPartySoftwarerules">
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;">
            <el-checkbox v-model="thirdPartySoftware.checked" >第三方软件</el-checkbox>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;" prop="input1">
            <el-input v-model="thirdPartySoftware.input1" placeholder="请输入合同额" size="mini" :disabled="!thirdPartySoftware.checked"></el-input>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;" prop="value">
            <el-select v-model="thirdPartySoftware.value" placeholder="请选择" size="mini" :disabled="!thirdPartySoftware.checked">
              <el-option
                  v-for="item in thirdPartySoftwareoptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;">
            <el-input v-model="thirdPartySoftware.input2" placeholder="请输入税率额" size="mini" style="width: 98%" :disabled="!thirdPartySoftware.checked"></el-input>
          </el-form-item>
        </el-form>
      </template>
      <template>
        <el-form :inline="true" style="display: flex; flex-wrap: wrap;" :model="systemIntegration" :rules="systemIntegrationrules">
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;">
            <el-checkbox v-model="systemIntegration.checked" >系统集成</el-checkbox>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;" prop="input1">
            <el-input v-model="systemIntegration.input1" placeholder="请输入合同额" size="mini" :disabled="!systemIntegration.checked"></el-input>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;" prop="value">
            <el-select v-model="systemIntegration.value" placeholder="请选择" size="mini" :disabled="!systemIntegration.checked">
              <el-option
                  v-for="item in systemIntegrationoptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;">
            <el-input v-model="systemIntegration.input2" placeholder="请输入税率额" size="mini" style="width: 98%" :disabled="!systemIntegration.checked"></el-input>
          </el-form-item>
        </el-form>
      </template>
      <template>
        <el-form :inline="true" style="display: flex; flex-wrap: wrap;" :model="maintenance" :rules="maintenancerules">
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;">
            <el-checkbox v-model="maintenance.checked" >维护保健</el-checkbox>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;" prop="input1">
            <el-input v-model="maintenance.input1" placeholder="请输入合同额" size="mini" :disabled="!maintenance.checked"></el-input>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;" prop="value">
            <el-select v-model="maintenance.value" placeholder="请选择" size="mini" :disabled="!maintenance.checked">
              <el-option
                  v-for="item in maintenanceoptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;">
            <el-input v-model="maintenance.input2" placeholder="请输入税率额" size="mini" style="width: 98%" :disabled="!maintenance.checked"></el-input>
          </el-form-item>
        </el-form>
      </template>
      <template>
        <el-form :inline="true" style="display: flex; flex-wrap: wrap;" :model="technicalServices" :rules="technicalServicesrules">
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;">
            <el-checkbox v-model="technicalServices.checked" >技术服务</el-checkbox>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;" prop="input1">
            <el-input v-model="technicalServices.input1" placeholder="请输入合同额" size="mini" :disabled="!technicalServices.checked"></el-input>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;" prop="value">
            <el-select v-model="technicalServices.value" placeholder="请选择" size="mini" :disabled="!technicalServices.checked">
              <el-option
                  v-for="item in technicalServicesoptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item style="flex: 1;display: flex; justify-content: center; align-items: center;">
            <el-input v-model="technicalServices.input2" placeholder="请输入税率额" size="mini" style="width: 98%" :disabled="!technicalServices.checked"></el-input>
          </el-form-item>
        </el-form>
      </template>
    </div>

    <!--履约保证金-->
    <h1 class="title-font">履约保证金</h1>
    <el-divider></el-divider>
    <el-checkbox v-model="performanceBond.checked" style="margin-top: 5px;margin-bottom: 5px;margin-left: 3px;">本合同存在履约保证金</el-checkbox>

    <!--支付信息-->
    <h1 class="title-font">支付信息
      <span class="tip-font" style="margin-top: 6px;">(框架、技术服务、维护保障合同之类的，请使用自定义方式配置)</span>
    </h1>
    <el-divider></el-divider>
    <div class="tableType" >
      <div class="tableHead">
        <el-form label-width="80px" label-position="center">
          <el-form-item label="付款阶段"  prop="region" size="mini" style="text-align:center;">
          </el-form-item>
        </el-form>
      </div>
      <div class="tableHead">
        <el-form label-width="80px" label-position="center">
          <el-form-item label="支付额"  prop="region" size="mini" style="text-align:center;">
          </el-form-item>
        </el-form>
      </div>
      <div class="tableHead">
        <el-form label-width="80px" label-position="center">
          <el-form-item label="占合同额"  prop="region" size="mini" style="text-align:center;">
          </el-form-item>
        </el-form>
      </div>
      <div class="tableHead">
        <el-form label-width="80px" label-position="center">
          <el-form-item label="支付节点"  prop="region" size="mini" style="text-align:center;">
          </el-form-item>
        </el-form>
      </div>
      <div class="tableHead">
        <el-form label-width="80px" label-position="center">
          <el-form-item label="付款条件"  prop="region" size="mini" style="text-align:center;">
          </el-form-item>
        </el-form>
      </div>
    </div>
    <div class="Table">
      <template>
        <el-row style="display: flex; justify-content: center;">
          <el-col :span="4">
            <el-checkbox v-model="firstPayment.checked" style="margin-left: 45%">首付款</el-checkbox>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left: 42px;">
            <el-input v-model="firstPayment.input1" placeholder="支付额: " size="mini" :disabled="!firstPayment.checked"></el-input>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left:0;">
            <el-input v-model="firstPayment.input2" placeholder="占合同额： %" size="mini" :disabled="!firstPayment.checked"></el-input>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left: 0;">
            <el-input v-model="firstPayment.input3" placeholder="支付节点： %" size="mini" :disabled="!firstPayment.checked"></el-input>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left: 0;">
            <el-input v-model="firstPayment.input4" placeholder="付款条件" size="mini" :disabled="!firstPayment.checked"></el-input>
          </el-col>
        </el-row>
      </template>
      <template>
        <el-row style="display: flex; justify-content: center;">
          <el-col :span="4">
            <el-checkbox v-model="onlinePayment.checked" style="margin-left: 45%">上线款</el-checkbox>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left: 42px;">
            <el-input v-model="onlinePayment.input1" placeholder="支付额： " size="mini" :disabled="!onlinePayment.checked"></el-input>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left:0;">
            <el-input v-model="onlinePayment.input2" placeholder="占合同额： %" size="mini" :disabled="!onlinePayment.checked"></el-input>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left: 0;">
            <el-input v-model="onlinePayment.input3" placeholder="支付节点： %" size="mini" :disabled="!onlinePayment.checked"></el-input>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left: 0;">
            <el-input v-model="onlinePayment.input4" placeholder="付款条件" size="mini" :disabled="!onlinePayment.checked"></el-input>
          </el-col>
        </el-row>
      </template>
      <template>
        <el-row style="display: flex; justify-content: center;">
          <el-col :span="4">
            <el-checkbox v-model="startPayment.checked" style="margin-left: 45%">初始款</el-checkbox>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left: 42px;">
            <el-input v-model="startPayment.input1" placeholder="支付额： " size="mini" :disabled="!startPayment.checked"></el-input>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left:0;">
            <el-input v-model="startPayment.input2" placeholder="占合同额： %" size="mini" :disabled="!startPayment.checked"></el-input>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left: 0;">
            <el-input v-model="startPayment.input3" placeholder="支付节点： %" size="mini" :disabled="!startPayment.checked"></el-input>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left: 0;">
            <el-input v-model="startPayment.input4" placeholder="付款条件" size="mini" :disabled="!startPayment.checked"></el-input>
          </el-col>
        </el-row>
      </template>
      <template>
        <el-row style="display: flex; justify-content: center;">
          <el-col :span="4">
            <el-checkbox v-model="finalInspectionPayment.checked" style="margin-left: 45%">终验款</el-checkbox>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left: 42px;">
            <el-input v-model="finalInspectionPayment.input1" placeholder="支付额： " size="mini" :disabled="!finalInspectionPayment.checked"></el-input>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left:0;">
            <el-input v-model="finalInspectionPayment.input2" placeholder="占合同额： %" size="mini" :disabled="!finalInspectionPayment.checked"></el-input>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left: 0;">
            <el-input v-model="finalInspectionPayment.input3" placeholder="支付节点： %" size="mini" :disabled="!finalInspectionPayment.checked"></el-input>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left: 0;">
            <el-input v-model="finalInspectionPayment.input4" placeholder="付款条件" size="mini" :disabled="!finalInspectionPayment.checked"></el-input>
          </el-col>
        </el-row>
      </template>
      <template>
        <el-row style="display: flex; justify-content: center;">
          <el-col :span="4">
            <el-checkbox v-model="finalPayment.checked" style="margin-left: 45%">尾款</el-checkbox>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left: 42px;">
            <el-input v-model="finalPayment.input1" placeholder="支付额： " size="mini" :disabled="!finalPayment.checked"></el-input>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left:0;">
            <el-input v-model="finalPayment.input2" placeholder="占合同额： %" size="mini" :disabled="!finalPayment.checked"></el-input>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left: 0;">
            <el-input v-model="finalPayment.input3" placeholder="支付节点： %" size="mini" :disabled="!finalPayment.checked"></el-input>
          </el-col>
          <el-col :span="4" style="width: 20%;margin-left: 0;">
            <el-input v-model="finalPayment.input4" placeholder="付款条件" size="mini" :disabled="!finalPayment.checked"></el-input>
          </el-col>
        </el-row>
      </template>
      <template>
        <div>
          <el-form :inline="true" label-width="100px" label-position="right" :model="paymentMethodForm" :rules="paymentMethodRules">
            <el-form-item label="付款方式" size="mini" style="display: inline-block;" prop="paymentMethod">
              <el-radio-group v-model="paymentMethodForm.paymentMethod" size="mini">
                <el-radio-button label="支票"></el-radio-button>
                <el-radio-button label="电汇"></el-radio-button>
                <el-radio-button label="银行承兑汇票"></el-radio-button>
                <el-radio-button label="商业承兑汇票"></el-radio-button>
                <el-radio-button label="转账"></el-radio-button>
              </el-radio-group>
            </el-form-item>
          </el-form>
        </div>
      </template>
    </div>

    <!--合同附件-->
    <h1 class="title-font">合同附件</h1>
    <el-divider></el-divider>
    <div class="form-style" style="margin-left: 40px; display: flex;">
      <el-form label-width="100px" label-position="right" style="width: 33%">
        <el-form-item label="合同正文" :required="true" prop="region" size="mini">
          <el-upload
              class="upload-demo"
              ref="ContractContentUpload"
              action="http://localhost:8888/sys/file/upload"
              :on-preview="handlePreview"
              :on-remove="handleRemove"
              :file-list="fileList1"
              :limit="1"
              :auto-upload="false"
              :on-exceed="handleExceed"
              :on-success="getContractContentName"
              :before-upload="beforeUpload"
              style="margin-left: 30px;">
            <el-button size="small" type="primary" icon="el-icon-upload2">点击上传</el-button>
            <div class="el-upload__tip" style="display: inline-block; margin-left: 5px;">只能上传pdf文件，且不超过50MB</div>
          </el-upload>
        </el-form-item>
      </el-form>
    </div>
    <div class="form-style" style="margin-left: 20px; display: flex;">
      <el-form label-width="120px" label-position="right" style="width: 30%">
        <el-form-item label="毛利率分析表" :required="true" prop="region" size="mini">
          <el-upload
              class="upload-demo"
              ref="GrossMarginUpload"
              action="http://localhost:8888/sys/file/upload"
              :on-preview="handlePreview"
              :on-remove="handleRemove"
              :file-list="fileList2"
              :auto-upload="false"
              :limit="1"
              :on-success="getGrossMarginName"
              :on-exceed="handleExceed"
              :before-upload="beforeUpload"
              style="margin-left: 30px;">
            <div style="display: flex; align-items: center;">
              <el-button size="small" type="primary" icon="el-icon-upload2">点击上传</el-button>
              <div class="el-upload__tip" style="display: inline-block; margin-left: 5px;">只能上传pdf文件，且不超过50MB</div>
            </div>
          </el-upload>
        </el-form-item>
      </el-form>
    </div>
    <div class="form-style" style="margin-left: 40px; display: flex;">
      <el-form label-width="100px" label-position="right" style="width: 33%">
        <el-form-item label="价格清单表" :required="true" prop="region" size="mini">
          <el-upload
              class="upload-demo"
              ref="PriceListUpload"
              action="http://localhost:8888/sys/file/upload"
              :on-preview="handlePreview"
              :on-remove="handleRemove"
              :file-list="fileList3"
              :auto-upload="false"
              :limit="1"
              :on-success="getPriceListName"
              :on-exceed="handleExceed"
              :before-upload="beforeUpload"
              style="margin-left: 30px;">
            <el-button size="small" type="primary" icon="el-icon-upload2">选择文件</el-button>
            <div class="el-upload__tip" style="display: inline-block; margin-left: 5px;">只能上传pdf文件，且不超过50MB</div>
          </el-upload>
        </el-form-item>
      </el-form>
    </div>
    <!--其它-->
    <h1 class="title-font">其它</h1>
    <el-divider></el-divider>
    <div style="margin-top: 10px;margin-bottom: 5px;"></div>
    <el-input
        type="textarea"
        placeholder="请输入内容"
        v-model="textarea"
        :rows="4"
        maxlength="1000"
        show-word-limit
        size="medium"
    >
    </el-input>
    <div class="release">
      <div class="release-font">
        <span style="color: black">共&nbsp;</span>
        <span style="color: #F56C6C">{{selectedCount}}&nbsp;</span>
        <span style="color: black">种合同类型</span>
      </div>
      <div class="release-font">
        <span style="color: black">合同总额&nbsp;</span>
        <span style="color: #F56C6C">{{ totalAmount }}&nbsp;</span>
        <span style="color: black">万</span>
        <span style="color: black">{{contractCurrency.radio1}}</span>
      </div>
      <div class="release-font">
        <span style="color: black">税率总额&nbsp;</span>
        <span style="color: #F56C6C">{{ totalTax }}&nbsp;</span>
        <span style="color: black">万</span>
        <span style="color: black">{{contractCurrency.radio1}}</span>
      </div>

      <div class="release-button">
        <el-button type="primary" @click="uploadAllFiles">提交文件</el-button>
<!--        <el-button type="primary" @click="totalSubmit"  :disabled="isPublishButtonDisabled">现在发布</el-button>-->
        <el-button type="primary" @click="totalSubmit"  :disabled="uploadCounter !== 3">现在发布</el-button>
      </div>

    </div>
  </div>
  <!-- <div class="footer"></div> -->

  </el-main>
</el-container>

</template>

<style lang="scss" scoped>
.el-main{
  padding-top: 0;
}
.background{
  width: 100%;
  height: 100%;
  box-sizing: border-box;
}
.header{
  height: 60px;
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
}
.header-content{
  margin: 0 auto;
  display: flex;
  width: 100%;
  height: 100%;
}
.header-lcontent{
  width: 50%;
  display: flex;
}
.header-rcontent{
  margin-top: 11px;
  display: flex;
  justify-content: flex-end;
  width: 50%;
}
.header-lcontent-text{
  margin-top: 20px;
  font-size: 22px;
  font-weight: 550;
}

.newContract{
  height: 1950px;
  background-color: rgba(64, 158, 255, 0.2);
  .center{
    width: 100%;
    height: 96%;
    padding: 0 10px;
    background: rgba(255, 255, 255, 1);
    /* border: black 1px solid; */
  }
 
}


.tip-font{
  font-size: 6px;
  color: #F56C6C;
  margin-left: 8px;
}
.title-font{
  display: flex;
  font-size: 20px;
  font-weight: 350;
  margin-top: 6px;
  margin-left: 8px;
}
.el-divider--horizontal{
  margin: 4px 0;
  background-color: black;
}
.form-style{
  margin-top: 2px;
  margin-bottom: 2px;
}
.form-style-parent {
  display: flex;
  align-items: center;
}
.form-style-left{
  width: 70%;
}
.form-style-right{
  width: 30%;
}
.demo-ruleForm{
  margin-right:20px;
}
.release{
  display: flex;
  width: 100%; /* 矩形的宽度 */
  height: 40px; /* 矩形的高度 */
  margin-top: 15px;
  border: 1px solid #e3e3e3; /* 矩形的边框，2px 的宽度，黑色 */
    .release-font{
    width: 30%;
    height: 100%;
    text-align: left;
    display: flex;
    justify-content: flex-start;
    align-items: center;
    margin-left: 5px;
  }
  .release-button{
    width: 15%;
    height: 100%;
    display: flex;
    justify-content: flex-end;
    align-items: center;
  }
}

.tableType{
  display: flex;
  line-height: 40px;
  width: 99%; /* 矩形的宽度 */
  height: 40px; /* 矩形的高度 */
  margin-left: 0.5%;
  margin-top: 10px;
  margin-bottom: 10px;
  background-color: #E4E7ED;/* 矩形的填充颜色 */
  //border: 0.5px solid black; /* 矩形的边框，2px 的宽度，黑色 */
  .tableHead{
  width: 25%;
  height: 100%;
  display: flex;
  justify-content: center;
}
}

.tablefont{
  font-size: 14px;
  color: #606266;
}
.Table{
  width: 100%;
}

</style>
<script>
import { provincedata } from '@/assets/provincedata.js';
import request from '@/utils/request';
// import axios from "axios";
export default {

  // 我的客户中寻找所有客户
  created: function(){
    // this.$http.get("/sys/customers/names").then((response) => {
    //   this.customersName = response.data;
    // })
    request.get("sys/customers/names").then(res =>{
      this.customersName = res
    })
    // console.log("MyClient被创建了")
  },
  data() {
    return {
      contractContentResponse: "",
      grossMarginResponse: "",
      priceListResponse:"",
      isPublishButtonDisabled: true,
      customersName: [],
      uploadCounter: 0,
      newcustomer_name:{
        newCustomerName:'',
      },
      fileList1:[],
      fileList2:[],
      fileList3:[],
      newCustomerData:{
        customerName:null,
        customerLevel:null,
        industry:null,
        postalCode:null,
        province:null,
        city:null,
        county:null,
        address:null,
      },
      invoiceInfoData:{
        company_name:null,
        tax_number:null,
        phone:null,
        address:null,
        bank_name:null,
        bank_account:null,
      },
      contractData:{
        contract_name:null,
        sign_date:null,
        contract_total:null,
        contract_content:null,
        state:null,
      },
      contractInfoData:{
        contract_name:null,
        customer_name:null,
        account_manager_name:null,
        contract_number:null,
        bg:null,
        bu:null,
        industry:null,
        sub_industry:null,
        project_type:null,
        region:null,
        institution:null,
        province:null,
        product_line:null,
        party_b:null,
        currency:null,
        gross_margin:null,
        price_list:null,
        performance_bonds:null,
        other:null,
        type_number:null,
        maintenance_period:null,
        rate_total:null,
        signing_status:null,
        payment_method:null,
      },
      contractPaymentData:{
        payment_type_id:null,
        contract_name:null,
        payment_amount:null,
        payment_percent:null,
        payment_node:null,
        payment_terms:null,
      },
      contractTypeInfoData:{
        contract_name:null,
        contract_type_id:null,
        amount:null,
        rate:null,
        tax_rate:null,
      },

      contract_name: {
        name: '',
      },
      rules_newcustomername:{
        newCustomerName: [
          { required: true, message: '请输入客户名称', trigger: 'blur' },
        ],
      },
      rules_contractName: {
        name: [
          { required: true, message: '请输入合同名称', trigger: 'blur' },
        ],
      },
      contractID: {
        ID: '',
      },
      rules_contractID: {
        ID: [
          { message: '请输入合同编号', trigger: 'blur' },
        ],
      },
      customerName: {
        region: ''
      },
      rules_customerName: {
        region: [
            {required: true, message: '请选择客户名称', trigger: 'change' },
        ],
      },


      Level_Industry_ZipCode: {
        customerLevel:'',
        newCustomerIndustry:'',
        customerZipcode:''
      },
      Province_City_County:{
        newCustomerProvince:'',
        customerCity:'',
        customerCounty:'',
      },
      newcustomer_address:{
        newCustomerAddress:'',
      },
      Unit_taxnumber_telephone:{
        customerUnit:'',
        customerTaxnumber:'',
        customerTelephone:'',
      },
      Address_Bank_Account:{
        customerAddress:'',
        customerBank:'',
        customerAccount:'',
      },
      //BG所在行
      BG_BU_Industry:{
        customerBG:'',
        customerBU:'',
        customerIndustry:'',
      },
      rules_BG_BU_Industry:{
        customerBG:[
            {required: true, message: '请选择BG', trigger: 'change'}
        ],
        customerBU:[
            {required: true, message: '请选择BU', trigger: 'change'}
        ],
        customerIndustry:[
          {required: true, message: '请选择行业', trigger: 'change'}
        ]
      },
      //子行业所在行
      Subsector_ProjectType_Area:{
        customerSubsector:'',
        customerProjectType:'',
        customerArea:'',
      },
      rules_Subsector_ProjectType_Area:{
        customerSubsector:[
          {required: true, message: '请选择子行业', trigger: 'change'}
        ],
        customerProjectType:[
          {required: true, message: '请选择项目类型', trigger: 'change'}
        ],
        customerArea:[
          {required: true, message: '请选择项目区域', trigger: 'change'}
        ]
      },
      //机构所在行
      Institution_Province_AccountManager:{
        customerInstitution:'',
        customerProvince:'',
        customerAccountManager:'',
      },
      rules_Institution_Province_AccountManager:{
        customerInstitution:[
          {required: true, message: '请选择机构', trigger: 'change'}
        ],
        customerProvince:[
          {required: true, message: '请选择省份', trigger: 'change'}
        ],
        customerAccountManager:[
          { required: true, message: '请输入客户经理', trigger: 'blur' },
        ],
      },
      provinces: provincedata,
      cities: [],
      counties: [],
      //产品线所在行
      ProductLine_PartyB:{
        customerProductLine:'',
        customerPartyB:'',
      },
      rules_ProductLine_PartyB:{
        customerProductLine:[
          {required: true, message: '请选择产品线', trigger: 'change'}
        ],
        customerPartyB:[
          {required: true, message: '请选择乙方单位', trigger: 'change'}
        ],
      },
      rules: {
        date1: [
          { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
        ],
      },
      ruleForm: {
        date1: '',

      },
      //签单状态行
      SigningStatus_MaintenancePeriod:{
        customerSigningStatus:'',
        customerMaintenancePeriod:'',
      },
      contractCurrency:{
        radio1: '',
      },
      rules_SigningStatus_MaintenancePeriod:{
        customerSigningStatus:[
          {required: true, message: '请选择签单状态', trigger: 'change'}
        ],
        customerMaintenancePeriod:[
          {required: true, message: '请选择维保期', trigger: 'change'}
        ]
      },
      // 软件开发
      softwareDevelop:{
        checked: false, // 复选框的选中状态
        input1: '', // 第一个输入框的值
        value: '', // 下拉框的选中值
        input2:'',
      },
      softwareDevelopoptions: [
        { value: '0.01', label: '0.01' },
        { value: '0.03', label: '0.03' },
        { value: '0.05', label: '0.05' },
        { value: '0.08', label: '0.08' },
        { value: '0.1', label: '0.1' },
        { value: '0.15', label: '0.15' },
      ],
      softwareDeveloprules: {
        input1: [
          { required: true, message: '请输入金额', trigger: 'blur', when: () => this.softwareDevelop.checked },
        ],
        value: [
          { required: true, message: '请选择一个选项', trigger: 'change', when: () => this.softwareDevelop.checked },
        ],
      },
      // 第三方硬件
      thirdPartyHardware:{
        checked: false, // 复选框的选中状态
        input1: '', // 第一个输入框的值
        value: '', // 下拉框的选中值
        input2:'',
      },
      thirdPartyHardwareoptions: [
        { value: '0.01', label: '0.01' },
        { value: '0.03', label: '0.03' },
        { value: '0.05', label: '0.05' },
        { value: '0.08', label: '0.08' },
        { value: '0.1', label: '0.1' },
        { value: '0.15', label: '0.15' },
      ],
      thirdPartyHardwarerules: {
        input1: [
          { required: true, message: '请输入金额', trigger: 'blur', when: () => this.thirdPartyHardware.checked },
        ],
        value: [
          { required: true, message: '请选择一个选项', trigger: 'change', when: () => this.thirdPartyHardware.checked },
        ],
      },
      //第三方软件
      thirdPartySoftware:{
        checked: false, // 复选框的选中状态
        input1: '', // 第一个输入框的值
        value: '', // 下拉框的选中值
        input2:'',
      },
      thirdPartySoftwareoptions: [
        { value: '0.01', label: '0.01' },
        { value: '0.03', label: '0.03' },
        { value: '0.05', label: '0.05' },
        { value: '0.08', label: '0.08' },
        { value: '0.1', label: '0.1' },
        { value: '0.15', label: '0.15' },
      ],
      thirdPartySoftwarerules: {
        input1: [
          { required: true, message: '请输入金额', trigger: 'blur', when: () => this.thirdPartySoftware.checked },
        ],
        value: [
          { required: true, message: '请选择一个选项', trigger: 'change', when: () => this.thirdPartySoftware.checked },
        ],
      },
      //系统集成
      systemIntegration:{
        checked: false, // 复选框的选中状态
        input1: '', // 第一个输入框的值
        value: '', // 下拉框的选中值
        input2:'',
      },
      systemIntegrationoptions: [
        { value: '0.01', label: '0.01' },
        { value: '0.03', label: '0.03' },
        { value: '0.05', label: '0.05' },
        { value: '0.08', label: '0.08' },
        { value: '0.1', label: '0.1' },
        { value: '0.15', label: '0.15' },
      ],
      systemIntegrationrules: {
        input1: [
          { required: true, message: '请输入金额', trigger: 'blur', when: () => this.systemIntegration.checked },
        ],
        value: [
          { required: true, message: '请选择一个选项', trigger: 'change', when: () => this.systemIntegration.checked },
        ],
      },
      // 维护保健
      maintenance: {
        checked: false, // 复选框的选中状态
        input1: '', // 第一个输入框的值
        value: '', // 下拉框的选中值
        input2: '',
      },
      maintenanceoptions: [
        { value: '0.01', label: '0.01' },
        { value: '0.03', label: '0.03' },
        { value: '0.05', label: '0.05' },
        { value: '0.08', label: '0.08' },
        { value: '0.1', label: '0.1' },
        { value: '0.15', label: '0.15' },
      ],
      maintenancerules: {
        input1: [
          { required: true, message: '请输入金额', trigger: 'blur', when: () => this.maintenance.checked },
        ],
        value: [
          { required: true, message: '请选择一个选项', trigger: 'change', when: () => this.maintenance.checked },
        ],
      },
      //技术服务
      technicalServices:{
        checked: false, // 复选框的选中状态
        input1: '', // 第一个输入框的值
        value: '', // 下拉框的选中值
        input2: '',
      },
      technicalServicesoptions: [
        { value: '0.01', label: '0.01' },
        { value: '0.03', label: '0.03' },
        { value: '0.05', label: '0.05' },
        { value: '0.08', label: '0.08' },
        { value: '0.1', label: '0.1' },
        { value: '0.15', label: '0.15' },
      ],
      technicalServicesrules: {
        input1: [
          { required: true, message: '请输入金额', trigger: 'blur', when: () => this.technicalServices.checked },
        ],
        value: [
          { required: true, message: '请选择一个选项', trigger: 'change', when: () => this.technicalServices.checked },
        ],
      },
      checkboxValues: [],

      // 履约保证金
      performanceBond:{
        checked: false, // 复选框的选中状态
      },
      // 首付款
      firstPayment:{
        checked: false, // 复选框的选中状态
        input1:'',
        input2:'',
        input3:'',
        input4:'',
      },
      //上线款
      onlinePayment:{
        checked: false, // 复选框的选中状态
        input1:'',
        input2:'',
        input3:'',
        input4:'',
      },
      //起始款
      startPayment:{
        checked: false, // 复选框的选中状态
        input1:'',
        input2:'',
        input3:'',
        input4:'',
      },
      //终验款
      finalInspectionPayment:{
        checked: false, // 复选框的选中状态
        input1:'',
        input2:'',
        input3:'',
        input4:'',
      },
      //尾款
      finalPayment:{
        checked: false, // 复选框的选中状态
        input1:'',
        input2:'',
        input3:'',
        input4:'',
      },
      paymentMethodForm: {
        paymentMethod: ''
      },
      paymentMethodRules: {
        paymentMethod: [{ required: true, message: '请选择付款方式', trigger: 'blur' }]
      },
      textarea: '',
    dialogVisible: false
    };
  },
  computed: {
    selectedCount() {
      let count = 0;
      if (this.softwareDevelop.checked) count++;
      if (this.thirdPartyHardware.checked) count++;
      if (this.thirdPartySoftware.checked) count++;
      if (this.systemIntegration.checked) count++;
      if (this.maintenance.checked) count++;
      if (this.technicalServices.checked) count++;
      return count;
    },
    totalAmount() {
      let sum = 0;
      if (this.softwareDevelop.checked) {
        sum += parseFloat(this.softwareDevelop.input1 || 0);
      }
      if (this.thirdPartyHardware.checked) {
        sum += parseFloat(this.thirdPartyHardware.input1 || 0);
      }
      if (this.thirdPartySoftware.checked) {
        sum += parseFloat(this.thirdPartySoftware.input1 || 0);
      }
      if (this.systemIntegration.checked) {
        sum += parseFloat(this.systemIntegration.input1 || 0);
      }
      if (this.maintenance.checked) {
        sum += parseFloat(this.maintenance.input1 || 0);
      }
      if (this.technicalServices.checked) {
        sum += parseFloat(this.technicalServices.input1 || 0);
      }
      return sum.toFixed(2);
    },
    totalTax() {
      let sum = 0;
      if (this.softwareDevelop.checked) {
        sum += parseFloat(this.softwareDevelop.input2 || 0);
      }
      if (this.thirdPartyHardware.checked) {
        sum += parseFloat(this.thirdPartyHardware.input2 || 0);
      }
      if (this.thirdPartySoftware.checked) {
        sum += parseFloat(this.thirdPartySoftware.input2 || 0);
      }
      if (this.systemIntegration.checked) {
        sum += parseFloat(this.systemIntegration.input2 || 0);
      }
      if (this.maintenance.checked) {
        sum += parseFloat(this.maintenance.input2 || 0);
      }
      if (this.technicalServices.checked) {
        sum += parseFloat(this.technicalServices.input2 || 0);
      }
      return sum.toFixed(2);
    },
    selectedProvince() {
      return this.Institution_Province_AccountManager.customerInstitution;
    },
    selectedNewProvince() {
      return this.Province_City_County.newCustomerProvince;
    },

    selectedCity() {
      return this.Province_City_County.customerCity;
    },
  },

  watch:{
    selectedCount(newVal){
      if (newVal==0) {
        this.$message.error('请至少选择一种合同类型');
        return;
      }
    },
    selectedProvince(newValue) {
      // 根据选择的省，更新可选的市数据
      const selectedProvince = this.provinces.find(province => province.value === newValue);
      this.cities = selectedProvince ? selectedProvince.children : [];
      // 重置市和县的选择
      this.Province_City_County.customerCity = '';
      this.Province_City_County.customerCounty = '';
      // 清空县的数据
      this.counties = [];
    },
    selectedNewProvince(newValue) {
      // 根据选择的省，更新可选的市数据
      const selectedProvince = this.provinces.find(province => province.value === newValue);
      this.cities = selectedProvince ? selectedProvince.children : [];
      // 重置市和县的选择
      this.Province_City_County.customerCity = '';
      this.Province_City_County.customerCounty = '';
      // 清空县的数据
      this.counties = [];
    },
    selectedCity(newValue) {
      // 根据选择的市，更新可选的县数据
      const selectedProvince = this.provinces.find(province => province.value === this.Province_City_County.newCustomerProvince);
      if (selectedProvince) {
        const selectedCity = selectedProvince.children.find(city => city.value === newValue);
        this.counties = selectedCity ? selectedCity.children : [];
      } else {
        this.counties = [];
      }
      // 重置县的选择
      this.Province_City_County.customerCounty= '';
    }
  },
  methods: {
    resetForm() {
      // 重置表单数据
      this.newcustomer_name = {
        newCustomerName: ''
      };
      this.Level_Industry_ZipCode = {
        customerLevel: '',
        newCustomerIndustry: '',
        customerZipcode: ''
      };
      this.Province_City_County = {
        newCustomerProvince: '',
        customerCity: '',
        customerCounty: ''
      };
      this.newcustomer_address = {
        newCustomerAddress: ''
      };
      this.Unit_taxnumber_telephone = {
        customerUnit: '',
        customerTaxnumber: '',
        customerTelephone: ''
      };
      this.Address_Bank_Account = {
        customerAddress: '',
        customerBank: '',
        customerAccount: ''
      };
      // 关闭对话框
      this.dialogVisible = false;
    },
    onSubmit() {
      this.insertCustomerData()
          .then(() => {
            // 第一个插入操作成功后再执行第二个插入操作
            return this.insertInvoiceInfoData();
          })
          .then(() => {
            // 两个插入操作都成功
            this.$message.success('提交成功');
            this.resetForm();
          })
          .catch(error => {
            // 插入操作失败
            this.$message.error('提交失败: ' + error);
          });
    },


    insertCustomerData() {
      return new Promise((resolve, reject) => {
        const newCustomerData = {
          customerName: this.newcustomer_name.newCustomerName,
          customerLevel: this.Level_Industry_ZipCode.customerLevel,
          industry: this.Level_Industry_ZipCode.newCustomerIndustry,
          postalCode: this.Level_Industry_ZipCode.customerZipcode,
          province: this.Province_City_County.newCustomerProvince,
          city: this.Province_City_County.customerCity,
          county: this.Province_City_County.customerCounty,
          address: this.newcustomer_address.newCustomerAddress
        };

        request.post('/sys/customers/addCustomer', newCustomerData)
            .then(response => {
              console.log(response);
              resolve();
            })
            .catch(error => {
              console.error(error);
              reject('插入客户信息失败');
            });
      });
    },

    insertInvoiceInfoData() {
      return new Promise((resolve, reject) => {
        const invoiceInfoData = {
          customerName: this.newcustomer_name.newCustomerName,
          companyName: this.Unit_taxnumber_telephone.customerUnit,
          taxNumber: this.Unit_taxnumber_telephone.customerTaxnumber,
          phone: this.Unit_taxnumber_telephone.customerTelephone,
          address: this.Address_Bank_Account.customerAddress,
          bankName: this.Address_Bank_Account.customerBank,
          bankAccount: this.Address_Bank_Account.customerAccount
        };
        console.log(invoiceInfoData.company_name)
        request.post('/sys/invoiceInfo/addInvoiceInfo', invoiceInfoData)
            .then(response => {
              console.log(response);
              resolve();
            })
            .catch(error => {
              console.error(error);
              reject('插入发票信息失败');
            });
      });
    },
    incrementCounter() {
      this.uploadCounter++; // 上传成功，递增计数器
      console.log('文件上传成功，uploadCounter:', this.uploadCounter);
    },
    uploadAllFiles() {
      const contractContentUpload = this.$refs.ContractContentUpload;
      const grossMarginUpload = this.$refs.GrossMarginUpload;
      const priceListUpload = this.$refs.PriceListUpload;

      // 调用每个文件的上传函数
      Promise.all([
        new Promise((resolve, reject) => {
          setTimeout(() => {
            this.uploadFile(contractContentUpload)
                .then(() => {
                  // this.incrementCounter();
                  resolve();
                })
                .catch((error) => {
                  // this.incrementCounter();
                  // console.log(error)
                  reject(error);
                });
          }, 0);
        }),
        new Promise((resolve, reject) => {
          setTimeout(() => {
            this.uploadFile(grossMarginUpload)
                .then(() => {
                  // this.incrementCounter();
                  resolve();
                })
                .catch((error) => {
                  reject(error);
                });
          }, 40);
        }),
        new Promise((resolve, reject) => {
          setTimeout(() => {
            this.uploadFile(priceListUpload)
                .then(() => {
                  // this.incrementCounter();
                  resolve();
                })
                .catch((error) => {
                  reject(error);
                });
          }, 80);
        })
      ])
          .then(() => {
            // 所有文件上传成功
            if (this.uploadCounter === 3) {
              this.enablePublishButton(); // 启用发布按钮
            }
          })
          .catch((error) => {
            // 处理上传过程中的错误
            this.$message.error('上传文件失败: ' + error);
          });
    },

    enablePublishButton() {
      this.isPublishButtonDisabled = false; // 启用发布按钮
      console.log('Publish button enabled');
    },

    uploadFile(uploadRef) {
      return new Promise((resolve, reject) => {
        uploadRef.submit();
        uploadRef.$on('success', () => {
          // 上传成功的处理逻辑
          resolve();
        });
        uploadRef.$on('error', (err) => {
          // 上传失败的处理逻辑
          reject(err);
        });
      });
    },

    totalSubmit() {
      this.insertContractData()
          .then(() => {
            return this.insertContractInfoData();
          })
          .then(() => {
            return this.insertContractTypesInfo();
          })
          .then(() => {
            return this.insertContractPayment();
          })
          .then(() => {
            this.$message.success('提交成功');
          })
          .catch(error => {
            this.$message.error('提交失败: ' + error);
          });
    },



    insertContractData(){
      const contractData={
        contractName:this.contract_name.name,
        signDate:this.ruleForm.date1,
        contractTotal:this.totalAmount,
        contractContent:this.contractContentResponse,
        state:0,
        userAccount:""
      };
      return request.post('/sys/contracts/addContracts', contractData)
          .then(response => {
            console.log(response);
          })
          .catch(error => {
            console.error(error);
            throw new Error('插入合同数据失败');
          });
    },

    getContractContentName(response){
      this.contractContentResponse=response;
      // console.log(response);
      this.incrementCounter();
    },
    getGrossMarginName(response){
      this.grossMarginResponse=response;
      // console.log(response);
      this.incrementCounter();
    },
    getPriceListName(response){
      this.priceListResponse=response;
      // console.log(response);
      this.incrementCounter();
    },

    insertContractInfoData(){
      const contractInfo={
        contractName:this.contract_name.name,
        customerName:this.customerName.region,
        accountManagerName:this.Institution_Province_AccountManager.customerAccountManager,
        contractNumber:this.contractID.ID,
        bg:this.BG_BU_Industry.customerBG,
        bu:this.BG_BU_Industry.customerBU,
        industry:this.BG_BU_Industry.customerIndustry,
        subIndustry:this.Subsector_ProjectType_Area.customerSubsector,
        projectType:this.Subsector_ProjectType_Area.customerProjectType,
        region:this.Subsector_ProjectType_Area.customerArea,
        institution:this.Institution_Province_AccountManager.customerInstitution,
        province:this.Institution_Province_AccountManager.customerProvince,
        productLine:this.ProductLine_PartyB.customerProductLine,
        partyB:this.ProductLine_PartyB.customerPartyB,
        currency:this.contractCurrency.radio1,
        grossMargin:this.grossMarginResponse,
        priceList:this.priceListResponse,
        performanceBonds:this.performanceBond.checked,
        other:this.textarea,
        typeNumber:this.selectedCount,
        maintenancePeriod:this.SigningStatus_MaintenancePeriod.customerMaintenancePeriod,
        rateTotal:this.totalTax,
        signingStatus:this.SigningStatus_MaintenancePeriod.customerSigningStatus,
        paymentMethod:this.paymentMethodForm.paymentMethod,
      };
      return request.post('/sys/contractInfo/addContractInfo', contractInfo)
          .then(response => {
            console.log(response);
          })
          .catch(error => {
            console.error(error);
            throw new Error('插入合同信息数据失败');
          });
    },

    insertContractTypesInfo() {
      const contractTypesInfoData = {
        contractName: this.contract_name.name,
        contractTypeId: null,
        amount: null,
        rate: null,
        taxRate: null,
      };

      if (this.softwareDevelop.checked) {
        contractTypesInfoData.contractTypeId = 1;
        contractTypesInfoData.amount = this.softwareDevelop.input1;
        contractTypesInfoData.rate = this.softwareDevelop.value;
        contractTypesInfoData.taxRate = this.softwareDevelop.input2;
        this.sendToBackend(contractTypesInfoData);
      }

      if (this.thirdPartyHardware.checked) {
        contractTypesInfoData.contractTypeId = 2;
        contractTypesInfoData.amount = this.thirdPartyHardware.input1;
        contractTypesInfoData.rate = this.thirdPartyHardware.value;
        contractTypesInfoData.taxRate = this.thirdPartyHardware.input2;
        this.sendToBackend(contractTypesInfoData);
      }

      if (this.thirdPartySoftware.checked) {
        contractTypesInfoData.contractTypeId = 3;
        contractTypesInfoData.amount = this.thirdPartySoftware.input1;
        contractTypesInfoData.rate = this.thirdPartySoftware.value;
        contractTypesInfoData.taxRate = this.thirdPartySoftware.input2;
        this.sendToBackend(contractTypesInfoData);
      }

      if (this.systemIntegration.checked) {
        contractTypesInfoData.contractTypeId = 4;
        contractTypesInfoData.amount = this.systemIntegration.input1;
        contractTypesInfoData.rate = this.systemIntegration.value;
        contractTypesInfoData.taxRate = this.systemIntegration.input2;
        this.sendToBackend(contractTypesInfoData);
      }

      if (this.maintenance.checked) {
        contractTypesInfoData.contractTypeId = 5;
        contractTypesInfoData.amount = this.maintenance.input1;
        contractTypesInfoData.rate = this.maintenance.value;
        contractTypesInfoData.taxRate = this.maintenance.input2;
        this.sendToBackend(contractTypesInfoData);
      }

      if (this.technicalServices.checked) {
        contractTypesInfoData.contractTypeId = 6;
        contractTypesInfoData.amount = this.technicalServices.input1;
        contractTypesInfoData.rate = this.technicalServices.value;
        contractTypesInfoData.taxRate = this.technicalServices.input2;
        this.sendToBackend(contractTypesInfoData);
      }
    },
    sendToBackend(contractTypesInfoData) {
      return request.post('/sys/contractTypesInfo/addContractTypesInfo', contractTypesInfoData)
          .then(response => {
            console.log(response);
          })
          .catch(error => {
            console.error(error);
            throw new Error('插入合同类型数据失败');
          });
    },
    insertContractPayment() {
      const contractPaymentData = {
        contractName: this.contract_name.name,
        paymentTypeId: null,
        paymentAmount: null,
        paymentPercent: null,
        paymentNode: null,
        paymentTerms: null,
      };

      if (this.firstPayment.checked) {
        contractPaymentData.paymentTypeId = 1;
        contractPaymentData.paymentAmount = this.firstPayment.input1;
        contractPaymentData.paymentPercent = this.firstPayment.input2;
        contractPaymentData.paymentNode = this.firstPayment.input3;
        contractPaymentData.paymentTerms = this.firstPayment.input4;
        this.insertDataToBackend(contractPaymentData);
      }

      if (this.onlinePayment.checked) {
        contractPaymentData.paymentTypeId = 2;
        contractPaymentData.paymentAmount = this.onlinePayment.input1;
        contractPaymentData.paymentPercent = this.onlinePayment.input2;
        contractPaymentData.paymentNode = this.onlinePayment.input3;
        contractPaymentData.paymentTerms = this.onlinePayment.input4;
        this.insertDataToBackend(contractPaymentData);
      }

      if (this.startPayment.checked) {
        contractPaymentData.paymentTypeId = 3;
        contractPaymentData.paymentAmount = this.startPayment.input1;
        contractPaymentData.paymentPercent = this.startPayment.input2;
        contractPaymentData.paymentNode = this.startPayment.input3;
        contractPaymentData.paymentTerms = this.startPayment.input4;
        this.insertDataToBackend(contractPaymentData);
      }

      if (this.finalInspectionPayment.checked) {
        contractPaymentData.paymentTypeId = 4;
        contractPaymentData.paymentAmount = this.finalInspectionPayment.input1;
        contractPaymentData.paymentPercent = this.finalInspectionPayment.input2;
        contractPaymentData.paymentNode = this.finalInspectionPayment.input3;
        contractPaymentData.paymentTerms = this.finalInspectionPayment.input4;
        this.insertDataToBackend(contractPaymentData);
      }

      if (this.finalPayment.checked) {
        contractPaymentData.paymentTypeId = 5;
        contractPaymentData.paymentAmount = this.finalPayment.input1;
        contractPaymentData.paymentPercent = this.finalPayment.input2;
        contractPaymentData.paymentNode = this.finalPayment.input3;
        contractPaymentData.paymentTerms = this.finalPayment.input4;
        this.insertDataToBackend(contractPaymentData);
      }
    },

    insertDataToBackend(contractPaymentData) {
      return request.post('/sys/contractPayment/addContractPayment', contractPaymentData)
          .then(response => {
            console.log(response);
          })
          .catch(error => {
            console.error(error);
            throw new Error('插入合同支付数据失败');
          });
    },



    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeUpload(file) {
      const isLt100M = file.size / 1024 / 1024 < 50;

      if (!isLt100M) {
        this.$message.error('上传文件大小不能超过50MB!');
      }
      return isLt100M;
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
          .then(() => {
            // 清空表单数据
            this.clearFormData();
            done();
          })
          .catch(error => {
            console.error('An error occurred:', error);
          });
    },

    clearFormData() {
      // 清空表单数据
      this.newcustomer_name.newCustomerName = '';
      this.Level_Industry_ZipCode.customerLevel = '';
      this.Level_Industry_ZipCode.newCustomerIndustry = '';
      this.Level_Industry_ZipCode.customerZipcode = '';
      this.Province_City_County.newCustomerProvince = '';
      this.Province_City_County.customerCity = '';
      this.Province_City_County.customerCounty = '';
      this.newcustomer_address.newCustomerAddress = '';
      this.Unit_taxnumber_telephone.customerUnit = '';
      this.Unit_taxnumber_telephone.customerTaxnumber = '';
      this.Unit_taxnumber_telephone.customerTelephone = '';
      this.Address_Bank_Account.customerAddress = '';
      this.Address_Bank_Account.customerBank = '';
      this.Address_Bank_Account.customerAccount = '';
    }
  }
}
</script>