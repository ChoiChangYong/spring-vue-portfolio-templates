<template>
    <div>
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
import YYFoliumNav from '../YYFoliumNav'
import YYFoliumHome from '../YYFoliumHome'
import YYFoliumAbout from '../YYFoliumAbout'
import YYFoliumResume from '../YYFoliumResume';
import YYFoliumPortfolio from '../YYFoliumPortfolio';
import YYFoliumContact from '../YYFoliumContact';
import YYFoliumFooter from '../YYFoliumFooter';
import $ from 'jquery';

import { mapActions } from 'vuex'

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
  methods: {
      ...mapActions("YYFoliumHome",['getUserHeader']),
      ...mapActions("YYFoliumAbout",['getUserSkills', 'getUserJobs']),
      ...mapActions("YYFoliumResume",['getUserResume']),
      ...mapActions("YYFoliumPortfolio",['getUserProjects'])
  },
  mounted() {
    this.getUserHeader();
    this.getUserSkills();
    this.getUserJobs();
    this.getUserResume();
    this.getUserProjects();

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

<style src="../../../assets/user/css/custom.css" scoped></style>
<style src="../../../assets/user/css/reset.css" scoped></style>
<style src="../../../assets/user/css/color-beige.css" scoped></style>
<style src="../../../plugins/user/magnific-popup/magnific-popup.css"></style>