import Vue from 'vue'

import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

Vue.use(VueSweetalert2);

export const Swal = require('sweetalert2')

export const api = {
    url: "http://ec2-52-79-241-61.ap-northeast-2.compute.amazonaws.com:8080/api",
    session: ""
}