<div id="headerInventario">
<button class="btn btn-primary" onClick="showPage('newProduct.jsp');"> <i class="glyphicon glyphicon-plus"> </i> Nuovo prodotto </button>
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
<tr id="A0001">
<td id="codice">A001</td>
<td id="nome">Millefoglie</td>
<td id="quantita">10</td>
<td id="scorta">20</td>
<td> <i style="display:inline;" class="glyphicon glyphicon-pencil" onClick="modifyInventario('A0001')"> </i>&nbsp;<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeProduct('A0001')"> </i> <button class="btn btn-primary" style="display:none;" onClick="saveInventario('A0001')"> Salva </button></td>
</tr>
<tr id="A0002">
<td id="codice">A002</td>
<td id="nome"> Panna e Nutella</td>
<td id="quantita">10</td>
<td id="scorta">20</td>
<td> <i style="display:inline;" class="glyphicon glyphicon-pencil" onClick="modifyInventario('A0002')"> </i>&nbsp;<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeProduct('A0002')"> </i> <button class="btn btn-primary" style="display:none;" onClick="saveInventario('A0002')"> Salva </button></td>
</tr>
<tr id="A0003">
<td id="codice">A003</td>
<td id="nome"> Ricotta e Pera</td>
<td id="quantita">10</td> 
<td id="scorta">20</td>
<td> <i style="display:inline;" class="glyphicon glyphicon-pencil" onClick="modifyInventario('A0003')"> </i>&nbsp;<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeProduct('A0003')"> </i> <button class="btn btn-primary" style="display:none;" onClick="saveInventario('A0003')"> Salva </button> </td>
</tr>
</tbody>
</table>
</div>