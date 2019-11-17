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
                        '<input id="startDate" type="text" class="form-control mb-15" placeholder="YYYY/MM/DD">'+
                    '</div>'+
                    '<h5>종료일자</h5>'+
                    '<div data-label="Example" class="mt-example demo-forms">'+
                        '<input id="endDate" type="text" class="form-control mb-15" placeholder="YYYY/MM/DD">'+
                    '</div>'+
                '</div>'+
                '<h5 class="mt-3">직무</h5>'+
                '<input id="work-job" class="form-control">'+
                '<h5 class="mt-3">회사명</h5>'+
                '<input id="work-name" class="form-control">'+
                '<h5 class="mt-3">추가설명</h5>'+
                '<input id="work-description" class="form-control">',
            inputAttributes: {
                autocapitalize: "off"
            },
            showCancelButton: true,
            confirmButtonText: "저장",
            showLoaderOnConfirm: true,
            preConfirm: function () {
                var name = document.getElementById('work-name').value
                var apiUrl = api.url
                return axios.post(apiUrl + "/resumes", 
                    {
                        'sessionObject': {
                            'sessionId': window.sessionStorage.getItem("sessionId"),
                        },
                        'resume': {
                            'name': name,
                        }
                    }
                ).then(function (work) {
                    state.works.push(work.data)
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
                'sessionId': window.sessionStorage.getItem("sessionId")
            }
        })
        .then((works) => {
            for (var work of works.data){
                var startDate = new Date(work.startDate);
                work.startDate = startDate.getFullYear() + "-" + (startDate.getMonth() + 1) + "-" + startDate.getDate();
                var endDate = new Date(work.endDate);
                work.endDate = endDate.getFullYear() + "-" + (endDate.getMonth() + 1) + "-" + endDate.getDate();
    
                state.works.push(work);
            }
        })
        .catch(function(error) {
            alert(error);
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
                mutations.getWorks()
            }
        })
        .catch(function(error) { 
                alert(error);
        })
    },
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
                axios.delete(api.url+"/resumes/"+id)
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