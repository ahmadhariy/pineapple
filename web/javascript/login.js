/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function check() {

    var username = document.forms["login"]["username"].value;
    var password = document.forms["login"]["password"].value;
    if (username === null || username === "" || username === "Username") {
        alert("Username must be filled out");
        return false;
    } else if (password === null || password === "" || password === "Password") {
        alert("Password must be filled out");
        return false;
    }


}

function preventBack() {
    window.history.forward();
}
setTimeout("preventBack()", 0);
window.onunload = function () {null};

$(document).ready(function () {
    $(".username").focus(function () {
        $(".user-icon").css("left", "-48px");
    });
    $(".username").blur(function () {
        $(".user-icon").css("left", "0px");
    });

    $(".password").focus(function () {
        $(".pass-icon").css("left", "-48px");
    });
    $(".password").blur(function () {
        $(".pass-icon").css("left", "0px");
    });
});