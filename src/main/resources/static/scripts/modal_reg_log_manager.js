chooseLogin();

function chooseLogin() {
    $("#input_password").off("input");
    flushRegistrationInputs();
    $("#input_login").attr("placeholder", "login");
    $("#par_Register").css("font-weight", "normal");
    $("#par_Login").css("font-weight", "bold");
    $("#input_password_repeat").hide();
    $("#div_login").attr("action", "/login");
    let submit = $("#button_submit_div_login");
    submit.val("sign in");
    submit.removeAttr("disabled");
}

function chooseRegister() {
    inputChangeFunctions();
    flushRegistrationInputs();
    $("#input_login").attr("placeholder", "login");
    $("#par_Register").css("font-weight", "bold");
    $("#par_Login").css("font-weight", "normal");
    $("#input_password_repeat").show();
    $("#div_login").attr("action", "/register");
    let submit = $("#button_submit_div_login");
    submit.val("register");
    submit.attr('disabled', "disabled");
}

function changeAbilitySubmitLoginButton() {
    let inputPassword = $("#input_password");
    if (inputPassword.val() !== $("#input_password_repeat").val() || inputPassword.val() === "")
        $("#button_submit_div_login").attr("disabled", "disabled");
    else
        $("#button_submit_div_login").removeAttr("disabled");
}

function flushRegistrationInputs() {
    $("#input_login").val("");
    $("#input_phone").val("");
    $("#input_password").val("");
    $("#input_password_repeat").val("");
    $("#input_login_pass_hash").val("");
    $("#input_phone_pass_hash").val("");
}

function inputChangeFunctions() {
    onPasswordInput();
    onPasswordRepeatInput();
}

function onPasswordInput() {
    $("#input_password").on("input", function () {
        changeAbilitySubmitLoginButton();
    })
}

function onPasswordRepeatInput() {
    $("#input_password_repeat").on("input", function () {
        changeAbilitySubmitLoginButton();
    })
}

$("#button_submit_div_login").on("click", function () {
    $.ajax({
        url: $("#div_login").attr("action"),
        method: 'post',
        dataType: 'html',
        data: {
            username: $("#input_login").val(),
            password: $("#input_password").val()
        },
        success: function (data){
            if(data === "registered" || "login success") {
                modalOverlay.classList.remove("modal-overlay--visible");
                modals.forEach((e1) => {
                    if (e1 !== null)
                        e1.classList.remove("modals--visible");
                })
                onLoadRequest();
            }
            if (data === "registration failed") {
                alert("Registration failed! login is already in use.");
                flushRegistrationInputs();
            }
            if (data === "login failed") {
                alert("Login failed!");
                flushRegistrationInputs();
            }
        }
    })
});