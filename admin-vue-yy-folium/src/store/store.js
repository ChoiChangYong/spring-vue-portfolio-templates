import Vue from 'vue'
import Vuex from 'vuex'

import Home from './modules/home'
import Common from './modules/common'
import Job from './modules/about-job'
import ShowAlert from './modules/alert.js'
import Login from './modules/login'
import Session from './modules/session'

import VueToastr2 from 'vue-toastr-2'
import 'vue-toastr-2/dist/vue-toastr-2.min.css'

import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';


window.toastr = require('toastr')

Vue.use(Vuex);
Vue.use(VueToastr2)
Vue.use(VueSweetalert2);

const state = {
    host: "http://ec2-52-79-241-61.ap-northeast-2.compute.amazonaws.com:8080/api"
}

const getters = {
    getHost(state){
        return state.host
    }
}

const mutations = {
    toastSubmit() {
        Vue.prototype.$toastr.success('성공적으로 저장되었습니다.', 'Submit Success', {timeOut: 1000});
    },
    
}

export const store = new Vuex.Store({
    namespaced: true,
    modules: {
        Home,
        Common,
        Job,
        ShowAlert,
        Login,
        Session
    },
    state,
    getters,
    mutations,
});