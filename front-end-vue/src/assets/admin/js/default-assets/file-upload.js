! function (n) {
    "use strict";
    n(function () {
        n(".file-upload-browse").on("click", function () {
            n(this).parent().parent().parent().find(".file-upload-default").trigger("click")
        }), n(".file-upload-default").on("change", function () {
            n(this).parent().find(".form-control").val(n(this).val().replace(/C:\\fakepath\\/i, ""))
        })
    })
}(jQuery);