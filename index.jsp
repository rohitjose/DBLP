<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<!-- IE Edge Meta Tag -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- Viewport -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
	<title>dblp Store</title>
</head>
<body>
	<!--Side Navigation: Shopping Cart-->
	<div id="mySidenav" class="sidenav">
     <!--Shopping Cart Icon-->
     <div class="row">
     <div class="col-md-12 text-right"><a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a></div>
     <div class="col-md-8"><img src="images/cart.png" height=50px width=50px/>
     <h3>Shopping Cart</h3></div>
     </div>
	</div>
	<!--Root page container-->
	<div class="container-fluid" id="main">
		<!--Navigation Bar for the page-->
		<nav class="navbar navbar-default" >
		 <div id="main" class="container-fluid">
		 	<!--Page Navigation bar header-->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
		      	<span class="sr-only">Toggle navigation</span>
		      	<span class="icon-bar"></span>
		      	<span class="icon-bar"></span>
		      	<span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#">&nbsp;<strong>dblp</strong> Store</a>
		    </div>
		    <!--Page Navigation bar header end-->
			<!--Navigation bar menu items-->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
		      <ul class="nav navbar-nav">
			      <li class="active" id="nav-menu-item-1" onclick="onClick()"><a href="#" onclick="openPage(event, 'home')">Home<span class="sr-only">(current)</span></a></li>
			      <li id="nav-menu-item-2" onclick="onClick()"><a href="#" onclick="openPage(event, 'search')">Advanced Search</a></li>
		      </ul>
		      <!--Title Search form in the Navigation bar-->
		      <form class="navbar-form navbar-right" role="search">
		        <div class="form-group">
		          <input type="text" class="form-control" placeholder="Title Search">
		        </div>
		        <button type="submit" class="btn btn-default">Submit</button>
		      </form>
		      <!--Title Search form end-->
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="#" onclick="openNav()"><span style="cursor:pointer">Shopping cart</span></a></li>
		      </ul>
		    </div>
		    <!--Navigation bar menu items end-->
		</nav>

		<!--Home Page begin -->
		<div class="container-fluid" id="home">	
			<div class="col-md-12">
				<h4><strong>Suggestions</strong></h4>
			</div>
			<!--Content Data-->
			<div class="col-md-4"> <!-- Item -->
					<div class="panel panel-primary"><!--Panel Definition-->
						<div class="panel-heading">Taggers for Parsers.</div><!--Panel heading-->
						<div class="panel-body"><!--Panel Body-->
							<table class="table table-striped">
								<tr><th>journal</th><td>Artif. In</div>tell</td></tr>
								<tr><th>ee</th><td>http://dx.doi.org/10.1016/0004-3702(95)00108-5</td></tr>
								<tr><th>pages</th><td>45-57</td></tr>
								<tr><th>volume</th><td>85</td></tr>
								<tr><th>number</th><td>1-2</td></tr>
								<tr><th>year</th><td>1996</td></tr>
								<tr><th>url</th><td>db/journals/ai/ai85.html#CharniakCACGKLM96</td></tr>
								<tr><th>author</th><td>John McCann</td></tr>
							</table>
							<a href="#" class="label label-primary">Add to Cart</a>
						</div><!--Panel body end-->
					</div><!--Panel Definition end-->
			</div><!--Item End-->
			<div class="col-md-4"> <!-- Item -->
					<div class="panel panel-primary"><!--Panel Definition-->
						<div class="panel-heading">Taggers for Parsers.</div><!--Panel heading-->
						<div class="panel-body"><!--Panel Body-->
							<table class="table table-striped">
								<tr><th>journal</th><td>Artif. In</div>tell</td></tr>
								<tr><th>ee</th><td>http://dx.doi.org/10.1016/0004-3702(95)00108-5</td></tr>
								<tr><th>pages</th><td>45-57</td></tr>
								<tr><th>volume</th><td>85</td></tr>
								<tr><th>number</th><td>1-2</td></tr>
								<tr><th>year</th><td>1996</td></tr>
								<tr><th>url</th><td>db/journals/ai/ai85.html#CharniakCACGKLM96</td></tr>
								<tr><th>author</th><td>John McCann</td></tr>
							</table>
							<a href="#" class="label label-primary">Add to Cart</a>
						</div><!--Panel body end-->
					</div><!--Panel Definition end-->
			</div><!--Item End-->
			<div class="col-md-4"> <!-- Item -->
					<div class="panel panel-primary"><!--Panel Definition-->
						<div class="panel-heading">Taggers for Parsers.</div><!--Panel heading-->
						<div class="panel-body"><!--Panel Body-->
							<table class="table table-striped">
								<tr><th>journal</th><td>Artif. In</div>tell</td></tr>
								<tr><th>ee</th><td>http://dx.doi.org/10.1016/0004-3702(95)00108-5</td></tr>
								<tr><th>pages</th><td>45-57</td></tr>
								<tr><th>volume</th><td>85</td></tr>
								<tr><th>number</th><td>1-2</td></tr>
								<tr><th>year</th><td>1996</td></tr>
								<tr><th>url</th><td>db/journals/ai/ai85.html#CharniakCACGKLM96</td></tr>
								<tr><th>author</th><td>John McCann</td></tr>
							</table>
							<a href="#" class="label label-primary">Add to Cart</a>
						</div><!--Panel body end-->
					</div><!--Panel Definition end-->
			</div><!--Item End-->
		</div>	
		<!--Home Page End-->
		<!--Search Page Begin-->
		<div class="container-fluid" id="search" style="display:none;">
			<div class="col-md-6">
				<!--Search Query Form-->
				<form class="form-horizontal">
	  				<fieldset>
	  				<!--Form details begin-->

	  				<legend><h4><strong>Search</strong></h4></legend><!--Form Heading-->
					<!--Form Item 1 begin-->
	  				<div class="form-group">
				      <label for="select" class="col-lg-2 control-label"><h5>Entry Type</h5></label>
				      <div class="col-lg-10">
				        <select multiple="" class="form-control">
				          <option value="article">Article</option>
				          <option value="inproceedings">Inproceedings</option>
				          <option value="proceedings">Proceedings</option>
				          <option value="book">Book</option>
				          <option value="incollection">Incollection</option>
				          <option value="phdthesis">PHD Thesis</option>
				          <option value="mastersthesis">Masters Thesis</option>
				          <option value="www">Web Resource</option>
				        </select>
				      </div>
				    </div>
				    <!--Form Item 1 end-->
				    <!--Form Item 2 begin-->
				    <div class="form-group">
				      <label for="inputTitle" class="col-lg-2 control-label"><h5>Title</h5></label>
				      <div class="col-lg-10">
				        <input type="text" class="form-control" id="inputTitle" placeholder="Title">
				      </div>
				    </div>
				    <!--Form Item 2 end-->
				    <!--Form Buttons-->
				    <div class="form-group">
				      <div class="col-lg-10 col-lg-offset-2 text-right">
				        <button type="reset" class="btn btn-default">Cancel</button>&nbsp;
				        <button type="submit" class="btn btn-primary">Search</button>
				      </div>
				    </div>
				    <!--Form buttons end-->
				    <!--Form details end-->
	  				</fieldset>
	  			</form>
	  			<!--Search query form end-->
  			</div>
		</div>
		<!--Search Page End-->
		<!--Footer-->
		<div class="footer navbar-fixed-bottom">
			<div class="container-fluid">
				<footer><h5>Footer of the page</h5></footer>
			</div>
		</div>
	</div>
	<!--Root page content end-->
	<!-- Scripts -->
  	<script src="js/jquery-3.1.0.min.js"></script>
  	<script src="js/bootstrap.js"></script>
  	<script src="js/script.js"></script>
</body>
</html>