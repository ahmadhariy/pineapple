<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
${paging}
<table border="1" cellpadding="1" cellspacing="1">
    <tr>
        <td>No</td>
        <td>Id</td>
        <td>Nama</td>
        <td>Alamat</td>
    </tr>
    <c:catch var ="catchException">
        <c:if test="${param.page eq null || param.page eq '1'}">
            <c:set var="no" value="0"/>
        </c:if>
        <c:if test="${param.page gt '1'}">
            <c:set var="no" value="${param.page * perpage - perpage }"/>
        </c:if>
    </c:catch>

    <c:if test="${catchException !=null}">
        <c:set var="no" value="0"/>
    </c:if>

    <c:forEach var="testlist" items="${temp}">
        <c:set var="no" value="${no +1}"/>
        <tr>
            <td>${no} .</td>
            <td>${testlist.id}</td>
            <td>${testlist.nama}</td>
            <td>${testlist.alamat}</td>
        </tr>
    </c:forEach></table>
${paging}