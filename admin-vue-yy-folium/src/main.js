import Vue from 'vue'
import App from './App.vue'

import 'expose-loader?$!expose-loader?jQuery!jquery'
import 'bootstrap'
import 'jquery-ui'
import 'jquery-slimscroll'
import 'owl.carousel'
import 'popper.js'
import 'particles.js'

import {router} from './routes'
import {store} from './store/store'

Vue.config.productionTip = false

new Vue({
  store,
  router,
  render: h => h(App),
}).$mount('#app')
