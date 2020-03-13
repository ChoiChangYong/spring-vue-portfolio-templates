<template>
    <div class="edit-table-area">
        <h4 class="card-title mb-15">
            Project Edit 
        </h4>
        <div class="card mb-2">
            <div class="card-header">
                <a class="text-body" data-toggle="collapse" aria-expanded="true">
                    <a class="text-muted">프로젝트를 수정해주세요</a>
                </a>
            </div>
            <!-- <div id="accordion-3" class="collapse show" data-parent="#accordion-">
                <div class="card-body">
                    <Vue2Dropzone id="projectImage" :options="dropzoneOptions" v-on:vdropzone-success="getProjects"></Vue2Dropzone>
                </div>
            </div> -->
            <div id="accordion-3" class="collapse show" data-parent="#accordion-">
                <div class="card-body">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="exampleSelectGender">메뉴</label>
                            <select class="form-control" id="exampleSelectGender" v-model="selectedMenuId.id">
                                <option v-for="menu in menus" v-bind:key="menu.id" :value="menu.id">{{ menu.name }}</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputName1">프로젝트명</label>
                            <input type="text" class="form-control" id="exampleInputName" v-model="project.name">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputName1">소속</label>
                            <input type="text" class="form-control" id="exampleInputBelong"  v-model="project.belong">
                        </div>
                        <div class="form-group">
                            <label for="exampleTextarea1">추가설명</label>
                            <textarea class="form-control" id="exampleTextarea1" rows="4" v-model="project.description"></textarea>
                        </div>
                    </div>
                </div>
            </div>
        </div>
            <div class="text-right">
                <button type="button" class="btn btn-primary" @click="editProject(paramsId)" >저장</button>
            </div>
    </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex';
export default {
    data() {
        return{
            paramsId: {
                projectId: "",
                menuId: ""
            }
        }
    },
    computed: {
        ...mapState("project",['project', 'menus', 'selectedMenuId'])
    },
    methods: {
        ...mapMutations("project",['getProject', 'editProject'])
    },
    mounted() {
        this.paramsId.projectId = this.$route.params.projectId
        this.paramsId.menuId = this.$route.params.menuId
        this.selectedMenuId.id = this.paramsId.menuId
        this.getProject(this.paramsId)
    }
}
</script>