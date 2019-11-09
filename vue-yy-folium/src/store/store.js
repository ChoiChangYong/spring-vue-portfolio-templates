import Vue from 'vue'
import Vuex from 'vuex'

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import VueTypedJs from 'vue-typed-js'

import YYFoliumNav from './modules/yy-folium-nav'
import YYFoliumHome from './modules/yy-folium-home'
import YYFoliumAbout from './modules/yy-folium-about'
import YYFoliuContact from './modules/yy-folium-contact'

Vue.use(BootstrapVue);
Vue.use(Vuex);
Vue.use(VueTypedJs);
 
export const store = new Vuex.Store({
    modules: {
        YYFoliumNav,
        YYFoliumHome,
        YYFoliumAbout,
        YYFoliuContact
    }
});