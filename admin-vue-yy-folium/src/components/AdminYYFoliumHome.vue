<template>
    <!-- Table area Start -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <div class="edit-table-area">
                            <h4 class="card-title mb-15">
                                포트폴리오 사이트의 첫 페이지를 채워주세요.
                            </h4>
                            <div class="card mb-2">
                                <div class="card-header">
                                    <a class="text-body" data-toggle="collapse" aria-expanded="true">
                                        <a class="text-muted">이미지를 선택해주세요.</a>
                                    </a>
                                </div>
                                <div id="accordion-2" class="collapse show" data-parent="#accordion-" style="">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-sm-4 col-lg-3 ">
                                                <div class="custom-control custom-radio">
                                                    <input type="radio" id="customRadio1" name="customRadio" class="custom-control-input">
                                                    <label class="custom-control-label" for="customRadio1">
                                                        <img src="../img/bg-img/banner-home.jpg" alt="select image 1" title="select image 1"/>
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-sm-4 col-lg-3 ">
                                                <div class="custom-control custom-radio">
                                                    <input type="radio" id="customRadio2" name="customRadio" class="custom-control-input">
                                                    <label class="custom-control-label" for="customRadio2">
                                                        <img src="../img/bg-img/banner-home-black.jpg" alt="select image 1" title="select image 1"/>
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card mb-2">
                                <div class="card-header">
                                    <a class="text-body" data-toggle="collapse" aria-expanded="true">
                                        <a class="text-muted">표를 채워주세요.</a>
                                    </a>
                                </div>
                                <div id="accordion-3" class="collapse show" data-parent="#accordion-">
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table id="basicTableId" class="table table-bordered table-striped">
                                                <colgroup>
                                                    <col width="30%" />
                                                    <col width="70%" />
                                                </colgroup>
                                                <tr>
                                                    <th class="bg-dark text-white">Category</th>
                                                    <th class="bg-dark text-white">Value</th>
                                                </tr>
                                                <tr>
                                                    <th>Title</th>
                                                    <td id="title" class="editMe"></td>
                                                </tr>
                                                <tr>
                                                    <th>Intro</th>
                                                    <td id="Intro" class="editMe"></td>
                                                </tr>
                                                <tr>
                                                    <th>SubIntro</th>
                                                    <td id="subTitle" class="editMe"></td>
                                                </tr>
                                            </table>
                                        </div>  
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="text-right">
                            <button type="button" class="btn btn-primary" @click="toastSubmit()">Submit</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { mapGetters, mapMutations } from "vuex"

export default {
    computed: {
        ...mapGetters(['setInputValue']),
    },
    methods: {
        ...mapMutations(['toastSubmit']),
    },
    mounted() {
    }
}
</script>

<style scpoed>
    .toast-top-right .toast {
    background-color: #007bff;
    }   
</style>