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
    chooseLogin();
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
    $("#button_log_reg").remove();
    $("#button_profile").remove();
    // let logRegBtn = $("#button_log_reg");
    // if (logRegBtn !== null)
    //     logRegBtn.remove();
    // else
    //     $("#button_profile").remove();
}

function getLogProfileButton(isLogButton, userdata) {
    let button = document.createElement("button");
    if (isLogButton) {
        button.setAttribute("id", "button_log_reg");
        button.innerText = "sign in"
        button.classList.add("button")
    } else {
        button.setAttribute("id", "button_profile");
        button.innerText = userdata.user.username;
        button.classList.add("button")
    }
    return button;
}

function displayUserData(userData) {
    if (userData.user === undefined)
        return;
    $("#span_username").html("#" + userData.user.username);
    displayName(userData.user.name);
    displayAge(userData.user.age);
    displayPhone(userData.user.phone);
    displayGeoData(userData.user.city)
}

function displayName(name) {
    if (name === undefined)
        return;
    $("#span_name").html("name: " + name);
    $("#input_name").val(name);
}

function displayAge(age) {
    if (age === undefined)
        return;
    $("#span_age").html("age: " + age);
    $("#input_age").val(age);
}

function displayPhone(phone) {
    if (phone === undefined)
        return;
    $("#span_phone").html("phone: " + phone);
    $("#input_phone").val(phone);
}

function displayGeoData(city) {
    if (city === undefined)
        return;
    $("#span_city").html("city: " + city.name);
    $("#span_country").html("country: " + city.country.name);

}

onLoadRequest();