import Vue from 'vue'
import VueRouter from 'vue-router'

import Login from './components/Login'
import AdminYYFoliumApp from './components/common/AdminYYFoliumApp'
import Home from './components/Home'
import AboutProfile from './components/AboutProfile'
import AboutJob from './components/AboutJob';
import AboutSkill from './components/AboutSkill'
import ResumeWork from './components/ResumeWork'
import ResumeEducation from './components/ResumeEducation'
import PortfolioMenu from './components/PortfolioMenu'
import PortfolioProject from './components/common/PortfolioProject'
import PortfolioProjectView from './components/PortfolioProjectView'
import PortfolioProjectAdd from './components/PortfolioProjectAdd'
import PortfolioProjectEdit from './components/PortfolioProjectEdit'
import PortfolioProjectImage from './components/PortfolioProjectImage'
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
                    component: PortfolioProject,
                    children: [
                        {
                            name: 'view',
                            path: '/portfolio/project/view',
                            component: PortfolioProjectView,
                            prop: true
                        },
                        {
                            name: 'add',
                            path: '/portfolio/project/add',
                            component: PortfolioProjectAdd,
                            prop: true
                        },
                        {
                            name: 'edit',
                            path: '/portfolio/project/edit/:projectId/:menuId',
                            component: PortfolioProjectEdit,
                            prop: true
                        },
                        {
                            name: 'image',
                            path: '/portfolio/project/image/:id',
                            component: PortfolioProjectImage,
                            prop: true
                        },
                    ]
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