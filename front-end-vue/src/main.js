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

import 'jquery-inview'
import 'magnific-popup';

import { router } from './routes/index'
import { store } from './store/store'
import { FontAwesomeIcon } from '@fortawesome/fontawesome-free'

Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.config.productionTip = false
dropzone.autoDiscover = false;

new Vue({
  store,
  router,
  render: h => h(App),
}).$mount('#app')
