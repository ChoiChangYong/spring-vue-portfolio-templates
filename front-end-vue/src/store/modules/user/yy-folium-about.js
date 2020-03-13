import axios from 'axios'
import { api, uuid } from './global-variable'

const state = {
    myAbout: {
        name: "이름을 입력해주세요",
        gender: "성별을 입력해주세요",
        email: "이메일을 입력해주세요",
        tel: "핸드폰 번호를 입력해주세요"
    },
    mySkills: [],
    myJobs: []
};

const getters = {
    getMyAbout() {
        return state.myAbout;
    }
}

const actions = {
    getUserSkills: () => {
        axios.get(api.url+"/anonymous/skills/"+ uuid
        )
        .then((response) => {
            for(var skill of response.data) {
                state.mySkills.push(skill);
            }
        })
        .catch(function(error) {
            alert(error);
        })
    },
    getUserJobs: () => {
        axios.get(api.url+"/anonymous/jobs/"+ uuid
        )
        .then((response) => {
            for(var job of response.data) {
                state.myJobs.push(job);
            }
        })
        .catch(function(error) {
            alert(error);
        })
    },
};

export default {
    namespaced: true,
    state,
    getters,
    actions
}