import Vue from 'vue'
import VueRouter from 'vue-router'
import store from "../store";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: () => import('../views/Manage.vue'),
    redirect:'/home',
    children:[
      {path:'home', name:'首页', component: () =>import('../views/Home.vue')},
      {path:'user',name:'用户管理',component: () => import('../views/User.vue')},
      {path:'person',name:'个人信息',component: () => import('../views/Person.vue')},
      {path:'file',name:'文件管理',component: () => import('../views/File.vue')},
      {path:'article',name:'党务公开',component: () => import('../views/Article.vue')},
      {path:'activities',name:'专题活动',component: () => import('../views/Activities.vue')},
      {path:'papers',name:'活动记载',component: () => import('../views/Papers.vue')},
      {path:'advertise',name:'宣传文章上传',component: () => import('../views/Advertise.vue')},
    ]
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/login',
    name:'Login',
    component:() => import('../views/Login.vue')
  },
  {
    path: '/register',
    name:'Register',
    component:() => import('../views/Register.vue')
  },
]


const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

/*路由守卫*/
router.beforeEach((to, from, next) => {
  localStorage.setItem("currentPathName",to.name) //设置当前的路由名称,为了在header组件中去使用
  store.commit("setPath") //触发store的数据更新
  next()  //放行路由
})

export default router
