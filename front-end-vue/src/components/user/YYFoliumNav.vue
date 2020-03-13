<template>
    <nav class="navbar fixed-top navbar-expand-md navbar-light top-navigation">
        <div class="container">
            <a class="navbar-brand" href="#home">{{ getHomes.title }}</a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#top-navbar" aria-controls="top-navbar" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="top-navbar">
                <ul class="navbar-nav ml-auto">
                    <li v-for="m in menus" v-bind:key="m" class="nav-item">
                        <a class="nav-link" :class="{active : m === selectMenu}" :href="'#'+m" v-on:click.self="onclick(m)">{{ m }}</a>
                    </li>

                    <!-- <li class="nav-item">
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
                    </li> -->
                </ul>
            </div>
        </div>
    </nav>
</template>

<script>
import { mapGetters } from 'vuex'
import $ from 'jquery'

export default {
    data: () => {
        return {
            menus: [
                'Home',
                'About',
                'Resume',
                'Portfolio',
                'Contact'
            ],
            selectMenu: 'Home'
        }
    },
    computed: {    
        ...mapGetters("YYFoliumHome",['getHomes'])
    },
    methods: {
        onclick(m){
            this.selectMenu = m;
        }
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

<style src="../../plugins/user/image-hover/imagehover.min.css" scoped></style>
<style src="../../assets/user/css/custom.css" scoped></style>
<style src="../../assets/user/css/reset.css" scoped></style>
<style src="../../assets/user/css/color-beige.css" scoped></style>
<style src="../../assets/user/css/user.css" scoped></style>
