import Vue from 'vue'
import VueRouter from 'vue-router'

import AdminYYFoliumLogin from './components/AdminYYFoliumLogin'
import AdminYYFoliumApp from './components/AdminYYFoliumApp'
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
            path: '/',
            component: AdminYYFoliumApp
        },
        { path: '/', component: AdminYYFoliumApp,
            children: [
                {
                    path: '/home',
                    component: AdminYYFoliumHome
                },
                {
                    path: '/about',
                    component: AdminYYFoliumAbout
                },
            ]
        }
    ],
})