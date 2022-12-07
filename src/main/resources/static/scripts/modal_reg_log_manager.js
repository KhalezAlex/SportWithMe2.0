chooseLogin();

function chooseLogin() {
    $("#input_password").off("input");
    flushRegistrationInputs();
    $("#input_login").attr("placeholder", "login");
    $("#par_Register").css("font-weight", "normal");
    $("#par_Login").css("font-weight", "bold");
    $("#input_password_repeat").hide();
    $("#form_login").attr("action", "/login");
    let submit = $("#button_submit_form_login");
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
    $("#form_login").attr("action", "/register");
    let submit = $("#button_submit_form_login");
    submit.val("register");
    submit.attr('disabled', "disabled");
}

function changeAbilitySubmitLoginButton() {
    let inputPassword = $("#input_password");
    if (inputPassword.val() !== $("#input_password_repeat").val() || inputPassword.val() === "")
        $("#button_submit_form_login").attr("disabled", "disabled");
    else
        $("#button_submit_form_login").removeAttr("disabled");
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