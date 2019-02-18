function callServlet(pulsante,servlet,page){
	$.when($("#viewOptionSidebar").fadeOut(200))
	.done(function() {
		$.get("/Pasticciotto/"+servlet, function(data) {
			$("#sidebarLogin button").css('box-shadow','0px 0px 0px 0px');
			pulsante.style.boxShadow = "1px 1px 1px 1px #fff";
	    	page = "loginPage/"+page;
			$("#viewOptionSidebar").load(page);
			$("#viewOptionSidebar").fadeIn(200);
	    });		
    });
	
}

function setPreparata(servlet,page){
	$.when($("#viewOptionSidebar").fadeOut(200))
	.done(function() {
		$.get("/Pasticciotto/"+servlet, function(data) {
			refreshDateOfPage('GetPrenotazioniControl', page);
	    });		
    });
	
}

function refreshDateOfPage(servlet,page){
	$.when($("#viewOptionSidebar").fadeOut(200))
	.done(function() {
		$.get("/Pasticciotto/"+servlet, function(data) {
	    	page = "loginPage/"+page;
			$("#viewOptionSidebar").load(page);
			$("#viewOptionSidebar").fadeIn(200);
	    });		
    });
	
}

function removeIngredient(ricetta, codice, nomeIngredient){
	if(confirm("Confermi di voler eliminare "+nomeIngredient+" ?"))
		$.get("UpdateCakesControl",{
			type: 1,
			KeyRecipe : ricetta,
			keyProduct : codice
		},function(data){
			if(data==="done"){
				$("#Composition"+ricetta+" #"+codice).remove();
				refreshDateOfPage('GetCakesControl','ricettario.jsp');	
			}
			else alert("C'è stato un errore nella rimozione di "+nomeIngredient);
		})
		
		
}

function addRecipe(){
	var parameters = "name=" + $("#formNewRecipe #nome").val();
	parameters += "&h=" + $("#formNewRecipe #ore").val();
	parameters += "&m=" + $("#formNewRecipe #minuti").val();
	parameters += "&procedimento=" + $("#formNewRecipe #procedimento").val();
	parameters += "&pV=0";
	parameters += "&pA=0";
	parameters += "&i=" + $('#compositionRicetta tr').length;
	$('#compositionRicetta tr').each(function(i,e){
		var codice = $(e).attr('id');
		var dose = $("#compositionRicetta #"+codice+" #dose").html();
		parameters += "&c"+i+"="+codice+"&d"+i+"="+dose;
	});	
	$.get("/Pasticciotto/NewCakesControl?"+parameters, function(data) {
		refreshDateOfPage('GetCakesControl','ricettario.jsp');
    });
}

function addProduct(){
	var n = $("#formNewProduct #nome").val();
	var q = $("#formNewProduct #quantita").val();
	var s = $("#formNewProduct #scorta").val();
	var p = $("#formNewProduct #prezzo").val();
	$.get("/Pasticciotto/NewIProductControl?name="+n+"&stock="+q+"&minStock="+s+"&price="+p, function(data) {
		refreshDateOfPage('GetInventarioControl','inventario.jsp');
    });		
}

function addEntrata(){
	var descrizione = $("#formNewEntrata #descrizione").val();
	var data = $("#formNewEntrata #data").val();
	var importo = $("#formNewEntrata #importo").val();
	$.get("/Pasticciotto/AddEntrataControl?descrizione="+descrizione+"&data="+data+"&importo="+importo, function(data) {
		refreshDateOfPage('GetFinanzeControl','finanze.jsp');
    });	
}

function addUscita(){
	var tipo = $("#formNewUscita #tipo").val();
	var descrizione = $("#formNewUscita #descrizione").val();
	var data = $("#formNewUscita #data").val();
	var importo = $("#formNewUscita #importo").val();
	$.get("/Pasticciotto/AddUscitaControl?descrizione="+descrizione+"&data="+data+"&importo="+importo+"&tipo="+tipo, function(data) {
		refreshDateOfPage('GetFinanzeControl','finanze.jsp');
    });	
}

function removeEntrata(codice){
	if(confirm("Confermi l'eliminazione ? ")){
		$.get("/Pasticciotto/RemoveFinanzaControl?tipo=entrata&code="+codice, function(data) {
			$("#entrate #"+codice).fadeOut();
			
	    });	
	}
}

function removeUscita(codice){
	if(confirm("Confermi l'eliminazione ? ")){
		$.get("/Pasticciotto/RemoveFinanzaControl?tipo=uscita&code="+codice, function(data) {
			$("#uscite #"+codice).fadeOut();
	    });		
	}
}

function removeProduct(codice){
	var n = $("#"+codice+" #nome").html();
	if(confirm("Confermi di voler eliminare "+n+" ?")){
	$.ajax({url: "/Pasticciotto/RemoveIProductControl?code="+codice, success: function(result,status){
		if(status.toLowerCase() === "success")
			$("#"+codice).fadeOut();
		else alert("Errore nella cancellazione del prodotto "+n+"\nControlla che il prodotto non sia associato ad una ricetta.");
	}, error: function(){
		alert("Errore nella cancellazione del prodotto "+n+"\nControlla che il prodotto non sia associato ad una ricetta.");
	}});
	}
}

function saveInventario(codice){
	var n = $("#"+codice+" #nomeM").val();
	var q = $("#"+codice+" #quantitaM").val();
	var s = $("#"+codice+" #scortaM").val();
	var p = $("#"+codice+" #prezzoM").val();
	$.get("/Pasticciotto/UpdateIProductControl?code="+codice+"&name="+n+"&stock="+q+"&minStock="+s+"&price="+p, function(data) {
		refreshDateOfPage('GetInventarioControl','inventario.jsp');
    });	
}

function modifyInventario(codice){
	$("#"+codice+" i").css('display','none');
	$("#"+codice+" button").css('display','inline');
	var n = $("#"+codice+" #nome").html();
	var q = $("#"+codice+" #quantita").html();
	var s = $("#"+codice+" #scorta").html();
	var p = $("#"+codice+" #prezzo").html();
	$("#"+codice+" #nome").html("<input id=\"nomeM\" class=\"form-control\" type=\"text\" value=\""+n+"\" style=\"color:black;\"/>");
	$("#"+codice+" #quantita").html("<input id=\"quantitaM\" class=\"form-control\" type=\"number\" min=\"0\" value=\""+q+"\" style=\"color:black;\"/>");
	$("#"+codice+" #scorta").html("<input id=\"scortaM\" class=\"form-control\" type=\"number\" min=\"0\" value=\""+s+"\" style=\"color:black;\"/>");
	$("#"+codice+" #prezzo").html("<input id=\"prezzoM\" class=\"form-control\" type=\"text\" value=\""+p+"\" style=\"color:black;\"/>");
}

function addOneIngredientToRicetta(code){
	codeProduct = $("#Composition"+code+" #addOneIngredient").find(":selected").attr('id');
	codeRecipe = code;
	q = $("#Composition"+code+" #quantityProduct").val();
	$.get("UpdateCakesControl",{
		type: 0,
		recipeKey: codeRecipe,
		keyProduct: codeProduct,
		quantity : q
	},function(data){
		alert(data);
		refreshDateOfPage('GetCakesControl','ricettario.jsp');
	});
}

function addIngredientToRicetta(codice, nome){
	$("#myTable #"+codice+" button").attr('class', 'btn btn-primary disabled');
	var text = $("#myTable #"+codice+" button").text();
	if(text===" &nbsp; &nbsp; Aggiunto &nbsp; &nbsp; ") return;
	var val = $('#'+codice+' input').val();
	$('#tableRicetta > tbody:last-child').append('<tr id=\''+codice+'\'> <td id=\'nome\'>'+nome+'</td><td id=\'dose\'>'+val+'</td><td><button type=\'button\' class=\'btn btn-primary\' onClick="removeIngredientToRicetta(\''+codice+'\');"> &nbsp; &nbsp;  Rimuovi  &nbsp; &nbsp; </button> </td></tr>');
	$("#myTable #"+codice+" button").text("Aggiunto");
}

function removeIngredientToRicetta(codice){
	$("#myTable #"+codice+" button").attr('class', 'btn btn-primary');
	$("#myTable #"+codice+" button").text("Aggiungi");
	$('#tableRicetta #'+codice).remove();
}

function filterTable(event){
	var code = event.keyCode;
	if(code==13){
		var value = $("#mySearch").val().toLowerCase();
		$("#myTable tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	}
}

function endModifyRicetta(codice){
	$.when($("#Composition"+codice+" div").slideUp())
	.done(function(){
		$("#Composition"+codice+" div").css('display','none');
		$("#Composition"+codice).css("display","none");
		$("#ricettario #"+codice+" #endModify").css('display','none');
		$("#ricettario #"+codice+" #modify").css('display','inline');
	});
	
}

function modifyRicetta(codice){
	//var nome = $("#ricettario #"+codice+" #nome").html();
	//var ore = $("#ricettario #"+codice+" #tempo #ore").html();
	//var minuti = $("#ricettario #"+codice+" #tempo #minuti").html();
	$("#ricettario #"+codice+" #modify").css('display','none');
	$("#ricettario #"+codice+" #endModify").css('display','inline');
	//$("#ricettario #"+codice+" #nome").html("<input id=\"nomeM\" class=\"form-control\" type=\"text\" value=\""+nome+"\" style=\"width:50%; color:black;\"/>");
	//$("#ricettario #"+codice+" #ore").html("<input id=\"oreM\" class=\"form-control\" type=\"number\" min=\"0\" value=\""+ore+"\" style=\"display:inline; width:50px; color:black;\"/>");
	//$("#ricettario #"+codice+" #minuti").html("<input id=\"minutiM\" class=\"form-control\" type=\"number\" min=\"0\" value=\""+minuti+"\" style=\"display:inline; width:50px; color:black;\"/>");
	$("#Composition"+codice).css("display","table-row");
	$("#Composition"+codice+" div").slideDown();
}

function showPage(page){
	$.when($("#viewOptionSidebar").fadeOut(200))
	.done(function() {
		page = "loginPage/"+page;
		$("#viewOptionSidebar").load(page);
		$("#viewOptionSidebar").fadeIn(200);
    });	
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
			$('#viewProductsOfPasticceria #products').html("<tr></tr>");
			if(prodotti.length==0) $('#viewProductsOfPasticceria #products tr:last').after('<tr> <td colspan=\'3\'> Al momento non ci sono prodotti in vetrina</td> </tr>');
			else{
			$(prodotti).each(function(index, prodotto){
				$('#viewProductsOfPasticceria #products tr:last').after('<tr> <td>'+prodotto.nome+'</td> <td> &euro; '+prodotto.prezzo+' /kg </td> <td> <button style="float:left;" onClick="prenota('+prodotto.codice+',\''+prodotto.nome+'\',\''+nome+'\')" class="btn btn--sm btn--primary">&nbsp; &nbsp;<i class="glyphicon glyphicon-shopping-cart"> </i> Aggiungi alla prenotazione &nbsp;&nbsp;</button> </td> </tr>');
			})
			}
			$('#viewProductsOfPasticceria').modal('show');
        });
}

function modifyPriceEndProduct(codice){
	$("#vetrina #myTable #"+codice+" #pV").html("<input type=\"number\" min=\"0\" id=\"newPriceEndProduct\"/>");
	$("#vetrina #myTable #"+codice+" #modify").css('display','none');
	$("#vetrina #myTable #"+codice+" #remove").css('display','none');
	$("#vetrina #myTable #"+codice+" #save").css('display','inline');
	
}

function removeEndProduct(codice){
	var nome = $("#vetrina #myTable #"+codice+" #nome").html();
	if(confirm("Confermi di voler eliminare "+nome+" ?")){
		$.get("RemoveProdottoFinitoControl",{
			codeRecipe : codice
		},function(data){
			if(data==='done'){
				refreshDateOfPage('GetProdottiFinitiControl','vetrina.jsp');
			} else {
				alert("C'è stato qualche problema nell'eliminazione di "+nome);
			}
		});
	}
}

function savePriceEndProduct(codice){
	var price = $("#vetrina #myTable #"+codice+" #pV #newPriceEndProduct").val();
	$.get("ModifySalesPriceControl",{
		codeRecipe : codice,
		price : price
	},function(data){
		if(data==='done'){
			refreshDateOfPage('GetProdottiFinitiControl','vetrina.jsp');
		} else {
			alert("Problema nell'aggiornamento del prezzo");
		}
	});
}

function addEndProduct(){
	var code = $("#formNewEndProduct #product").find(":selected").attr('value');
	var price = $("#formNewEndProduct #price").val();
	$.get("NewProdottoFinitoControl",{
		codeRecipe : code,
		price : price
	},function(data){
		if(data==='done'){
			refreshDateOfPage('GetProdottiFinitiControl','vetrina.jsp');
		} else {
			alert("Problema nell'inserimento");
		}
	});
}