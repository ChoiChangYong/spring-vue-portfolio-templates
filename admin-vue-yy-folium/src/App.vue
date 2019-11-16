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
import './assets/js/treemenu.js'

export default {
  name: 'app',
  components: {
  },
  mounted() {
    // :: Preloader Active Code
    setTimeout(function () {
        $("#droba-loader").addClass("loaded")
    }, 1500)

  }
}
</script>

<style>
@import url("./assets/css/bootstrap.min.css");
@import url("./assets/css/style.css");
</style>
