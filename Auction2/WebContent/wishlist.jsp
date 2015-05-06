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

<title>Wishlist</title>
  
  </head>  
    
  <body style= "text-align:center" >  
  <h1><b>Your Wishlist</b></h1>  
    
    <c:if test= "${empty auctionItems}">  
 <font color= "red" >Still empty</font><br/>  
 
   you can  
    <a href= "homepage.jsp" >go shopping</a>  
    </c:if >  
    <c:if test= "${!empty auctionItems}" >  
      <table class="table table-hover"   style="margin:0px auto; width:70%" >  
        <tr> 
           <th>Item name</th>
           <th>Picture</th>  
           <th>Current price</th>  
           <th>Item Detail</th>  
           <th>Delete</th>  
        </tr>  
        <c:forEach var="item"  items= "${auctionItems}" >  
          <tr>  
           <td>${item.itemName}</td>  
           <td><img width="150px" src="${item.picture}"> 
           <td>${item.currentBid}</td>
           <td><form ACTION='dispatcher?operation=itemDetail' METHOD='post'>
					<input type="hidden" name="id" value="${item.id}">
					<input type="submit" class="btn btn-warning" value="Detail">
				</form>	
		   </td>  
           <td>  
               <form ACTION='dispatcher?operation=deleteWishList' METHOD='post'>
							<input type="hidden" name="id" value="${item.id}">
							<input type="submit" class="btn btn-danger" value="Delete">
				</form>	
           </td>     
            
          </tr>  
          
        </c:forEach>  
        
  
      </table>  
      <br><br>
      <a href= "homepage.jsp" >Back to shopping</a>  
       </c:if >  
  </body>  
</html>