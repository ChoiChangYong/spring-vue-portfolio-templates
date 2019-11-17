import { api } from './common/global-variable'
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

export default {
    namespaced: true,
    state,
    mutations
}