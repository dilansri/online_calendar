<!DOCTYPE html>
<%@ page session="false"%>
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
</body>
</html>