<template>
    <!-- Resume START -->
    <div class="resume" id="Resume">
        <div class="container">
            <h2>Resume</h2>

            <div class="row">
                <div class="col-md-6">
                    <h3>Work History</h3>

                    <ul class="timeline">
                        <li class="timeline-event" v-show="work.historyFlag == '0'" v-for="work in myResume" v-bind:key="work.id">
                            <label class="timeline-event-icon"></label>

                            <div class="timeline-event-container">
                                <p class="timeline-event-date">{{ work.startDate }} - {{ work.endDate }}</p>

                                <h3>{{ work.job }}</h3>

                                <h4>{{ work.company }}</h4>

                                <p>{{ work.description }}</p>
                            </div>
                        </li>
                    </ul>
                </div>

                <div class="col-md-6">
                    <h3>Education</h3>

                    <ul class="timeline">
                        <li class="timeline-event" v-show="work.historyFlag == '1'" v-for="work in myResume" v-bind:key="work.id">
                            <label class="timeline-event-icon" ></label>

                            <div class="timeline-event-container">
                                <p class="timeline-event-date">{{ work.startDate }} - {{ work.endDate }}</p>

                                <h3>{{ work.job }}</h3>

                                <h4>{{ work.company }}</h4>

                                <p>{{ work.description }}</p>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- Resume END -->
</template>

<script>
import { mapState } from 'vuex'

export default {
    
    computed: {
        ...mapState("YYFoliumResume",['myResume'])
    },

}
</script>

<style src="../../plugins/user/image-hover/imagehover.min.css" scoped></style>
<style src="../../assets/user/css/custom.css" scoped></style>
<style src="../../assets/user/css/reset.css" scoped></style>
<style src="../../assets/user/css/color-beige.css" scoped></style>
<style src="../../assets/user/css/user.css" scoped></style>