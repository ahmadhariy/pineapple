<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Login</title>

        <link href="css/login_style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
        <script>
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
        </script>
    </head>
    <body>
        <div id="wrapper">
            <div class="user-icon"></div>
            <div class="pass-icon"></div>
            <form method="post" name="login" class="login" action="Login" onsubmit="check()">
                <div class="header">
                    <h1>Login</h1>
                    <span>Please login first to access the Member Maintenance.</span>
                </div>
                <div class="content">
                    <input type="text" name="username" class="input username" id="username" value="Username" onfocus="this.value = ''"/>
                    <input type="password" name="password" class="input password" id="password" value="Password" onfocus="this.value = ''"/>
                </div>
                <div class="footer">
                    <input type="submit" value="Login" name="login" class="button"/>
                </div>
            </form>
        </div>

    </body>
</html>