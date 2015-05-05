<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script></head>

<% 
if (request.getAttribute("newuser")==null){
	request.getAttribute("newuser");
	request.getAttribute("message");
	request.getAttribute("valid");
}
%>

<title>Registration</title>
</head>
<body>
	<%@ include file="header.jsp"%>
		<div class="container">
		<div class="row">
			<div class="col-md-offset-2 col-md-8">
				<center>
					<h1><b>Registration</b></a></h1>
					
				</center>
			</div>
		<!-- MESSAGE : SUCCESS OR FAILED show message from arraylist-->
		<div class="row">
			<div class="col-lg-2 col-md-push-1">
		            <div class="col-md-12">
		            <%
		            	if (request.getAttribute("valid")!=null){
		            		if (request.getAttribute("valid").toString()=="true"){
		            		%><div class="alert alert-success">
		            		<strong><span class="glyphicon glyphicon-ok">
		            		<%
			            	}
			            	else {
			            		%>
			            		<div class="alert alert-danger">
		                   			 <span class="glyphicon glyphicon-remove"></span><strong>
			            		<%
			            	}
		            	}
		            %>
		                
		                    ${message}
		                    </span></strong>
		                </div>
		            </div>
		    </div>
	    </div>
	    
	    <div class="row">
	        <form role="form" action="dispatcher?operation=register" method="post">
	            <div class="col-lg-6">
	                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
	                <div class="form-group">
	                    <label for="InputName">Enter First Name</label>
	                    <div class="input-group">
	                        <input type="text" class="form-control" name="NewFirstName" id="NewFirstName" placeholder="Enter First Name" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="InputName">Enter Last Name</label>
	                    <div class="input-group">
	                        <input type="text" class="form-control" name="NewLastName" id="NewLastName" placeholder="Enter Last Name" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="InputName">Enter Username</label>
	                    <div class="input-group">
	                        <input type="text" class="form-control" name="NewUserName" id="NewUserName" placeholder="Enter Username" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="InputName">Password</label>
	                    <div class="input-group">
	                        <input type="password" class="form-control" name="NewPassword" id="NewPassword" placeholder="Enter Password" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="InputEmail">Enter Email</label>
	                    <div class="input-group">
	                        <input type="email" class="form-control" id="NewEmail" name="NewEmail" placeholder="Enter Email" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="InputEmail">Enter Contact Number</label>
	                    <div class="input-group">
	                        <input type="text" class="form-control" id="NewNumber" name="NewNumber" placeholder="Enter Contact Number" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>
	                <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right">
	            </div>
	        </form>
	    </div>
	    </div>
	</div>
</body>
</html>