<template>
    <!-- Sidemenu Area -->
    <div class="ecaps-sidemenu-area">
        <!-- Desktop Logo -->
        <div class="ecaps-logo">
            <a href="index.html"><img class="desktop-logo" src="../img/core-img/logo.png" alt="Desktop Logo"> <img class="small-logo" src="img/core-img/small-logo.png" alt="Mobile Logo"></a>
        </div>

        <!-- Side Nav -->
        <!-- slimScrollDiv 확인 -->
            <div class="ecaps-sidenav" id="ecapsSideNav">
                <!-- Side Menu Area -->
                <div class="side-menu-area">
                    <!-- Sidebar Menu -->
                    <nav>
                        <ul class="sidebar-menu" data-widget="tree">
                            <li class="active"><a href="#"><i class="fas fa-home"></i> <span>Home</span></a></li>
                            <li><a href="#"><i class="fas fa-id-card-alt"></i> <span>About</span></a></li>
                            <li><a href="#"><i class="fas fa-history"></i> <span>Resume</span></a></li>
                            <li class="treeview">
                                <a href="javascript:void(0)"><i class="fas fa-puzzle-piece"></i> <span>Portfolio</span> <i class="fa fa-angle-right"></i></a>
                                <ul class="treeview-menu">
                                    <li><a href="#">All</a></li>
                                </ul>
                            </li>
                            <li><a href="#"><i class="fas fa-envelope"></i> <span>Contact</span></a></li>
                        </ul>
                    </nav>
                </div>
        </div>
    </div>
</template>

<script>
import $ from 'jquery';
import '../assets/js/treemenu.js'

export default {
    mounted() {
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
        
    }
}
</script>

<style>

</style>