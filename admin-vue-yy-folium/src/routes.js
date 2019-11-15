import Vue from 'vue'
import VueRouter from 'vue-router'

import AdminYYFoliumLogin from './components/AdminYYFoliumLogin'
import AdminYYFoliumApp from './components/AdminYYFoliumApp'
import AdminYYFoliumHome from './components/AdminYYFoliumHome'
import AdminYYFoliumAboutProfile from './components/AdminYYFoliumAboutProfile'
import AdminYYFoliumAboutJob from './components/AdminYYFoliumAboutJob';
import AdminYYFoliumResumeWork from './components/AdminYYFoliumResumeWork'

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
                    path: '/about/profile',
                    component: AdminYYFoliumAboutProfile
                },
                {
                    path: '/about/job',
                    component: AdminYYFoliumAboutJob
                },
                { 
                    path: '/resume/work', 
                    component: AdminYYFoliumResumeWork
                },
                {
                    path: '/resume/education',
                    // component: AdminYYFoliumResume
                }
            ],
            
        }
    ],
})