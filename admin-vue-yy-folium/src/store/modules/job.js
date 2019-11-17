import { api, Swal } from './common/global-variable'
import { toastSubmit } from './common/toastr'
import axios from 'axios'

const state = {
    jobs: []
}

const mutations = {
    addJob: () => {
        Swal.fire({
            title: "직업을 입력해주세요.",
            html:
                '<h4>Name</h4>'+
                '<input id="job-name" class="form-control">',
            inputAttributes: {
                autocapitalize: "off"
            },
            showCancelButton: true,
            confirmButtonText: "저장",
            showLoaderOnConfirm: true,
            preConfirm: function () {
                var name = document.getElementById('job-name').value
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
                ).then(function (job) {
                    state.skills.jobs(job.data)
                }).catch(function (t) {
                    Swal.showValidationMessage("Request failed: " + t)
                })
            },
            allowOutsideClick: function () {
                Swal.isLoading()
            }
        })
    },
    getJob: () => {
        state.jobs = []
        axios.get(api.url+"/jobs",{
            params: {
                'sessionId': window.sessionStorage.getItem("sessionId")
            }
        })
        .then((jobs) => {
            for (var job of jobs.data){
                state.jobs.push(job);
            }
        })
        .catch(function(error) {
            alert(error);
        })
    },
    updateJob: (jobs) => {
        axios.put(api.url+"/jobs",
            jobs
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