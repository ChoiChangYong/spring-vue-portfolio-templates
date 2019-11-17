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
                                            <tr v-for="skill in skills" v-bind:key="skill.id">
                                                <td id="name" class="editMe" ref="name">{{ skill.name }}</td>
                                                <td>
                                                    <select id="level" class="form-control" v-model="skill.level" ref="level">
                                                        <option value="2">20%</option>
                                                        <option value="4">40%</option>
                                                        <option value="6">60%</option>
                                                        <option value="8">80%</option>
                                                        <option value="10">100%</option>
                                                    </select>
                                                </td>
                                                <td>
                                                    <i class="fas fa-minus-square fa-2x" @click="deleteSkill(skill.id)"></i>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="text-right">
                            <button type="button" class="btn btn-primary" @click="submitSkill()">Submit</button>
                        </div>
                    </div>
                </div> <!-- end card-body-->
            </div> <!-- end card-->
        </div><!-- end col -->
    </div>
    <!-- end row -->
</template>

<script>
import { mapState, mapMutations, mapActions } from "vuex"
import SimpleTableCellEditor from '../assets/js/SimpleTableCellEditor'
import $ from "jquery"

export default {
    
    data: () => {
        return {
            newSkills: []
        }
    },
    computed: {
        ...mapState("skill",['skills'])
    },
    methods: {
        ...mapMutations("skill",['addSkill', "updateSkills"]),
        ...mapActions("skill",['deleteSkill','sessionCheck']),
        submitSkill(){
            for(var idx = 0; idx < this.skills.length; idx++){
                this.newSkills.push(this.skills[idx])
            }
            for (var jdx = 0; jdx < this.skills.length; jdx++){
                this.newSkills[jdx].name = this.$refs.name[jdx].innerHTML
                this.newSkills[jdx].level = this.$refs.level[jdx].value
            }
            this.updateSkills(this.newSkills)
        }
    },
    mounted() {
        this.sessionCheck()
        new SimpleTableCellEditor("basicTableId").SetEditableClass("editMe"),
        $("#basicTableId").on("cell:edited")
    }
}
</script>

<style>

</style>