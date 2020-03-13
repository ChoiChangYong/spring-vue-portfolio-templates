import { api, Swal } from './common/global-variable'
import { toastSubmit } from './common/toastr'
import axios from 'axios'
import { router } from '../../../routes/index'

const state = {
    jobs: [],
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
            cancelButtonText: "취소",
            showLoaderOnConfirm: true,
            preConfirm: function () {
                var name = document.getElementById('job-name').value
                var apiUrl = api.url
                return axios.post(apiUrl + "/jobs", 
                    {
                        'sessionId': window.sessionStorage.getItem("sessionId"),
                        'job': {
                            'name': name,
                        }
                    }
                ).then(function () {
                    mutations.getJobs()
                }).catch(function (t) {
                    Swal.showValidationMessage("Request failed: " + t)
                })
            },
            allowOutsideClick: function () {
                Swal.isLoading()
            }
        })
    },
    getJobs: () => {
        state.jobs = []
        axios.get(api.url+"/jobs",{
            params: {
                "sessionId": window.sessionStorage.getItem("sessionId")
            }
        })
        .then((response) => {
            if(!response.data){
                router.push('/admin/login')
            }
            else {
                for (var job of response.data){
                    state.jobs.push(job);
                }
            }
        })
        .catch(function(error) {
            alert(error);
        })
    },
    updateJobs: (state) => {

        axios.put(api.url+"/jobs", 
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
    //             'sessionId': state.sessionId
    //         }
    //     )
    //     .then( response => {
    //         if(!response.data){
    //             router.push('/login')
    //         }
    //         else {
    //             mutations.getJobs()
    //         }
    //     })
    //     .catch(function(error) { 
    //             alert(error);
    //     })
    // },

    deleteJob: (state, id) => {
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
                axios.delete(api.url+"/jobs/"+id,{
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
                    mutations.getJobs()
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