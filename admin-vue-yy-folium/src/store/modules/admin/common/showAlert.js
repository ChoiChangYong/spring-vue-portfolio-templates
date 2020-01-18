

// export const showAlertConfirm = () => {
//     Swal({
//       title: '삭제하시겠습니까?',
//       text: "삭제할 경우 되돌릴 수 없습니다.",
//       type: 'warning',
//       showCancelButton: true,
//       confirmButtonColor: '#3085d6',
//       cancelButtonColor: '#d33',
//       confirmButtonText: 'Yes, delete it!'
//     }).then((result) => {
//       if (result.value) {
//         Swal(
//           'Deleted!',
//           'Your file has been deleted.',
//           'success'
//         )
//       }
//     })
// }

// export const addSkill = () =>{
//     const swal = this.$swal
    // swal({
    //     title: "Skill을 입력해주세요.",
    //     input: "text",
    //     inputAttributes: {
    //         autocapitalize: "off"
    //     },
    //     showCancelButton: !0,
    //     confirmButtonText: "저장",
    //     showLoaderOnConfirm: !0,
    //     preConfirm: function (t) {
    //         return fetch("//api.github.com/users/" + t).then(function (t) {
    //             if (!t.ok) throw new Error(t.statusText);
    //             return t.json()
    //         }).catch(function (t) {
    //             swal.showValidationMessage("Request failed: " + t)
    //         })
    //     },
    //     allowOutsideClick: function () {
    //         swal.isLoading()
    //     }
    // }).then(function (t) {
    //     t.value && swal.fire({
    //         title: "\" "+t.value.login + " \"이 등록되었습니다."
    //     })
    // })
// }
