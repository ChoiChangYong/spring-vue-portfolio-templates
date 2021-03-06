$(function () {
    $("#ts-success").on("click", function () {
        toastr.success("Have fun storming the castle!", "Miracle Max Says")
    }), $("#ts-info").on("click", function () {
        toastr.info("We do have the Kapua suite available.", "Turtle Bay Resort")
    }), $("#ts-warning").on("click", function () {
        toastr.warning("My name is Inigo Montoya. You killed my father, prepare to die!")
    }), $("#ts-error").on("click", function () {
        toastr.error("I do not think that word means what you think it means.", "Inconceivable!")
    }), $("#pos-top-left").on("click", function () {
        toastr.info("I do not think that word means what you think it means.", "Top Left!", {
            positionClass: "toastr toast-top-left",
            containerId: "toast-top-left"
        })
    }), $("#pos-top-center").on("click", function () {
        toastr.info("I do not think that word means what you think it means.", "Top Center!", {
            positionClass: "toastr toast-top-center",
            containerId: "toast-top-center"
        })
    }), $("#pos-top-right").on("click", function () {
        toastr.info("I do not think that word means what you think it means.", "Top Right!", {
            positionClass: "toastr toast-top-right",
            containerId: "toast-top-right"
        })
    }), $("#pos-top-full").on("click", function () {
        toastr.info("I do not think that word means what you think it means.", "Top Full Width!", {
            positionClass: "toastr toast-top-full-width",
            containerId: "toast-top-full-width"
        })
    }), $("#pos-bottom-left").on("click", function () {
        toastr.info("I do not think that word means what you think it means.", "Bottom Left!", {
            positionClass: "toastr toast-bottom-left",
            containerId: "toast-bottom-left"
        })
    }), $("#pos-bottom-center").on("click", function () {
        toastr.info("I do not think that word means what you think it means.", "Bottom Center!", {
            positionClass: "toastr toast-bottom-center",
            containerId: "toast-bottom-center"
        })
    }), $("#pos-bottom-right").on("click", function () {
        toastr.info("I do not think that word means what you think it means.", "Bottom Right!", {
            positionClass: "toastr toast-bottom-right",
            containerId: "toast-bottom-right"
        })
    }), $("#pos-bottom-full").on("click", function () {
        toastr.info("I do not think that word means what you think it means.", "Bottom Full Width!", {
            positionClass: "toastr toast-bottom-full-width",
            containerId: "toast-bottom-full-width"
        })
    }), $("#text-notification").on("click", function () {
        toastr.info("Have fun storming the castle!", "Miracle Max Says")
    }), $("#close-button").on("click", function () {
        toastr.success("Have fun storming the castle!", "With Close Button", {
            closeButton: !0
        })
    }), $("#progress-bar").on("click", function () {
        toastr.warning("Have fun storming the castle!", "Progress Bar", {
            progressBar: !0
        })
    }), $("#clear-toast-btn").on("click", function () {
        toastr.error('Clear itself?<br /><br /><button type="button" class="btn btn-secondary clear">Yes</button>', "Clear Toast Button")
    }), $("#slide-toast").on("click", function () {
        toastr.success("I do not think that word means what you think it means.", "Slide Down / Slide Up!", {
            showMethod: "slideDown",
            hideMethod: "slideUp",
            timeOut: 2e3
        })
    }), $("#fade-toast").on("click", function () {
        toastr.success("I do not think that word means what you think it means.", "Slide Down / Slide Up!", {
            showMethod: "fadeIn",
            hideMethod: "fadeOut",
            timeOut: 2e3
        })
    })
});