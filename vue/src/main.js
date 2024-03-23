import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VeCharts from 've-charts'
Vue.use(VeCharts)

import axios from 'axios'
Vue.use(ElementUI)
axios.defaults.baseURL="http://localhost:8888"
// Vue.prototype.$http=axios

import '@/assets/styles/common.scss'
 import request from '@/utils/request'
// import axios from 'axios'

Vue.config.productionTip = false
Vue.config.request = request
// Vue.prototype.$http = axios

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
