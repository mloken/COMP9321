<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<title>User Profile</title>
</head>
<%@ include file="header.jsp"%>
<body>	
		<center><h1><b>User Profile</b></h1></center>
		<div class="container">
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
			<div class="col-md-offset-2 col-md-8">
			<table class="table table-hover"  style="margin:0px auto; text-align: center;">
			  <tr>
			    
			    <td colspan="2"><h1>${user.username}</h1></td>
			  </tr>
			  <tr>
			    <td><b>First name</b></td>
			    <td>${user.firstName}</td>
			 </tr>
	
	  			
			  <tr>
			     <td>Last name</td>
			    <td>${user.lastName}</td>
			  </tr>
			  <tr>
			    <td>Email</td>
			    <td>${user.email}</td>
			  </tr>
			  <tr>
			    <td >Contact number</td>
			    <td >${user.contactNumber}</td>
			  </tr>
			  <tr>
			    <td >Contact number</td>
			    <td >${user.contactNumber}</td>
			  </tr>
			  <tr>
			    <td >nickname</td>
			    <td >${user.nickname}</td>
			  </tr>
			  <tr>
			    <td >year_of_birth</td>
			    <td >${user.yearOfBirth}</td>
			  </tr>
			  <tr>
			    <td >credit card</td>
			    <td >${user.creditCard}</td>
			  </tr>
			  <tr>
			    <td >Address</td>
			    <td >${user.address.streetAddress}, ${user.address.city}, ${user.address.state}, ${user.address.country}, ${user.address.postalCode}</td>
			  </tr>
			  <tr>
			    <td >Password</td>
			    <td >${user.password}</td>
			  </tr>
	
			  
	
			  
			</table>
		
			<center>
				<a href= "./editUserProfile.jsp" class="btn btn-info">Edit</a>  
			</center>
			</div>
			</div>
		</div>
</body>
</html>