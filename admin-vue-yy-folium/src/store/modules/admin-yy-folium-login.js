import axios from 'axios';
import { router } from '../../routes'

const state = {
    user: {
        id: '',
        password: ''
    },
    url: 'http://ec2-52-79-241-61.ap-northeast-2.compute.amazonaws.com:8080/api',
    session: "0",
    loginError: ""
}

const mutations = {
    loginTrue() {
        if(state.session == 0){
            state.loginError = "아이디 또는 비밀번호가 일치하지 않습니다."
        } else {
            window.sessionStorage.setItem("sessionId",state.session)
            router.push('/home');
        }
    }
}

const actions = {
    loginAction: async (context) => {
        const loginApi = state.url + "/login"
        await axios.post(loginApi, {
            'id': state.user.id,
            'password': state.user.password
        })
        .then((response) => {
            state.session = response.data;
            context.commit("loginTrue");
        })
        .catch(function(error) { 
            alert(error);
        })
    }
}

export default {
    namespaced: true,
    state,
    mutations,
    actions
}