import Vue from 'vue'
import VueToastr2 from 'vue-toastr-2'
import 'vue-toastr-2/dist/vue-toastr-2.min.css'

window.toastr = require('toastr')

Vue.use(VueToastr2)

export const toastSubmit = () => {
    Vue.prototype.$toastr.success('성공적으로 저장되었습니다.', 'Submit Success', {timeOut: 1000});
}