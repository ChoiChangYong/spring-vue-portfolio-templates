<template>
  <div id="app">
    <!-- Preloader -->
    <div id="droba-loader">
        <div class="loader"></div>
    </div>
    <div class="ecaps-page-wrapper">
      <!--Preloader-->
      <AdminYYFoliumNav></AdminYYFoliumNav>
    </div>
  </div>
</template>

<script>
import $ from "jquery"
import AdminYYFoliumNav from "./components/AdminYYFoliumNav"

export default {
  name: 'app',
  components: {
    AdminYYFoliumNav
  },
  mounted() {
    "use strict";

    var pageWrapper = $(".ecaps-page-wrapper");
    var sideMenuArea = $(".ecaps-sidemenu-area");
    
    // :: Preloader Active Code
    setTimeout(function () {
        $("#droba-loader").addClass("loaded")
    }, 1500);
    
    // :: Menu Active Code
    $("#menuCollasped").on("click", function () {
        pageWrapper.toggleClass("menu-collasped-active");
    });

    $("#mobileMenuOpen").on("click", function () {
        pageWrapper.toggleClass("mobile-menu-active");
    });
        sideMenuArea.on("mouseenter", function () {
        pageWrapper.addClass("sidemenu-hover-active");
        pageWrapper.removeClass("sidemenu-hover-deactive");
    });

    sideMenuArea.on("mouseleave", function () {
        pageWrapper.removeClass("sidemenu-hover-active");
        pageWrapper.addClass("sidemenu-hover-deactive");
    });
  }
}
</script>

<style>
@import url("./assets/css/style.css");
</style>
