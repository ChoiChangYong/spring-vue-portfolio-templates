import { api } from './common/global-variable'
import { router } from '../../routes'
import axios from 'axios'

const state = {
    isActive: false
}

const mutations = {
    TrriggerActive: (state) => {
        state.isActive = !state.isActive
    },
    
    MenuCollaspedActive: (state) => {
        state.isActive = !state.isActive
    }
}

const actions = {
    logout: function() {
        axios.post(api.url+"/logout",
            {
                'sessionId': window.sessionStorage.getItem("sessionId")
            }
        )
        .then(()=>{
            window.sessionStorage.clear()
            router.push('/login')
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