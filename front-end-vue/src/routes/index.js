import Vue from 'vue'
import Router from 'vue-router'

import adminRouter from './admin'
import userRouter from './user'

Vue.use(Router)

export const router = new Router({
    mode: 'history',
    routes: [
        ...adminRouter,
        ...userRouter
    ]
})