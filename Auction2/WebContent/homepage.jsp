<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script></head>

<title>Auction Time</title>
</head>
<body>
	<!-- menu -->
	<div class="container">
		<div class="row">
			<div class="col-md-offset-2 col-md-8">
				<center>
					<h1><a href="homepage"><b>Auction Time</b></a></h1>
					<div class="btn-group">
					  <button type="button" class="btn btn-primary">HomePage </button>
					  <button type="button" class="btn btn-warning">User Profile</button>
					  <button type="button" class="btn btn-danger">Wish List</button>
					</div>
					<p></p>
					<p></p>
				</center>
			</div>
		</div>

	</div>
	
	
	<!-- search (action page need to be change!)-->
	<form action="search" method="GET">
		 
		 
		 <div style="text-align:center">
	    	<div style="width:50%;margin:0px auto;"  class="input-group">
	     		<input type="text" class="form-control"  name="searchKey" placeholder="Search for...">
	     		<span class="input-group-btn">
	       		 <button type="submit" class="btn btn-primary " type="button">Go!</button>
	      		</span>
	   		 </div><!-- /input-group -->
	 	 </div><!-- /.col-lg-6 -->
	</form>
	
	<!-- slide show -->
	<center>
	<div class="container">
	  <br>
	  <div id="myCarousel" class="carousel slide" data-ride="carousel">
	    <!-- Indicators -->
	    <ol class="carousel-indicators">
	      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	      <li data-target="#myCarousel" data-slide-to="1"></li>
	      <li data-target="#myCarousel" data-slide-to="2"></li>
	      <li data-target="#myCarousel" data-slide-to="3"></li>
	    </ol>
	
	    <!-- Wrapper for slides -->
	    <div class="carousel-inner" role="listbox">
	
	      <div class="item active">
	        <img src="http://www.target.com.au/medias/static_content/product/images/large/76/52/A717652.jpg" alt="Chania" width="460" height="345">
	        <div class="carousel-caption">
	          <h3>Camera</h3>
	          <p>SONY Compact Digital Camera DSC-W830V</p>
	        </div>
	      </div>
		 
		 <div class="item">
	        <img src="http://thumbs1.ebaystatic.com/d/l225/m/mDVbol8-hqWA_ZJ9gpZ20VA.jpg" alt="Flower" width="460" height="345">
	        <div class="carousel-caption">
	          <h3>Art</h3>
	          <p>Original Painting Oil on Canvas Art Cafe City Dusan</p>
	        </div>
	      </div>
	      <div class="item">
	        <img src="http://www.target.com.au/medias/static_content/product/images/grid/38/12/A793812.jpg" alt="Flower" width="460" height="345">
	        <div class="carousel-caption">
	          <h3>Women Tops</h3>
	          <p>Yours Sincerely Silk Longline Shirt</p>
	        </div>
	      </div>
	      <div class="item">
	        <img src="http://thumbs1.ebaystatic.com/d/l225/pict/201327141904_1.jpg" alt="Flower" width="460" height="345">
	        <div class="carousel-caption">
	          <h3>Art</h3>
	          <p>Wall Quotes Art Stretched Canvas Prints Framed Wall Decor Restaurant Bar Cafe AU</p>
	        </div>
	      </div>
	      <div class="item">
	        <img src="http://i.ebayimg.com/00/s/NTAwWDc5MA==/z/A60AAOSw1ZBUxDAG/$_12.JPG" alt="Flower" width="460" height="345">
	        <div class="carousel-caption">
	          <h3>Sporting</h3>
	          <p>Brand New Cyber Black and Red 26 inch 27 Gears Shimano Mountain bike</p>
	        </div>
	      </div>
	      <div class="item">
	        <img src="http://i.ebayimg.com/00/s/MTYwMFgxMjAw/z/OzMAAOSw7aBVETW2/$_12.JPG" alt="Flower" width="460" height="345">
	        <div class="carousel-caption">
	          <h3>Cars, Boats</h3>
	          <p>Nissan gq patrol tb42 auto</p>
	        </div>
	      </div>
	      <div class="item">
	        <img src="http://thumbs2.ebaystatic.com/d/l225/m/m0lDuWFegaq8MKeuAER1UEw.jpg" alt="Flower" width="460" height="345">
	        <div class="carousel-caption">
	          <h3>Electronics</h3>
	          <p>Yamaha CD-S300S CD Player CD/MP3/WMA iPod, Flash Drive via Front USB - Silver</p>
	        </div>
	      </div>
	      
	      <div class="item">
	        <img src="http://www.target.com.au/medias/static_content/product/images/large/35/99/A713599.jpg" alt="Chania" width="460" height="345">
	        <div class="carousel-caption">
	          <h3>Beauty</h3>
	          <p>Philips Sonicare Flexcare HX9182</p>
	        </div>
	      </div>
	    
	      <div class="item">
	        <img src="http://www.target.com.au/medias/static_content/product/images/grid/30/23/A113023.jpg" alt="Flower" width="460" height="345">
	        <div class="carousel-caption">
	          <h3>Kitchen</h3>
	          <p>Breville 'The Original' Sandwich Maker - BTS200</p>
	        </div>
	      </div>
	
	      <div class="item">
	        <img src="http://www.target.com.au/medias/static_content/product/images/grid/38/12/A793812.jpg" alt="Flower" width="460" height="345">
	        <div class="carousel-caption">
	          <h3>Women Tops</h3>
	          <p>Yours Sincerely Silk Longline Shirt</p>
	        </div>
	      </div>
	  	
	    </div>
	
	    <!-- Left and right controls -->
	    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
	      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	      <span class="sr-only">Previous</span>
	    </a>
	    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	      <span class="sr-only">Next</span>
	    </a>
	  </div>
	</div>
	</center>
</body>
</html>