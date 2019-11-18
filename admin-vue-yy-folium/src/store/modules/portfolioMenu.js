import { api, Swal } from './common/global-variable'
import { toastSubmit } from './common/toastr'
import axios from 'axios'
import { router } from '../../routes'

const state = {
    menus: []
}

const mutations = {
    addMenu: () => {
        Swal.fire({
            title: "Menu를 입력해주세요.",
            html:
                '<h4>Name</h4>'+
                '<input id="menu-name" class="form-control">',
            inputAttributes: {
                autocapitalize: "off"
            },
            showCancelButton: true,
            confirmButtonText: "저장",
            showLoaderOnConfirm: true,
            preConfirm: function () {
                var name = document.getElementById('menu-name').value
                return axios.post(api.url + "/portfolio-menus", 
                    {
                        'sessionObject': {
                            'sessionId': window.sessionStorage.getItem("sessionId"),
                        },
                        'portfolioMenu': {
                            'name': name,
                        }
                    }
                ).then(function () {
                    mutations.getMenus()
                }).catch(function (t) {
                    Swal.showValidationMessage("Request failed: " + t)
                })
            },
            allowOutsideClick: function () {
                Swal.isLoading()
            }
        })
    },
    getMenus: () => {
        state.menus = []
        axios.get(api.url+"/portfolio-menus",{
            params: {
                'sessionId': window.sessionStorage.getItem("sessionId")
            }
        })
        .then((menus) => {
            for (var menu of menus.data){
                state.menus.push(menu);
            }
        })
        .catch(function(error) {
            alert(error);
        })
    },
    updateMenus: (portfolioMenus) => {

        axios.put(api.url+"/portfolio-menus",
            {
                'sessionObject': {
                    'sessionId': window.sessionStorage.getItem("sessionId"),
                },
                'portfolioMenus': portfolioMenus
            }
        )
        .then(() => {
            toastSubmit()
        })
        .catch(function(error) {
            alert(error);
        })
    },
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
    deleteMenu: async (state, id) => {
        Swal.fire({
            title: '삭제하시겠습니까?',
            text: "삭제할 경우 되돌릴 수 없습니다.",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.value) {
                axios.delete(api.url+"/portfolio-menus/"+id)
                .then(() => {
                    Swal.fire(
                        'Deleted!',
                        'Your file has been deleted.',
                        'success'
                    )
                    mutations.getMenus()
                })
                .catch(function(error) {
                    alert(error);
                })
            }
        })
    }
}

export default {
    namespaced: true,
    state,
    mutations,
    actions
}