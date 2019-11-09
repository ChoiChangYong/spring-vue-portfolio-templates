<template>
  <div id="app">
    <!-- Preloader -->
    <div class="page-preloader"></div>
    <!-- Main Content START -->
    <main class="one-page">
      <div class="pr-section pr-selected">
        <YYFoliumNav></YYFoliumNav>
        <YYFoliumHome></YYFoliumHome>
        <!-- Page Content START -->
        <div class="pr-content">
          <YYFoliumAbout></YYFoliumAbout>
          <div class="strength"></div>
          <YYFoliumResume></YYFoliumResume>
          <div class="talk-to-me"></div>
          <YYFoliumPortfolio></YYFoliumPortfolio>
          <YYFoliumContact></YYFoliumContact>
        </div>
        <YYFoliumFooter></YYFoliumFooter>
      </div>
    </main>

    <!-- Overlay Effect -->
    <div class="pr-overlay"></div>

    <!-- Back to Top -->
    <a class="back-to-top"></a>
  </div>
</template>

<script>
import YYFoliumNav from './components/YYFoliumNav'
import YYFoliumHome from './components/YYFoliumHome'
import YYFoliumAbout from './components/YYFoliumAbout'
import YYFoliumResume from './components/YYFoliumResume';
import YYFoliumPortfolio from './components/YYFoliumPortfolio';
import YYFoliumContact from './components/YYFoliumContact';
import YYFoliumFooter from './components/YYFoliumFooter';
import $ from 'jquery';

export default {
  name: 'app',
  components: {
    YYFoliumNav,
    YYFoliumHome,
    YYFoliumAbout,
    YYFoliumResume,
    YYFoliumPortfolio,
    YYFoliumContact,
    YYFoliumFooter
  },
  mounted() {
    $(window).on('load', function() {
      'use strict';

      // Page Preloader
      $('.page-preloader').fadeOut('slow');
    }),

    // Back to Top
    $(window).scroll(function() {
        if ($(window).scrollTop() >= 280) {
            $('.back-to-top').fadeIn();
        } else {
            $('.back-to-top').fadeOut();
        }
    });
    $('.back-to-top').on('click', function(event) {
        event.preventDefault();

        $('html, body').animate({
            scrollTop: 0
        }, '300');
    });
  }
}
</script>

<style>
@import url("./plugins/image-hover/imagehover.min.css");
@import url("./plugins/magnific-popup/magnific-popup.css");
@import url("./assets/css/custom.css");
@import url("./assets/css/reset.css");
@import url("./assets/css/color-beige.css");
</style>
