<template>
  <div id="app">
    <!-- Preloader -->
    <div id="droba-loader">
        <div class="loader"></div>
    </div>
    <div class="ecaps-page-wrapper">
      <!--Preloader-->
      <AdminYYFoliumNav></AdminYYFoliumNav>
      <!-- Page Content -->
      <div class="ecaps-page-content">
        <AdminYYFoliumHeader></AdminYYFoliumHeader>
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import $ from 'jquery'
import AdminYYFoliumNav from "./components/AdminYYFoliumNav"
import AdminYYFoliumHeader from "./components/AdminYYFoliumHeader"


export default {
  name: 'app',
  components: {
    AdminYYFoliumNav,
    AdminYYFoliumHeader
  },
  mounted() {
    // :: PreventDefault a Click
    $('a[href="#"]').on("click", function ($) {
        $.preventDefault();
    });
  }
}
</script>

<style>
@import url("./assets/css/style.css");
</style>
