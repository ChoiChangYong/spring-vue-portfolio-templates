import { api, Swal } from './common/global-variable'
import { router } from '../../routes'
import axios from 'axios'

const state = {
    educations: []
}

const mutations = {
    addEducation: () => {
        Swal.fire({
            title: "경력을 입력해주세요.",
            html:
                '<div>'+
                    '<h5>시작일자</h5>'+
                    '<div data-label="Example" class="mt-example demo-forms">'+
                        '<input id="education-start-date" type="date" class="form-control mb-15" placeholder="YYYY/MM/DD">'+
                    '</div>'+
                    '<h5>종료일자</h5>'+
                    '<div data-label="Example" class="mt-example demo-forms">'+
                        '<input id="education-end-date" type="date" class="form-control mb-15" placeholder="YYYY/MM/DD">'+
                    '</div>'+
                '</div>'+
                '<h5 class="mt-3">학과명</h5>'+
                '<input id="education-job" class="form-control">'+
                '<h5 class="mt-3">학교명</h5>'+
                '<input id="education-company" class="form-control">'+
                '<h5 class="mt-3">추가설명</h5>'+
                '<textarea id="education-description" class="form-control">',
            inputAttributes: {
                autocapitalize: "off"
            },
            showCancelButton: true,
            confirmButtonText: "저장",
            cancelButtonText: "취소",
            showLoaderOnConfirm: true,
            preConfirm: function () {
                var startDate = document.getElementById('education-start-date').value
                var endDate = document.getElementById('education-end-date').value
                var company = document.getElementById('education-company').value
                var job = document.getElementById('education-job').value
                var description = document.getElementById('education-description').value
                return axios.post(api.url + "/resumes", 
                    {
                        'sessionId': window.sessionStorage.getItem("sessionId"),
                        'resume': {
                            job,
                            company,
                            description,
                            startDate,
                            endDate,
                            'historyFlag': "1"
                        }
                    }
                ).then(function () {
                    mutations.getEducations()
                }).catch(function (t) {
                    Swal.showValidationMessage("Request failed: " + t)
                })
            },
            allowOutsideClick: function () {
                Swal.isLoading()
            }
        })
    },
    getEducations: () => {
        state.educations = []
        axios.get(api.url+"/resumes",{
            params: {
                'sessionId': window.sessionStorage.getItem("sessionId"),
                'historyFlag': "1"
            }
        })
        .then((response) => {
            if(!response.data){
                router.push('/login')
            } else{
                for (var education of response.data){
                    var startDate = new Date(education.startDate);
                    education.startDate = startDate.getFullYear() + "-" + (startDate.getMonth() + 1) + "-" + startDate.getDate();
                    var endDate = new Date(education.endDate);
                    education.endDate = endDate.getFullYear() + "-" + (endDate.getMonth() + 1) + "-" + endDate.getDate();
        
                    state.educations.push(education);
                }
            }
        })
        .catch(function(error) {
            alert(error);
        })
    }
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
    //             mutations.getEducations()
    //         }
    //     })
    //     .catch(function(error) { 
    //             alert(error);
    //     })
    // },
    deleteEducation: async (state, id) => {
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
                axios.delete(api.url+"/resumes/"+id, {
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
                    mutations.getEducations()
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