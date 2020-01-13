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
    // sessionCheck: function(context) {
    //     axios.post(api.url+"/session-validation",
    //         {
    //             'sessionId': window.sessionStorage.getItem("sessionId")
    //         },
    //         {
    //             withCredentials: true,
    //         }
    //     )
    //     .then( response => {
            
    //         if(!response.data){
    //             router.push('/login')
    //         }
    //         else {
                
    //         }
    //     })
    //     .catch(function(error) {
    //             alert(error);
    //             // router.push('/login')
    //     })
    // },
    getHeader: () => {
        axios.get(api.url+"/headers",{
            params: {
                'sessionId': window.sessionStorage.getItem("sessionId")
            }
        })
        .then((response, context) => {
            if(!response.data){
                router.push('/login')
            } else {
                context.commit("setHomeItems", response.data)
            }
        })
        .catch(function(error) {
            router.push('/login')
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