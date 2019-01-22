<div id="headerInventario">
<button class="btn btn-primary" onClick="showPage(false,'newProduct.jsp');"> <i class="glyphicon glyphicon-plus"> </i> Nuovo prodotto </button>
<input class="form-control" id="mySearch" onkeyup="filterTable();" type="text" placeholder="Search.."> 
</div>
<div id="inventario">
<table class="table">
<thead>
<tr>
<td> <b>Codice</b> </td>
<td> <b>Nome</b> </td>
<td> <b> Quantità</b> </td>
<td> <b>Scorta Minima</b> </td>
<td> <b>Azione</b> </td>
</tr>
</thead>
<!-- Non ci devono essere spazi nei campi di <td> -->
<tbody id="myTable">
<tr id="P00004">
<td id="codice">P00004</td>
<td id="nome">Zucchero</td>
<td id="quantita">30</td>
<td id="scorta">20</td>
<td> <i style="display:inline;" class="glyphicon glyphicon-pencil" onClick="modifyInventario('P00004')"> </i>&nbsp;<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeProduct('P00004')"> </i> <button class="btn btn-primary" style="display:none;" onClick="saveInventario('P00004')"> Salva </button></td>
</tr>
<tr id="A0002" class="table-danger">
<td id="codice">A002</td>
<td id="nome"> Panna e Nutella</td>
<td id="quantita">10</td>
<td id="scorta">20</td>
<td> <i style="display:inline;" class="glyphicon glyphicon-pencil" onClick="modifyInventario('A0002')"> </i>&nbsp;<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeProduct('A0002')"> </i> <button class="btn btn-primary" style="display:none;" onClick="saveInventario('A0002')"> Salva </button></td>
</tr>
<tr id="A0003">
<td id="codice">A003</td>
<td id="nome"> Ricotta e Pera</td>
<td id="quantita">40</td> 
<td id="scorta">20</td>
<td> <i style="display:inline;" class="glyphicon glyphicon-pencil" onClick="modifyInventario('A0003')"> </i>&nbsp;<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeProduct('A0003')"> </i> <button class="btn btn-primary" style="display:none;" onClick="saveInventario('A0003')"> Salva </button> </td>
</tr>
</tbody>
</table>
</div>