import axios from 'axios'
import { api } from './api'

const state = {
    tilte:"Input Title",
    intro: "Input Intro",
    subIntro: "Input SubIntro",
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
    }
}

export default {
    namespaced: true,
    state,
    actions
}