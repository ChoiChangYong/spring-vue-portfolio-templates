<template>
    <div>
        <div class="ecaps-page-wrapper">
            <!--Preloader-->
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
            </div>
        </div>
    </div>
</template>

<script>
import SideNav from "./common/SideNav"
import HeaderNav from "./common/HeaderNav"

export default {
    components: {
        SideNav,
        HeaderNav,
    },
}
</script>

<style>
</style>