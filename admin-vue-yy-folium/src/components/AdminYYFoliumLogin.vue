<template>
    <div class="main-content- login-area-2 bg-img h-100vh dark-color-overlay" id="particles-js">
        <div class="container h-100">
            <div class="row h-100 justify-content-center align-items-center">
                <div class="col-md-7 col-lg-6 mx-auto">
                    <!-- Middle Box -->
                    <div class="middle-box  text-center">
                        <h3 class="mb-50 text-white">Admin</h3>
                        <!-- Form -->
                        <form class="login-form" @submit.prevent="onSubmit(id, password)">
                            <!-- Form Group -->
                            <div class="form-group">
                                <input type="text" class="form-control" v-model="id" placeholder="User ID" required="">
                            </div>

                            <!-- Form Group -->
                            <div class="form-group">
                                <input type="password" class="form-control" v-model="password" placeholder="Password" required="">
                            </div>
                            <button type="submit" class="btn btn-outline-primary text-white btn-block">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

export default {
    methods: {
        // onSubmit(id, password) {

        // }
    }
}
</script>

<style scoped>
#particles-js {
    background-image: url( "../img/bg-img/banner-home.jpg" );
}
</style>