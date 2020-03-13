import axios from 'axios'
import { api, uuid } from './global-variable'

const state = {
    menus: [],
    projects: [],
    imageUrls: []
};

const actions = {
    getUserProjects: () => {
        state.projects = []
        axios.get(api.url+"/anonymous/portfolio-menus/"+7+"/portfolio-projects/"+uuid
        )
        .then((projects) => {
            for (const project of projects.data){
                axios.get(api.url+"/anonymous/portfolio-projects/"+project.id+"/portfolio-images/"+uuid
                )
                .then((images) => {
                    for (var image of images.data){
                        state.imageUrls.push(image.url);
                    }
                    project.imageUrls = state.imageUrls
                    state.projects.push(project);
                    state.imageUrls = []
                    // alert(JSON.stringify(project.name) + JSON.stringify(project.imageUrls))
                })
                .catch(function(error) {
                    alert(error);
                })
            }
        })
        .catch(function(error) {
            alert(error);
        })
    },
    // getUserProjects: () => {
        
    //     axios.get(api.url+"/anonymous/portfolio-menus/"+ uuid
    //     )
    //     .then((menus) => {
    //         for(var menu of menus.data) {
    //             axios.get(api.url+"/anonymous/portfolio-menus/"+menu.id + "/portfolio-projects/" + uuid
    //             )
    //             .then((projects) => {
    //                 for(var project of projects.data) {
    //                     axios.get(api.url+"/anonymous/portfolio-projects/"+project.id+"/portfolio-images/" + uuid
    //                     )
    //                     .then((images) => {
    //                         for (var image of images.data){
    //                             state.imageUrls.push(image.url);
    //                         }
    //                         project.imageUrls = state.imageUrls;
    //                         state.projects.push(project);
    //                         state.imageUrls = []
    //                     })
    //                     .catch(function(error) {
    //                         alert(error);
    //                     })
    //                 }
    //             })
    //             .catch(function(error) {
    //                 alert(error);
    //             })
    //             state.menus.push(menu);
    //         }
    //     })
    //     .catch(function(error) {
    //         alert(error);
    //     })
    // }
};

export default {
    namespaced: true,
    state,
    actions
}