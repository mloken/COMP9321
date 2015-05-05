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
    <h2>____________</h2>  
    <c:if test= "${empty wishList}">  
 <font color= "red" >Still empty</font><br/>  
 
   you can  
    <a href= "homepage.jsp" >go shopping</a>  
    </c:if >  
    <c:if test= "${!empty wishList}" >  
      <table class="table table-hover"   style="margin:0px auto; width:70%" >  
        <tr> 
           <th>ID</th>
           <th>Item name</th>  
           <th>Picture</th>  
           <th>Description</th>  
           <th>EndTime</th>  
           <th>Delete Item</th>     
        </tr>  
        <c:forEach var="item"  items= "${wishList}" >  
          <tr>  
           <td>${item.id}</td>  
           <td>${item.item_name}</td>  
           <td><img width="144" src="${item.picture}"></td>
           <td>${item.description}</td>
           <td>${item.endTime}</td>   
           <td>  
               <form ACTION='dispatcher?operation=deleteFromWishList' METHOD='GET'>
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