<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
	<form action="dispatcher?operation=adminLogin" method="post">
		<center>
		<h2>Admins login here:</h2>
		<p></p>

		<input type="text" class="form-control" name="username"
			placeholder="username">
		<p></p>
		<input type="text" class="form-control" name="password"
			placeholder="password">
		<p></p>
			<button type="submit" class="btn btn-primary " type="button">Login
				now!</button>
		</center>
	</form>
</body>
</html>