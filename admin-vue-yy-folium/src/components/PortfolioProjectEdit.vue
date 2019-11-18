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
            <div id="accordion-3" class="collapse show" data-parent="#accordion-">
                <div class="card-body">
                    <Vue2Dropzone id="projectImage" :options="dropzoneOptions" v-on:vdropzone-success="getProjects"></Vue2Dropzone>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

</script>

<style>

</style>