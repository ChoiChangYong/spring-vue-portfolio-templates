import axios from 'axios';
import { router } from '../../routes'
// const storage = {
//     // 페이지가 렌더링되기 전에 데이터를 넣기위해서 사용
//     fetch() {
        
//     }
// }

const state = {
    user: {
        id: '',
        password: ''
    },
    url: "http://ec2-52-79-241-61.ap-northeast-2.compute.amazonaws.com:8080/api",
    loginCheck: false,
    session: "0",
    loginError: ""
}

const mutations = {
    loginTrue() {
        if(state.session == 0){
        // if(!state.loginCheck) {
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
            // state.loginCheck = response.data;
            state.session = response.data;
            context.commit("loginTrue");
        })
        .catch(function(error) { 
            alert(error);
        })
    },
    SessionCheck: () => {
        axios.post(state.url+"/session-validation",
            {
                'sessionId': window.sessionStorage.getItem("sessionId")
            }
        )
        .then((response) => {
            if(!response.data){
                router.push('/login');
            }
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