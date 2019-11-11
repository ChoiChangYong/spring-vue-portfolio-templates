<template>
  <div id="app">
    <body>
      <!-- Preloader -->
      <div id="droba-loader">
          <div class="loader"></div>
      </div>

      <router-view></router-view>
    </body>
  </div>
</template>

<script>
import $ from 'jquery'

export default {
  name: 'app',
  components: {
  },
  mounted() {
    // :: Preloader Active Code
    setTimeout(function () {
        $("#droba-loader").addClass("loaded")
    }, 1500);

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
