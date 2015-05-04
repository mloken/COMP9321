<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script></head>
<title>Item Detail</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-2 col-md-8">
				<center>
					<h1><b>Item Name : ${displayedItem.title}</b></h1>
					<table>
		<tr>
			<td><b>Info</b></td>
		</tr>
		<tr>
			<td>Title</td>
			<td>${displayedItem.title }</td>
		</tr>
		<tr>
			<td>Category</td>
			<td>${displayedItem.category }</td>
		</tr>
		<tr>
			<td>Picture</td>
			<td>${displayedItem.picture }</td>
		</tr>
		<tr>
			<td>Description</td>
			<td>${displayedItem.description }</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><b>Postal Address</b></td>
		</tr>
		<tr>
			<td>Street Address</td>
			<td>${displayedItem.postalAddress.streetAddress }</td>
		</tr>
		<tr>
			<td>City</td>
			<td>${displayedItem.postalAddress.city }</td>
		</tr>
		<tr>
			<td>State</td>
			<td>${displayedItem.postalAddress.state }</td>
		</tr>
		<tr>
			<td>Country</td>
			<td>${displayedItem.postalAddress.country }</td>
		</tr>
		<tr>
			<td>Postal Code</td>
			<td>${displayedItem.postalAddress.postalCode }</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><b>Cost</b></td>
		</tr>
		<tr>
			<td>Reserve Price</td>
			<td>${displayedItem.reservePrice }</td>
		</tr>
		<tr>
			<td>Bidding Start Price</td>
			<td>${displayedItem.biddingStartPrice }</td>
		</tr>
		<tr>
			<td>Bidding Increments</td>
			<td>${displayedItem.biddingIncrements }</td>
		</tr>
		<tr>
			<td>End Time</td>
			<td>${displayedItem.endTime.toString() }</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>
			
				<form action='control' method='POST'>
					<input type='hidden' name='action' value='addToWishlist' /> <input
						type='hidden' name='auctionItemId' value="${displayedItem.id}" />
					<input type='hidden' name='prevPage' value="displayAuction" /> <input
						type='submit' value='Add to wishlist'
						style="height: 25px; width: 200px">
				</form>
			</td>
		</tr>
	</table>
				</center>
			</div>
		</div>
	</div>

</body>
</html>