import axios from 'axios'
import { api, uuid } from './global-variable'

const state = {
    myResume: []
};

const actions = {
    getUserResume: () => {
        axios.get(api.url+"/anonymous/resumes/"+ uuid
        )
        .then((response) => {
            for(var resume of response.data) {
                var startDate = new Date(resume.startDate);
                resume.startDate = startDate.getFullYear()+"."+(startDate.getMonth()+1)+"."+startDate.getDate();

                var endDate = new Date(resume.endDate);
                resume.endDate = endDate.getFullYear()+"."+(endDate.getMonth()+1)+"."+endDate.getDate();
                
                state.myResume.push(resume);
            }
        })
        .catch(function(error) {
            alert(error);
        })
    },
};

export default {
    namespaced: true,
    state,
    actions
}