<template>
    <!-- Sidemenu Area -->
    <div class="ecaps-sidemenu-area">
        <!-- Desktop Logo -->
        <div class="ecaps-logo">
            <a href="index.html">
                <img class="desktop-logo" src="../../img/core-img/logo.png" alt="Desktop Logo"> 
                <img class="small-logo" src="../../img/core-img/small-logo.png" alt="Mobile Logo">
            </a>
        </div>

        <!-- Side Nav -->
        <!-- slimScrollDiv 확인 -->
            <div class="ecaps-sidenav" id="ecapsSideNav">
                <!-- Side Menu Area -->
                <div class="side-menu-area">
                    <!-- Sidebar Menu -->
                    <nav>
                        <ul class="sidebar-menu" data-widget="tree">
                            <li class="active"><router-link to="/home"><i class="fas fa-home"></i><span>Home</span></router-link></li>
                            <li class="treeview">
                                <a href="javascript:void(0)">
                                    <i class="fas fa-id-card-alt"></i>
                                    <span>About</span>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                                <ul class="treeview-menu">
                                    <li><router-link to="/about/profile">Profile</router-link></li>
                                    <li><router-link to="/about/job">Job</router-link></li>
                                </ul>
                            </li>
                            <li class="treeview">
                                <a href="javascript:void(0)">
                                    <i class="fas fa-history"></i>
                                    <span>Resume</span>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                                <ul class="treeview-menu">
                                    <li><router-link to="/resume/work">Work</router-link></li>
                                    <li><router-link to="/resume/education">Education</router-link></li>
                                </ul>
                            </li>
                            <li class="treeview">
                                <a href="javascript:void(0)">
                                    <i class="fas fa-puzzle-piece"></i> 
                                    <span>Portfolio</span>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </li>
                            <li><router-link to="/contact"><i class="fas fa-envelope"></i> <span>Contact</span></router-link></li>
                        </ul>
                    </nav>
                </div>
        </div>
    </div>
</template>

<script>
import $ from 'jquery'

export default {
    mounted() {
        
        var pageWrapper = $(".ecaps-page-wrapper");
        var sideMenuArea = $(".ecaps-sidemenu-area");

        // :: Slimscroll Active Code
        if ($.fn.slimscroll) {
            $('#ecapsSideNav').slimscroll({
                height: '100%',
                size: '1px',
                position: 'right',
                color: '#9c9c9c',
                alwaysVisible: false,
                distance: '0px',
                railVisible: false,
                wheelStep: 15
            });
        }

        sideMenuArea.on("mouseenter", function () {
            pageWrapper.addClass("sidemenu-hover-active");
            pageWrapper.removeClass("sidemenu-hover-deactive");
        });

        sideMenuArea.on("mouseleave", function () {
            pageWrapper.removeClass("sidemenu-hover-active");
            pageWrapper.addClass("sidemenu-hover-deactive");
        });
                
        // :: Menu Active Code
        $("#menuCollasped").on("click", function () {
            pageWrapper.toggleClass("menu-collasped-active");
        });

        $("#mobileMenuOpen").on("click", function () {
            pageWrapper.toggleClass("mobile-menu-active");
        });

    }

}
</script>

<style>

</style>