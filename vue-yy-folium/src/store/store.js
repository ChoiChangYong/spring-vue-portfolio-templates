import Vue from 'vue'
import Vuex from 'vuex'

import YYFoliumNav from './modules/yy-folium-nav'

Vue.use(Vuex);

export const store = new Vuex.Store({
    modules: {
        YYFoliumNav
    }
});