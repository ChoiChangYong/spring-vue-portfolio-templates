import axios from 'axios'
import { api, uuid } from './global-variable'

const state = {
    homes: {
        title: "",
        intro: "제목을 입력해주세요",
        subIntro: "부제목을 입력해주세요",
        backgroundImageFlag: "",
    }
};

const getters = {
    getHomes() {
        return state.homes;
    }
};


const actions = {
    getUserHeader: () => {
        axios.get(api.url+"/anonymous/headers/"+ uuid
        )
        .then((response) => {
            for(var header of response.data) {
                state.homes.title = header.title;
                state.homes.intro = header.intro;
                state.homes.subIntro = header.subIntro;
                state.homes.backgroundImageFlag = header.backgroundImageFlag;
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