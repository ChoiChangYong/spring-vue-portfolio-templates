<template>
      <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <div class="edit-table-area">
                        <h4 class="card-title mb-15">
                            Skill
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
export default {

}
</script>

<style>

</style>