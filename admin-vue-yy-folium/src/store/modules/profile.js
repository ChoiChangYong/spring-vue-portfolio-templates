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
    },
    dropzoneOptions: {
        url: api.url+"/users/image-upload",
        thumbnailWidth: 150,
        maxFilesize: 128,
        addRemoveLinks: true,
        maxFiles: 1,
        uploadMultiple: false,
        method: 'post',
        acceptedFiles: ".jpeg,.jpg,.png,.gif,.JPEG,.JPG,.PNG,.GIF",
        // headers: { "My-Awesome-Header": "header value" },
        params: {'sessionId': window.sessionStorage.getItem("sessionId")},
    }
}
const mutations = {
    getProfiles: () => {
        axios.get(api.url+"/user",{
            params: {
                'sessionId': window.sessionStorage.getItem("sessionId"),
            }
        })
        .then((response) => {
            if(!response.data){
                router.push('/login')
            } else {
                state.userAbout.name = response.data.name
                state.userAbout.gender = response.data.gender
                state.userAbout.email = response.data.email
                state.userAbout.tel = response.data.tel
                state.userAbout.imageUrl = response.data.imageUrl
            }
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