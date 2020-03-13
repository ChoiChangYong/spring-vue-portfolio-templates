<template>
    <!-- Portfolio Section START -->
    <div class="container portfolio" id="Portfolio">
        <!-- Section Title START -->
        <div class="section-title">
            <div class="container pr-title">
                <h2>My <span>Portfolio</span></h2>

                <p>A Few Words About Portfolio</p>
            </div>
        </div>
        <!-- Section Title END -->

        <ul class="filter-gallery">
            <li class="active" v-for="menu in menus" v-bind:key="menu.id">
                <a href="javascript:void(0)" data-mixitup-control v-bind:data-filter="menu.name">{{ menu.name }}</a>
            </li>
        </ul>

        <div class="row gallery">
            <div class="col-12 col-md-4 col-sm-6 col-xs-6 mix" v-bind:class="project.portfolioMenu.name" v-for="project in projects" v-bind:key="project.id">
                <figure class="imghvr-zoom-in">
                    <img class="img-fluid" :src="project.imageUrls[0]" alt="Portfolio"/>

                    <figcaption>
                        <h1>{{ project.name }}</h1>

                        <p>{{ project.description }}</p>

                        <!-- <font-awesome-icon class="fas fa-plus fa-inverse fa-2x"></font-awesome-icon> -->
                    </figcaption>
                    <!-- <a v-bind:title="project.name" :href="project.imageUrls[0]" class="portfolio-popup"></a> -->
                </figure>
            </div>
            <!-- <div class="col-12 col-md-4 col-sm-6 col-xs-6 mix app">
                <figure class="imghvr-zoom-in">
                    <img id="portfolio_image" class="img-fluid" src="../../img/user/portfolio/1.jpg" alt="Portfolio" />

                    <figcaption>
                        <h1>Web Designing</h1>

                        <p>Duis finibus nisi et diam rhoncus, non efficitur sem malesuada. Ut bibendum efficitur hendrerit. Fusce quis sodales diam.</p>

                        <font-awesome-icon class="fas fa-plus fa-inverse fa-2x"></font-awesome-icon>
                    </figcaption>

                    <a href="../../img/user/portfolio/1.jpg" class="portfolio-popup" title="Web Designing"></a>
                </figure>
            </div> -->
        </div>
    </div>
    <!-- Portfolio Section END -->
</template>

<script>
import { mapState } from 'vuex'
import $ from 'jquery'
import mixitup from 'mixitup';

export default {
    computed: {
        ...mapState("YYFoliumPortfolio",['menus','projects','imageUrls'])
    },
    mounted() {
        
        $('.portfolio-popup').attr("href", $('#portfolio_image').attr("src"));

        // Flter Portfolio Gallery
        mixitup('.gallery', {
            selectors: {
                control: '[data-mixitup-control]'
            }
        }),

        // Portfolio Gallery Popup
        $('.portfolio-popup').magnificPopup({
            type: 'image',
            gallery: {
                enabled: true
            }
        }),

        // Activate Current Element in Filtering Links
        $('.filter-gallery').on('click', function(event) {
            $('.filter-gallery li').removeClass('active');

            var target = $(event.target);

            // Detect Exact Element of the Event (Delegate)
            if (target.is('a')) {
                target.parent().addClass('active');
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

<style scoped>
.img-fluid {
    max-width: 100%;
    height: auto;
}
img {
    vertical-align: middle;
    border-style: none;
}
</style>