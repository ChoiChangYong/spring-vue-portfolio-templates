<template>
    <!-- Sidemenu Area -->
    <div class="ecaps-sidemenu-area">
        <!-- Desktop Logo -->
        <div class="ecaps-logo">
            <router-link to="/admin/home"><strong class="desktop-logo center">Folium</strong></router-link>
            <router-link to="/admin/home"><strong class="small-logo center">Folium</strong></router-link>
        </div>

        <!-- Side Nav -->
        <!-- slimScrollDiv 확인 -->
            <div class="ecaps-sidenav" id="ecapsSideNav">
                <!-- Side Menu Area -->
                <div class="side-menu-area">
                    <!-- Sidebar Menu -->
                    <nav>
                        <ul class="sidebar-menu" data-widget="tree">
                            <li><router-link to="/admin/home"><i class="fas fa-home"></i><span>Home</span></router-link></li>
                            <li class="treeview">
                                <a href="javascript:void(0)">
                                    <i class="fas fa-id-card-alt"></i>
                                    <span>About</span>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                                <ul class="treeview-menu">
                                    <li><router-link to="/admin/about/profile">Profile</router-link></li>
                                    <li><router-link to="/admin/about/job">Job</router-link></li>
                                    <li><router-link to="/admin/about/skill">Skill</router-link></li>
                                </ul>
                            </li>
                            <li class="treeview">
                                <a href="javascript:void(0)">
                                    <i class="fas fa-history"></i>
                                    <span>Resume</span>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                                <ul class="treeview-menu">
                                    <li><router-link to="/admin/resume/work">Work</router-link></li>
                                    <li><router-link to="/admin/resume/education">Education</router-link></li>
                                </ul>
                            </li>
                            <li class="treeview">
                                <a href="javascript:void(0)">
                                    <i class="fas fa-puzzle-piece"></i>
                                    <span>Portfolio</span>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                                <ul class="treeview-menu">
                                    <li><router-link to="/admin/portfolio/menu">Menu</router-link></li>
                                    <li><router-link to="/admin/portfolio/project/view">Project</router-link></li>
                                </ul>
                            </li>

                            <li><router-link to="/admin/contact"><i class="fas fa-envelope"></i> <span>Contact</span></router-link></li>
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
.center {
    font-size: 25px;
    width: auto;
    margin: auto;
}
</style>