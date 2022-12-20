function onLoadRequest() {
    $.ajax({
        url: "/onLoad",
        type: "GET",
        success: function (data) {
            refreshHeaderButtons(JSON.parse(data));
        }
    })
    buttonModalsListeners();
}

function refreshHeaderButtons(userData) {
    if (userData.user === undefined)
        anonUserButtons();
    else {
        if (userData.user.roles[0].includes("ADMIN"))
            adminUserButtons();
        if (userData.user.roles[0].includes("USER"))
            userUserButtons();
        if (userData.user.roles[0].includes("STRIKED"))
            strikedUserButtons();
        refreshLoginProfileButton(userData);
    }
}

function anonUserButtons() {
    $("#button_new_event").attr("disabled", "disabled");
    $("#button_chat").attr("disabled", "disabled");
    $("#button_admin").attr("disabled", "disabled");
}

function adminUserButtons() {
    $("#button_new_event").removeAttr("disabled");
    $("#button_chat").removeAttr("disabled");
    $("#button_admin").removeAttr("disabled");
}

function userUserButtons() {
    $("#button_new_event").removeAttr("disabled");
    $("#button_chat").removeAttr("disabled");
    $("#button_admin").attr("disabled", "disabled");
}

function strikedUserButtons() {
    $("#button_new_event").attr("disabled", "disabled");
    $("#button_chat").removeAttr("disabled");
    $("#button_admin").attr("disabled", "disabled");
}

function refreshLoginProfileButton(userData) {
    deleteLastButton();
    document.getElementById("header").
        appendChild(getLogProfileButton(userData.user.roles[0].includes("ANON"), userData));
    buttonModalsListeners();
    document.getElementById("username").innerText = userData.username;
}

function deleteLastButton() {
    let logRegBtn = $("#button_log_reg");
    if (logRegBtn != null)
        logRegBtn.remove();
    else $("#button_profile").remove();
}

function getLogProfileButton(isLogButton, userdata) {
    let button = document.createElement("button");
    if (isLogButton) {
        button.setAttribute("id", "button_log_reg");
        button.innerText = "sign in"
        button.classList.add("button")
    }
    else {
        button.setAttribute("id", "button_profile");
        button.innerText = userdata.user.username;
        button.classList.add("button")
    }
    return button;
}


onLoadRequest();



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