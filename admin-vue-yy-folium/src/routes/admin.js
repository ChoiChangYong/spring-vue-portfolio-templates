import Vue from 'vue'
import VueRouter from 'vue-router'

import Login from '../components/admin/Login'
import AdminYYFoliumApp from '../components/admin/common/AdminYYFoliumApp'
import Home from '../components/admin/Home'
import AboutProfile from '../components/admin/AboutProfile'
import AboutJob from '../components/admin/AboutJob';
import AboutSkill from '../components/admin/AboutSkill'
import ResumeWork from '../components/admin/ResumeWork'
import ResumeEducation from '../components/admin/ResumeEducation'
import PortfolioMenu from '../components/admin/PortfolioMenu'
import PortfolioProject from '../components/admin/common/PortfolioProject'
import PortfolioProjectView from '../components/admin/PortfolioProjectView'
import PortfolioProjectAdd from '../components/admin/PortfolioProjectAdd'
import PortfolioProjectEdit from '../components/admin/PortfolioProjectEdit'
import PortfolioProjectImage from '../components/admin/PortfolioProjectImage'
import Contact from '../components/admin/Contact'
import PageNotFound from '../components/admin/common/404NotFound'

Vue.use(VueRouter)

export const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/admin/login',
            component: Login
        },
        {
            path: '/',
            redirect: '/admin/home'
        },
        {
            path: '/admin', 
            component: AdminYYFoliumApp,
            children: [
                {
                    path: '/admin/home',
                    component: Home
                },
                {
                    path: '/admin/about/profile',
                    component: AboutProfile
                },
                {
                    path: '/admin/about/job',
                    component: AboutJob
                },
                {
                    path: '/admin/about/skill',
                    component: AboutSkill
                },
                { 
                    path: '/admin/resume/work', 
                    component: ResumeWork
                },
                {
                    path: '/admin/resume/education',
                    component: ResumeEducation
                },
                {
                    path: '/admin/portfolio/menu',
                    component: PortfolioMenu
                },
                {
                    path: '/admin/portfolio/project',
                    component: PortfolioProject,
                    children: [
                        {
                            name: 'view',
                            path: '/admin/portfolio/project/view',
                            component: PortfolioProjectView,
                            prop: true
                        },
                        {
                            name: 'add',
                            path: '/admin/portfolio/project/add',
                            component: PortfolioProjectAdd,
                            prop: true
                        },
                        {
                            name: 'edit',
                            path: '/admin/portfolio/project/edit/:projectId/:menuId',
                            component: PortfolioProjectEdit,
                            prop: true
                        },
                        {
                            name: 'image',
                            path: '/admin/portfolio/project/image/:id',
                            component: PortfolioProjectImage,
                            prop: true
                        },
                    ]
                },
                {
                    path: '/admin/contact',
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