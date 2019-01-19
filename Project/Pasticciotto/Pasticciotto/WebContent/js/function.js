function showRicetta(codice){
	$('#'+codice).modal('show');
}

function removeProduct(codice){
	var n = $("#"+codice+" #nome").html();
	if(confirm("Confermi di voler eliminare "+n+" ?"))
		$("#"+codice).remove();
}

function saveInventario(codice){
	$("#"+codice+" button").css('display','none');
	var n = $("#"+codice+" #nomeM").val();
	var q = $("#"+codice+" #quantitaM").val();
	var s = $("#"+codice+" #scortaM").val();
	$("#"+codice+" #nome").html(n);
	$("#"+codice+" #quantita").html(q);
	$("#"+codice+" #scorta").html(s);	
}

function modifyInventario(codice){
	$("#"+codice+" button").css('display','inline');
	var n = $("#"+codice+" #nome").html();
	var q = $("#"+codice+" #quantita").html();
	var s = $("#"+codice+" #scorta").html();
	$("#"+codice+" #nome").html("<input id=\"nomeM\" class=\"form-control\" type=\"text\" value=\""+n+"\" style=\"color:black;\"/>");
	$("#"+codice+" #quantita").html("<input id=\"quantitaM\" class=\"form-control\" type=\"number\" min=\"0\" value=\""+q+"\" style=\"color:black;\"/>");
	$("#"+codice+" #scorta").html("<input id=\"scortaM\" class=\"form-control\" type=\"number\" min=\"0\" value=\""+s+"\" style=\"color:black;\"/>");
}

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