import Vue from 'vue'

import 'expose-loader?$!expose-loader?jQuery!jquery'
import 'jquery-inview'
import 'magnific-popup';

import App from './App.vue'

import {store} from './store/store'

Vue.config.productionTip = false

new Vue({
    store,
    render: h => h(App),
}).
$mount('#app')

