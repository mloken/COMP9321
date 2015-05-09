<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auction Halting</title>
</head>
<body>

	<c:if test="${user.accessLevel < 2}">
	<!--USED WHEN USER LOGGED IN IS ADMIN-->
    <a href="adminMenu.jsp">Back</a>
    <h2>Halt active auction items here:</h2>

		<table cellpadding="2px" cellspacing="2px">
			<tr>
				<th>Auction name</th>
				<th>Auction ID</th>
				<th>Owner ID</th>
				<th>Status</th>
			</tr>
			<c:forEach var="item" items="${allActiveAuctionItems}">
				<tr>
					<td>${item.itemName}</td>
					<td>${item.id}</td>
					<td>${item.ownerId}</td>
					<td>
						<c:if test="${item.status == 1}">
						Active
						</c:if>
						<c:if test="${item.status == 0}">
						Unactive
						</c:if>
					</td>
					<td>
						<c:if test="${item.status == 1}">
							<form action='dispatcher?operation=adminHaltAuction'
								METHOD='post'>
								<input type="hidden" name="itemIdToHalt" value="${item.id}" />
								<input type="submit" value="Halt" />
							</form>
						</c:if> <c:if test="${item.status == 0}">
							<form action='dispatcher?operation=adminHaltAuction'
								METHOD='post'>
								<input type="hidden" name="itemIdToUnhalt" value="${item.id}" />
								<input type="submit" value="Unhalt" />
							</form>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>

	</c:if>
    
	<c:if test="${user.accessLevel >= 2}">
	<!--USED WHEN USER LOGGED IN IS NOT ADMIN-->
    You do not have admin permission
    </c:if>
    
	<c:if test="${user.accessLevel == null}">
	<!--USED WHEN NO USER IS LOGGED IN-->
    You are not logged in with admin permission
    </c:if>


</body>
</html>