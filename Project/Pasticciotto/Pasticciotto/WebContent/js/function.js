function removeIngredient(ricetta, codice){
	var n = $("#Composition"+ricetta+" #"+codice+" td").html();
	if(confirm("Confermi di voler eliminare "+n+" ?"))
		$("#Composition"+ricetta+" #"+codice).remove();
}

function removeProduct(codice){
	var n = $("#"+codice+" #nome").html();
	if(confirm("Confermi di voler eliminare "+n+" ?")){
	$.ajax({url: "/Pasticciotto/RemoveIProductControl?code="+codice, success: function(result,status){
		if(status.toLowerCase() === "success")
			$("#"+codice).remove();
		else alert("Errore nella cancellazione del prodotto "+n);
	}, error: function(){
		alert("Errore nella cancellazione del prodotto "+n);
	}});
	}
}

function saveInventario(codice){
	$("#"+codice+" i").css('display','inline');
	$("#"+codice+" button").css('display','none');
	var n = $("#"+codice+" #nomeM").val();
	var q = $("#"+codice+" #quantitaM").val();
	var s = $("#"+codice+" #scortaM").val();
	if(q>=s) $("#"+codice).attr('class', '');
	else $("#"+codice).attr('class', 'table-danger');
	$("#"+codice+" #nome").html(n);
	$("#"+codice+" #quantita").html(q);
	$("#"+codice+" #scorta").html(s);	
}

function modifyInventario(codice){
	$("#"+codice+" i").css('display','none');
	$("#"+codice+" button").css('display','inline');
	var n = $("#"+codice+" #nome").html();
	var q = $("#"+codice+" #quantita").html();
	var s = $("#"+codice+" #scorta").html();
	$("#"+codice+" #nome").html("<input id=\"nomeM\" class=\"form-control\" type=\"text\" value=\""+n+"\" style=\"color:black;\"/>");
	$("#"+codice+" #quantita").html("<input id=\"quantitaM\" class=\"form-control\" type=\"number\" min=\"0\" value=\""+q+"\" style=\"color:black;\"/>");
	$("#"+codice+" #scorta").html("<input id=\"scortaM\" class=\"form-control\" type=\"number\" min=\"0\" value=\""+s+"\" style=\"color:black;\"/>");
}

function addIngredientToRicetta(codice, nome){
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

function saveRicetta(){
	page = "loginPage/ricettario.jsp";
	$("#viewOptionSidebar").load(page);
}

function modifyRicetta(codice){
	var nome = $("#ricettario #"+codice+" #nome").html();
	var ore = $("#ricettario #"+codice+" #tempo #ore").html();
	var minuti = $("#ricettario #"+codice+" #tempo #minuti").html();
	$("#ricettario #"+codice+" #modify").css('display','none');
	$("#ricettario #"+codice+" #nome").html("<input id=\"nomeM\" class=\"form-control\" type=\"text\" value=\""+nome+"\" style=\"width:50%; color:black;\"/>");
	$("#ricettario #"+codice+" #ore").html("<input id=\"oreM\" class=\"form-control\" type=\"number\" min=\"0\" value=\""+ore+"\" style=\"display:inline; width:50px; color:black;\"/>");
	$("#ricettario #"+codice+" #minuti").html("<input id=\"minutiM\" class=\"form-control\" type=\"number\" min=\"0\" value=\""+minuti+"\" style=\"display:inline; width:50px; color:black;\"/>");
	$("#Composition"+codice).css("display","table-row");
	$("#Composition"+codice+" div").slideDown();
}

function showPage(pulsante,page){
	if(!(pulsante==false)){
	$("#sidebarLogin button").css('box-shadow','0px 0px 0px 0px');
	pulsante.style.boxShadow = "1px 1px 1px 1px #fff";
	}
	page = "loginPage/"+page;
	$("#viewOptionSidebar").load(page);
	
}

function showRicetta(codice){
	$('#R'+codice).modal('show');
}

function showProducts(codice){
        $.get("/Pasticciotto/GetVetrinaControl?code="+codice, function(data) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
        	var pasticceria = JSON.parse(data);
			var nome = pasticceria.nome;
			var prodotti = pasticceria.prodotti;
			$('#viewProductsOfPasticceria #nomeP').html(nome);
			$(prodotti).each(function(index, prodotto){
				$('#viewProductsOfPasticceria #products tr:last').after('<tr> <td>'+prodotto.nome+'</td> <td> &euro; '+prodotto.prezzo+' /kg </td> <td> <button style="float:left;" class="btn btn-primary"> &euro; Prenota</button> </td> </tr>');
			})
			$('#viewProductsOfPasticceria').modal('show');
        });
}