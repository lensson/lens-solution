import Vue from 'vue'

import App from './App'
import router from './router'
import store from './store'
import '@/icons'
import '@/permission'

// 添加粒子特效
import VueParticles from 'vue-particles'

Vue.use(VueParticles)

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
