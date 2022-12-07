$.ajax({
    url: "/onLoad",
    type: "GET",
    success: function (data) {
        if (JSON.parse(data).includes("ANON")) {
            // $("#button_admin_page").attr("disabled", "disabled"); //css("visibility", "hidden");
            $("#button_profile").attr("disabled", "disabled");
            $("#button_chat").attr("disabled", "disabled");
            $("#button_new_event").attr("disabled", "disabled");
        }
    }
})