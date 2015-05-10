
<div class="row">
			<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
			</div>
			<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-center">
			<%
	 		
				if (session.getAttribute("winsomething")!=null && session.getAttribute("winsomething").toString()=="true"){
					
					request.setAttribute("from", "winnotif");
				%>
				
				<h2>You won something, go to your <a href="dispatcher?operation=showBidList">Bid List</a> page to check</h2><br>
				
				<%
				}
			%>
				<%
				if (session.getAttribute("sellsomething")!=null && session.getAttribute("sellsomething").toString()=="true"){
					
				%>
				
				<h2>You have items which have reached closing time, go to your <a href="dispatcher?operation=showAuctionList">Auction Item List</a> page to check</h2><br>
				
				<%
				}
			%>	
					<h1><a href="dispatcher?operation=homepage"><b>Auction Time</b></a></h1>
					<div class="btn-group">
						  <a href="dispatcher?operation=homepage" type="button" class="btn btn-primary">Shopping</a>
						  <a href="addAuction.jsp" type="button" class="btn btn-success">Add Auction</a>
						  <a href="dispatcher?operation=showWishList" type="button" class="btn btn-danger">My Wish List</a>
						  <a href="dispatcher?operation=showBidList" type="button" class="btn btn-warning">My Bid List</a>
						  
						  
					</div>
					<p></p>
					<p></p>
				
			</div>
			<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2 pull-right">
				<c:choose>			
					<c:when test= "${empty user}">  
						<center>You are not login yet! <a href="login.jsp" type="button" class="btn btn-info">Login now!</a></center>
					
		 			</c:when>
		 			<c:otherwise>
						<h4>Welcome, ${user.nickname}!</h4>
						<div class="btn-group pull-left">
							   <button type="button" class="btn btn-info dropdown-toggle " data-toggle="dropdown">
							      User <span class="caret"></span></button>
							       <ul class="dropdown-menu" role="menu">
							           <li><a href="userProfile.jsp">Profile</a></li>
							           <li><a href="dispatcher?operation=showAuctionList">My Auction</a></li>
							           <li><a href="dispatcher?operation=logout">Log out</a></li>
							      </ul>
						 </div>
		 			</c:otherwise>
	 			</c:choose>
	 		</div>	
	 		
</div>

	

	