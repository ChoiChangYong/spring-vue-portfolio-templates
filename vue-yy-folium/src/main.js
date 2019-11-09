import Vue from 'vue'

import 'expose-loader?$!expose-loader?jQuery!jquery'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'


import App from './App.vue'

import {store} from './store/store'

Vue.config.productionTip = false

new Vue({
    store,
    render: h = > h(App),
}).
$mount('#app')

