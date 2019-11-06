import Vue from 'vue'
import Vuex from 'vuex'

import VueTypedJs from 'vue-typed-js'

import YYFoliumNav from './modules/yy-folium-nav'
import YYFoliumHome from './modules/yy-folium-home'

Vue.use(Vuex);
Vue.use(VueTypedJs);

export const store = new Vuex.Store({
    modules: {
        YYFoliumNav,
        YYFoliumHome
    }
});