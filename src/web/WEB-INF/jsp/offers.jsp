<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="rs" dataSource="jdbc/spring">
    select * from springtutorial.offers
</sql:query>

<html>
<head>
    <title>DB Test</title>
</head>
<body>

<h2>Results</h2>

<c:forEach var="offer" items="${offers}">
    <p>
        <c:out value="${offer}"/>
    </p>
</c:forEach>
</body>
</html>