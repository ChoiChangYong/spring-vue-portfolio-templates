<template>
    <nav class="navbar fixed-top navbar-expand-md navbar-light bg-light top-navigation">
        <div class="container">
            <a class="navbar-brand" href="#home">{{ getTitle }}</a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#top-navbar" aria-controls="top-navbar" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="top-navbar">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link active" href="#home">Home</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#about">About</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#service">Services</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#portfolio">Portfolio</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#review">Reviews</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
    computed: {
        ...mapGetters(['getTitle'])
    }
}
</script>