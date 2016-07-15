import Vue from 'vue'
import VueRouter from 'vue-router'
import VueResource from 'vue-resource'
//var VueBreadcrumbs = require('vue-breadcrumbs')
//import VueBreadcrumbs from 'vue-breadcrumbs'


import App from './App.vue'
import Home from './components/Home.vue'
import TimeEntries from './components/TimeEntries.vue'
import LogTime from './components/LogTime.vue'


Vue.use(VueResource)
Vue.use(VueRouter)
//Vue.use(VueBreadcrumbs)

const router = new VueRouter()

router.map({
  '/home': {
    component: Home,
  },
  '/time-entries': {
    component: TimeEntries,
    subRoutes: {
      '/log-time': {
        component: LogTime,
      }
    }
  }
})

router.redirect({
  '*':'/home'
})

router.start(App,'#app')

new Vue({
  el: 'body',
  components: { App }
})
