<template>
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title mb-15">
                        Work
                    </h4>
                    <div class="card mb-2">
                        <div class="card-header">
                            <a class="text-body" data-toggle="collapse" aria-expanded="true">
                                <a class="text-muted">경력사항을 입력해주세요.</a>
                            </a>
                            <div class="text-right float-right">
                                <i class="fas fa-plus-square fa-2x" @click="addWork"></i>
                            </div>
                        </div>
                        
                        <div id="accordion-2" class="collapse show" data-parent="#accordion-">
                            <div class="card-body">
                                <!-- Ibox content -->
                                <div class="ibox-content" id="ibox-content" v-for="work in works" v-bind:key="work.id">
                                    <div id="vertical-timeline" class="vertical-container light--timeline">
                                        <div class="vertical-timeline-block">
                                            <div class="vertical-timeline-icon navy-bg"></div>
                                            <div class="vertical-timeline-content">
                                                <div class="float-right">
                                                    <i class="fas fa-minus-square fa-2x" @click="deleteWork(work.id)"></i>
                                                </div>
                                                <div class="mb-2">
                                                    <mark>{{ work.startDate }} ~ {{ work.endDate }}</mark>
                                                </div>
                                                <div class="mb-2">
                                                    <h5>{{ work.job }}</h5>
                                                    <strong>{{ work.company }}</strong>
                                                </div>
                                                <div>
                                                    <p>{{ work.description }}</p>
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
        ...mapState("work",['works'])
    },
    methods: {
        ...mapMutations("work",['addWork']),
        ...mapActions("work",['sessionCheck','deleteWork'])
    },
    mounted() {
        this.sessionCheck()
    }
}
</script>

<style>
</style>