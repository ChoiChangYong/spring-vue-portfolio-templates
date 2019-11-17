import { api, Swal } from './common/global-variable'
import { toastSubmit } from './common/toastr'
import axios from 'axios'

const state = {
    skills: []
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
            showLoaderOnConfirm: true,
            preConfirm: function () {
                var name = document.getElementById('skill-name').value
                var level = document.getElementById("skill-level").value
                var apiUrl = api.url
                return axios.post(apiUrl + "/skills", 
                    {
                        'sessionObject': {
                            'sessionId': window.sessionStorage.getItem("sessionId"),
                        },
                        'skill': {
                            'name': name,
                            'level': level
                        }
                    }
                ).then(function (skill) {
                    state.skills.push(skill.data)
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
        .then((skills) => {
            for (var skill of skills.data){
                state.skills.push(skill);
            }
        })
        .catch(function(error) {
            alert(error);
        })
    },
    updateSkills: (skill) => {
        axios.put(api.url+"/skills",
            skill
        )
        .then(() => {
            toastSubmit()
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