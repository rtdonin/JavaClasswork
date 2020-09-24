/*
    Created by: Software Guild
    Date revised: 08/31/20
*/

$(document).ready(function () {
    // Center all H1 elements.
    $('h1').addClass('text-center');

    // Center all H2 elements.
    $('h1').addClass('text-center');

    // Replace the class that is on the element containing
    // the text "Team Up!" with the class page-header.
    $('.myBannerHeading').addClass('page-header');
    $('.myBannerHeading').removeClass('myBannerHeading');

    // Change the text of "The Squad" to "Yellow Team".
    $('#yellowHeading').html('Yellow Team');

    // Change the background color for each team list to match the name of the team.
    $('#redHeading').css('background-color', 'red');
    $('#orangeHeading').css('background-color', 'orange');
    $('#blueHeading').css('background-color', 'blue');
    $('#yellowHeading').css('background-color', 'yellow');

    // Add Joseph Banks and Simon Jones to the Yellow Team list.
    $('#yellowTeamList').html('<li>Joseph Banks</li> <li>Simon Jones</li>');

    // Hide the element containing the text "Hide Me!!!"
    $('#oops').hide();
    
    // Remove the element containing the text "Bogus Contact Info" from the footer.
    $('#footerPlaceholder').remove();

    // Add a paragraph element containing your name and email to the footer.
    $('footer').html('<p>Margaret Donin<br />rtdonin@gmail.com<p>')
    // The text must be in Courier font and be 24 pixels in height.
    $('footer').css({ 'font-family': 'Courier', 'font-size': '24px' });
});