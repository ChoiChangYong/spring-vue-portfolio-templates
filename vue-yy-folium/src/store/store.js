import Vue from 'vue'
import Vuex from 'vuex'

import VueTypedJs from 'vue-typed-js'

import YYFoliumNav from './modules/yy-folium-nav'
import YYFoliumHome from './modules/yy-folium-home'
import YYFoliumAbout from './modules/yy-folium-about'

Vue.use(Vuex);
Vue.use(VueTypedJs);
 
export const store = new Vuex.Store({
    modules: {
        YYFoliumNav,
        YYFoliumHome,
        YYFoliumAbout
    }
});