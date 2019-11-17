import { api, Swal } from './common/global-variable'
// import { Swal } from './common/global-variable'
import axios from 'axios'

const state = {
    skills: []
}

const mutations = {
    addJob: () => {
        Swal.fire({
            title: "직업을 입력해주세요.",
            html:
                '<h4>Name</h4>'+
                '<input id="skill-name" class="form-control">',
            inputAttributes: {
                autocapitalize: "off"
            },
            showCancelButton: true,
            confirmButtonText: "저장",
            showLoaderOnConfirm: true,
            preConfirm: function () {
                var name = document.getElementById('skill-name').value
                var apiUrl = api.url
                return axios.post(apiUrl + "/jobs", 
                    {
                        'sessionObject': {
                            'sessionId': window.sessionStorage.getItem("sessionId"),
                        },
                        'job': {
                            'name': name,
                        }
                    }
                ).then(function (response) {
                    alert(JSON.stringify(response.data))
                }).catch(function (t) {
                    Swal.showValidationMessage("Request failed: " + t)
                })
            },
            allowOutsideClick: function () {
                Swal.isLoading()
            }
        })
    },
    getSkill: () => {
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
    updateSkill: (skill) => {
        alert(JSON.stringify(skill))
        axios.put(api.url+"/skills",
            skill
        )
        .then((response) => {
            alert(response)
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