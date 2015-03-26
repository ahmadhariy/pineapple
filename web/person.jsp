<%@page import="com.hariy.model.Member"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link href="css/addedit_style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
    <script src="javascript/person.js"></script>
    <script src="javascript/sweet-alert.min.js"></script> 
        <link rel="stylesheet" type="text/css" href="css/sweet-alert.css">
            </script>


    <body>
    <div id="wrapper">
    <div class="bar-userid"><p>user id</p></div>
            <div class="bar-username"><p>username</p></div>
            <div class="bar-password"><p>password</p></div>
            <div class="bar-firstname"><p>first name</p></div>
            <div class="bar-lastname"><p>last name</p></div>
            <div class="bar-birthdate"><p>birth date</p></div>
            <div class="bar-accbank"><p>acc. bank</p></div>
            <div class="bar-salary"><p>salary</p></div>
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

            <form method="post" action="Member" name="member" class="member" onsubmit="test()">
                <%
                    Member person = (Member) request.getAttribute("person");
                %>                
                <input type="hidden" name="type" id="type" value="<%= person.getType()%>" >
                <input type="text" name="userid" class="input userid" id="userid" value="<%= person.getUserid()%>" readonly="true">
                <input type="text" name="username" class="input username" id="username" value="<%= person.getUsername()%>" onfocus="this.value = ''">
                <input type="password" name="password" class="input password" id="password" value="<%= person.getPassword()%>" onfocus="this.value = ''">
                <input type="text" name="firstname" class="input firstname" id="firstname" value="<%= person.getFirstname()%>" onfocus="this.value = ''">
                <input type="text" name="lastname" class="input lastname" id="lastname" value="<%= person.getLastname()%>" onfocus="this.value = ''">
                <input type="date" name="birthdate" class="input birthdate" id="birthdate" value="<%= person.getBirthdate()%>" onfocus="this.value = ''">
                <input name="accbank" type="text" class="input accbank" id="accbank" onfocus="this.value = ''" value="<%= person.getAccbank()%>">
<input type="text" name="salary" class="input salary" id="salary" value="<%= person.getSalary()%>" onfocus="this.value = ''">
                <input type="submit" value="Save" class="button" onclick="return check()"/>
            </form>
        </div>
        </div>
    </body>
</html>