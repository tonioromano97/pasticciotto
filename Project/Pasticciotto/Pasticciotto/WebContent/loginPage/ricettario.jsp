<div id="headerRicettario">
<button class="btn btn-primary" onClick="showPage('newRicetta.jsp');"> <i class="glyphicon glyphicon-plus"> </i> Nuova ricetta </button>
<input class="form-control" id="mySearch" onkeyup="filterTable();" type="text" placeholder="Search.."> 
</div>
<div id="ricettario">
<table class="table">
<thead>
<tr>
<td> <b>Nome</b> </td>
<td> <b>Tempo medio</b> </td>
<td> <b>Azione</b> </td>
</tr>
</thead>
<tbody id="myTable">
<tr>
<td> Ricotta e pera</td>
<td> 1h:40m <i class="glyphicon glyphicon-dashboard"> </i></td>
<td> <i class="glyphicon glyphicon-pencil"> </i> <i class="glyphicon glyphicon-list-alt"> </i></td>
</tr>
<tr>
<td> Millefoglie</td>
<td> 1h:40m <i class="glyphicon glyphicon-dashboard"> </i></td>
<td> <i class="glyphicon glyphicon-pencil"> </i> <i class="glyphicon glyphicon-list-alt"> </i></td>
</tr>
<tr>
<td> Panna e Nutella </td>
<td> 1h:40m <i class="glyphicon glyphicon-dashboard"> </i></td>
<td> <i class="glyphicon glyphicon-pencil"> </i> <i class="glyphicon glyphicon-list-alt"> </i></td>
</tr>
</tbody>
</table>
</div>