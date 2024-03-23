<template>
  <div>
<!--    <el-button type="primary" @click="showDialog">打开弹窗</el-button>-->
    <el-dialog :visible="PaydialogVisible" title="支付节点" @close="closePayDialog">
      <!--支付信息-->

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
              <el-checkbox v-model="firstPayment.checked" style="margin-left: 45%" :disabled="firstDisabled">首付款</el-checkbox>
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
              <el-checkbox v-model="onlinePayment.checked" style="margin-left: 45%" :disabled="onlineDisabled">上线款</el-checkbox>
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
              <el-checkbox v-model="startPayment.checked" style="margin-left: 45%" :disabled="startDisabled">初始款</el-checkbox>
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
              <el-checkbox v-model="finalInspectionPayment.checked" style="margin-left: 45%" :disabled="finalInspectionDisabled">终验款</el-checkbox>
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
              <el-checkbox v-model="finalPayment.checked" style="margin-left: 45%" :disabled="finalDisabled">尾款</el-checkbox>
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
<!--        <template>-->
<!--          <div>-->
<!--            <el-form :inline="true" label-width="100px" label-position="right" :model="paymentMethodForm" :rules="paymentMethodRules">-->
<!--              <el-form-item label="付款方式" size="mini" style="display: inline-block;" prop="paymentMethod">-->
<!--                <el-radio-group v-model="paymentMethodForm.paymentMethod" size="mini">-->
<!--                  <el-radio-button label="支票"></el-radio-button>-->
<!--                  <el-radio-button label="电汇"></el-radio-button>-->
<!--                  <el-radio-button label="银行承兑汇票"></el-radio-button>-->
<!--                  <el-radio-button label="商业承兑汇票"></el-radio-button>-->
<!--                  <el-radio-button label="转账"></el-radio-button>-->
<!--                </el-radio-group>-->
<!--              </el-form-item>-->
<!--            </el-form>-->
<!--          </div>-->
<!--        </template>-->
      </div>

    </el-dialog>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  data() {
    return {
      firstDisabled:true,
      onlineDisabled:true,
      startDisabled:true,
      finalInspectionDisabled:true,
      finalDisabled:true,
      PaydialogVisible:false,
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
    };
  },
  methods: {
    showPayDialog(contractName) {
      // console.log(contractName);
      request.get("http://localhost:8888/sys/contractPayment/getPaymentByContractName?contractName="+contractName).then(res=>{
        res.data.forEach(payment=>{
          if(payment.paymentTypeId===1){
            this.firstPayment.checked=true;
            this.firstPayment.input1=payment.paymentAmount;
            this.firstPayment.input2=payment.paymentPercent;
            this.firstPayment.input3=payment.paymentNode;
            this.firstPayment.input4=payment.paymentTerms;
            this.firstDisabled=false;
          }else if(payment.paymentTypeId===2){
            this.onlinePayment.checked=true;
            this.onlinePayment.input1=payment.paymentAmount;
            this.onlinePayment.input2=payment.paymentPercent;
            this.onlinePayment.input3=payment.paymentNode;
            this.onlinePayment.input4=payment.paymentTerms;
            this.onlineDisabled=false;
          }else if(payment.paymentTypeId===3){
            this.startPayment.checked=true;
            this.startPayment.input1=payment.paymentAmount;
            this.startPayment.input2=payment.paymentPercent;
            this.startPayment.input3=payment.paymentNode;
            this.startPayment.input4=payment.paymentTerms;
            this.startDisabled=false;
          }else if(payment.paymentTypeId===4){
            this.finalInspectionPayment.checked=true;
            this.finalInspectionPayment.input1=payment.paymentAmount;
            this.finalInspectionPayment.input2=payment.paymentPercent;
            this.finalInspectionPayment.input3=payment.paymentNode;
            this.finalInspectionPayment.input4=payment.paymentTerms;
            this.finalInspectionDisabled=false;
          }else if(payment.paymentTypeId===5){
            this.finalPayment.checked=true;
            this.finalPayment.input1=payment.paymentAmount;
            this.finalPayment.input2=payment.paymentPercent;
            this.finalPayment.input3=payment.paymentNode;
            this.finalPayment.input4=payment.paymentTerms;
            this.finalDisabled=false;
          }
        })
      })
      this.PaydialogVisible = true;
    },
    closePayDialog() {
      this.$emit('close'); // 触发关闭弹窗的事件
      this.PaydialogVisible=false;
      this.clearData();
    },
    clearData() {
      Object.keys(this.firstPayment).forEach(key => {
        if (key !== 'checked') {
          this.$set(this.firstPayment, key, '');
        }
      });
      this.firstPayment.checked = false;

      Object.keys(this.onlinePayment).forEach(key => {
        if (key !== 'checked') {
          this.$set(this.onlinePayment, key, '');
        }
      });
      this.onlinePayment.checked = false;

      Object.keys(this.startPayment).forEach(key => {
        if (key !== 'checked') {
          this.$set(this.startPayment, key, '');
        }
      });
      this.startPayment.checked = false;

      Object.keys(this.finalInspectionPayment).forEach(key => {
        if (key !== 'checked') {
          this.$set(this.finalInspectionPayment, key, '');
        }
      });
      this.finalInspectionPayment.checked = false;

      Object.keys(this.finalPayment).forEach(key => {
        if (key !== 'checked') {
          this.$set(this.finalPayment, key, '');
        }
      });
      this.finalPayment.checked = false;
          this.firstDisabled=true;
          this.onlineDisabled=true;
          this.startDisabled=true;
          this.finalInspectionDisabled=true;
          this.finalDisabled=true;
    }
  }
};
</script>
<style  scoped>
.el-dialog_body{
  padding-top: 10px !important;
}

.tableType{
  display: flex;
  width: 99%; /* 矩形的宽度 */
//height: 40px; /* 矩形的高度 */
  margin-left: 0.5%;
  margin-top: 10px;
  margin-bottom: 10px;
  background-color: #E4E7ED;/* 矩形的填充颜色 */
//border: 0.5px solid black; /* 矩形的边框，2px 的宽度，黑色 */
}
.tableHead{
  width: 25%;
  height: 100%;
  text-align: center;
  display: flex;
  justify-content: center;
  align-items: center;
}
.Table{
  width: 100%;
}

</style>
