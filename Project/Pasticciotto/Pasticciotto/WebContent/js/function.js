function filterTable(){
	var value = $("#mySearch").val().toLowerCase();
	$("#myTable tr").filter(function() {
		$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	});
}

function showPage(page){
	  xmlhttp=new XMLHttpRequest();
	  xmlhttp.onreadystatechange=function() {
	    if (this.readyState==4 && this.status==200) {
	      document.getElementById("viewOptionSidebar").innerHTML = xmlhttp.responseText;
	    }
	  }
	  xmlhttp.open("GET","/Pasticciotto/loginPage/"+page,true);
	  xmlhttp.send();
}

function viewProducts(){
	document.getElementById("information").style.display = "table";
	var div = document.getElementById("viewInformationOrProducts");
	div.innerHTML = "" +
			"<table class=\"table\">" +
			"<thead>" +
			"<tr>" +
			"<th> Nome </th>" +
			"<th> Prezzo </th>" +
			"<th> Prenota </th>" +
			"</tr>" +
			"</thead>" +
			"<tbody>" +
			"<tr>" +
			"<td> Ricotta e Pera </td>" +
			"<td> &euro; 10.00 /kg </td>" +
			"<td> <button style=\"float:left;\" class=\"btn btn-primary\"> &euro; Prenota</button> </td>" +
			"</tr>" +
			"<tr>" +
			"<td> Panna e Nutella</td>" +
			"<td> &euro; 8.00 /kg </td>" +
			"<td> <button style=\"float:left;\" class=\"btn btn-primary\"> &euro; Prenota</button> </td>" +
			"</tr>" +
			"</tbody>" +
			"</table>";
}