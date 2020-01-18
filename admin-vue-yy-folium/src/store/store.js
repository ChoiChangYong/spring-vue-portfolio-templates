import Vue from 'vue'
import Vuex from 'vuex'

import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

Vue.use(VueSweetalert2);

import nav from './modules/admin/nav'
import login from './modules/admin/login'
import home from './modules/admin/home'
import profile from './modules/admin/profile'
import skill from './modules/admin/skill'
import job from './modules/admin/job'
import work from './modules/admin/work'
import education from './modules/admin/education'
import menu from './modules/admin/portfolioMenu'
import project from './modules/admin/portfolioProject'
import contact from './modules/admin/contact'

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