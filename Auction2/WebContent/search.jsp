<!-- search (action page need to be change!)-->
	<form action="dispatcher?operation=search" method="post">
		 
		 
		 <div style="text-align:center">
	    	<div style="width:50%;margin:0px auto;"  class="input-group">
	    	<input type="text" class="form-control"  name="searchKey" placeholder="Search for...">
	    		<span class="input-group-btn">
	       		 	<button type="submit" name="search" id="search" class="btn btn-primary " type="button">Search!</button>
	      		</span>
	      		</div>
	      	<div style="width:50%;margin:0px auto;"  class="input-group">
	      		<br>
	    	<table>
	    	<td>Advance Search : </td>
	     			<td>
	     				<div class="input-group">
		                        <select id="minPrice" name="minPrice" class="input-xlarge">
								<option>0</option>
								<option>50</option>
								<option>100</option>
								<option>300</option>
								<option>500</option>
								<option>1000</option>
								<option>3000</option>
								<option>5000</option>
							</select>
		                    </div>
	     			</td>
	     			<td>
	     				<div class="input-group">
		                        <select id="maxPrice" name="maxPrice" class="input-xlarge">
								<option>50</option>
								<option>100</option>
								<option>300</option>
								<option>500</option>
								<option>700</option>
								<option>1000</option>
								<option>2000</option>
								<option>3000</option>
								<option>5000</option>
							</select>
		                    </div>
	     			</td>
	     			<td>
	     			
		     			<div class="input-group">
		                        <select id="category" name="category" class="input-xlarge">
								<option>Computers</option>
								<option>Art</option>
								<option>Car, Boat</option>
								<option>Television</option>
								<option>Kid</option>
								<option>Sports</option>
								<option>Clothes</option>
								<option>Beauty</option>
							</select>
		                    </div>
		     		</td>
	     		</table>
	     		<br>
	     	</div>
	     	<div>
	     		<span class="input-group-btn">
	       		 <button type="submit" class="btn btn-primary " type="button">Advance Search!</button>
	      		</span>
	   		 </div><!-- /input-group -->
	 	 </div><!-- /.col-lg-6 -->
	</form>