import axios from 'axios';
import { mapState } from "vuex";

const state = {
    host: mapState("store",['host'])
}

const actions = {
    Session: () => {
        axios.get(state.url+"/headers",{
            params: {
                'sessionId': window.sessionStorage.getItem("sessionId")
            }
        })
        .then((response) => {
            alert(JSON.stringify(response.data),null,2);
        })
        .catch(function(error) {
            alert(window.sessionStorage.getItem("sessionId"));
            alert(error);
        })
    }
}

export default {
    namespaced: true,
    state,
    actions
}