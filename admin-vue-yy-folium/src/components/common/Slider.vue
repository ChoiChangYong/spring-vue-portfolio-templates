<template>
    <carousel :autoplay="true" :nav="false">
        <img src='https://placeimg.com/200/200/any?4'>
    </carousel>
</template>

<script>
import carousel from 'vue-owl-carousel'

export default {
    components: { 
        carousel 
    }
}
</script>

<style>

</style>