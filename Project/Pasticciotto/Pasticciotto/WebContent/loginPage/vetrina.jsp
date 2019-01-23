<div id="vetrina">
<table class="table">
<thead>
<tr>
<td> <b>Nome</b> </td>
<td> <b> Prezzo Acquisto</b> </td>
<td> <b>Prezzo Vendita</b> </td>
</tr>
</thead>
<tbody id="myTable">
<tr>
<td id="nome">Ricotta e Pera</td>
<td id="pA">10</td>
<td id="pV"> <i id="less" style="display:inline;" class="glyphicon glyphicon-minus" onClick="less(1)"></i>&euro; <span id="1">20.00</span> <i id="more" style="display:inline;" class="glyphicon glyphicon-plus" onClick="more(1)"> </i></td>
</tr>
</tbody>
</table>
</div>
<script>
function less(codice){
	var prezzo = $("#"+codice).html();
	prezzo = parseFloat(prezzo);
	prezzo = prezzo-0.5;
	$("#"+codice).html(prezzo);
}
function more(codice){
	var prezzo = $("#"+codice).html();
	prezzo = parseFloat(prezzo);
	prezzo = prezzo+0.5;
	$("#"+codice).html(prezzo);
}
</script>