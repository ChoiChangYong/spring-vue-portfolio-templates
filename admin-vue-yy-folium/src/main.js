import Vue from 'vue'
import App from './App.vue'

import 'expose-loader?$!expose-loader?jQuery!jquery'

import 'bootstrap'

import 'dropify'
import 'dropify/dist/css/dropify.min.css'

import 'vue2-dropzone/dist/vue2Dropzone.min.css'

import 'jquery-ui'

import 'jquery-slimscroll'

import 'owl.carousel'

import 'popper.js'

import 'particles.js'
import dropzone from 'dropzone'

import { router } from './routes/admin'
import { store } from './store/store'

Vue.config.productionTip = false
dropzone.autoDiscover = false;

new Vue({
  store,
  router,
  render: h => h(App),
}).$mount('#app')
