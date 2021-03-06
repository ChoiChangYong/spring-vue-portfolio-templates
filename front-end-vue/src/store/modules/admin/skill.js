import { api, Swal } from './common/global-variable'
import { toastSubmit } from './common/toastr'
import axios from 'axios'
import { router } from '../../../routes/index'

const state = {
    skills: [],
    sessionId: window.sessionStorage.getItem("sessionId")
}

const mutations = {
    addSkill: () => {
        Swal.fire({
            title: "Skill을 입력해주세요.",
            html:
                '<h4>Name</h4>'+
                '<input id="skill-name" class="form-control">' +
                '<h4 class="mb-4">Level</h4>'+
                ' <select id="skill-level" class="form-control">'+
                    '<option value="2">20%</option>'+'<option value="4">40%</option>'+'<option value="6">60%</option>'+'<option value="8">80%</option>'+'<option value="10">100%</option>'+
                '</select>',
            inputAttributes: {
                autocapitalize: "off"
            },
            showCancelButton: true,
            confirmButtonText: "저장",
            cancelButtonText: "취소",
            showLoaderOnConfirm: true,
            preConfirm: function () {
                var name = document.getElementById('skill-name').value
                var level = document.getElementById("skill-level").value
                var apiUrl = api.url
                return axios.post(apiUrl + "/skills", 
                    {
                        'sessionId': window.sessionStorage.getItem("sessionId"),
                        'skill': {
                            'name': name,
                            'level': level
                        }
                    }
                ).then(function () {
                    mutations.getSkills()
                }).catch(function (t) {
                    Swal.showValidationMessage("Request failed: " + t)
                })
            },
            allowOutsideClick: function () {
                Swal.isLoading()
            }
        })
    },
    getSkills: () => {
        state.skills = []
        axios.get(api.url+"/skills",{
            params: {
                'sessionId': window.sessionStorage.getItem("sessionId")
            }
        })
        .then((response) => {
            if(!response.data){
                router.push('/admin/login')
            } else {
                for (var skill of response.data){
                    state.skills.push(skill);
                }
            }
        })
        .catch(function(error) {
            alert(error);
        })
    },
    updateSkills: (state) => {
        axios.put(api.url+"/skills",
            state
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
    // sessionCheck: function() {
    //     axios.post(api.url+"/session-validation",
    //         {
    //             'sessionId': window.sessionStorage.getItem("sessionId")
    //         }
    //     )
    //     .then( response => {
    //         if(!response.data){
    //             router.push('/login')
    //         }
    //         else {
    //             mutations.getSkills()
    //         }
    //     })
    //     .catch(function(error) { 
    //             alert(error);
    //     })
    // },
    deleteSkill: async (state, id) => {
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
                axios.delete(api.url+"/skills/"+id,{
                    data: {
                        "sessionId": window.sessionStorage.getItem("sessionId")
                    }
                })
                .then(() => {
                    Swal.fire(
                        'Deleted!',
                        'Your file has been deleted.',
                        'success'
                    )
                    mutations.getSkills()
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