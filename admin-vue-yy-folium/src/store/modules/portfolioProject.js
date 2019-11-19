import { api, Swal } from './common/global-variable'
import { router } from '../../routes'
import axios from 'axios'

const state = {
    projects: [],
    newProjects: {
        name: "",
        belong: "",
        description: "",
    },
    newProject: {
        id: ""
    },
    menus: [],
    selectedMenuId: {
        id: ""
    },
    imageUrls: [],
}

const mutations = {
    submitProject: (state, menu_id) => {
        const portfolioProject = state.newProjects
        axios.post(api.url+"/portfolio-menus/"+menu_id+"/portfolio-projects",{
                'sessionObject': {
                    'sessionId': window.sessionStorage.getItem("sessionId"),
                },
                portfolioProject
        })
        .then((response) => {
            state.newProject.id = response.data.id
            mutations.submitSwal()
        })
        .catch(function(error) {
            alert(error);
        })
    },
    getMenus: () => {
        axios.get(api.url+"/portfolio-menus",{
            params: {
                'sessionId': window.sessionStorage.getItem("sessionId")
            }
        })
        .then((portfolioMenus) => {
            if(portfolioMenus.data.length==0){
                Swal.fire({
                    type: 'info',
                    text: '메뉴를 먼저 등록해주세요!',
                    preConfirm: function () {
                        router.push('/portfolio/menu')
                    },
                })
            } else {
                state.menus=[]
                for (var portfolioMenu of portfolioMenus.data){
                    state.menus.push(portfolioMenu)
                    mutations.getProjects(portfolioMenu.id)
                }
            }
        })
        .catch(function(error) {
            alert(error);
        })
    },
    getProjects: (menuId) => {
        state.projects = []
        axios.get(api.url+"/portfolio-menus/"+menuId+"/portfolio-projects",{
            params: {
                'sessionId': window.sessionStorage.getItem("sessionId")
            }
        })
        .then((projects) => {
            for (const project of projects.data){
                axios.get(api.url+"/portfolio-projects/"+project.id+"/portfolio-images",{
                    params: {
                        'sessionId': window.sessionStorage.getItem("sessionId")
                    }
                })
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
    // getImageUrl: (projectId) => {
    // }
    submitSwal: () => {
        Swal.fire({
            type: 'success',
            footer: '프로젝트가 저장되었습니다.',
            text: '이미지를 등록하시겠습니까?',
            inputAttributes: {
                autocapitalize: "off"
            },
            showCancelButton: true,
            confirmButtonText: "Yes",
            cancelButtonText: 'No',
            showLoaderOnConfirm: true,
            allowOutsideClick: function () {
                Swal.isLoading()
            }
        }).then((result) => {
            if (result.value) {
                const id = state.newProject.id
                router.push({ name: 'image', params: { id: id }})
            } else {
                router.push({ path: '/portfolio/project/view'})
            }
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
                mutations.getMenus()
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