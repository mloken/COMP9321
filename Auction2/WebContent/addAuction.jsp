<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script></head>

<title>Add a new auction</title>
</head>
<body>
	
	<%@ include file="header.jsp"%>
	<%@ include file="search.jsp"%>

	<div class="container">
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<form class="form-horizontal" action='dispatcher?operation=addNewAuctionItem' method="post">
				<fieldset>
		
					<!-- Form Name -->
					<legend>New Auction</legend>
		
					<!-- Text input-->
					<div class="control-group">
						<label class="control-label" for="item_name">Title</label>
						<div class="controls">
							<input id="item_name" name="item_name" type="text" placeholder=""
								class="input-xlarge" required="">
						</div>
					</div>
		
					<!-- Select Basic -->
					<div class="control-group">
						<label class="control-label" for="category">Category</label>
						<div class="controls">
							<select id="category" name="category" class="input-xlarge">
								<option>Computers</option>
								<option>Photography</option>
								<option>Television</option>
								<option>Sports</option>
								<option>Clothes</option>
								<option>Beauty</option>
							</select>
						</div>
					</div>
		
					<!-- File Button -->
					<div class="control-group">
						<label class="control-label" for="picture">Picture</label>
						<div class="controls">
							<input id="picture" name="picture" class="input-file" type="file">
						</div>
					</div>
		
					<!-- Textarea -->
					<div class="control-group">
						<label class="control-label" for="description">Description</label>
						<div class="controls">
							<textarea id="description" name="description" rows=6 cols=36></textarea>
						</div>
					</div>
		
					<br></br>
		
					<!-- Text input-->
					<div class="control-group">
						<label class="control-label" for="streetAddress">Street
							Address</label>
						<div class="controls">
							<input id="streetAddress" name="streetAddress" type="text"
								placeholder="" class="input-xlarge" required="">
		
						</div>
					</div>
		
					<!-- Text input-->
					<div class="control-group">
						<label class="control-label" for="city">City</label>
						<div class="controls">
							<input id="city" name="city" type="text" placeholder=""
								class="input-xlarge" required="">
		
						</div>
					</div>
		
					<!-- Text input-->
					<div class="control-group">
						<label class="control-label" for="state">State</label>
						<div class="controls">
							<input id="state" name="state" type="text" placeholder=""
								class="input-xlarge" required="">
		
						</div>
					</div>
		
					<!-- Text input-->
					<div class="control-group">
						<label class="control-label" for="country">Country</label>
						<div class="controls">
							<input id="country" name="country" type="text" placeholder=""
								class="input-xlarge" required="">
		
						</div>
					</div>
		
					<!-- Text input-->
					<div class="control-group">
						<label class="control-label" for="postalCode">Postal
							Code</label>
						<div class="controls">
							<input id="postalCode" name="postalCode" type="text"
								placeholder="Eg. 2000" class="input-xlarge" required="">
						</div>
					</div>
		
					<br></br>
		
					<!-- Select Basic -->
					<div class="control-group">
						<label class="control-label" for="currency">Currency</label>
						<div class="controls">
							<select id="currency" name="currency" class="input-xlarge">
								<option>AUD</option>
								<option>USD</option>
								<option>EUR</option>
								<option>GBP</option>
							</select>
						</div>
					</div>
		
					<!-- Text input-->
					<div class="control-group">
						<label class="control-label" for="reservePrice">Reserve
							Price</label>
						<div class="controls">
							<input id="reservePrice" name="reservePrice" type="text"
								placeholder="0.00" class="input-xlarge" required="">
						</div>
					</div>
		
					<!-- Text input-->
					<div class="control-group">
						<label class="control-label" for="biddingStartPrice">Bidding
							Start Price</label>
						<div class="controls">
							<input id="biddingStartPrice" name="biddingStartPrice" type="text"
								placeholder="0.00" class="input-xlarge" required="">
						</div>
					</div>
		
					<!-- Text input-->
					<div class="control-group">
						<label class="control-label" for="biddingIncrements">Bidding
							Increments</label>
						<div class="controls">
							<input id="biddingIncrements" name="biddingIncrements" type="text"
								placeholder="0.00" class="input-xlarge" required="">
						</div>
					</div>
		
					<!-- Text input-->
					<div class="control-group">
						<label class="control-label" for="endTime">End Time</label>
						<div class="controls">
							<input id="endTime" name="endTime" type="text"
								placeholder="Eg. 2015-01-31-23:59" class="input-xlarge"
								required="">
							<p class="help-block">Must have format: yyyy-MM-dd-hh:mm</p>
						</div>
					</div>
		
					<!-- Textarea -->
					<div class="control-group">
						<label class="control-label" for="notes">Notes</label>
						<div class="controls">
							<textarea id="notes" name="notes" rows=6 cols=36></textarea>
						</div>
					</div>
		
					<!-- Button -->
					<div class="control-group">
						<label class="control-label" for="submitInput"></label>
						<div class="controls">
							<button id="submitInput" name="submitInput" class="btn btn-default">Submit</button>
						</div>
					</div>
		
				</fieldset>
			</form>
			</div>
			</div>
		</div>
</body>
</html>