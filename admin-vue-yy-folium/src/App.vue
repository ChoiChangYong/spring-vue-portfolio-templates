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
      </div>
    </div>
  </div>
</template>

<script>
// import './assets/js/active.js'
import AdminYYFoliumNav from "./components/AdminYYFoliumNav"
import AdminYYFoliumHeader from "./components/AdminYYFoliumHeader"


export default {
  name: 'app',
  components: {
    AdminYYFoliumNav,
    AdminYYFoliumHeader
  },
}
</script>

<style>
@import url("./assets/css/style.css");
</style>
