import axios from 'axios'
import { api, uuid } from './global-variable'

const state = {
    menus: [],
    projects: [],
    imageUrls: []
};

const actions = {
    getUserProjects: () => {
        axios.get(api.url+"/anonymous/portfolio-menus/"+ uuid
        )
        .then((response) => {
            for(var menu of response.data) {
                axios.get(api.url+"/anonymous/portfolio-menus/"+menu.id + "/portfolio-projects/" + uuid
                )
                .then((response) => {
                    for(var project of response.data) {
                        axios.get(api.url+"/anonymous/portfolio-projects/"+project.id+"/portfolio-images/" + uuid
                        )
                        .then((images) => {
                            for (var image of images.data){
                                state.imageUrls.push(image.url);
                            }
                            project.imageUrls = state.imageUrls
                            state.projects.push(project);
                            state.imageUrls = []
                        })
                        .catch(function(error) {
                            alert(error);
                        })
                    }
                })
                .catch(function(error) {
                    alert(error);
                })
                state.menus.push(menu);
            }
        })
        .catch(function(error) {
            alert(error);
        })
    }
};

export default {
    namespaced: true,
    state,
    actions
}