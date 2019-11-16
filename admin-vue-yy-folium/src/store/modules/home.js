import axios from 'axios'
import { api } from './api'
import { router } from '../../routes'

const state = {
    homeItems: {
        id: "",
        backgroundImageFlag: "",
        title: "",
        intro: "",
        subIntro: ""
    }
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
    }
}

const actions = {
    SessionCheck: () => {
        axios.post(api.url+"/session-validation",
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
    },  
    HomeAction: (context) => {
        axios.get(api.url+"/headers",{
            params: {
                'sessionId': window.sessionStorage.getItem("sessionId")
            }
        })
        .then((response) => {
            context.commit("setHomeItems", response.data)
        })
        .catch(function(error) {
            alert(error);
        })
    },
    SubmitApi: () => {
        axios.put(api.url+"/headers",{
            'id': state.homeItems.id,
            'backgroundImageFlag': state.homeItems.backgroundImageFlag,
            'title': state.homeItems.title,
            'intro': state.homeItems.intro,
            'subIntro': state.homeItems.subIntro
        })
        .then((response) => {
            alert(response)
            // context.commit("toastSubmit")
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


// [
//     {
//         "id":1,
//         "user":
//         {
//             "uuid":"3f03c82e36bc492aaa414c4d613e494b",
//             "id":"yong",
//             "password":"{bcrypt}$2a$10$aw0cMaeuJa58uI2h3JFc5u7MgNW5hA2tzaJzKilwMtmKhajmXW4Re",
//             "name":"최창용",
//             "gender":1,
//             "email":"yong@naver.com",
//             "tel":"01011112222",
//             "imageUrl":"",
//             "created":1573363287000,"updated":1573363287000
//         },
//         "title":"yong's folium",
//         "intro":"I am Chang-yong Choi",
//         "subIntro":"If you don't move forward, there's nowhere to look back.",
//         "backgroundImageFlag":1,
//         "created":1573503580000,
//         "updated":1573503599000
//     },
// ]