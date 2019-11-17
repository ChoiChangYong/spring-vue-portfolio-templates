import { api } from './common/global-variable'
import { router } from '../../routes'
import axios from 'axios'

const state = {
    contacts: []
}

const mutations = {
    getContacts: () => {
        state.contacts = []
        axios.get(api.url+"/contacts",{
            params: {
                'sessionId': window.sessionStorage.getItem("sessionId")
            }
        })
        .then((getContacts) => {
            for (var contact of getContacts.data){
                state.contacts.push(contact);
            }
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
                mutations.getContacts()
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