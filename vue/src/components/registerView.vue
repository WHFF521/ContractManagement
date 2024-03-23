<template>
  <div class="register-page">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span class="register-title">用户注册</span>
        <el-button class="return-button" type="text" @click="handleReturn">返回登录</el-button>
      </div>
      <div class="register-form">
        <el-form :model="form" :rules="registerRules" ref="registerForm">
          <el-form-item label="账号" prop="username">
            <el-input v-model="form.username" placeholder="请输入账号"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="form.password" placeholder="请输入密码"></el-input>
          </el-form-item>
          <el-form-item label="用户姓名" prop="name">
            <el-input v-model="form.name" placeholder="请输入用户姓名"></el-input>
          </el-form-item>
          <el-form-item label="电话" prop="phone">
            <el-input v-model="form.phone" placeholder="请输入电话"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="form.email" placeholder="请输入邮箱"></el-input>
          </el-form-item>
          <el-form-item label="身份" prop="role">
            <el-select v-model="form.role" placeholder="请选择身份">
              <el-option label="客户经理" value="1"></el-option>
              <el-option label="主管" value="2"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="handleRegister" :loading="loading">注册</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'registerView',
  data() {
    return {
      loading: false,
      form: {
        username: '',
        password: '',
        name: '',
        phone: '',
        email: '',
        role: ''
      },
      registerRules: {
        username: [
          { required: true, message: '请输入账号', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ],
        name: [
          { required: true, message: '请输入用户姓名', trigger: 'blur' }
        ],
        phone: [
          { required: true, message: '请输入电话', trigger: 'blur' }
        ],
        role: [
          { required: true, message: '请选择身份', trigger: 'change' }
        ]
      }
    }
  },
  methods: {
    handleRegister() {
      this.$refs.registerForm.validate().then(() => {
        this.loading = true;
        const responseData={
          userAccount:this.form.username,
          userPassword:this.form.password,
          userName:this.form.name,
          userPhone:this.form.phone,
          userEmail:this.form.email,
          userRole:this.form.role
        }
        axios.post('http://localhost:8888/sys/users/register', responseData)
            .then(response => {
              // 注册成功
              this.$message.success(response.data);
              this.loading = false;
              this.$router.push('/');
            })
            .catch(error => {
              // 注册失败
              this.$message.error('注册失败，请重试');
              this.loading = false;
            });
      }).catch(() => {
        return false;
      });
    },
    handleReturn() {
      this.$router.push('/');
    }
  }
}
</script>

<style scoped>
.register-page {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.box-card {
  width: 400px;
}

.register-title {
  font-size: 18px;
  float: left;
  line-height: 40px;
}

.return-button {
  float: right;
  margin-top: -5px;
}

.register-form {
  margin-top: 20px;
}
</style>
