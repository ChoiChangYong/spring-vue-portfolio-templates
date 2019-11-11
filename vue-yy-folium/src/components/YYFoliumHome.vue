<template>
    <header class="banner banner-img" id="home">
        <div class="container pr-title">
            <h2>{{ getIntro }}</h2>

            <div id="typed-strings">
                <span>안녕하세요 반갑습니다</span>
            </div>

            <vue-typed-js 
                :stringsElement="'#typed-strings'"
                :typeSpeed="50"
                :backSpeed="30"
                :smartBackspace="true"
                :loop="true"
                :contentType="'html'"
            >
                <h3> - <span class="typing"></span> - </h3>
            </vue-typed-js>

            <p>{{ getSubIntro }}</p>

            <div class="modern-button banner-button">
                <a href="#">Download CV <i class="fas fa-arrow-down"></i></a>
            </div>

            <div class="arrow-bounce">
                <a href="#about"><i class="fas fa-angle-double-down fa-2x"></i></a>
            </div>
        </div>
    </header>
</template>

<script>
import { mapGetters } from 'vuex'
import $ from 'jquery'

export default {
    computed: {    
        ...mapGetters(['getIntro']),
        ...mapGetters(['getSubIntro'])
    },
    mounted() {
        'use strict';

        $('a').on('click', function(event) {
            if (this.hash !== '') {
                event.preventDefault();

                var hash = this.hash;

                // Smooth Page Scroll to Target
                $('html, body').animate({
                    scrollTop: $(hash).offset().top
                }, 800);
            }
        });
    }
}
</script>

<style scoped>
h3 {
    margin: 0 auto;
}
</style>