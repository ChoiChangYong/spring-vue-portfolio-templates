import { api, Swal } from './common/global-variable'
import { router } from '../../routes'
import axios from 'axios'

const state = {
    works: []
}

const mutations = {
    addWork: () => {
        Swal.fire({
            title: "경력을 입력해주세요.",
            html:
                '<div>'+
                    '<h5>시작일자</h5>'+
                    '<div data-label="Example" class="mt-example demo-forms">'+
                        '<input id="work-start-date" type="date" class="form-control mb-15" placeholder="YYYY/MM/DD">'+
                    '</div>'+
                    '<h5>종료일자</h5>'+
                    '<div data-label="Example" class="mt-example demo-forms">'+
                        '<input id="work-end-date" type="date" class="form-control mb-15" placeholder="YYYY/MM/DD">'+
                    '</div>'+
                '</div>'+
                '<h5 class="mt-3">직무</h5>'+
                '<input id="work-job" class="form-control">'+
                '<h5 class="mt-3">회사명</h5>'+
                '<input id="work-company" class="form-control">'+
                '<h5 class="mt-3">추가설명</h5>'+
                '<textarea id="work-description" class="form-control">',
            inputAttributes: {
                autocapitalize: "off"
            },
            showCancelButton: true,
            confirmButtonText: "저장",
            cancelButtonText: "취소",
            showLoaderOnConfirm: true,
            preConfirm: function () {
                var startDate = document.getElementById('work-start-date').value
                var endDate = document.getElementById('work-end-date').value
                var company = document.getElementById('work-company').value
                var job = document.getElementById('work-job').value
                var description = document.getElementById('work-description').value
                return axios.post(api.url + "/resumes", 
                    {
                        'sessionId': window.sessionStorage.getItem("sessionId"),
                        'resume': {
                            job,
                            company,
                            description,
                            startDate,
                            endDate,
                            'historyFlag': "0"
                        }
                    }
                ).then(function () {
                    mutations.getWorks()
                }).catch(function (t) {
                    Swal.showValidationMessage("Request failed: " + t)
                })
            },
            allowOutsideClick: function () {
                Swal.isLoading()
            }
        })
    },
    getWorks: () => {
        state.works = []
        axios.get(api.url+"/resumes",{
            params: {
                'sessionId': window.sessionStorage.getItem("sessionId"),
                'historyFlag': "0"
            }
        })
        .then((response) => {
            if(!response.data){
                router.push('/login')
            }
            else {
                for (var work of response.data){
                    var startDate = new Date(work.startDate);
                    work.startDate = startDate.getFullYear() + "-" + (startDate.getMonth() + 1) + "-" + startDate.getDate();
                    var endDate = new Date(work.endDate);
                    work.endDate = endDate.getFullYear() + "-" + (endDate.getMonth() + 1) + "-" + endDate.getDate();
        
                    state.works.push(work);
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
    //             mutations.getWorks()
    //         }
    //     })
    //     .catch(function(error) { 
    //             alert(error);
    //     })
    // },
    deleteWork: async (state, id) => {
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
                axios.delete(api.url+"/resumes/"+id,{
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
                    mutations.getWorks()
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