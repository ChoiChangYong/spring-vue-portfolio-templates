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
                                        <i class="fas fa-plus-square fa-2x" @click="addSkill"></i>
                                    </div>
                                    <div class="table-responsive">
                                        <table id="basicTableId" class="table table-bordered table-striped">
                                            <colgroup>
                                                <col width="50%" />
                                                <col width="45%" />
                                                <col width="5%" />
                                            </colgroup>
                                            <tr>
                                                <th class="bg-dark text-white">Name</th>
                                                <th class="bg-dark text-white">Level</th>
                                                <th class="bg-dark text-white"></th>
                                            </tr>
                                            <tr>
                                                <!-- v-bind:id="index" -->
                                                <!-- v-bind:id="index+'remove'"  -->
                                            <!-- <tr v-for="(jobs, index) in getJobs" v-bind:key="jobs.job"> -->
                                                <td  class="editMe" ref="skillName"></td>
                                                <td>
                                                    <select id="inputState" class="form-control">
                                                        <option>20%</option>
                                                        <option>40%</option>
                                                        <option>60%</option>
                                                        <option>80%</option>
                                                        <option>100%</option>
                                                    </select>
                                                </td>
                                                <td>
                                                    <i class="fas fa-minus-square fa-2x" @click="submitSKill"></i>
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
import { mapState, mapMutations } from "vuex"

export default {
    computed: {
        ...mapState("skill",['skill'])
    },
    methods: {
        ...mapMutations("skill",['addSkill']),
        submitSKill(){
            this.skill.name = this.$refs.skillName.innerHTML
        }
    }
}
</script>

<style>

</style>