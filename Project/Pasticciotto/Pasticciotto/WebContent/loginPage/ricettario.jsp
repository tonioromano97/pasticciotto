<div id="headerRicettario">
<button class="btn btn-primary" onClick="showPage(false,'newRicetta.jsp');"> <i class="glyphicon glyphicon-plus"> </i> Nuova ricetta </button>
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
<tr id="A0001">
<td id="nome"> Ricotta e pera</td>
<td id="tempo"> <span id="ore">1</span>h:<span id="minuti">40</span>m <i class="glyphicon glyphicon-dashboard"> </i></td>
<td> <i id="modify" style="display:inline;" class="glyphicon glyphicon-pencil" onClick="modifyRicetta('A0001')"> </i> <i style="display:inline;" class="glyphicon glyphicon-list-alt" onClick="showRicetta('A0001')"> </i></td>
</tr>
<tr id="CompositionA0001" style="display:none;">
<td colspan="3">
<div style="display:none;">
	<div>
	<table class="table" style="background-color: rgb(40,130,160);">
	  <thead>
	  <tr>
	  <td> <b>Ingrediente</b> </td>
	  <td> <b>Quantità</b> </td>
	  <td> <b>Elimina</b> </td>
	  </tr>
	  </thead>
	  <tbody>
	  <tr id="1">
	  <td> Uova </td>
	  <td> <input type="number" min="0" value="0" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;"></td>
	  <td>
			<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeIngredient('A0001','1')"> </i> 
	  </td>
	  </tr>
	  <tr id="2">
	  <td> Farina </td>
	  <td> <input type="number" min="0" value="0" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;"></td>
	  <td>
			<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeIngredient('A0001','2')"> </i> 
	  </td>
	  </tr>
	  <tr id="3">
	  <td> Acqua </td>
	  <td> <input type="number" min="0" value="0" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;"></td>
	  <td>
			<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeIngredient('A0001','3')"> </i> 
	  </td>
	  </tr>
	  </tbody>
	  </table>
	  </div>
	<button class="btn btn-primary" onClick="saveRicetta()"> Salva modifiche</button>
</div>
</td>
</tr>
<tr id="A0002">
<td id="nome"> Millefoglie</td>
<td id="tempo"> <span id="ore">2</span>h:<span id="minuti">30</span>m <i class="glyphicon glyphicon-dashboard"> </i></td>
<td> <i id="modify" style="display:inline;" class="glyphicon glyphicon-pencil" onClick="modifyRicetta('A0002')"> </i> <i style="display:inline;" class="glyphicon glyphicon-list-alt" onClick="showRicetta('A0002')"> </i></td>
</tr>
<tr id="CompositionA0002" style="display:none;">
<td colspan="3">
<div style="display:none;">
	<div>
	<table class="table" style="background-color: rgb(40,130,160);">
	  <thead>
	  <tr>
	  <td> <b>Ingrediente</b> </td>
	  <td> <b>Quantità</b> </td>
	  <td> <b>Elimina</b> </td>
	  </tr>
	  </thead>
	  <tbody>
	  <tr id="1">
	  <td> Uova </td>
	  <td> <input type="number" min="0" value="0" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;"></td>
	  <td>
			<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeIngredient('A0002','1')"> </i> 
	  </td>
	  </tr>
	  <tr id="2">
	  <td> Farina </td>
	  <td> <input type="number" min="0" value="0" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;"></td>
	  <td>
			<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeIngredient('A0002','2')"> </i> 
	  </td>
	  </tr>
	  <tr id="3">
	  <td> Acqua </td>
	  <td> <input type="number" min="0" value="0" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;"></td>
	  <td>
			<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeIngredient('A0002','3')"> </i> 
	  </td>
	  </tr>
	  </tbody>
	  </table>
	  </div>
	<button class="btn btn-primary" onClick="saveRicetta()"> Salva modifiche</button>
</div>
</td>
</tr>
<tr id="A0003">
<td id="nome"> Panna e Nutella </td>
<td id="tempo"> <span id="ore">3</span>h:<span id="minuti">10</span>m <i class="glyphicon glyphicon-dashboard"> </i></td>
<td> <i id="modify" style="display:inline;" class="glyphicon glyphicon-pencil" onClick="modifyRicetta('A0003')"> </i> <i style="display:inline;" class="glyphicon glyphicon-list-alt" onClick="showRicetta('A0003')"> </i></td>
</tr>
<tr id="CompositionA0003" style="display:none;">
<td colspan="3">
<div style="display:none;">
	<div>
	<table class="table" style="background-color: rgb(40,130,160);">
	  <thead>
	  <tr>
	  <td> <b>Ingrediente</b> </td>
	  <td> <b>Quantità</b> </td>
	  <td> <b>Elimina</b> </td>
	  </tr>
	  </thead>
	  <tbody>
	  <tr id="1">
	  <td> Uova </td>
	  <td> <input type="number" min="0" value="0" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;"></td>
	  <td>
			<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeIngredient('A0003','1')"> </i> 
	  </td>
	  </tr>
	  <tr id="2">
	  <td> Farina </td>
	  <td> <input type="number" min="0" value="0" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;"></td>
	  <td>
			<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeIngredient('A0003','2')"> </i> 
	  </td>
	  </tr>
	  <tr id="3">
	  <td> Acqua </td>
	  <td> <input type="number" min="0" value="0" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;"></td>
	  <td>
			<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeIngredient('A0003','3')"> </i> 
	  </td>
	  </tr>
	  </tbody>
	  </table>
	  </div>
	<button class="btn btn-primary" onClick="saveRicetta()"> Salva modifiche</button>
</div>
</td>
</tr>
</tbody>
</table>
</div>
<!-- Aggiungo la lettera R prima dell'id per identificare il modal -->
<div id="RA0001" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
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
<div id="RA0002" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
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
<div id="RA0003" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
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