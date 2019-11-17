<template>
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <div class="edit-table-area">
                        <h4 class="card-title mb-15">
                            Job
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
                                        <i class="fas fa-plus-square fa-2x" @click="addJob"></i>
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
                                            <tr v-for="(job) in jobs" v-bind:key="job.id">
                                                <td id="name" class="editMe" ref="name">{{ job.name }}</td>
                                                <td>
                                                    <i class="fas fa-minus-square fa-2x" @click="deleteJob(job.id)"></i>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="text-right">
                            <button type="button" class="btn btn-primary" @click="submitJob()">Submit</button>
                        </div>
                    </div>
                </div> <!-- end card-body-->
            </div> <!-- end card-->
        </div><!-- end col -->
    </div>
    <!-- end row -->
</template>

<script>
import { mapState, mapMutations } from "vuex"
import SimpleTableCellEditor from '../assets/js/SimpleTableCellEditor'
import $ from "jquery"

export default {
    data() {
        return {
            newJobs: []
        }
    },
    computed: {
        ...mapState("job",['jobs'])
    },
    methods: {
        ...mapMutations("job",['addJob', "getJob", "updateJob"]),
        submitJob(){
            for(var idx = 0; idx < this.jobs.length; idx++){
                this.newJobs.push(this.jobs[idx])
            }
            for (var jdx = 0; jdx < this.jobs.length; jdx++){
                this.newJobs[jdx].name = this.$refs.name[jdx].innerHTML
            }
            this.updateJob(this.newJobs)
        }
    },
    mounted() {
        new SimpleTableCellEditor("basicTableId").SetEditableClass("editMe"),
        $("#basicTableId").on("cell:edited")
    }
}
</script>

<style>
    .fa-plus-square {
        color: #ffc107
    }
    .fa-minus-square {
        color: #dc3545
    }
</style>