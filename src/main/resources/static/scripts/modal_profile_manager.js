function clickToUpdateProfileListener() {
    $("#div_column_user_data").on("click", function() {
        $("#div_column_user_data").off("click");
        hideSpans();
        showInputs();
    })
}

function hideSpans() {
    $("#span_name").hide();
    $("#span_age").hide();
    $("#span_phone").hide();
    $("#span_city").hide();
    $("#span_country").hide();
}

function showSpans() {
    $("#span_name").show();
    $("#span_age").show();
    $("#span_phone").show();
    $("#span_city").show();
    $("#span_country").show();
}

function showInputs() {
    $("#input_name").show();
    $("#input_age").show();
    $("#input_phone").show();
    $("#select_city").show();
    $("#select_country").show();
    $("#button_submit_profile_changes").show();
    geoSelectsComplete();
}

function hideInputs() {
    $("#input_name").hide();
    $("#input_age").hide();
    $("#input_phone").hide();
    $("#select_city").hide();
    $("#select_country").hide();
    $("#button_submit_profile_changes").hide();
}

function geoSelectsComplete() {
    $.ajax({
        url: "/loadCitiesCountries",
        type: "GET",
        success: function (data) {
            let geoData = JSON.parse(data);
            addOptions(geoData.countries,"select_country");
            addOptions(geoData.cities, "select_city");
            setUserGeoDataSelected();
        }
    })
}

function getOption(id) {
    let option = document.createElement("option");
    option.innerHTML = id;
    return option;
}

function addOptions(values, selectId) {
    for (let i = 0; i < values.length; i ++)
        document.getElementById(selectId).appendChild(getOption(values[i]));
}

function setUserGeoDataSelected() {
    $.ajax({
        url: "/onLoad",
        type: "GET",
        success: function (data) {
            let userData = JSON.parse(data);
            if (userData.user.city === undefined)
                return;
            document.getElementById("select_country").value = userData.user.city.country.name;
            document.getElementById("select_city").value = userData.user.city.name;
        }
    })
}

function setSubmitChangesButtonListener() {
    $("#button_submit_profile_changes").on('click', function() {
        $.ajax({
            url: "/updateProfile",
            type: "GET",
            data: {
                username: $("#span_username").text().substring(1),
                name: $("#input_name").val(),
                age: $("#input_age").val(),
                phone: $("#input_phone").val(),
                cityName: $("#select_city").val()
            },
            success: function(data) {
                console.log(data);
            }
        })
    })
}

clickToUpdateProfileListener();
setSubmitChangesButtonListener();