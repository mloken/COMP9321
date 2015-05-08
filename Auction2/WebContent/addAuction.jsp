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
<title>Add a new auction</title>
</head>
<body>
<%@ include file="header.jsp"%>

	
	<% 
	if (request.getAttribute("item")==null){
		request.getAttribute("item");
		request.getAttribute("message");
		request.getAttribute("valid");
	}
	%>

	<div class="container">
			<div class="row">
				<div class="col-md-offset-2 col-md-8">
					<center>
						<h1><b>Add New Auction Item</b></a></h1>
						
					</center>
				</div>
			<!-- MESSAGE : SUCCESS OR FAILED show message from message-->
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
		        <form role="form" action="dispatcher?operation=addNewAuctionItem" method="post">
		            <div class="col-md-offset-2 col-md-8">
		                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
		                <div class="form-group">
		                    <label for="item_name">Title</label>
		                    <div class="input-group">
		                        <input type="text" class="form-control" name="item_name" id="item_name" placeholder="Enter Item Name" required>
		                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="category">Category</label>
		                    <div class="input-group">
		                        <select id="category" name="category" class="input-xlarge">
								<option>Computers</option>
								<option>Art</option>
								<option>Car, Boat</option>
								<option>Television</option>
								<option>Kid</option>
								<option>Sports</option>
								<option>Clothes</option>
								<option>Beauty</option>
							</select>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="picture">Picture</label>
		                    <div class="input-group">
		                        <input id="picture" name="picture" class="input-file" type="file">
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="description">Description</label>
		                    <div class="input-group">
		                        <textarea id="description" name="description" rows=6 cols=46 class="form-control" placeholder="Enter Item Description"></textarea>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="streetAddress">Street Address</label>
		                    <div class="input-group">
		                        <input type="text" class="form-control" id="streetAddress" name="streetAddress" placeholder="Enter Street Address" required>
		                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="city">City</label>
		                    <div class="input-group">
		                        <input type="text" class="form-control" id="city" name="city" placeholder="Enter City" required>
		                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="state">State</label>
		                    <div class="input-group">
		                        <input type="text" class="form-control" id="state" name="state" placeholder="Enter State" required>
		                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="country">Country</label>
		                    <div class="input-group">
		                        <input type="text" class="form-control" name="country" id="country" placeholder="Enter Country" required>
		                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="postalCode">Postal Code</label>
		                    <div class="input-group">
		                        <input type="text" class="form-control" id="postalCode" name="postalCode" placeholder="Enter Postal Code" required>
		                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="currency">Select Currency</label>
		                    <div class="input-group">
		                        <select id="currency" name="currency" class="input-xlarge">
									<option>AUD</option>
									<option>USD</option>
									<option>EUR</option>
									<option>GBP</option>
								</select>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="reservePrice">Reserve Price</label>
		                    <div class="input-group">
		                        <input type="text" class="form-control" id="reservePrice" name="reservePrice" placeholder="0.00" required>
		                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="biddingStartPrice">Bidding Start Price</label>
		                    <div class="input-group">
		                        <input type="text" class="form-control" id="biddingStartPrice" name="biddingStartPrice" placeholder="0.00" required>
		                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="biddingIncrements">Bidding Increments</label>
		                    <div class="input-group">
		                        <input type="text" class="form-control" id="biddingIncrements" name="biddingIncrements" placeholder="0.00" required>
		                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="endTime">End Time</label>
		                    <div class="input-group">
		                        <input type="text" class="form-control" id="endTime" name="endTime" placeholder="Eg. 2015-01-31-23:59">
		                        <span class="input-group-addon"></span>
		                    </div>
		                    <p class="help-block">Must have format: yyyy-MM-dd-hh:mm (If left empty: end time set to 10 minutes from now)</p>
		                </div>
		                <div class="form-group">
		                    <label for="notes">Notes</label>
		                    <div class="input-group">
		                        <textarea id="notes" name="notes" rows=6 cols=46></textarea>
		                    </div>
		                </div>
		                <input type="submit" name="submitInput" id="submitInput" value="Submit" class="btn btn-info pull-right">
		            </div>
		        </form>
		    </div>
		    </div>
		</div>


</body>
</html>