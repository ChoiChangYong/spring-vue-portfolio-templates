<template>
    <Vue2Dropzone id="profileImage" :options="dropzoneOptions" v-on:vdropzone-success="getProfiles"></Vue2Dropzone>
</template>

<script>
import Vue2Dropzone from 'vue2-dropzone'
import { mapMutations } from 'vuex'

export default {
    components: {
        Vue2Dropzone
    },
    data: () => {
        return {
            dropzoneOptions: {
                url: "http://192.168.0.99:8080/api/users/image-upload",
                thumbnailWidth: 150,
                maxFilesize: 128,
                addRemoveLinks: true,
                maxFiles: 1,
                uploadMultiple: false,
                method: 'post',
                acceptedFiles: ".jpeg,.jpg,.png,.gif,.JPEG,.JPG,.PNG,.GIF",
                // headers: { "My-Awesome-Header": "header value" },
                params: {'sessionId': window.sessionStorage.getItem("sessionId")},
            }
        }
    },
    methods: {
        ...mapMutations("profile",['getProfiles'])
    }
}
</script>

<style>

</style>