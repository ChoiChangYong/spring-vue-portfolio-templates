<template>
    <!-- Top Header Area -->
    <header class="top-header-area d-flex align-items-center justify-content-between">
        <div class="left-side-content-area d-flex align-items-center">
            <!-- Mobile Logo -->
            <div class="mobile-logo mr-3 mr-sm-4">
                <router-link to="/home">Folium</router-link>
            </div>

            <!-- Triggers -->
            <div class="ecaps-triggers mr-1 mr-sm-3">
                <div class="menu-collasped" id="menuCollasped">
                    <i class="zmdi zmdi-menu"></i>
                </div>
                <div class="mobile-menu-open" id="mobileMenuOpen">
                    <i class="zmdi zmdi-menu"></i>
                </div>
            </div>
        </div>

        <div class="right-side-navbar d-flex align-items-center justify-content-end">
            <!-- Mobile Trigger -->
            <div class="right-side-trigger" id="rightSideTrigger" @click="TrriggerActive()">
                <i class="ti-align-left"></i>
            </div>

            <!-- Top Bar Nav -->
            <ul class="right-side-content d-flex align-items-center" v-bind:class="{ active : isActive}">
                <li>
                    <button class="btn btn-outline-dark mr-2" @click="logout">Logout</button>
                </li>
            </ul>
        </div>
    </header>
</template>

<script>
import $ from 'jquery'
import { mapState, mapMutations, mapActions } from 'vuex';

export default {
    computed: {
        ...mapState("nav",['isActive'])
    },
    methods: {
        ...mapMutations("nav", ['TrriggerActive']),
        ...mapActions("nav",['logout'])
    },
    mounted() {
        // :: Dropdown Active Code
        if ($.fn.dropdown) {
            $("dropdown-toggle").dropdown();
        }
    }
}
</script>

<style scoped>
/* .dropdown-item{
    background-color: #ffc107;
} */
</style>