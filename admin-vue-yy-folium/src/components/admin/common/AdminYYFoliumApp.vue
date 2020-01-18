<template>
    <div>
        <!-- Preloader -->
        <div id="droba-loader">
            <div class="loader"></div>
        </div>
        <div class="ecaps-page-wrapper">
            <SideNav></SideNav>
            <!-- Page Content -->
            <div class="ecaps-page-content">
                <HeaderNav></HeaderNav>
                <!-- Main Content Area -->
                <div class="main-content">
                    <div class="container-fluid">
                        <router-view></router-view>
                    </div>
                </div>
                <Footer></Footer>
            </div>
        </div>
    </div>
</template>

<script>
import $ from 'jquery'
import SideNav from "./SideNav"
import HeaderNav from "./HeaderNav"
import Footer from "./Footer"

export default {
    components: {
        SideNav,
        HeaderNav,
        Footer
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
</style>