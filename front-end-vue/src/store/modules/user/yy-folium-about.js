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
            for(var data of response.data) {
                var level = Number(data.level);
                data.level = level * 10;
                state.mySkills.push(data);
                state.myAbout.name = data.user.name;
                state.myAbout.email = data.user.email;
                state.myAbout.tel = data.user.tel;
                if(data.user.gender == "1"){
                    state.myAbout.gender = "남자";
                } else if(data.user.gender == "2"){
                    state.myAbout.gender = "여자";
                }
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