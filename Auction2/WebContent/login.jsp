<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-offset-2 col-md-8">
				<center>
					<h1>
						<b>Auction Time</b>
					</h1>

				</center>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
				<img alt="" src="login.jpg" class="img-responsive">
			</div>
			<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
				<form action="dispatcher?operation=login" method="post">
					<p></p>

					<input type="text" class="form-control" name="username"
						placeholder="username">
					<p></p>
					<input type="password" class="form-control" name="password"
						placeholder="password">
					<p></p>
					<center>
						<button type="submit" class="btn btn-primary " type="button">Login
							now!</button>
					</center>
				</form>
				<!-- MESSAGE : FAILED show message from arraylist-->
				<div class="row">
					<p></p>
					<div class="col-md-offset-0 col-md-12">
						<%
							if (request.getAttribute("valid") != null) {
								if (request.getAttribute("valid").toString() == "false") {
						%>
						<div class="alert alert-danger">
							<span class="glyphicon glyphicon-remove"></span><strong>
								<%
									}
									}
								%> <b>${message}</b>
							</strong>
						</div>
					</div>
				</div>
				<form method="get" action="registration.jsp">
					<p></p>
					<center>
						<button type="submit" class="btn btn-warning " type="button">Register
							a new account</button>
					</center>
					<p></p>
					<p></p>
				</form>
				<center>
					<a href="adminLogin.jsp">Admin Login</a>
				</center>
			</div>
		</div>
	</div>


</body>
</html>