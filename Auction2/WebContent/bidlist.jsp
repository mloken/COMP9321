<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bid List</title>
</head>
<body>
	<table class="table table-hover"  style="margin:0px auto; text-align: center;width:70%">
    	<c:forEach var="bid" items="${bidlist}">
			   <tr>
			   		<td>Item ID</td>
					<td>
			   			${bid.itemId}
			   		</td>
			   	</tr>
			   	<tr>
			   		<td>Bidder ID</td>
			   		<td>
			   			${bid.bidderId}
			   		</td>
			   	</tr>
			   	<tr>
			   		<td>Bid Price</td>
			   		<td>
			   			${bid.price}
			   		</td>
			   	</tr>
			   	<tr>
			   		<td>Bid Date</td>
			   		<td>
			   			${bid.date}
			   		</td>
				</tr>
				<td>&nbsp</td>
			</c:forEach>
		</table>
</body>
</html>