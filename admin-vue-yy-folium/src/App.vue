<template>
  <div id="app">
    <body>
      <router-view></router-view>
    </body>
  </div>
</template>

<script>
import './assets/admin/js/treemenu.js'

export default {
  name: 'app',
  components: {
  },
  mounted() {

  }
}
</script>

<style>
@import url("./assets/admin/css/bootstrap.min.css");
@import url("./assets/admin/css/style.css");
</style>
