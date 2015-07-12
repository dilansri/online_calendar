<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
</head>
<body>
    <h1>Share Calendar Page</h1>
    <form action="./shareCalendar.html" method="POST">
    	<input name="shared_with" required />
    	<input type="submit" value="SHARE" />
    </form>
    <h2>Shared With me</h2>
    <ul>
    <c:forEach var="item" items="${sharedWithMeUsers}">
    	<li><a href="./viewCalendar.html?user=${item}"><c:out value="${item}"/></a></li>
    </c:forEach>
    </ul>
    
    <h2>Shared By me</h2>
    <ul>
    <c:forEach var="item" items="${sharedByMeUsers}">
    	<li><c:out value="${item}"/></li>
    </c:forEach>
    </ul>
</body>
</html>