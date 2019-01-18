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
<td> <b> Quantita</b> </td>
<td> <b>Scorta Minima</b> </td>
<td> <b>Azione</b> </td>
</tr>
</thead>
<tbody id="myTable">
<tr>
<td> A001</td>
<td> Millefoglie</td>
<td> 10 </td>
<td> 20 </td>
<td> <i class="glyphicon glyphicon-shopping-cart"> </i> <i class="glyphicon glyphicon-trash"> </i></td>
</tr>
<tr>
<td> A001</td>
<td> Panna e nutella</td>
<td> 10 </td>
<td> 20 </td>
<td> <i class="glyphicon glyphicon-shopping-cart"> </i> <i class="glyphicon glyphicon-trash"> </i></td>
</tr>
<tr>
<td> A001</td>
<td> Ricotta e pera</td>
<td> 10 </td>
<td> 20 </td>
<td> <i class="glyphicon glyphicon-shopping-cart"> </i> <i class="glyphicon glyphicon-trash"> </i></td>
</tr>
</tbody>
</table>
</div>