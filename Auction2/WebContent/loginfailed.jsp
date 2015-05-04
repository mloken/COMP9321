<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script></head>
<body >
	
	<div class="container">
		<div class="row">
			<div class="col-md-offset-2 col-md-8">
				<center>
					<h1><a href="login"><b>Auction Time</b></a></h1>
					
				</center>
			</div>
		</div>
		<div class="row">
             <div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
					<img alt="" src="login.jpg" class="img-responsive">
			 </div>
			 <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
					<form action="UserService" method="GET">
						<center><p style="color:red;">Could not connect to database</p></center>
						<input type="text" class="form-control"  name="username" placeholder="username">
						<p></p>
						<input type="text" class="form-control"  name="password" placeholder="password">
						<p></p>
						<center><button type="submit" class="btn btn-primary " type="button">LOGIN!</button></center>
					</form>
						
			</div>
		</div>
	</div>
	
	
</body>
</html>