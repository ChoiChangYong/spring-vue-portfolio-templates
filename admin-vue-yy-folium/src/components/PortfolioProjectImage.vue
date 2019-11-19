<template>
    <div class="edit-table-area">
        <h4 class="card-title mb-15">
            Project Image 등록
        </h4>
        <div class="card mb-2">
            <div class="card-header">
                <a class="text-body" data-toggle="collapse" aria-expanded="true">
                    <a class="text-muted">프로젝트 이미지를 등록해주세요.</a>
                </a>
            </div>
            <div id="accordion-3" class="collapse show" data-parent="#accordion-">
                <div class="card-body">
                    <Vue2Dropzone id="projectImage" :options="dropzoneOptions"></Vue2Dropzone>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { api } from '../store/modules/common/global-variable'
import Vue2Dropzone from 'vue2-dropzone'
// import { router } from '../routes'
// import { mapState } from 'vuex'

export default {
    data: () => {
        return{
            newProjectId: "",
            dropzoneOptions: {
                url: "",
                thumbnailWidth: 150,
                maxFilesize: 128,
                addRemoveLinks: true,
                maxFiles: 5,
                uploadMultiple: false,
                method: 'post',
                acceptedFiles: ".jpeg,.jpg,.png,.gif,.JPEG,.JPG,.PNG,.GIF",
                // headers: { "My-Awesome-Header": "header value" },
                params: {'sessionId': window.sessionStorage.getItem("sessionId")},
            },
        }
    },
    computed: {
        // ...mapState("portfolio",['newProject'])
    },
    components: {
        Vue2Dropzone
    },
    created() {
        this.newProjectId = this.$route.params.id
        this.dropzoneOptions.url = api.url+"/portfolio-projects/"+this.newProjectId+"/image-upload"
    }
}
</script>

<style>

</style>