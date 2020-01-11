<template>
    <nav class="navbar fixed-top navbar-expand-md navbar-light top-navigation">
        <div class="container">
            <a class="navbar-brand text-white" href="#home">{{ homeItems.title }}</a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#top-navbar" aria-controls="top-navbar" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="top-navbar">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#home">Home</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#about">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#resume">Resume</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#portfolio">Portfolio</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>

<script>
import { mapState } from 'vuex'
import $ from 'jquery'

export default {
    computed: {
        ...mapState("home",['homeItems'])
    },
    mounted() {
        // Top Navigation Effect
        $(window).on('scroll', function() {
            if ($(window).scrollTop() > 0) {
                $('.top-navigation').addClass('stick');
            } else {
                $('.top-navigation').removeClass('stick');
            }
        });
    }
}
</script>