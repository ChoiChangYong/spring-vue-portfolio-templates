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
        </div>
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
import $ from 'jquery'

export default {
  name: 'app',
  components: {
    YYFoliumNav,
    YYFoliumHome,
    YYFoliumAbout
  },
  mounted() {
    $(window).on('load', function() {
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
