<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.hariy.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link href="css/home_style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
    <script language="javascript">
        function addRecord() {

            window.location.href = "Member?act=insert";
        }

        function check() {
            if (!form.x.value) {
                alert("Please fill the keyword to search..");
                return (false);
            }
            return (true);
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
            </span></div>
        <div class="content">
        <input type="button" class="add" value="Add"onclick="addRecord();">
      <input type="button" class="search" value="Search"onclick="addRecord();">
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

                    for (int i = 0; i < listMember.size(); i++) {

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
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </body>
</html>