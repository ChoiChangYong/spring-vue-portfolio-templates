import { api, Swal } from './common/global-variable'
// import { Swal } from './common/global-variable'
import axios from 'axios'

const state = {
    skill: {
        id: "",
        name: "",
        level: ""
    },
    skills: []
}

const mutations = {
    addSkill: () => {
        Swal.fire({
            title: "Skill을 입력해주세요.",
            html:
                '<h4>Name</h4>'+
                '<input id="skill-name" class="swal2-input">' +
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
                // alert(t + ", name : " + name + "level : " + level)
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
                ).then(function (response) {
                    alert(JSON.stringify(response.data))
                    // return response.json()
                }).catch(function (t) {
                    Swal.showValidationMessage("Request failed: " + t)
                })
            },
            allowOutsideClick: function () {
                Swal.isLoading()
            }
        })
    }
}

export default {
    namespaced: true,
    state,
    mutations
}