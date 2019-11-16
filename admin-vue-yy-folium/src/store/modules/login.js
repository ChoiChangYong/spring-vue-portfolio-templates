import axios from 'axios'
import { api } from './api'
import { router } from '../../routes'

const state = {
    user: {
        id: '',
        password: ''
    },
    login: {
        session: "0",
        error: ""
    }
}


const mutations = {
    loginTrue: (state) => {
        if(state.login.session == 0){
            state.login.error = "아이디 또는 비밀번호가 일치하지 않습니다."
        } else {
            state.login.session = window.sessionStorage.setItem("sessionId", state.login.session)
            router.push('/home');
        }
    }
}

const actions = {
    loginAction: async (context) => {
        await axios.post(api.url+"/login", {
            'id': state.user.id,
            'password': state.user.password
        })
        .then((response) => {
            state.login.session = response.data
            context.commit("loginTrue")
        })
        .catch(function() { 
            state.login.error = "서비스 준비 중입니다."
        })
    }
}

export default {
    namespaced: true,
    state,
    mutations,
    actions
}