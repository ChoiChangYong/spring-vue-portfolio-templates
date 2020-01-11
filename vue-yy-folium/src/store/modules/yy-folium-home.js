import axios from 'axios'
import { api } from './global-variable'

const state = {
    homeItems: {
        id: "",
        backgroundImageFlag: "1",
        title: "Insert Title",
        intro: "Insert Intro",
        subIntro: "Insert SubIntro",
    },
    userAbout: {
        name: "Input Name",
        gender: "Input Gender",
        email: "Input Email",
        tel: "Input Tel",
        imageUrl: ""
    },
    jobs: []
}

const mutations = {
    setHomeItems: (state, homeItems) => {
        for(var homeItem of homeItems) {
            state.homeItems.id = homeItem.id
            state.homeItems.backgroundImageFlag = homeItem.backgroundImageFlag
            state.homeItems.title = homeItem.title
            state.homeItems.intro = homeItem.intro
            state.homeItems.subIntro = homeItem.subIntro
        }
    },
}

const actions = {
    sessionCheck: function() {
        axios.post(api.url+"/welcome-user",
            {
                'sessionId': window.sessionStorage.getItem("sessionId")
            }
        )
        .then( (response) => {
            window.sessionStorage.setItem("sessionId",response.data)
        })
        .catch(function(error) { 
                alert(error);
        })
    },
    getHomes: () => {
        axios.get(api.url+"/headers",{
            params: {
                'sessionId': window.sessionStorage.getItem("sessionId")
            }
        })
        .then((response) => {
            mutations.setHomeItems(state, response.data)
        })
        .catch(function(error) {
            alert(error);
        })
    },
    getProfiles: () => {
        axios.get(api.url+"/user",{
            params: {
                'sessionId': window.sessionStorage.getItem("sessionId"),
            }
        })
        .then((profiles) => {
            state.userAbout.name = profiles.data.name
            state.userAbout.gender = profiles.data.gender
            state.userAbout.email = profiles.data.email
            state.userAbout.tel = profiles.data.tel
            state.userAbout.imageUrl = profiles.data.imageUrl
        })
        .catch(function(error) {
            alert(error);
        })
    },
    getJobs: () => {
        state.jobs = []
        axios.get(api.url+"/jobs",{
            params: {
                'sessionId': window.sessionStorage.getItem("sessionId")
            }
        })
        .then((jobs) => {
            for (var job of jobs.data){
                state.jobs.push(job);
            }
        })
        .catch(function(error) {
            alert(error);
        })
    },
}

export default {
    namespaced: true,
    state,
    mutations,
    actions
}