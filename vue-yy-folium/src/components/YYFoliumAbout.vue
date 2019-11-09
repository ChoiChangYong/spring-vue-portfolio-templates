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
            <div class="col-md-4 col-lg-4">
                <!-- About Image -->
                <img src="../images/about-me.png" alt="About Me" class="img-fluid" />
            </div>

            <!-- About Information START -->
            <div class="col-md-8 col-lg-8">
                <div class="pr-right-info">
                    <h4>Name</h4>
                    <p>{{ getName }}</p>
                </div>

                <div class="pr-right-info">
                    <h4>Current Position</h4>
                    <p>{{ getPosition }}</p>
                </div>

                <div class="pr-right-info">
                    <h4>Gender</h4>
                    <p>{{ getGender }}</p>
                </div>

                <div class="pr-right-info">
                    <h4>Phone</h4>
                    <p>{{ getTel }}</p>
                </div>

                <div class="pr-right-info">
                    <h4>Email</h4>
                    <p><a v-bind:href="emailLink">{{ getEmail }}</a></p>
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
                        <div class="skill-title clearfix">UX Design</div>

                        <div class="skill-progressbar">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="95" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </div>
                    </div>

                    <div class="skill-progress">
                        <div class="skill-title clearfix">Graphic Design</div>

                        <div class="skill-progressbar">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </div>
                    </div>

                    <div class="skill-progress">
                        <div class="skill-title clearfix">Brochure Design</div>

                        <div class="skill-progressbar">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="skill-progress">
                        <div class="skill-title clearfix">Branding Design</div>

                        <div class="skill-progressbar">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="95" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </div>
                    </div>

                    <div class="skill-progress">
                        <div class="skill-title clearfix">Motion Graphics</div>

                        <div class="skill-progressbar">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </div>
                    </div>

                    <div class="skill-progress">
                        <div class="skill-title clearfix">Flyers Design</div>

                        <div class="skill-progressbar">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
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
import { mapGetters } from 'vuex'
import $ from 'jquery'

export default {
    computed: {
        ...mapGetters(['getName']),
        ...mapGetters(['getPosition']),
        ...mapGetters(['getGender']),
        ...mapGetters(['getEmail']),
        ...mapGetters(['getEmailLink']),
        ...mapGetters(['getTel']),

        emailLink() {
            return "mailto:"+this.getEmail;
        }
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

<style>

</style>