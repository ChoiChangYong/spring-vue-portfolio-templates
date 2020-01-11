<template>
    <header class="banner banner-img" id="home">
        <div class="container pr-title">
            <h2>{{ homeItems.intro }}</h2>

            <div id="typed-strings">
                <span>Welcome to the MYFolium portfolio site.</span>
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

            <div class="arrow-bounce">
                <a href="#about"><i class="fas fa-angle-double-down fa-2x"></i></a>
            </div>
        </div>
    </header>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import $ from 'jquery'

export default {
    computed: {
        ...mapState("home",['homeItems'])
    },
    methods: {
        ...mapActions("home",['getHomes'])
    },
    mounted() {
        this.getHomes()
        
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