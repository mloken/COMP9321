<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin menu</title>
</head>
<body>

	<c:if test="${user.uid < 2}">
	<!--USED WHEN USER LOGGED IN IS ADMIN-->
		<h2>Admin functions</h2>
		<p>
			<a href="dispatcher?operation=adminHaltAuction">Halt auction</a> 
			<a href="dispatcher?operation=adminRemoveItem">Remove auction</a> 
			<a href="dispatcher?operation=adminBanUser">Ban user</a>
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