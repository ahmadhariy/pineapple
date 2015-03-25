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
    <body>
        <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <th>User ID</th>
                <th>Username</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Birth Date</th>
                <th>Account Bank</th>
                <th>Salary</th>
            </tr>

            <c:forEach var="member" items="${employeeList}">
                <tr>
                    <td>${member.userid}</td>
                    <td>${member.username}</td>
                    <td>${member.firstname}</td>
                    <td>${member.lastname}</td>
                    <td>${member.birthdate}</td>
                    <td>${member.accbank}</td>
                    <td>${member.salary}</td>
                </tr>
            </c:forEach>
        </table>

        <%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
        <td><a href="PagginationServlet?page=${currentPage - 1}">Previous</a></td>
    </c:if>

    <%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="PagginationServlet?page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>

<%--For displaying Next link --%>
<c:if test="${currentPage lt noOfPages}">
    <td><a href="PagginationServlet?page=${currentPage + 1}">Next</a></td>
</c:if>

</body>
</html>