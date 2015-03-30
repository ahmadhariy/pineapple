<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.hariy.model.*" %>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Member Maintenance</title>
</head>
<link href="css/home_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script src="javascript/home.js"></script>
<script src="javascript/sweet-alert.min.js"></script> 
<link rel="stylesheet" type="text/css" href="css/sweet-alert.css">
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
        </span></div>
    <div class="content">
        <form method="post" class="formSearch" id="formSearch" action="Member?act=search">
            <input type="button" class="add" value="Add"onclick="addRecord();">
            <input type="hidden" value="search" name="type" id="type"/>
            <input type="text" name="inputSearch" class="inputSearch" id="inputSearch" value="Search Data By.." 
                   onfocus="if (this.value == 'Search Data By..') {
                               this.value = '';
                           }">
            <select name="searchBy" class="searchBy" id="searchBy">
                <option value="userid">User ID</option>
                <option value="username">Username</option>
                <option value="firstname">Firstname</option>
            </select>
            <input type="submit" class="search" value="Search"onclick="search();">
        </form>
        <table  cellspacing='0'>
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Username</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Birth Date</th>
                    <th>Account Bank</th>
                    <th>Salary</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <%

                DecimalFormat df = new DecimalFormat("'Rp.'###,###,###.00");
                ArrayList<Member> listMember = (ArrayList<Member>) request.getAttribute("listPerson");

                boolean data = false;
                for (int i = 0; i < listMember.size(); i++) {
                    data = true;
            %>

            <tbody>
                <tr>
                    <td><%= listMember.get(i).getUserid()%></td>
                    <td><%= listMember.get(i).getUsername()%></td>
                    <td><%= listMember.get(i).getFirstname()%></td>
                    <td><%= listMember.get(i).getLastname()%></td>
                    <td><%= listMember.get(i).getBirthdate()%></td>
                    <td><%= listMember.get(i).getAccbank()%></td>
                    <td><%= df.format(listMember.get(i).getSalary())%></td>
                    <td><a href="Member?act=edit&no=<%= listMember.get(i).getUserid()%>">Edit</a></td>
                    <td><a href="Member?act=delete&no=<%= listMember.get(i).getUserid()%>">Delete</a></td>


                    <%
                        }
                        if (!data) {
                    %>
                    <td colspan="9"><center><b>-- No Record --</b></center></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</body>
</html>