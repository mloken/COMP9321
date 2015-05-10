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


<center>
   <div class="container">
		<div class="row">
			<!-- search-->
	<%@ include file="search.jsp" %>
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
			<!-- MESSAGE : SUCCESS OR FAILED show message from arraylist-->
		<div class="row">
			<div class="col-md-offset-2 col-md-8">
		           
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
		                
		                    <b>${message}</b>
		                    
		                    </span></strong>
		                </div>
		            
		    </div>
	    </div>
	
	

	<table class="table table-hover"  style="margin:0px auto; width:80%" >
		<tr>
		   		<th>
		   			Item Name
		   		</th>
		   		<th>
		   			Picture
		   		</th>
		   		
		   		<th>
		   			More Detail
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
		 	<c:if test="${!empty searchKey}">
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
			   			 <form ACTION='dispatcher?operation=itemDetail' METHOD='post'>
							<input type="hidden" name="id" value="${auctionItem.id}">
							<input type="hidden" name="searchKey" value="${searchKey}">
							<input type="submit" class="btn btn-warning" value="Detail">
						</form>		
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