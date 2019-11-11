<template>
    <!-- File upload area Start -->
    
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title mb-2">Dropzone File Upload</h4>
                        <p class="sub-header mb-30">
                            DropzoneJS is an open source library that provides drag’n’drop file uploads with image previews.
                        </p>

                        <form action="/" method="post" class="dropzone" id="myAwesomeDropzone">
                            <div class="fallback">
                                <input name="file" type="file" multiple />
                            </div>

                            <div class="dz-message needsclick">
                                <i class="h1 text-muted dripicons-cloud-upload"></i>
                                <h3>Drop files here or click to upload.</h3>
                                <span class="text-muted font-13">(This is just a demo dropzone. Selected files are <strong>not</strong> actually uploaded.)</span>
                            </div>
                        </form>
                        <div class="clearfix text-right mt-3">
                            <button type="button" class="btn btn-danger"> <i class="mdi mdi-send mr-1"></i> Submit</button>
                        </div>

                    </div> <!-- end card-body-->
                </div> <!-- end card-->
            </div><!-- end col -->
        </div>
        <!-- end row -->
</template>

<script>
export default {
}   
</script>

<style>

</style>