import Vue from 'vue'

import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

Vue.use(VueSweetalert2);

const showAlertConfirm = () => {
    this.$swal({
      title: '삭제하시겠습니까?',
      text: "삭제할 경우 되돌릴 수 없습니다.",
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.value) {
        this.$swal(
          'Deleted!',
          'Your file has been deleted.',
          'success'
        )
      }
    })
}

const showAlertAdd = () =>{
    this.$swal({
        title: "직업을 입력해주세요.",
        input: "text",
        inputAttributes: {
            autocapitalize: "off"
        },
        showCancelButton: !0,
        confirmButtonText: "저장",
        showLoaderOnConfirm: !0,
        preConfirm: function (t) {
            return fetch("//api.github.com/users/" + t).then(function (t) {
                if (!t.ok) throw new Error(t.statusText);
                return t.json()
            }).catch(function (t) {
                this.$swal.showValidationMessage("Request failed: " + t)
            })
        },
        allowOutsideClick: function () {
            this.$swal.isLoading()
        }
    }).then(function (t) {
        t.value && this.$swal.fire({
            title: "\" "+t.value.login + " \"이 등록되었습니다."
        })
    })
}

export default{
    showAlertConfirm,
    showAlertAdd
}