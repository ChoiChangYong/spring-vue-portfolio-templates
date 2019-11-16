<template>
  <div id="app">
    <body>
      <router-view></router-view>
    </body>
  </div>
</template>

<script>
import './assets/js/treemenu.js'

export default {
  name: 'app',
  components: {
  },
  mounted() {

  }
}
</script>

<style>
@import url("./assets/css/bootstrap.min.css");
@import url("./assets/css/style.css");
</style>
