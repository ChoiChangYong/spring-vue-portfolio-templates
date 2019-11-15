import Vue from 'vue'
import VueRouter from 'vue-router'

import Login from './components/Login'
import AdminYYFoliumApp from './components/AdminYYFoliumApp'
import Home from './components/Home'
import AboutProfile from './components/AboutProfile'
import AboutJob from './components/AboutJob';
import ResumeWork from './components/ResumeWork'
import ResumeEducation from './components/ResumeEducation'
import PortfolioMenu from './components/PortfolioMenu'
import Contact from './components/Contact'

Vue.use(VueRouter)

export const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/login',
            component: Login
        },
        {
            path: '/',
            component: AdminYYFoliumApp
        },
        { path: '/', component: AdminYYFoliumApp,
            children: [
                {
                    path: '/home',
                    component: Home
                },
                {
                    path: '/about/profile',
                    component: AboutProfile
                },
                {
                    path: '/about/job',
                    component: AboutJob
                },
                { 
                    path: '/resume/work', 
                    component: ResumeWork
                },
                {
                    path: '/resume/education',
                    component: ResumeEducation
                },
                {
                    path: '/portfolio/menu',
                    component: PortfolioMenu
                },
                {
                    path: '/contact',
                    component: Contact
                }
            ],
            
        }
    ],
})