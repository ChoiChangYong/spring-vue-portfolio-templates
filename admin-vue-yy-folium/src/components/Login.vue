<template>
    <div class="main-content- login-area-2 bg-img h-100vh dark-color-overlay" id="particles-js">
        <div class="container h-100">
            <div class="row h-100 justify-content-center align-items-center">
                <div class="col-md-7 col-lg-6 mx-auto">
                    <!-- Middle Box -->
                    <div class="middle-box  text-center">
                        <h3 class="mb-50 text-white">Admin</h3>
                        <!-- Form -->
                        <form class="login-form" @submit.prevent="loginAction()">
                            <!-- Form Group -->
                            <div class="form-group">
                                <input type="text" class="form-control" v-model="user.id" placeholder="아이디를 입력해주세요." required="">
                            </div>
                            <!-- Form Group -->
                            <div class="form-group">
                                <input type="password" class="form-control" v-model="user.password" placeholder="비밀번호를 입력해주세요." required="">
                            </div>
                            <button type="submit" class="btn btn-outline-primary text-white btn-block">Login</button>
                            <div class="mt-3">
                                <p id="loginError">{{ login.error }}</p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
    computed: {
        ...mapState("login",['user']),
        ...mapState("login",['login'])
    },
    methods: {
        ...mapActions("login",['loginAction']),
    },
    actions: {
    }
}
</script>

<style scoped>
#particles-js {
    background-image: url( "../img/bg-img/banner-home.jpg" );
}
#loginError {
    color: #dc3545
}
</style>