import Vue from 'vue'
import Vuex from 'vuex'

import Home from './modules/admin-yy-folium-home'
import Common from './modules/admin-yy-folium-common'
import Job from './modules/admin-yy-folium-about-job'
import ShowAlert from './modules/admin-yy-folium-alert.js'
import Login from './modules/admin-yy-folium-login'

import VueToastr2 from 'vue-toastr-2'
import 'vue-toastr-2/dist/vue-toastr-2.min.css'

import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';


window.toastr = require('toastr')

Vue.use(Vuex);
Vue.use(VueToastr2)
Vue.use(VueSweetalert2);

const mutations = {
    toastSubmit() {
        Vue.prototype.$toastr.success('성공적으로 저장되었습니다.', 'Submit Success', {timeOut: 1000});
    },
    
}

export const store = new Vuex.Store({
    modules: {
        Home,
        Common,
        Job,
        ShowAlert,
        Login
    },
    mutations,
});