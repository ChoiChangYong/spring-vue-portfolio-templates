import Vue from 'vue'
import Vuex from 'vuex'

import nav from './modules/nav'
import login from './modules/login'
import home from './modules/home'
import contact from './modules/contact'

Vue.use(Vuex);

export const store = new Vuex.Store({
    modules: {
        nav,
        login,
        home,
        contact
    },
});