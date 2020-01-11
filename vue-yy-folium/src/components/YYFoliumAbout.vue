<template>
<!-- About Section START -->
    <div class="container about" id="about">
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
                <img v-bind:src="userAbout.imageUrl" alt="About Me" class="img-fluid" />
            </div>

            <!-- About Information START -->
            <div class="col-md-6 col-lg-7">
                <div class="pr-right-info">
                    <h4>Name</h4>
                    <p>{{ userAbout.name }}</p>
                </div>
                <div class="pr-right-info">
                    <h4>Gender</h4>
                    <p>{{ gender }}</p>
                </div>

                <div class="pr-right-info">
                    <h4>Phone</h4>
                    <p>{{ userAbout.tel }}</p>
                </div>

                <div class="pr-right-info">
                    <h4>Email</h4>
                    <p>{{ userAbout.email }}</p>
                </div>
                <div class="pr-right-info">
                    <h4>Job</h4>
                    <div v-for="(job) in jobs" v-bind:key="job.id">
                        <p>
                            {{ job.name }}
                        </p>
                    </div>
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
                    <div class="skill-progress">
                        <div class="skill-title clearfix">Spring boot</div>

                        <div class="skill-progressbar">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </div>
                    </div>

                    <div class="skill-progress">
                        <div class="skill-title clearfix">UI/UX</div>

                        <div class="skill-progressbar">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </div>
                    </div>

                    <div class="skill-progress">
                        <div class="skill-title clearfix">C</div>

                        <div class="skill-progressbar">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="skill-progress">
                        <div class="skill-title clearfix">JAVA</div>

                        <div class="skill-progressbar">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </div>
                    </div>

                    <div class="skill-progress">
                        <div class="skill-title clearfix">Spring</div>

                        <div class="skill-progressbar">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </div>
                    </div>

                    <div class="skill-progress">
                        <div class="skill-title clearfix">Vue</div>

                        <div class="skill-progressbar">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
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
import { mapState, mapActions } from 'vuex'
import $ from 'jquery'

export default {
    data: () => {
        return {
            gender: ""
        }
    },
    computed: {
        ...mapState("home",['userAbout','jobs'])
    },
    methods: {
        ...mapActions("home",['getProfiles','getJobs']),
        isGender(){
            if(this.userAbout.Gender == 1){
                this.gender = "남자"
            } else {
                this.gender = "여자"
            }
        }
    },
    mounted() {
        this.getProfiles()
        this.getJobs()
        this.isGender()
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

<style>

</style>