/*
    Created by: Software Guild
    Date revised: 08/31/20

    Completed Behavior
    Upon successful completion of this exercise, the supplied HTML page will
    appear to be four separate views to a user, each of which displays when
    the associated main navigation buttons are clicked. The Akron, Minneapolis,
    and Louisville ‘views’ each have a section for the weather in that city.
    The Show/Hide Weather button shows and hides the weather for a given city
    as described in the requirements. Finally, the Akron, Minneapolis, and
    Louisville ‘views’ each contain a table, when you are done with the
    assignment, the non-header rows of these tables will be highlighted
    when the mouse pointer hovers over them as described in the requirements.

    All table rows (except the header row) must display with the "WhiteSmoke"
    background color when the mouse is hovering over them.
*/

function hideEverything() {
    $('#mainInfoDiv').hide();
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').hide();
};

function mainButton() {
    hideEverything();
    $('#mainInfoDiv').show();
}

function akronButton() {
    hideEverything();
    $('#akronInfoDiv').show();
    $('#akronWeather').hide();
};

function louisvilleButton() {
    hideEverything();
    $('#louisvilleInfoDiv').show();
    $('#louisvilleWeather').hide();
};

function minneapolisButton() {
    hideEverything();
    $('#minneapolisInfoDiv').show();
    $('#minneapolisWeather').hide();
};

$(document).ready(function () {
    // Page Load
    // Only the content in the Main section should display when the page is loaded.
    mainButton();
    $(document).on('click', '#mainButton', mainButton);

    // Navigation Button Behavior
    // When the Akron button is clicked, only the content in the Akron section
    // should display; the weather information for Akron should be hidden initially.
    $(document).on('click', '#akronButton', akronButton);
    

    // When the Minneapolis button is clicked, only the content in the Minneapolis
    // section should display; the weather information for Minneapolis should be
    // hidden initially.
    $(document).on('click', '#minneapolisButton', minneapolisButton);

    // When the Louisville button is clicked, only the content in the Louisville
    // section should display; the weather information for Louisville should be
    // hidden initially.
    $(document).on('click', '#louisvilleButton', louisvilleButton);
    
    // Show/Hide Weather Behavior
    // When the Show/Hide Weather button is clicked, the page should display
    // the associated weather information if it was hidden or hide the associated
    // weather information if it was showing. It should default to hidden.
    $(document).on('click', '#akronWeatherButton', function () {$(akronWeather).toggle();});
    $(document).on('click', '#louisvilleWeatherButton', function () {$(louisvilleWeather).toggle();});
    $(document).on('click', '#minneapolisWeatherButton', function () {$(minneapolisWeather).toggle();});

    // Table Row Behavior
    // The background color of any table row should change to “WhiteSmoke” when
    // the mouse pointer is hovering over the row. The background color of the
    // row should return to white when the mouse pointer is no longer hovering
    // over the row.This applies to all rows in all tables except the first
    // (header) row in a given table.The first(header) row in any table should
    // not change appearance when the mouse pointer hovers over it.
    $('tr:has(td)').hover(
        // in callback
        function () {
            $(this).css('background-color', 'WhiteSmoke');
        },
        // out callback
        function () {
            $(this).css('background-color', 'White');
        });

});