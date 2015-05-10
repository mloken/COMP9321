<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<%@ include file="header.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<title>Successful Bid</title>
  
  </head>  
    
  <body style= "text-align:center" >  
  <h1><b>You have successfully bid</b></h1>  
    
 
 <%
 	if (request.getAttribute("win").toString()=="true"){
 		%>
 		<h1><b>And you won the item! Congratulations!</b></h1>
 		<%
 	}
 %>
	 <h2>____________</h2>  
 
   see  
    <a href="dispatcher?operation=showBidList">My Bidlist</a> 
    
    