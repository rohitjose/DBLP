function openNav() {
    document.getElementById("mySidenav").style.width = "450px";
    document.getElementById("main").style.marginLeft = "450px";
    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
    document.body.style.backgroundColor = "white";
}

function onClick(){
	document.getElementById('nav-menu-item-1').classList.toggle('active');
	document.getElementById('nav-menu-item-2').classList.toggle('active');
}

function openPage(evt,page){
	document.getElementById(page).style.display = "block";

	if(page==="home"){
		document.getElementById("search").style.display = "none";
	}

	if(page==="search"){
		document.getElementById("home").style.display = "none";
	}
}