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
    <script lang="javascript">
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

            <form method="post" action="Member" class="member" onsubmit="test()">
                <%
                    Member person = (Member) request.getAttribute("person");
                %>                
                <input type="hidden" name="type" id="type" value="<%= person.getType()%>" >
                <input type="text" name="userid" class="input userid" id="userid" value="<%= person.getUserid()%>" readonly="true">
                <input type="text" name="username" class="input username" id="username" value="Username" onfocus="this.value = ''">
                <input type="password" name="password" class="input password" id="password" value="Password" onfocus="this.value = ''">
                <input type="text" name="firstname" class="input firstname" id="firstname" value="First Name" onfocus="this.value = ''">
                <input type="text" name="lastname" class="input lastname" id="lastname" value="Last Name" onfocus="this.value = ''">
                <input type="date" name="birthdate" class="input birthdate" id="birthdate" value="Birth Date" onfocus="this.value = ''">
                <input type="text" name="accbank" class="input accbank" id="accbank" value="Account Bank" onfocus="this.value = ''">
                <input type="text" name="salary" class="input salary" id="salary" value="Salary" onfocus="this.value = ''">
                <input type="submit" value="Save" class="button"/>
            </form>
        </div>
    </body>
</html>