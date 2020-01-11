import axios from 'axios'
import { api } from './common/global-variable'
import { toastSubmit } from './common/toastr'
import { router } from '../../routes'

const state = {
    homeItems: {
        id: "",
        backgroundImageFlag: "",
        title: "",
        intro: "",
        subIntro: "",
    },
    sessionFlag: false
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
    // setUpdateHomeItems: (state, payload) => {} 
}

const actions = {
    sessionCheck: function(context) {
        axios.post(api.url+"/session-validation",
            {
                'sessionId': window.sessionStorage.getItem("sessionId")
            }
        )
        .then( response => {
            
            if(!response.data){
                router.push('/login')
            }
            else {
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
            }
        })
        .catch(function(error) { 
                alert(error);
        })
    },
    updateHomeItems: () => {
        axios.put(api.url+"/headers",{
            'id': state.homeItems.id,
            'backgroundImageFlag': state.homeItems.backgroundImageFlag,
            'title': state.homeItems.title,
            'intro': state.homeItems.intro,
            'subIntro': state.homeItems.subIntro
        })
        .then(() => {
            toastSubmit()
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