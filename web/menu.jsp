<%-- 
    Document   : menu
    Created on : 25 Feb 15, 16:52:06
    Author     : INTEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <link href="css/menu_style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
    <script language="javascript">
        function popup() {

            window.open("Home", "_blank", "scrollbars=1,resizable=1,height=500,width=700");
        }



    </script>
    <body>
        <div class="header">

            <span class="left">
                Welcome, <%= session.getAttribute("login")%>!
            </span>
            <span class="right">
                <form action="UserLogout" class="logout">
                    <input type="submit" value="Logout" class="button"/>
                </form>
            </span>
        </div>

        <div class="content">
            <h1>Welcome</h1>
            <span>Welcome to Member Maintenance system. To process all the system, click button below.</span>
            <form action="Home" class="home">
                <input type="submit" value="Process" class="button"/>
            </form>
        </div>
    </center>

</body>
</html>

