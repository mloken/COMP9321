<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script></head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<% 
if (request.getAttribute("newuser")==null){
	request.getAttribute("newuser");
	request.getAttribute("message");
	request.getAttribute("valid");
}
%>

<title>Edit Profile</title>
</head>
<%@ include file="header.jsp"%>
<body>
		<div class="container">
		<div class="row">
			<div class="col-md-offset-2 col-md-8">
				<center>
					
					<h1><b>Edit ${user.nickname}'s Profile</b></h1>
					
				</center>
			</div>
		<!-- MESSAGE : SUCCESS OR FAILED show message from arraylist-->
		<div class="row">
			<div class="col-md-offset-2 col-md-8">
		           
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
		                
		                    <b>${message}</b>
		                    
		                    </span></strong>
		                </div>
		            
		    </div>
	    </div>
	    
	    <div class="row">
	        <form role="form" action="dispatcher?operation=editProfile" method="post">
	            <div class="col-md-offset-2 col-md-8">
	                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
	                <div class="form-group">
	                    <label for="InputName">Username</label>
	                    <div class="input-group">
	                       <font style="red">${user.username} </font>
	                       
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="InputName">First Name</label>
	                    <div class="input-group">
	                        <input type="text" class="form-control" name="NewFirstName" id="NewFirstName" value="${user.firstName }" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="InputName">Last Name</label>
	                    <div class="input-group">
	                        <input type="text" class="form-control" name="NewLastName" id="NewLastName" value="${user.lastName }" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="InputName">Nickname</label>
	                    <div class="input-group">
	                        <input type="text" class="form-control" name="NewNickname" id="NewNickname" value="${user.nickname}" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>

	                <div class="form-group">
	                    <label for="InputName">Password</label>
	                    <div class="input-group">
	                        <input type="password" class="form-control" name="NewPassword" id="NewPassword" value="${user.password}" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="InputEmail">Email</label>
	                    <div class="input-group">
	                        <input type="email" class="form-control" id="NewEmail" name="NewEmail" value="${user.email}" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="InputEmail">Contact Number</label>
	                    <div class="input-group">
	                        <input type="text" class="form-control" id="NewNumber" name="NewNumber" value="${user.contactNumber}" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="InputEmail">Year of Birth</label>
	                    <div class="input-group">
	                        <input type="text" class="form-control" id="NewYearOfBirth" name="NewYearOfBirth" value="${user.yearOfBirth}" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="InputEmail">Credit Card Number</label>
	                    <div class="input-group">
	                        <input type="text" class="form-control" id="NewCreditCard" name="NewCreditCard" value="${user.creditCard}" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="InputEmail">Street Address</label>
	                    <div class="input-group">
	                        <input type="text" class="form-control" id="NewStreetAddress" name="NewStreetAddress" value="${user.address.streetAddress}" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="InputEmail">City</label>
	                    <div class="input-group">
	                        <input type="text" class="form-control" id="NewCity" name="NewCity" value="${user.address.city}" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="InputEmail">State</label>
	                    <div class="input-group">
	                        <input type="text" class="form-control" id="NewState" name="NewState" value="${user.address.state}" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="InputEmail">Country</label>
	                    <div class="input-group">
	                        <input type="text" class="form-control" id="NewCountry" name="NewCountry" value="${user.address.country}" required>
	                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="InputEmail">Postal Code</label>
	                    <div class="input-group">
	                        <input type="text" class="form-control" id="NewPostalCode" name="NewPostalCode" value="${user.address.postalCode}" required>
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