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
<title>Bid List</title>
</head>
<body>
<body style= "text-align:center" >  
  <h1><b>Win Items</b></h1>
	<table class="table table-hover"  style="margin:0px auto; text-align: center;width:70%">
    	<c:forEach var="bid" items="${winbidlist}">
			   <tr>
			   		<td>Item ID</td>
					<td>
			   			${bid.itemId}
			   		</td>
			   	</tr>
			   	<tr>
			   		<td>Bidder ID</td>
			   		<td>
			   			${bid.bidderId}
			   		</td>
			   	</tr>
			   	<tr>
			   		<td>Bid Price</td>
			   		<td>
			   			${bid.price}
			   		</td>
			   	</tr>
			   	<tr>
			   		<td>Bid Date</td>
			   		<td>
			   			${bid.date}
			   		</td>
				</tr>
				<td>&nbsp</td>
			</c:forEach>
		</table>
		<br>
		<br>
<body style= "text-align:center" >  
  <h1><b>Bid List with highest price</b></h1>
	<table class="table table-hover"  style="margin:0px auto; text-align: center;width:70%">
    	<c:forEach var="bid" items="${highbidlist}">
			   <tr>
			   		<td>Item ID</td>
					<td>
			   			${bid.itemId}
			   		</td>
			   	</tr>
			   	<tr>
			   		<td>Bidder ID</td>
			   		<td>
			   			${bid.bidderId}
			   		</td>
			   	</tr>
			   	<tr>
			   		<td>Bid Price</td>
			   		<td>
			   			${bid.price}
			   		</td>
			   	</tr>
			   	<tr>
			   		<td>Bid Date</td>
			   		<td>
			   			${bid.date}
			   		</td>
				</tr>
				<td>&nbsp</td>
			</c:forEach>
		</table>
		<br>
		<br>
<body style= "text-align:center" >  
  <h1><b>Lost Bid List</h1></b></h1>
	<table class="table table-hover"  style="margin:0px auto; text-align: center;width:70%">
    	<c:forEach var="bid" items="${lostbidlist}">
			   <tr>
			   		<td>Item ID</td>
					<td>
			   			${bid.itemId}
			   		</td>
			   	</tr>
			   	<tr>
			   		<td>Bidder ID</td>
			   		<td>
			   			${bid.bidderId}
			   		</td>
			   	</tr>
			   	<tr>
			   		<td>Bid Price</td>
			   		<td>
			   			${bid.price}
			   		</td>
			   	</tr>
			   	<tr>
			   		<td>Bid Date</td>
			   		<td>
			   			${bid.date}
			   		</td>
				</tr>
				<td>&nbsp</td>
			</c:forEach>
		</table>
</body>

		<%
		if (request.getAttribute("from")!=null && request.getAttribute("from").equals("winnotif")){
					session.setAttribute("winsomething", false);
					request.setAttribute("from", "bidlist");
		}
		
		if (request.getAttribute("ischeck")!=null){
			session.setAttribute("ischeck", null);
}
		%>
</html>