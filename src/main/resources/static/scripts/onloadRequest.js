function onLoadRequest() {
    $.ajax({
        url: "/onLoad",
        type: "GET",
        success: function (data) {
            let userData = JSON.parse(data);

            if (userData.auth.includes("ANON")) {
                $("#button_new_event").attr("disabled", "disabled");
                $("#button_chat").attr("disabled", "disabled");
                $("#button_admin_page").attr("disabled", "disabled"); //css("visibility", "hidden");
                buttonLog_Profile(userData)
            }
            if (userData.auth.includes("ADMIN")) {
                $("#button_new_event").removeAttr("disabled");
                $("#button_chat").removeAttr("disabled");
                $("#button_admin_page").removeAttr("disabled");
                buttonLog_Profile(userData);

            }
            if (userData.auth.includes("USER")) {
                $("#button_new_event").removeAttr("disabled");
                $("#button_chat").removeAttr("disabled");
                $("#button_admin_page").attr("disabled", "disabled");
                buttonLog_Profile(userData)
            }
            if (userData.auth.includes("STRIKED")) {
                $("#button_new_event").attr("disabled", "disabled");
                $("#button_chat").removeAttr("disabled");
                $("#button_admin_page").attr("disabled", "disabled");
                buttonLog_Profile(userData);
            }
        }
    })
}

function buttonLog_Profile(userdata) {
    let bLogReg = $("#button_log_reg_form");
    let bProfile = $("#button_profile");
    console.log(userdata.auth);
    console.log(userdata.username);
    if (userdata.auth.includes("ANON")) {
        bProfile.attr("id", "button_log_reg_form");
        bLogReg.attr("data-path", "modal_log_reg");
        bLogReg.html("sign in");
    }
    else {
        bProfile.attr("id", "button_profile");
        bLogReg.attr("data-path", "modal_profile");
        bLogReg.html(userdata.username);
    }
}

onLoadRequest();