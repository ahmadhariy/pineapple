<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Employees</title>
    </head>
    <link href="css/home_style.css" rel="stylesheet" type="text/css" />
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
                <th>Emp ID</th>
                <th>Emp Name</th>
                <th>Salary</th>
                <th>Dept Name</th>
            </tr>
            </thead>

            <c:forEach var="employee" items="${employeeList}">
            <tbody>
                <tr>
                    <td>${employee.employeeId}</td>
                    <td>${employee.employeeName}</td>
                    <td>${employee.salary}</td>
                    <td>${employee.deptName}</td>
                </tr>
                </tbody>
            </c:forEach>
        </table>

        

    <%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>
    <table  cellspacing='0'>
        <tr>
        <%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
        <td><a href="EmployeeServlet?page=${currentPage - 1}">Previous</a></td>
    </c:if>
        
        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="EmployeeServlet?page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        
        <%--For displaying Next link --%>
<c:if test="${currentPage lt noOfPages}">
    <td><a href="EmployeeServlet?page=${currentPage + 1}">Next</a></td>
</c:if>
    </tr>
</table>


</div>
</body>
</html>