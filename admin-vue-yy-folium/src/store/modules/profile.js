import { api } from './common/global-variable'
import { toastSubmit } from './common/toastr'
import { router } from '../../routes'
import axios from 'axios'

const state = {
    userAbout: {
        name: "",
        gender: "",
        email: "",
        tel: "",
        imageUrl: ""
    }
}
const mutations = {
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
    updateprofile: () => {
        axios.put(api.url+"/users",{
            'sessionObject': {
                'sessionId': window.sessionStorage.getItem("sessionId"),
            },
            'user': {
                'name': state.userAbout.name,
                'gender': state.userAbout.gender,
                'email': state.userAbout.email,
                'tel': state.userAbout.tel,
                'imageUrl': state.userAbout.imageUrl
            }
        })
        .then(() => {
            toastSubmit()
        })
        .catch(function(error) {
            alert(error);
        })
    }
}

const actions = {
    sessionCheck: function() {
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
                mutations.getProfiles()
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