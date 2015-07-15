<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Search</title>
</head>
<body>
<h1>Search Events</h1>
<form method="POST">
	<input name="startDate" type="text" value="${startDateString}" required />
	<input name="endDate" type="text" value="${endDateString}" required />
	<input type="submit" value="Search" />
</form>
<c:forEach  var="item" items="${result}">
	<p>${item.text}</p>
</c:forEach>
</body>
</html>