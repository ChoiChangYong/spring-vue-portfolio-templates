<template>
    <div>
        <div class="ecaps-page-wrapper">
            <!--Preloader-->
            <AdminYYFoliumNav></AdminYYFoliumNav>
            <!-- Page Content -->
            <div class="ecaps-page-content">
                <AdminYYFoliumHeader></AdminYYFoliumHeader>
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
import AdminYYFoliumNav from "./common/AdminYYFoliumNav"
import AdminYYFoliumHeader from "./common/AdminYYFoliumHeader"

export default {
    components: {
        AdminYYFoliumNav,
        AdminYYFoliumHeader,
    },
}
</script>

<style>

</style>