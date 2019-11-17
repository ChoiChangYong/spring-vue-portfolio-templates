<template>
<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title mb-15">
                   Education
                </h4>
                <div class="card mb-2">
                    <div class="card-header">
                        <a class="text-body" data-toggle="collapse" aria-expanded="true">
                            <a class="text-muted">학력사항을 입력해주세요.</a>
                        </a>
                    </div>
                    <div id="accordion-2" class="collapse show" data-parent="#accordion-">
                        <div class="card-body">
                            <div id="accordion-2" class="collapse show" data-parent="#accordion-">
                            <div class="card-body">
                                <!-- Ibox content -->
                                <div class="ibox-content" id="ibox-content" v-for="education in educations" v-bind:key="education.id">
                                    <div id="vertical-timeline" class="vertical-container light--timeline">
                                        <div class="vertical-timeline-block">
                                            <div class="vertical-timeline-icon navy-bg"></div>
                                                <div class="vertical-timeline-content">
                                                    <div class="float-right">
                                                        <i class="fas fa-minus-square fa-2x" @click="deleteEducation(education.id)"></i>
                                                    </div>
                                                    <div class="mb-2">
                                                        <mark>{{ education.startDate }} ~ {{ education.endDate }}</mark>
                                                    </div>
                                                    <div class="mb-2">
                                                        <h5>{{ education.job }}</h5>
                                                        <strong>{{ education.company }}</strong>
                                                    </div>
                                                    <div>
                                                        <p>{{ education.description }}</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</template>

<script>

import { mapActions, mapMutations, mapState } from 'vuex'

export default {
    computed: {
        ...mapState("education",['educations'])
    },
    methods: {
        ...mapMutations("education",['addEducation']),
        ...mapActions("education",['sessionCheck','deleteEducation'])
    },
    mounted() {
        this.sessionCheck()
    }
}
</script>

<style>

</style>