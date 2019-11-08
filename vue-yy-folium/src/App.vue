<template>
  <div id="app">
    <!-- Preloader -->
    <div class="page-preloader"></div>
    <!-- Main Content START -->
    <main class="one-page">
      <div class="pr-section pr-selected">
        <YYFoliumNav></YYFoliumNav>
        <YYFoliumHome></YYFoliumHome>
      </div>
    </main>
    <!-- Overlay Effect -->
    <div class="pr-overlay"></div>

    <!-- Back to Top -->
    <a class="back-to-top"></a>
  </div>
</template>

<script src="./plugins/circliful/js/jquery.circliful.min.js"></script>
<script src="./plugins/inview/jquery.inview.min.js"></script>
<script src="./plugins/count-up/countUp.min.js"></script>
<script src="./plugins/mixitup/mixitup.min.js"></script>
<script src="./plugins/magnific-popup/jquery.magnific-popup.min.js"></script>
<script src="./plugins/owl-carousel/owl.carousel.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB_wGWMl2iJ-ixWJI525qrGsnxFgkieSro&amp;callback=initMap" async defer></script>

<script>
import YYFoliumNav from './components/YYFoliumNav'
import YYFoliumHome from './components/YYFoliumHome'
import $ from 'jquery'

export default {
  name: 'app',
  components: {
    YYFoliumNav,
    YYFoliumHome
  },
  mounted() {
    $(window).on('load', function(e) {
      'use strict';

      // Page Preloader
      $('.page-preloader').fadeOut('slow');
    })
  }
}
</script>

<style>
@import url("./assets/css/color-beige.css");
@import url("./assets/css/custom.css");
@import url("./assets/css/reset.css");
</style>
