<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<title>Auction Time</title>
</head>
<body>
<%@ include file="header.jsp"%>

	
<c:forTokens items="" delims=""></c:forTokens>
	  
	<!-- search-->
	<form action="dispatcher?operation=search" method="post">
		 
		 
		 <div style="text-align:center">
	    	<div style="width:50%;margin:0px auto;"  class="input-group">
	     		<input type="text" class="form-control"  name="searchKey" placeholder="Search for...">
	     		<span class="input-group-btn">
	       		 <button type="submit" class="btn btn-primary " type="button">Go!</button>
	      		</span>
	   		 </div><!-- /input-group -->
	 	 </div><!-- /.col-lg-6 -->
	</form>
	
	<!-- slide show -->
	<center>
	<div class="container">
	  <br>
	  <div id="myCarousel" class="carousel slide" data-ride="carousel">
	    <!-- Indicators -->
	    <ol class="carousel-indicators">
	      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	      <li data-target="#myCarousel" data-slide-to="1"></li>
	      <li data-target="#myCarousel" data-slide-to="2"></li>
	      <li data-target="#myCarousel" data-slide-to="3"></li>
	    </ol>
	
	    <!-- Wrapper for slides -->
	    <div class="carousel-inner" role="listbox">
	


	     <c:set var="active" value="no" /> 
	     <c:forEach var="auctionItem" items="${randomTenAuctionItems}">
	      	 <c:choose>
	      		<c:when test="${active=='no'}">
		      		<div class="item active">
					<img src="${auctionItem.picture}" alt="Flower" width="400" height="345" >
			        	<div class="carousel-caption">
			        	 <h3>${auctionItem.itemName}</h3>
			        	 
				        	 <form ACTION='dispatcher?operation=itemDetail' METHOD='post'>
										<input type="hidden" name="id" value="${auctionItem.id}">
										<input type="hidden" name="searchKey" value="${searchKey}">
										<input type="submit" class="btn btn-warning" value="Detail">
							</form>	
						</div>					
			 		</div>
	      			<c:set var="active" value="1" />
	      		</c:when>
	      	<c:otherwise>
	      		<div class="item">
					<img src="${auctionItem.picture}" alt="Flower" width="400" height="345" >
		        	<div class="carousel-caption">
		        	 <h3>${auctionItem.itemName}</h3>
		        	 
			        	 <form ACTION='dispatcher?operation=itemDetail' METHOD='post'>
									<input type="hidden" name="id" value="${auctionItem.id}">
									<input type="hidden" name="searchKey" value="${searchKey}">
									<input type="submit" class="btn btn-warning" value="Detail">
						</form>	
					</div>					
				</div>
	      	</c:otherwise>
		  </c:choose>
		</c:forEach>
	      
	  	
	    </div>
	
	    <!-- Left and right controls -->
	    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
	      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	      <span class="sr-only">Previous</span>
	    </a>
	    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	      <span class="sr-only">Next</span>
	    </a>
	  </div>
	</div>
	
	
	
	</center>
</body>
</html>