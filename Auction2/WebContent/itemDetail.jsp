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
<title>Item Detail</title>
</head>
<%@ include file="header.jsp"%>
<body>	
<%
	if (request.getAttribute("valid")!=null && request.getAttribute("valid").toString()=="false"){
		%>
		<center><font color= "red" >${message}</font></center>
		<%
	}
%>
	<form ACTION='dispatcher?operation=bid' METHOD='POST'>
		<table class="table table-hover"  style="margin:0px auto; text-align: center;width:70%">
		  <tr>
		    
		    <td colspan="2"><h1>${auctionItem.itemName}</h1></td>
		  </tr>
		  <tr>
		    
		    <td colspan="2">${auctionItem.category}</td>
		  </tr>
		  <tr>
		    <td colspan="2"><img width="400px" src="${auctionItem.picture}"></td>
		  </tr>
		  <tr>
		    <td colspan="2">${auctionItem.description}</td>
		  </tr>
		  <tr>
		    <td >Current Price</td>
		    <td >${currentprice}</td>
		  </tr>
		  <tr>
		    <td >biddingStartPrice</td>
		    <td >${auctionItem.biddingStartPrice}</td>
		  </tr>
		  <tr>
		    <td >biddingIncrements</td>
		    <td >${auctionItem.biddingIncrements}</td>
		  </tr>
		  <tr>
		    <td >endTime</td>
		    <td>${auctionItem.endTime}</td>
		  </tr>
		  <tr>
		    <td >id</td>
		    <td >${auctionItem.id}</td>
		  </tr>
		  <tr>
			<td>Street Address</td>
			<td>${auctionItem.address.streetAddress }</td>
		 </tr>
		 <tr>
			<td>City</td>
			<td>${auctionItem.address.city }</td>
		 </tr>
		 <tr>
			<td>State</td>
			<td>${auctionItem.address.state }</td>
		 </tr>
		 <tr>
			<td>Country</td>
			<td>${auctionItem.address.country }</td>
		 </tr>
		 <tr>
			<td>Postal Code</td>
			<td>${auctionItem.address.postalCode }</td>
		 </tr>
		  <tr>
		 	<td>Input Bid Price</td>
		 	<td><input type="text" class="form-control" id="bidPrice" name="bidPrice" placeholder="0.00" required></td>
		 </tr>
		  
		</table>
		<br><br>
		<center>
							<input type="hidden" name="iid" value="${auctionItem.id}">
							<input type="hidden" name="uid" value="${user.uid}">
							<input type="submit" class="btn btn-danger" value="Bid">
		</center>
		</form>		
		
		<br><br>

		<center>
		<form ACTION='dispatcher?operation=addToWishList' METHOD='post'>
							<input type="hidden" name="itemId" value="${auctionItem.id}">
							<input type="hidden" name="searchKey" value="">
							<input type="hidden" name="message" value="Item Added to Wishlist">
							<input type="submit" class="btn btn-primary" value="Add to Wishlist">
		</form>			
		</center>
		<br><br>
		<center><a href= homepage.jsp" class="btn btn-warning">Back to shopping</a></center>  
</body>
</html>