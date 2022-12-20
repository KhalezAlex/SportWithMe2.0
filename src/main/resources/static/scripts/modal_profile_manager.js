$("#div_column_user_data").on("click", function() {
    $("#div_column_user_data").off("click");
    hideSpans();
    showInputs();
})

function hideSpans() {
    $("#span_name").hide();
    $("#span_age").hide();
    $("#span_phone").hide();
    $("#span_city").hide();
    $("#span_country").hide();
}

function showInputs() {
    $("#input_name").show();
    $("#input_age").show();
    $("#input_phone").show();
    $("#select_city").show();
    $("#select_country").show();
    $("#input_submit_profile_changes").show();
    geoSelectsComplete();
}

function geoSelectsComplete() {
    $.ajax({
        url: "/loadCitiesCountries",
        type: "GET",
        success: function (data) {
            let geoData = JSON.parse(data);
            addOptions(geoData.countries,"select_country");
            addOptions(geoData.cities, "select_city"    );
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