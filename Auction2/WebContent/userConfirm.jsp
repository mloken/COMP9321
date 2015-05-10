<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Confirm Page</title>
</head>
<body>
<div class="container">
		<div class="row">
			<div class="col-md-offset-2 col-md-8">
				
					<h1>
						<b>Auction Time</b>
						<%=request.getParameter("confirmCode")%>
						${param.confirmCode}
					</h1>

				
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
				<img alt="" src="login.jpg" class="img-responsive">
			</div>
			<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
				<form action="dispatcher?operation=userConfirm" method="post">
					<p></p>

					<input type="text" class="form-control" name="username"
						placeholder="username">
					<p></p>
					<input type="password" class="form-control" name="password"
						placeholder="password">
					<p></p>
					<input type="hidden" class="form-control" name="confirmCode" value="${param.confirmCode}">
					
						<button type="submit" class="btn btn-primary " type="button">Confirm</button>
					
				</form>
				<div class="row">
					<div class="col-md-offset-2 col-md-8">
				           
				            <%
				            	if (request.getAttribute("valid")!=null){
				            		if (request.getAttribute("valid").toString()=="true"){
				            		%><div class="alert alert-success">
				            		<strong><span class="glyphicon glyphicon-ok">
				            		<b><a href="login.jsp" type="button" class="btn btn-warning">Login now!</a></b>
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
				
				
			</div>
		</div>
	</div>


</body>
</html>