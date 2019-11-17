import Vue from 'vue'
import Vuex from 'vuex'

import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

Vue.use(VueSweetalert2);

import nav from './modules/nav'
import login from './modules/login'
import home from './modules/home'
import skill from './modules/skill'
import job from './modules/job'
import contact from './modules/contact'

Vue.use(Vuex);

export const store = new Vuex.Store({
    modules: {
        nav,
        login,
        home,
        skill,
        job,
        contact
    },
});