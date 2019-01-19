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
<td> <i class="glyphicon glyphicon-pencil"> </i> <i class="glyphicon glyphicon-list-alt" onClick="showRicetta('A0001')"> </i></td>
</tr>
<tr>
<td> Millefoglie</td>
<td> 1h:40m <i class="glyphicon glyphicon-dashboard"> </i></td>
<td> <i class="glyphicon glyphicon-pencil"> </i> <i class="glyphicon glyphicon-list-alt" onClick="showRicetta('A0002')"> </i></td>
</tr>
<tr>
<td> Panna e Nutella </td>
<td> 1h:40m <i class="glyphicon glyphicon-dashboard"> </i></td>
<td> <i class="glyphicon glyphicon-pencil"> </i> <i class="glyphicon glyphicon-list-alt" onClick="showRicetta('A0003')"> </i></td>
</tr>
</tbody>
</table>
</div>

<div id="A0001" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
		<div id="details" style="background-color: rgb(40,130,160); color:rgb(245,245,245); padding:30px;">
			<h1> Ricotta e Pera </h1>
			<table class="table">
			<thead>
			<tr>
			<td> <b>Ingrediente</b> </td>
			<td> <b>Quantità</b> </td>
			</tr>
			</thead>
			<tbody>
			<tr>
			<td>Uova</td>
			<td>3</td>
			</tr>
			<tr>
			<td>Acqua</td>
			<td>10 ml</td>
			</tr>
			<tr>
			<td>Farina</td>
			<td>200 gr</td>
			</tr>
			</tbody>
			</table>
		</div>      
    </div>
  </div>
</div>
<div id="A0002" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
		<div id="details" style="background-color: rgb(40,130,160); color:rgb(245,245,245); padding:30px;">
			<h1> Millefoglie </h1>
			<table class="table">
			<thead>
			<tr>
			<td> <b>Ingrediente</b> </td>
			<td> <b>Quantità</b> </td>
			</tr>
			</thead>
			<tbody>
			<tr>
			<td>Uova</td>
			<td>3</td>
			</tr>
			<tr>
			<td>Acqua</td>
			<td>10 ml</td>
			</tr>
			<tr>
			<td>Farina</td>
			<td>200 gr</td>
			</tr>
			</tbody>
			</table>
		</div>
    </div>
  </div>
</div>
<div id="A0003" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div id="details" style="background-color: rgb(40,130,160); color:rgb(245,245,245); padding:30px;">
			<h1> Panna e nutella </h1>
			<table class="table">
			<thead>
			<tr>
			<td> <b>Ingrediente</b> </td>
			<td> <b>Quantità</b> </td>
			</tr>
			</thead>
			<tbody>
			<tr>
			<td>Uova</td>
			<td>3</td>
			</tr>
			<tr>
			<td>Acqua</td>
			<td>10 ml</td>
			</tr>
			<tr>
			<td>Farina</td>
			<td>200 gr</td>
			</tr>
			</tbody>
			</table>
		</div>
    </div>
  </div>
</div>