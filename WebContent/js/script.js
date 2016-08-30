function openNav() {
	document.getElementById("mySidenav").style.width = "450px";
	document.getElementById("main").style.marginLeft = "450px";
	document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}

function closeNav() {
	document.getElementById("mySidenav").style.width = "0";
	document.getElementById("main").style.marginLeft = "0";
	document.body.style.backgroundColor = "white";
}

function onClick() {
	document.getElementById('nav-menu-item-1').classList.toggle('active');
	document.getElementById('nav-menu-item-2').classList.toggle('active');
}

function openPage(evt, page) {
	document.getElementById(page).style.display = "block";

	if (page === "home") {
		document.getElementById("search").style.display = "none";
	}

	if (page === "search") {
		document.getElementById("home").style.display = "none";
	}
}

function modal_open(hashcode) {
	var modal = document.getElementById("myModal_".concat(hashcode));
	modal.style.display = "block";

}

function close_modal(hashcode) {
	var modal = document.getElementById("myModal_".concat(hashcode));
	modal.style.display = "none";
}


function formSubmit(hashcode) {
	var form = $('#cart'.concat(hashcode));
	var test = $('#cart'.concat(hashcode)).serialize();
	console.log("This is test" + JSON.stringify(test));
	
	var children= $(this).children();

	console.log(children);
	
	var modal = document.getElementById("myModal_".concat(hashcode));
	modal.style.display = "none";
	
	if (test === null) {
		console.log("Test is null");
	}
	$.ajax({
		type : 'POST',
		url : 'cart',//data : {title:$(('input#'.concat('title_')).concat(hashcode)).val()}
		data : $(this).serialize(),
		success : function(data) {

		}
	}
	
	);
	 return false; // not refreshing page
}
