<template>
    <Vue2Dropzone ref="profileImage" id="profileImage" :options="dropzoneOptions"></Vue2Dropzone>
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
                url: 'localhost:8080',
                thumbnailWidth: 150,
                maxFilesize: 0.5,
                headers: { "My-Awesome-Header": "header value" }
            }
        }
    }
}
</script>

<style>

</style>