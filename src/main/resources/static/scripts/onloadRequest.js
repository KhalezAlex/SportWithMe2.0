function onLoadRequest() {
    $.ajax({
        url: "/onLoad",
        type: "GET",
        success: function (data) {
            let userData = JSON.parse(data);
            refreshHeaderButtons(userData);
            displayUserData(userData);
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

function displayUserData(userData) {
    console.log(userData);
    if (userData.user !== undefined) {
        $("#span_username").html("#" + userData.user.username);
        if (userData.user.name !== undefined)
            $("#span_name").html("name: " + userData.user.name);
        if (userData.user.age !== undefined)
            $("#span_age").html("age: " + userData.user.age);
        if (userData.user.phone !== undefined)
            $("#span_phone").html("phone: " + userData.user.phone);
        if (userData.user.city !== undefined) {
            $("#span_city").html("city: " + userData.user.city.name);
            $("#span_country").html("country: " + userData.user.city.country.name);
        }
    }
}


onLoadRequest();