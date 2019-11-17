<template>
    <!-- File upload area Start -->
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title mb-15">Profile</h4>
                    <div class="card mb-2">
                        <div class="card-header">
                            <a data-toggle="collapse" aria-expanded="true" class="text-body text-muted">
                                <a class="text-muted">프로필에 들어갈 이미지를 넣어주세요.</a>
                            </a>
                        </div>
                        <div id="accordion-2" data-parent="#accordion-" class="collapse show">
                            <div class="card-body">
                                <ImageDropzone></ImageDropzone>
                            </div>
                        </div>
                    </div>
                    <div class="card mb-2" v-show="userAbout.imageUrl != null">
                        <div class="card-header">
                            <a data-toggle="collapse" aria-expanded="true" class="text-body text-muted">
                                <a class="text-muted">프로필 이미지</a>
                            </a>
                        </div>
                        <div id="accordion-2" data-parent="#accordion-" class="collapse show">
                            <div class="card-body">
                                <div class="col-sm-6 col-lg-5 img-center">
                                    <img v-bind:src="userAbout.imageUrl" class="img-fluid" alt="" />
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
                        <div id="accordion-3" class="collapse show" data-parent="#accordion-" style="">
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
                                            <th>Name</th>
                                            <td id="name" class="editMe">{{ userAbout.name }}</td>
                                        </tr>
                                        <tr>
                                            <th>Gender</th>
                                            <td>
                                                <select id="inputState" class="form-control" v-model="userAbout.gender">
                                                    <option value="1">남자</option>
                                                    <option value="2">여자</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Email</th>
                                            <td id="email" class="editMe">{{ userAbout.email }}</td>
                                        </tr>
                                        <tr>
                                            <th>Tel</th>
                                            <td id="tel" class="editMe">{{ userAbout.tel }}</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="text-right">
                        <button type="button" class="btn btn-primary">Submit</button>
                    </div>
                </div> <!-- end card-body-->
            </div> <!-- end card-->
        </div><!-- end col -->
    </div>
    <!-- end row -->
</template>

<script>
import SimpleTableCellEditor from '../assets/js/SimpleTableCellEditor'
import ImageDropzone from "./common/ImageDropzone"
import { mapState, mapActions } from "vuex"
import $ from 'jquery'

export default {
    components: {
        ImageDropzone
    },
    computed: {
        ...mapState("profile",['userAbout'])
    },
    methods: {
        // ...mapMutations(['toastSubmit']),
        ...mapActions("profile",['sessionCheck'])
    },
    mounted() {
        this.sessionCheck()
        // :: Dropdown Active Code
        if ($.fn.dropdown) {
            $("dropdown-toggle").dropdown();
        }
        new SimpleTableCellEditor("basicTableId").SetEditableClass("editMe"),
        $("#basicTableId").on("cell:edited");
    }
}   
</script>

<style>
@import url('../assets/css/dropzone.min.css');
.img-center {
    margin: auto;
}
</style>