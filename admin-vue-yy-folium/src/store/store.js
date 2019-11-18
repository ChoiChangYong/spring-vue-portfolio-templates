import Vue from 'vue'
import Vuex from 'vuex'

import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

Vue.use(VueSweetalert2);

import nav from './modules/nav'
import login from './modules/login'
import home from './modules/home'
import profile from './modules/profile'
import skill from './modules/skill'
import job from './modules/job'
import work from './modules/work'
import education from './modules/education'
import menu from './modules/portfolioMenu'
import project from './modules/portfolioProject'
import contact from './modules/contact'

Vue.use(Vuex);

export const store = new Vuex.Store({
    modules: {
        nav,
        login,
        home,
        profile,
        job,
        skill,
        work,
        education,
        menu,
        project,
        contact
    },
});