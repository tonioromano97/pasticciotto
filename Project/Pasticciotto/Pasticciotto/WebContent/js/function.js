function addIngredientToRicetta(codice, nome){
	//document.getElementById('#myTable #'+codice+' button').style.pointerEvents = 'none';
	$("#myTable #"+codice+" button").attr('class', 'btn btn-primary disabled');
	var text = $("#myTable #"+codice+" button").text();
	if(text==="Aggiunto") return;
	var val = $('#'+codice+' input').val();
	$('#tableRicetta > tbody:last-child').append('<tr id=\''+codice+'\'> <td>'+nome+'</td><td>'+val+'</td><td><button type=\'button\' class=\'btn btn-primary\' onClick="removeIngredientToRicetta(\''+codice+'\');"> Rimuovi </button> </td></tr>');
	$("#myTable #"+codice+" button").text("Aggiunto");
}

function removeIngredientToRicetta(codice){
	$("#myTable #"+codice+" button").attr('class', 'btn btn-primary');
	$("#myTable #"+codice+" button").text("Aggiungi");
	$('#tableRicetta #'+codice).remove();
}

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