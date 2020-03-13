<template>
<!-- About Section START -->
    <div class="container about" id="About">
        <!-- Section Title START -->
        <div class="section-title">
            <div class="container pr-title">
                <h2><span>About</span> Me</h2>
                <p>A Few Words About Me</p>
            </div>
        </div>
        <!-- Section Title END -->

        <div class="row">
            <div class="col-md-6 col-lg-5">
                <!-- About Image -->
                <img src="../../img/user/minyeong.png" alt="About Me" class="img-fluid" />
            </div>

            <!-- About Information START -->
            <div class="col-md-6 col-lg-7">
                <div class="pr-right-info">
                    <h4>Name</h4>
                    <p>{{ getMyAbout.name }}</p>
                </div>

                <div class="pr-right-info">
                    <h4>Gender</h4>
                    <p>{{ getMyAbout.gender }}</p>
                </div>

                <div class="pr-right-info">
                    <h4>Phone</h4>
                    <p>{{ getMyAbout.tel }}</p>
                </div>

                <div class="pr-right-info">
                    <h4>Email</h4>
                    <p>{{ getMyAbout.email }}</p>
                </div>
                
                <div class="pr-right-info">
                    <h4>Jobs</h4>
                    <p v-for="job in myJobs" v-bind:key="job.name">{{ job.name }}</p>
                </div>
            </div>
            <!-- About Information END -->
        </div>

        <!-- Skills START -->
        <div class="skills-chart">
            <h2>Skills</h2>

            <!-- Skills Progressbar START -->
            <div class="row">
                <div class="col-md-6">
                    <div class="skill-progress" v-for="skill in mySkills.slice(0,2,mySkills.length)" v-bind:key="skill.id">
                        <div class="skill-title clearfix">{{ skill.name }}</div>
                        <div class="skill-progressbar">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" v-bind:aria-valuenow="skill.level" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="col-md-6">
                    <div class="skill-progress" v-for="skill in mySkills.slice(2,mySkills.length)" v-bind:key="skill.id">
                        <div class="skill-title clearfix">{{ skill.name }}</div>
                        <div class="skill-progressbar">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" v-bind:aria-valuenow="skill.level" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <!-- Skills Progressbar END -->
        </div>
        <!-- Skills END -->
    </div>
    <!-- About Section END -->
</template>

<script>
import { mapState, mapGetters } from 'vuex'
import $ from 'jquery'

export default {
    computed: {
        ...mapState("YYFoliumAbout",['mySkills','myJobs']),
        ...mapGetters("YYFoliumAbout",['getMyAbout'])
    },
    mounted() {
        // Animate Skills Progressbar In View
        $('.progress-bar').one('inview', function(event, isInView) {
            if (isInView) {
                var valueMax = $(this).attr('aria-valuemax');
                var valueNow = $(this).attr('aria-valuenow');
                var valuePercent = (valueNow * 100) / valueMax;

                $(this).css('width', valuePercent + '%');
                $(this).html(valuePercent + '%');
            }
        })
    }
}
</script>

<style src="../../plugins/user/image-hover/imagehover.min.css" scoped></style>
<style src="../../assets/user/css/custom.css" scoped></style>
<style src="../../assets/user/css/reset.css" scoped></style>
<style src="../../assets/user/css/color-beige.css" scoped></style>
<style src="../../assets/user/css/user.css" scoped></style>
<style src="../../assets/user/css/bootstrap-grid.min.css" scoped></style>
