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

import VueTypedJs from 'vue-typed-js'

import YYFoliumHome from './modules/user/yy-folium-home'
import YYFoliumAbout from './modules/user/yy-folium-about'
import YYFoliumResume from './modules/user/yy-folium-resume'
import YYFoliumPortfolio from './modules/user/yy-folium-portfolio'
import YYFoliuContact from './modules/user/yy-folium-contact'

Vue.use(Vuex);
Vue.use(VueTypedJs);

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
        contact,

        YYFoliumHome,
        YYFoliumAbout,
        YYFoliumResume,
        YYFoliumPortfolio,
        YYFoliuContact
    },
});