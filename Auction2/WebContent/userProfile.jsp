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
		<table class="table table-hover"  style="margin:0px auto; text-align: center;width:70%">
		  <tr>
		    
		    <td colspan="2"><h1>${user.username}</h1></td>
		  </tr>
		  <tr>
		    <td>First name</td>
		    <td >${user.firstName}</td>
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
		  

		  
		</table>
</body>
</html>