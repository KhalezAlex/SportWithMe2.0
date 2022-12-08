function onLoadRequest() {
    $.ajax({
        url: "/onLoad",
        type: "GET",
        success: function (data) {
            console.log(data);
            if (JSON.parse(data).includes("ANON")) {
                $("#button_new_event").attr("disabled", "disabled");
                $("#button_chat").attr("disabled", "disabled");
                $("#button_profile").attr("disabled", "disabled");
                $("#button_admin_page").attr("disabled", "disabled"); //css("visibility", "hidden");
                $("#button_log_reg_form").removeAttr("disabled");
            }
            if (JSON.parse(data).includes("ADMIN")) {
                $("#button_new_event").removeAttr("disabled");
                $("#button_chat").removeAttr("disabled");
                $("#button_profile").removeAttr("disabled");
                $("#button_admin_page").removeAttr("disabled");
                $("#button_log_reg_form").attr("disabled", "disabled");
            }
            if (JSON.parse(data).includes("USER")) {
                $("#button_new_event").removeAttr("disabled");
                $("#button_chat").removeAttr("disabled");
                $("#button_profile").removeAttr("disabled");
                $("#button_admin_page").attr("disabled", "disabled");
                $("#button_log_reg_form").attr("disabled", "disabled");
            }
            if (JSON.parse(data).includes("STRIKED")) {
                $("#button_new_event").attr("disabled", "disabled");
                $("#button_chat").removeAttr("disabled");
                $("#button_profile").removeAttr("disabled");
                $("#button_admin_page").attr("disabled", "disabled");
                $("#button_log_reg_form").attr("disabled", "disabled");
            }
        }
    })
}

onLoadRequest();