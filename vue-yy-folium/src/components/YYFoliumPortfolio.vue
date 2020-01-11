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
                <a href="javascript:void(0)" data-mixitup-control data-filter="all">App</a>
            </li>

            <li>
                <a href="javascript:void(0)" data-mixitup-control data-filter=".website">Web</a>
            </li>
        </ul>

        <div class="row gallery">
            <!-- <div class="col-12 col-md-4 col-sm-6 col-xs-6 mix all"> -->
                <!-- <figure class="imghvr-zoom-in">
                    <img id="portfolio_image" class="img-fluid" src="../images/banner-home-black.jpg" alt="Portfolio" />

                    <figcaption>
                        <h1>QR코드를 이용한 책거래 시스템</h1>

                        <p>QR코드를 이용한 책거래 시스템 구매자 - 웹 판매자 - 앱</p>

                        <i class="fas fa-plus fa-inverse fa-2x"></i>
                    </figcaption>

                    <a href="../images/banner-home-black.jpg" class="portfolio-popup" title="Web Designing"></a>
                </figure> -->
            <!-- </div>
            <div class="col-12 col-md-4 col-sm-6 col-xs-6 mix website">
                <figure class="imghvr-zoom-in">
                    <img id="portfolio_image" class="img-fluid" src="../images/profile.jpg" alt="Portfolio" />

                    <figcaption>
                        <h1>포트폴리오 웹 사이트 배포</h1>

                        <p>SpringBoot와 VueJS를 이용한 포토폴리오 웹 사이트 템플릿 배포</p>

                        <i class="fas fa-plus fa-inverse fa-2x"></i>
                    </figcaption>

                    <a href="../images/profile.jpg" class="portfolio-popup" title="Web Designing"></a>
                </figure>
            </div> -->
        </div>
    </div>
    <!-- Portfolio Section END -->
</template>

<script>
import $ from 'jquery'
import mixitup from 'mixitup';


export default {
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

<style>

</style>