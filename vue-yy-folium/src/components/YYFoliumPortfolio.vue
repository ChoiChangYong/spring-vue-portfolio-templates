<template>
    <!-- Portfolio Section START -->
    <div class="container portfolio" id="portfolio">
        <!-- Section Title START -->
        <div class="section-title">
            <div class="container pr-title">
                <h2>My <span>Portfolio</span></h2>

                <p>A Few Words About Portfolio</p>
            </div>
        </div>
        <!-- Section Title END -->

        <ul class="filter-gallery">
            <li class="active">
                <a href="javascript:void(0)" data-mixitup-control data-filter="all">All</a>
            </li>

            <li>
                <a href="javascript:void(0)" data-mixitup-control data-filter=".website">Website</a>
            </li>

            <li>
                <a href="javascript:void(0)" data-mixitup-control data-filter=".system">System</a>
            </li>

            <li>
                <a href="javascript:void(0)" data-mixitup-control data-filter=".logo">Logo</a>
            </li>

            <li>
                <a href="javascript:void(0)" data-mixitup-control data-filter=".app">App</a>
            </li>
        </ul>

        <div class="row gallery">
            <div class="col-12 col-md-4 col-sm-6 col-xs-6 mix website">
                <figure class="imghvr-zoom-in">
                    <img class="img-fluid" src="../images/portfolio/1.jpg" alt="Portfolio" />

                    <figcaption>
                        <h1>Web Designing</h1>

                        <p>Duis finibus nisi et diam rhoncus, non efficitur sem malesuada. Ut bibendum efficitur hendrerit. Fusce quis sodales diam.</p>

                        <i class="fas fa-plus fa-inverse fa-2x"></i>
                    </figcaption>

                    <a href="../images/portfolio/1.jpg" class="portfolio-popup" title="Web Designing"></a>
                </figure>
            </div>

            <div class="col-12 col-md-4 col-sm-6 col-xs-6 mix system">
                <figure class="imghvr-zoom-in">
                    <img class="img-fluid" src="../images/portfolio/2.jpg" alt="Portfolio" />

                    <figcaption>
                        <h1>System Development</h1>

                        <p>Duis finibus nisi et diam rhoncus, non efficitur sem malesuada. Ut bibendum efficitur hendrerit. Fusce quis sodales diam.</p>

                        <i class="fas fa-plus fa-inverse fa-2x"></i>
                    </figcaption>

                    <a href="../images/portfolio/2.jpg" class="portfolio-popup" title="System Development"></a>
                </figure>
            </div>

            <div class="col-12 col-md-4 col-sm-6 col-xs-6 mix logo">
                <figure class="imghvr-zoom-in">
                    <img class="img-fluid" src="../images/portfolio/3.jpg" alt="Portfolio" />

                    <figcaption>
                        <h1>Logo Designing</h1>

                        <p>Duis finibus nisi et diam rhoncus, non efficitur sem malesuada. Ut bibendum efficitur hendrerit. Fusce quis sodales diam.</p>

                        <i class="fas fa-plus fa-inverse fa-2x"></i>
                    </figcaption>

                    <a href="../images/portfolio/3.jpg" class="portfolio-popup" title="Logo Designing"></a>
                </figure>
            </div>

            <div class="col-12 col-md-4 col-sm-6 col-xs-6 mix app">
                <figure class="imghvr-zoom-in">
                    <img class="img-fluid" src="../images/portfolio/4.jpg" alt="Portfolio" />

                    <figcaption>
                        <h1>App Development</h1>

                        <p>Duis finibus nisi et diam rhoncus, non efficitur sem malesuada. Ut bibendum efficitur hendrerit. Fusce quis sodales diam.</p>

                        <i class="fas fa-plus fa-inverse fa-2x"></i>
                    </figcaption>

                    <a href="../images/portfolio/4.jpg" class="portfolio-popup" title="App Development"></a>
                </figure>
            </div>
        </div>
    </div>
    <!-- Portfolio Section END -->
</template>

<script>
import $ from 'jquery'
import mixitup from 'mixitup';
import 'magnific-popup';

export default {
    mounted() {
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

<style>

</style>