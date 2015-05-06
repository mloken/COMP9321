<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<%@ include file="header.jsp"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<title>Search Result</title>
</head>
<body >
<% String searchKey= (String) request.getAttribute("searchKey");%>

<center>
   <div class="container">
		<div class="row">
			<form action="dispatcher?operation=search" method="post">
				 <div class="col-md-offset-2 col-md-8">
			    	<div style="width:50%;"  class="input-group">
			    		
						<input type="text" class="form-control"  name="searchKey" placeholder="New Search for...">
			     		<span class="input-group-btn">
			       		 <button type="submit" class="btn btn-primary " type="button">Go!</button>
			      		</span>
			      		
			   		 </div><!-- /input-group -->
			 	 </div><!-- /.col-lg-6 -->
			</form>
		</div>
		<br>
		<div class="row">
			<form method="get" action="http://www.google.com/search">
				<div class="col-md-offset-2 col-md-8">
					<div style="width:50%;"  class="input-group">
					
					<input type="text"  class="form-control"  name="q"  placeholder="Or search on Google..."	/>
					<span class="input-group-btn">
			       		 <button type="submit" class="btn btn-warning " type="button">Go!</button>
			      	</span>
			      	
					</div>
				</div>
			</form>
		</div>
	</div>
</center>
	<br>
	<script type="text/javascript" src="https%3A%2F%2Fcse.google.com%2Fcse/tools/onthefly?form=searchbox_demo&lang="></script>
	
	<c:if test="${!empty message}"><center><font color= "red" >${message}</font></center></c:if>

	<table class="table table-hover"  style="margin:0px auto; width:80%" >
		<tr>
		   		<th>
		   			Item Name
		   		</th>
		   		<th>
		   			Picture
		   		</th>
		   		<th>
		   			Description
		   		</th>
		   		<th>
		   			More Detail
		   		</th>
		   		<th>
		   			ID
		   		</th>
		   		<th>
		   			Add Wishlist
		   		</th>
		
		</tr>
	 <c:choose>
	 	<c:when test="${empty auctionItems}">
					<center><h2>Search for "${searchKey}": No results found</h2></center>
		</c:when>
		 <c:otherwise>
		 	<c:if test="${!empty searckKey}">
		 			<center><h2>Search for "${searchKey}"</h2></center>
		 	</c:if>
		 	
			<c:forEach var="auctionItem" items="${auctionItems}">
			   <tr>
			   		<td>
			   			${auctionItem.itemName}
			   		</td>
			   		<td>
			   			<img width="144" src="${auctionItem.picture}">
			   		</td>
					<td>
			   			${auctionItem.description}
			   		</td>
			   		<td>
			   			 <form ACTION='dispatcher?operation=itemDetail' METHOD='post'>
							<input type="hidden" name="id" value="${auctionItem.id}">
							<input type="submit" class="btn btn-warning" value="Detail">
						</form>		
			   		</td>
			   		<td>
			   			${auctionItem.id}
			   		</td>
			   		<td>
			   			 <form ACTION='dispatcher?operation=addToWishList' METHOD='post'>
							<input type="hidden" name="itemId" value="${auctionItem.id}">
							<input type="hidden" name="searchKey" value="${searchKey}">
							<input type="hidden" name="message" value="Item Added to Wishlist">
							<input type="submit" class="btn btn-primary" value="Add">
						</form>		
			   		</td>
				</tr>
			</c:forEach>
		</c:otherwise>
		
	</c:choose>
	</table>
</body>
</html>