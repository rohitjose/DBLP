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
	<!--Navigation Bar for the page-->
	
		<nav class="navbar navbar-default" id="main">
		 <div id="main" class="container-fluid">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#">&nbsp;<strong>dblp</strong> Store</a>
		    </div>

		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
		      <ul class="nav navbar-nav">
		        <li class="active" id="nav-menu-item-1" onclick="onClick()"><a href="#">Home<span class="sr-only">(current)</span></a></li>
		        <li id="nav-menu-item-2" onclick="onClick()"><a href="#">Advanced Search</a></li>
		      </ul>
		      
		      <form class="navbar-form navbar-right" role="search">
		        <div class="form-group">
		          <input type="text" class="form-control" placeholder="Title Search">
		        </div>
		        <button type="submit" class="btn btn-default">Submit</button>
		      </form>
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="#" onclick="openNav()"><span style="cursor:pointer">Shopping cart</span></a></li>
		      </ul>
		    
		</nav>
		</div>
		
			<div class="container-fluid">
				<div class="col-md-12">
					<h3>Suggestions</h3>
				</div>
					<!--Content Data-->
				<div class="col-md-4">
					<div class="panel panel-primary">
						<div class="panel-heading">Taggers for Parsers.</div>
						<div class="panel-body">
							<table class="table table-striped table-hover ">
								<tr><th>journal</th><td>Artif. In</div>tell</td></tr>
								<tr><th>ee</th><td>http://dx.doi.org/10.1016/0004-3702(95)00108-5</td></tr>
								<tr><th>pages</th><td>45-57</td></tr>
								<tr><th>volume</th><td>85</td></tr>
								<tr><th>number</th><td>1-2</td></tr>
								<tr><th>year</th><td>1996</td></tr>
								<tr><th>url</th><td>db/journals/ai/ai85.html#CharniakCACGKLM96</td></tr>
								<tr><th>author</th><td>John McCann</td></tr>
							</table>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="panel panel-primary">
						<div class="panel-heading">Taggers for Parsers.</div>
						<div class="panel-body">
							<table class="table table-striped table-hover ">
								<tr><th>journal</th><td>Artif. In</div>tell</td></tr>
								<tr><th>ee</th><td>http://dx.doi.org/10.1016/0004-3702(95)00108-5</td></tr>
								<tr><th>pages</th><td>45-57</td></tr>
								<tr><th>volume</th><td>85</td></tr>
								<tr><th>number</th><td>1-2</td></tr>
								<tr><th>year</th><td>1996</td></tr>
								<tr><th>url</th><td>db/journals/ai/ai85.html#CharniakCACGKLM96</td></tr>
								<tr><th>author</th><td>John McCann</td></tr>
							</table>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="panel panel-primary">
						<div class="panel-heading">Taggers for Parsers.</div>
						<div class="panel-body">
							<table class="table table-striped table-hover ">
								<tr><th>journal</th><td>Artif. In</div>tell</td></tr>
								<tr><th>ee</th><td>http://dx.doi.org/10.1016/0004-3702(95)00108-5</td></tr>
								<tr><th>pages</th><td>45-57</td></tr>
								<tr><th>volume</th><td>85</td></tr>
								<tr><th>number</th><td>1-2</td></tr>
								<tr><th>year</th><td>1996</td></tr>
								<tr><th>url</th><td>db/journals/ai/ai85.html#CharniakCACGKLM96</td></tr>
								<tr><th>author</th><td>John McCann</td></tr>
							</table>
						</div>
					</div>
				</div>

			</div>
		
	</div>
  	<script src="js/jquery-3.1.0.min.js"></script>
  	<script src="js/bootstrap.js"></script>
  	<script src="js/script.js"></script>
</body>
</html>