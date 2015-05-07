<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User banning</title>
</head>
<body>

	<c:if test="${user.uid < 2}">
	<!--USED WHEN USER LOGGED IN IS ADMIN-->
    Ban users here:
		
		<table cellpadding="2px" cellspacing="2px">
			<tr>
				<th>Username</th>
				<th>Status</th>
			</tr>
			<c:forEach var="itUser" items="${allUsers}">
				<tr>
					<td>
						${itUser.username}
					</td>
					<!-- Status and Ban/Unban-button-->
					<c:if test="${itUser.accessLevel <= 3}">
					<td>Not banned</td><td>Ban</td>
					</c:if>
					<c:if test="${itUser.accessLevel == 4}">
					<td>Banned</td><td>Unban</td>
					</c:if>

				</tr>
			</c:forEach>
		</table>


	</c:if>
    
	<c:if test="${user.uid >= 2}">
	<!--USED WHEN USER LOGGED IN IS NOT ADMIN-->
    You do not have admin permission
    </c:if>
    
	<c:if test="${user.uid == null}">
	<!--USED WHEN NO USER IS LOGGED IN-->
    You are not logged in with admin permission
    </c:if>

</body>
</html>