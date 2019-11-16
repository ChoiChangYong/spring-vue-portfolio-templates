import Vue from 'vue'
import Vuex from 'vuex'

import nav from './modules/nav'
// import * as getters from './modules/getters'
// import * as mutations from './modules/mutations'
import loginApi from './modules/loginApi'

import VueToastr2 from 'vue-toastr-2'
import 'vue-toastr-2/dist/vue-toastr-2.min.css'

import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';


window.toastr = require('toastr')

Vue.use(Vuex);
Vue.use(VueToastr2)
Vue.use(VueSweetalert2);

// const mutations = {
//     toastSubmit() {
//         Vue.prototype.$toastr.success('성공적으로 저장되었습니다.', 'Submit Success', {timeOut: 1000});
//     },
    
// }

export const store = new Vuex.Store({
    modules: {
        nav,
        loginApi,
    },
});