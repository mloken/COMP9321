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


	<form action="dispatcher?operation=search" method="post">
		 
		 
		 <div class="col-lg-6">
	    	<div style="width:50%;margin:0px auto;"  class="input-group">
				<input type="text" class="form-control"  name="searchKey" placeholder="New Search for...">
	     		<span class="input-group-btn">
	       		 <button type="submit" class="btn btn-primary " type="button">Go!</button>
	      		</span>
	   		 </div><!-- /input-group -->
	 	 </div><!-- /.col-lg-6 -->
	</form>
	
	<form method="get" action="http://www.google.com/search">
		<div class="col-lg-6">
			<div style="width:50%;margin:0px auto;"  class="input-group">
			<input type="text"  class="form-control"  name="q"  placeholder="Or search on Google..."	/>
			<span class="input-group-btn">
	       		 <button type="submit" class="btn btn-warning " type="button">Go!</button>
	      	</span>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="https%3A%2F%2Fcse.google.com%2Fcse/tools/onthefly?form=searchbox_demo&lang="></script>
	<br><br>  
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
		   			
		   		</th>
		
		</tr>
	 <c:choose>
	 	<c:when test="${empty auctionItems}">
					<center><h2>Search for " <%out.println(searchKey);%> ": No results found</h2></center>
		</c:when>
		 <c:otherwise>
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
			   			 <form ACTION='MoreDetail' METHOD='GET'>
							<input type="hidden" name="id" value="${auctionItem.id}">
							<input type="submit" class="btn btn-warning" value="Detail">
						</form>		
			   		</td>
			   		<td>
			   			${auctionItem.id}
			   		</td>
			   		<td>
			   			 <form ACTION='AddWishList' METHOD='GET'>
							<input type="hidden" name="id" value="${auctionItem.id}">
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