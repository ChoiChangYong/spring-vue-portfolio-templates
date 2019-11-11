import Vue from 'vue'
import Vuex from 'vuex'

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import VueToastr2 from 'vue-toastr-2'
import 'vue-toastr-2/dist/vue-toastr-2.min.css'

import home from './modules/admin-yy-folium-home'

window.toastr = require('toastr')

Vue.use(Vuex);
Vue.use(BootstrapVue);
Vue.use(VueToastr2)

export const store = new Vuex.Store({
    modules: {
        home
    }
});