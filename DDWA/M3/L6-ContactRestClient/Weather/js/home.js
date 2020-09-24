/*
    Name: Margaret Donin
    Date Created: 09/08/20
    Date revised:
*/

// hides lines, current weather, 5 day weather
function hideWeather() {
    $('#current, #five-day, .display-weather').hide();
};

function showWeather() {
    $('#current, #five-day, .display-weather').show();
};

function hideError() {
    $('#error-message').hide();
};

function showError() {
    $('#error-message').show();
};

function validateZipcode(zip) {
    let pattern = new RegExp("[^0-9]");
    let compare = pattern.test(zip);
    
    if (zip.length != 5 || compare) {
        return false;
    } else {
        return true;
    }
};

function currentWeather(zip, units) {
    $.ajax ({
        type: 'GET',
        url: 'api.openweathermap.org/data/2.5/weather?zip=' + zip
            + '&units=' + units + '&appid=2422067ea2a423947ea2f2b9c1145396',
        dataType: "json",
        success: function (data) {
            // gather data
            var icon = data.weather.icon; // number for img src
            var description = data.weather.main + ': ' + data.weather.description;
            
            // input data
            $('#city').html(data.name);
            $('#icon').html(`<img src = "http://openweathermap.org/img/w/` + icon + `.png" />`);
            $('#current-description').html(description);
            $('#current-temperature').html(data.main.temp);
            $('#current-humidity').html(data.main.humidity);
            $('#current-wind').html(data.wind.speed);

        },
        error: function(data) {
            alert('something went wrong');
        }
    });
    
};

function fiveDayWeather(zip, units) {
    // api.openweathermap.org/data/2.5/forecast?zip={zip code},{country code}&appid={your api key}
}

// organizes the info
function getWeather() {
    var zip = $('#zipcode').val();
    var units = $('#units').val() == 1 ? 'imperial' : 'metric';

    console.log("Hello");
    console.log(validateZipcode(zip));

    // validate zipcode
    if (validateZipcode(zip)) {
        currentWeather(zip, units);
        fiveDayWeather(zip, units);

        showWeather();
    } else {
        hideWeather();
        showError();
    }
};

/************************************************************
 * 
 * THE READY FUNCTION
 * 
 ************************************************************/
$(document).ready(function () {
    hideError();
    hideWeather();
    $(document).on('click', '#button', getWeather);
});