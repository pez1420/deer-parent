/*!
 * navFixed.min.js
 */ 
$(document).ready(function () {
    if ($(window).height() < $(document).height()) {
        $('#register').css("position", "fixed");
    }
    $(window).scroll(function () {
        if ($(window).scrollTop() >= 100) {
            $('#register').css("position", "relative");
        } else {
            $('#register').css("position", "fixed");
        }
        if ($(window).scrollTop() + $(window).height() >= $(document).height() - 100) {
            $('#register').css("position", "relative");
        } else {
            $('#register').css("position", "fixed");
        }
    });
});
