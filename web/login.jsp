<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Login</title>

        <link href="css/login_style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
        <script src="javascript/login.js"></script>
  </script>
        
        <%
            String err = (String) request.getAttribute("err");
            if (err != null) {
        %>
        <script type="text/javascript">
            alert('<%=err%>');
        </script>
        <%
            }
        %>
    </head>
    <body>
        <div id="wrapper">
            <div class="user-icon"><p>username</p></div>
            <div class="pass-icon"><p>password</p></div>
            <form method="post" name="login" class="login" action="Login">
                <div class="header">
                    <h1>Login</h1>
                    <span>Please login first to access the Member Maintenance.</span>
                </div>
                <div class="content">
                    <input type="text" name="username" class="input username" id="username" value="Username" onfocus="this.value = ''"/>
                    <input type="password" name="password" class="input password" id="password" value="Password" onfocus="this.value = ''"/>
                </div>
                <div class="footer">
                    <input type="submit" value="Login" name="login" class="button" onclick="return check()"/>
                </div>
            </form>
        </div>
    </body>
</html>