<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h3>Authorized users only!</h3>
<table class="formtable">
    <tr><td>Username</td><td>Email</td><td>Role</td><td>Enabled</td></tr>

    <c:forEach var="user" items="${users}">

        <tr><td><c:out value="${user.username}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.authority}"/></td>
            <td><c:out value="${user.enabled}"/></td>

        </tr>

    </c:forEach>

</table>
</body>
</html>
