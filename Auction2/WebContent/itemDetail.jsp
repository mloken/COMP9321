<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<title>Item Detail</title>
</head>
<%@ include file="header.jsp"%>
<body>	

		<table class="table table-hover"  style="margin:0px auto; text-align: center;width:70%">
		  <tr>
		    
		    <td colspan="2"><h1>${auctionItem.itemName}</h1></td>
		  </tr>
		  <tr>
		    
		    <td colspan="2">${auctionItem.category}</td>
		  </tr>
		  <tr>
		    <td colspan="2"><img width="600px" src="${auctionItem.picture}"></td>
		  </tr>
		  <tr>
		    <td colspan="2">${auctionItem.description}</td>
		  </tr>
		  <tr>
		    <td >reservePrice</td>
		    <td >${auctionItem.reservePrice}</td>
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
		  
		</table>
		<br><br>
		<center>
		<form ACTION='AddWishList' METHOD='GET'>
							<input type="hidden" name="id" value="${auctionItem.id}">
							<input type="submit" class="btn btn-primary" value="Cart">
		</form>		
		</center>
		<br><br>
		<center><a href= "searchResults.jsp" >Back to shopping</a></center>  
</body>
</html>