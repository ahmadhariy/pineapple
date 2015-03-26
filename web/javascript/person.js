// JavaScript Document

function check() {

    var username = document.forms["member"]["username"].value;
    var password = document.forms["member"]["password"].value;
    var firstname = document.forms["member"]["firstname"].value;
    var lastname = document.forms["member"]["lastname"].value;
    var birthdate = document.forms["member"]["birthdate"].value;
    var accbank = document.forms["member"]["accbank"].value;
    var salary = document.forms["member"]["salary"].value;
    if (username === null || username === "" || username === "Username") {
        alert("Username must be filled out");
        return false;
    } else if (password === null || password === "" || password === "Password") {
        alert("Password must be filled out");
        return false;
    } else if (firstname === null || firstname === "" || firstname === "First Name") {
        alert("First name must be filled out");
        return false;
    } else if (lastname === null || lastname === "" || lastname === "Last Name") {
        alert("Last name must be filled out");
        return false;
    } else if (birthdate === null || birthdate === "" || birthdate === "mm/dd/yyyy") {
        alert("Birth date must be filled out");
        return false;
    } else if (accbank === null || accbank === "" || accbank === "0") {
        alert("Account bank must be filled out");
        return false;
    } else if (salary === null || salary === "" || salary === "0.0") {
        alert("Salary must be filled out");
        return false;
    }


}


$(function test() {
    $('#submit').bind('click', function () {
        var txtVal = $('#birthdate').val();
        if (!isDate(txtVal)) {
            alert('Invalid Date\nFormat Birth Date is: YYYY-MM-DD');
            return false;
        }
    });

    function isDate(birthdate)
    {
        var currVal = birthdate;
        if (currVal == '')
            return false;

        var rxDatePattern = /^(\d{4})(\/|-)(\d{1,2})(\/|-)(\d{1,2})$/; //Declare Regex
        var dtArray = currVal.match(rxDatePattern); // is format OK?

        if (dtArray == null)
            return false;

        //Checks for mm/dd/yyyy format.
        dtMonth = dtArray[3];
        dtDay = dtArray[5];
        dtYear = dtArray[1];

        if (dtMonth < 1 || dtMonth > 12)
            return false;
        else if (dtDay < 1 || dtDay > 31)
            return false;
        else if ((dtMonth == 4 || dtMonth == 6 || dtMonth == 9 || dtMonth == 11) && dtDay == 31)
            return false;
        else if (dtMonth == 2)
        {
            var isleap = (dtYear % 4 == 0 && (dtYear % 100 != 0 || dtYear % 400 == 0));
            if (dtDay > 29 || (dtDay == 29 && !isleap))
                return false;
        }
        return true;
    }
    return false;
});

$(document).ready(function () {
    $(".userid").focus(function () {
        $(".bar-userid").css("left", "-100px");
    });
    $(".userid").blur(function () {
        $(".bar-userid").css("left", "0px");
    });

    $(".username").focus(function () {
        $(".bar-username").css("left", "-100px");
    });
    $(".username").blur(function () {
        $(".bar-username").css("left", "0px");
    });
	
	$(".password").focus(function () {
        $(".bar-password").css("left", "-100px");
    });
    $(".password").blur(function () {
        $(".bar-password").css("left", "0px");
    });
	
	$(".firstname").focus(function () {
        $(".bar-firstname").css("left", "-100px");
    });
    $(".firstname").blur(function () {
        $(".bar-firstname").css("left", "0px");
    });
	
	$(".lastname").focus(function () {
        $(".bar-lastname").css("left", "-100px");
    });
    $(".lastname").blur(function () {
        $(".bar-lastname").css("left", "0px");
    });
	
	$(".birthdate").focus(function () {
        $(".bar-birthdate").css("left", "-100px");
    });
    $(".birthdate").blur(function () {
        $(".bar-birthdate").css("left", "0px");
    });
	
	$(".accbank").focus(function () {
        $(".bar-accbank").css("left", "-100px");
    });
    $(".accbank").blur(function () {
        $(".bar-accbank").css("left", "0px");
    });
	
	$(".salary").focus(function () {
        $(".bar-salary").css("left", "-100px");
    });
    $(".salary").blur(function () {
        $(".bar-salary").css("left", "0px");
    });
});