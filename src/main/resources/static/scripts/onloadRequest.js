function onLoadRequest() {
    $.ajax({
        url: "/onLoad",
        type: "GET",
        success: function (data) {
            let userData = JSON.parse(data);
            if (userData.auth.includes("ANON")) {
                $("#button_new_event").attr("disabled", "disabled");
                $("#button_chat").attr("disabled", "disabled");
                $("#button_admin").attr("disabled", "disabled"); //css("visibility", "hidden");
            }
            if (userData.auth.includes("ADMIN")) {
                $("#button_new_event").removeAttr("disabled");
                $("#button_chat").removeAttr("disabled");
                $("#button_admin").removeAttr("disabled");
            }
            if (userData.auth.includes("USER")) {
                $("#button_new_event").removeAttr("disabled");
                $("#button_chat").removeAttr("disabled");
                $("#button_admin").attr("disabled", "disabled");
            }
            if (userData.auth.includes("STRIKED")) {
                $("#button_new_event").attr("disabled", "disabled");
                $("#button_chat").removeAttr("disabled");
                $("#button_admin").attr("disabled", "disabled");
            }
            deleteLastButton();
            document.getElementById("header").
                appendChild(getLogProfileButton(userData.auth.includes("ANON"), userData));
            buttonModalsListeners();
            document.getElementById("username").innerText = JSON.parse(data).username;
        }
    })
    buttonModalsListeners();
}

// function buttonLog_Profile(userdata) {
//     let bLogReg = $("#button_log_reg");
//     let bProfile = $("#button_profile");
//     if (userdata.auth.includes("ANON")) {
//         bProfile.attr("id", "button_log_reg");
//         bLogReg.attr("data-path", "modal_log_reg");
//         bLogReg.html("sign in");
//     }
//     else {
//         bProfile.attr("id", "button_profile");
//         bLogReg.attr("data-path", "modal_profile");
//         bLogReg.html(userdata.username);
//     }
// }

// function buttonLog_Profile(userdata) {
//     document.getElementById("header").
//                             appendChild(getLogProfileButton(userdata.auth.includes("ANON"), userdata));
// }

function getLogProfileButton(isLogButton, userdata) {
    let button = document.createElement("button");
    if (isLogButton) {
        button.setAttribute("id", "button_log_reg");
        button.innerText = "sign in"
        button.classList.add("button")
    }
    else {
        button.setAttribute("id", "button_profile");
        button.innerText = userdata.username;
        button.classList.add("button")
    }
    return button;
}

function deleteLastButton() {
    let buttonLogReg = $("#button_log_reg");
    if (buttonLogReg != null)
        buttonLogReg.remove();
    else $("#button_profile").remove();
}

onLoadRequest();