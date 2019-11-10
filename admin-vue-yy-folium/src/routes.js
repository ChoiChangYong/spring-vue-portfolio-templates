import Vue from 'vue'
import VueRouter from 'vue-router'

import AdminYYFoliumLogin from './components/AdminYYFoliumLogin'
import AdminYYFoliumHome from './components/AdminYYFoliumHome'
import AdminYYFoliumAbout from './components/AdminYYFoliumAbout'

Vue.use(VueRouter)

export const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/login',
            component: AdminYYFoliumLogin
        },
        {
            path: '/home',
            component: AdminYYFoliumHome
        },  
        {
            path: '/about',
            component: AdminYYFoliumAbout
        },
    ]
})