/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function check() {

    var username = document.forms["login"]["username"].value;
    var password = document.forms["login"]["password"].value;
    if (username === null || username === "" || username === "Username") {
		sweetAlert("Oops...", "Are you forget to type your username?", "error");
        return false;
    } else if (password === null || password === "" || password === "Password") {
        sweetAlert("Oops...", "Are you forget to type your password?", "error");
        return false;
    }


}

function preventBack() {
    window.history.forward();
}
setTimeout("preventBack()", 0);
window.onunload = function () {
    null
};

$(document).ready(function () {
    $(".username").focus(function () {
        $(".user-icon").css("left", "-100px");
    });
    $(".username").blur(function () {
        $(".user-icon").css("left", "0px");
    });

    $(".password").focus(function () {
        $(".pass-icon").css("left", "-100px");
    });
    $(".password").blur(function () {
        $(".pass-icon").css("left", "0px");
    });
});

