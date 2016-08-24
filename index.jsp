<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<!-- IE Edge Meta Tag -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- Viewport -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="css/bootstrap_lumen.css">
	<link rel="stylesheet" href="css/style.css">
	<title>dblp Store</title>
</head>
<body>
	<!--Side Navigation: Shopping Cart-->
	<div id="mySidenav" class="sidenav">
			     <!--Shopping Cart Icon-->
			     <a href="#"><img src="images/cart.png" height=50px width=50px/><a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a></a>
	</div>
	<!--Navigation Bar for the page-->
	<div id="main" class="container-fluid">
		<nav class="navbar navbar-inverse" id="main">
		 
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#"><strong>dblp</strong> Store</a>
		    </div>

		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
		      <ul class="nav navbar-nav">
		        <li class="active"><a href="#">Home<span class="sr-only">(current)</span></a></li>
		        <li><a href="#">Advanced Search</a></li>
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
		    </div>
		</nav>
		
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-11">
					<h3>Top Pics</h3>
				</div>
			</div>
		
	</div>
  	<script src="js/jquery-3.1.0.min.js"></script>
  	<script src="js/bootstrap.js"></script>
  	<script>
	function openNav() {
	    document.getElementById("mySidenav").style.width = "400px";
	    document.getElementById("main").style.marginLeft = "400px";
	    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
	}

	function closeNav() {
	    document.getElementById("mySidenav").style.width = "0";
	    document.getElementById("main").style.marginLeft= "0";
	    document.body.style.backgroundColor = "white";
	}
	</script>
</body>
</html>