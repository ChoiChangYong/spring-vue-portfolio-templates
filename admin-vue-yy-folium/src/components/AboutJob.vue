<template>
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <div class="edit-table-area">
                        <h4 class="card-title mb-15">
                            직무를 작성해주세요.
                        </h4>
                        <div class="card mb-2">
                            <div class="card-header">
                                <a class="text-body" data-toggle="collapse" aria-expanded="true">
                                    <a class="text-muted">표를 채워주세요.</a>
                                </a>
                            </div>
                            <div id="accordion-3" class="collapse show" data-parent="#accordion-">
                                <div class="card-body">
                                    <div class="text-right mb-2">
                                        <i class="fas fa-plus-square fa-2x" @click="showAlertAdd"></i>
                                    </div>
                                    <div class="table-responsive">
                                        <table id="basicTableId" class="table table-bordered table-striped">
                                            <colgroup>
                                                <col width="95%" />
                                                <col width="5%" />
                                            </colgroup>
                                            <tr>
                                                <th colspan="2" class="bg-dark text-white">Name</th>
                                            </tr>
                                            <tr v-for="(jobs, index) in getJobs" v-bind:key="jobs.job">
                                                <td v-bind:id="index" class="editMe"></td>
                                                <td>
                                                    <i v-bind:id="index+'remove'" class="fas fa-minus-square fa-2x" @click="showAlertConfirm"></i>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="text-right">
                            <button type="button" class="btn btn-primary" @click="toastSubmit()">Submit</button>
                        </div>
                    </div>
                </div> <!-- end card-body-->
            </div> <!-- end card-->
        </div><!-- end col -->
    </div>
    <!-- end row -->
</template>

<script>
import SimpleTableCellEditor from '../assets/js/SimpleTableCellEditor'
import $ from 'jquery'
import { mapGetters, mapMutations } from 'vuex';

export default {
    data() {
        return {
            idx: 1
        }
    },
    computed: {
        ...mapGetters(['getJobs'])
    },
    methods: {
        ...mapMutations(['toastSubmit']),
        showAlertConfirm(){
            this.$swal({
              title: '삭제하시겠습니까?',
              text: "삭제할 경우 되돌릴 수 없습니다.",
              type: 'warning',
              showCancelButton: true,
              confirmButtonColor: '#3085d6',
              cancelButtonColor: '#d33',
              confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
              if (result.value) {
                this.$swal(
                  'Deleted!',
                  'Your file has been deleted.',
                  'success'
                )
              }
            })
        },
        showAlertAdd(){
            var Swal = this.$swal
            Swal({
                title: "직업을 입력해주세요.",
                input: "text",
                inputAttributes: {
                    autocapitalize: "off"
                },
                showCancelButton: !0,
                confirmButtonText: "저장",
                showLoaderOnConfirm: !0,
                preConfirm: function (t) {
                    return fetch("//api.github.com/users/" + t).then(function (t) {
                        if (!t.ok) throw new Error(t.statusText);
                        return t.json()
                    }).catch(function (t) {
                        Swal.showValidationMessage("Request failed: " + t)
                    })
                },
                allowOutsideClick: function () {
                    Swal.isLoading()
                }
            }).then(function (t) {
                t.value && Swal.fire({
                    title: "\" "+t.value.login + " \"이 등록되었습니다."
                })
            })
        }
    },
    mounted() {
        new SimpleTableCellEditor("basicTableId").SetEditableClass("editMe"),
        $("#basicTableId").on("cell:edited",
            function(e){
                // consol.log error 해결
                /*jslint devel: true */
                /* eslint-disable no-console */
                /*eslint no-undef: "error"*/
                /*eslint-env node*/
                console.log(`'${e.target.id}' changed to '${e.newValue}'`)
            }
        )
    }
}
</script>

<style scoped>
    .fa-plus-square {
        color: #ffc107
    }
    .fa-minus-square {
        color: #dc3545
    }
</style>