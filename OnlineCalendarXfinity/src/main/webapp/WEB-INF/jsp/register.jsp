<!DOCTYPE html>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
</head>
<body>
    <h1>Registration Page</h1>
    <form action="./registerUser.html" method="POST">
    	<input name="username" required />
    	<input type="password" name="password" required />
    	<input type="submit" value="SUBMIT" />
    </form>
</body>
</html>