function viewProducts(){
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