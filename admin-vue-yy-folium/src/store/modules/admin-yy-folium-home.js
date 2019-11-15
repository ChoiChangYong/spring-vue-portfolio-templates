import axios from 'axios';

const state = {
    inputValue: {
        tilte:"Input Title",
        intro: "Input Intro",
        subIntro: "Input SubIntro",
        job: ["Input Job"],
    },
    url: "http://ec2-52-79-241-61.ap-northeast-2.compute.amazonaws.com:8080/api",
};

const getters = {
    setInputValue(state) {
        return state.name;
    },
};

const actions = {
    HomeSession: () => {
        axios.get(state.url+"/headers",{
            params: {
                'sessionId': window.sessionStorage.getItem("sessionId")
            }
        })
        .then((response) => {
            alert(JSON.stringify(response.data),null,2);
        })
        .catch(function(error) {
            alert(window.sessionStorage.getItem("sessionId"));
            alert(error);
        })
    }
}


export default {
    // storage,
    state,
    getters,
    actions
}