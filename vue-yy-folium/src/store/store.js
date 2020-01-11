import Vue from 'vue'
import Vuex from 'vuex'

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import VueTypedJs from 'vue-typed-js'

import home from './modules/yy-folium-home'
import contact from './modules/yy-folium-contact'

Vue.use(BootstrapVue);
Vue.use(Vuex);
Vue.use(VueTypedJs);
 
export const store = new Vuex.Store({
    modules: {
        home,
        contact
    }
});