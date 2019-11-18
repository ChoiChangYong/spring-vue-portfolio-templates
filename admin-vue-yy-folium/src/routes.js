import Vue from 'vue'
import VueRouter from 'vue-router'

import Login from './components/Login'
import AdminYYFoliumApp from './components/AdminYYFoliumApp'
import Home from './components/Home'
import AboutProfile from './components/AboutProfile'
import AboutJob from './components/AboutJob';
import AboutSkill from './components/AboutSkill'
import ResumeWork from './components/ResumeWork'
import ResumeEducation from './components/ResumeEducation'
import PortfolioMenu from './components/PortfolioMenu'
import PortfolioProject from './components/PortfolioProject'
import Contact from './components/Contact'
import PageNotFound from './components/common/404NotFound'

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
            redirect: '/home'
        },
        {
            path: '/', 
            component: AdminYYFoliumApp,
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
                    path: '/about/skill',
                    component: AboutSkill
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
                    path: '/portfolio/project',
                    component: PortfolioProject
                },
                {
                    path: '/contact',
                    component: Contact
                }
            ],
        },
        {
            path: "*",
            component: PageNotFound 
        }
    ],
})