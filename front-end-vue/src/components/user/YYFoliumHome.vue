<template>
    <header class="banner banner-img" id="Home">
        <div class="container pr-title">
            <h2 class="home">{{ getHomes.intro }}</h2>

            <div id="typed-strings">
                <span>{{ getHomes.title }}</span>
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

            <p>{{ getHomes.subIntro }}</p>

            <div class="modern-button banner-button">
                <a href="#">Download CV <font-awesome-icon class="fas fa-arrow-down"></font-awesome-icon></a>
            </div>

            <div class="arrow-bounce">
                <a href="#about"><font-awesome-icon class="fas fa-angle-double-down fa-2x"></font-awesome-icon></a>
            </div>
        </div>
    </header>
</template>

<script>
import { mapGetters } from 'vuex'
import $ from 'jquery'

export default {
    computed: {    
        ...mapGetters("YYFoliumHome",['getHomes'])
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

<style src="../../plugins/user/image-hover/imagehover.min.css" scoped></style>
<style src="../../assets/user/css/custom.css" scoped></style>
<style src="../../assets/user/css/reset.css" scoped></style>
<style src="../../assets/user/css/color-beige.css" scoped></style>
<style src="../../assets/user/css/user.css" scoped></style>
