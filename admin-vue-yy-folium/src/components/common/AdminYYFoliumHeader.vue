<template>
    <!-- Top Header Area -->
    <header class="top-header-area d-flex align-items-center justify-content-between">
        <div class="left-side-content-area d-flex align-items-center">
            <!-- Mobile Logo -->
            <div class="mobile-logo mr-3 mr-sm-4">
                <a href="#"><img src="../../img/core-img/small-logo.png" alt="Mobile Logo"></a>
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
            <ul class="right-side-content d-flex align-items-center" v-bind:class="{ active : getIsActive}">
                <li class="nav-item dropdown">
                    <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="../../img/member-img/mail-5.jpg" alt=""></button>
                    <div class="dropdown-menu dropdown-menu-right">
                        <!-- User Profile Area -->
                        <div class="user-profile-area">
                            <div class="user-profile-heading">
                                <!-- Thumb -->
                                <div class="profile-thumbnail">
                                    <img src="../../img/member-img/mail-5.jpg" alt="">
                                </div>
                                <!-- Profile Text -->
                                <div class="profile-text">
                                    <h6>Ajoy Das</h6>
                                    <span>ajoydas@example.com</span>
                                </div>
                            </div>
                            <a href="#" class="dropdown-item"><i class="ti-unlink text-warning" aria-hidden="true"></i> Logout</a>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </header>
</template>

<script>
import $ from 'jquery'
import { mapMutations, mapGetters } from 'vuex';

export default {
    computed: {
        ...mapGetters(['getIsActive'])
    },
    methods: {
        ...mapMutations(['TrriggerActive']),
    },
    mounted() {
        // :: Dropdown Active Code
        if ($.fn.dropdown) {
            $("dropdown-toggle").dropdown();
        }
    }
}
</script>

<style>

</style>