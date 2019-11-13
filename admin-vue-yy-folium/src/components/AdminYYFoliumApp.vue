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
import $ from 'jquery'
import SimpleTableCellEditor from '../assets/js/SimpleTableCellEditor'

import AdminYYFoliumNav from "./common/AdminYYFoliumNav"
import AdminYYFoliumHeader from "./common/AdminYYFoliumHeader"

export default {
    components: {
        AdminYYFoliumNav,
        AdminYYFoliumHeader,
    },
    mounted() {
        new SimpleTableCellEditor("basicTableId").SetEditableClass("editMe"),
        $("#basicTableId").on("cell:edited");
    }
}
</script>

<style>
</style>