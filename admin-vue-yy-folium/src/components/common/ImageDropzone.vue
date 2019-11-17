<template>
    <Vue2Dropzone ref="profileImage" id="profileImage" :options="dropzoneOptions" ></Vue2Dropzone>
</template>

<script>
import Vue2Dropzone from 'vue2-dropzone'
import 'vue2-dropzone/dist/vue2Dropzone.min.css'

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
                params: {'sessionId': window.sessionStorage.getItem("sessionId")}
            }
        }
    }
}
</script>

<style>

</style>