import Vue from 'vue'
import VueRouter from 'vue-router'

//import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    redirect: "/login"
  },
  {
    path: '/home',
    name: '框架页',
    component: () => import('../views/layout/indexView.vue'),
    redirect: '/contractBoard',
    children:[
      {
        path: '/contractBoard',
        component: () => import('../components/contractBoard1.vue')
      },
      {
        path: '/myBoard',
        component: () => import('../components/myBoard1.vue')
      },
      {
        path: '/addContract',
        component: () => import('../components/addContract.vue')
      },
      {
        path: '/contractAnalyze',
        component: () => import('../components/contractAnalyze.vue')
      },
      {
        path:'/myCustomers',
        component:() => import('../components/MyCustomers.vue')
      },
      {
        path:'/myWeeklyReport',
        component:() => import('../components/my_weekly_report2.vue')
      },
      {
        path:'/addWeeklyReport',
        component:() => import('../components/addWeeklyReport.vue')
      },
      {
        path:'/weeklyReviews',
        component:() => import('../components/weeklyReviews.vue')
      },
      {
        path:"/enterProjectView",
        name:'enterProjectView',
        component: () => import('../components/enterProjectView2.vue')
      },
      {
        path: '/accepted',
        component:() => import('../components/accepted.vue')
      },
      {
        path: '/details1',
        name: 'details1',
        component: () => import('../components/details1.vue')
      },
      {
        path: '/details2',
        name: 'details2',
        component: () => import('../components/details2.vue')
      },
      {
        path: '/details3',
        name: 'details3',
        component: () => import('../components/details3.vue')
      },
      {
        path: '/details4',
        name: 'details4',
        component: () => import('../components/details4.vue')
      },
      {
        path: '/details5',
        name: 'details5',
        component: () => import('../components/details5.vue')
      },
      {
        path: '/details6',
        name: 'details6',
        component: () => import('../components/details6.vue')
      },
      {
        path: '/details7',
        name: 'details7',
        component: () => import('../components/details7.vue')
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../components/Login.vue')
  },
  {
    path: "/registerView",
    name:'registerView',
    component: () => import('../components/registerView.vue')
  },

]

const router = new VueRouter({
  routes
})

export default router
