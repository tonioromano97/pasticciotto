<form>
  <div class="form-group">
    <label for="exampleFormControlInput1">Nome</label>
    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Nome prodotto">
  </div>
  <div class="form-group">
    <label>Ore : Minuti</label>
    <br>
    <input type="number" min="0" value="0" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px; display:inline-block;">
    <input type="number" min="0" value="0" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px; display:inline-block;">
  </div>
  <div class="form-group" style="display: inline-block;">
  <input class="form-control" id="mySearch" onkeyup="filterTable();" type="text" placeholder="Cerca un ingrediente...">
  </div>
  <div class="form-group">
    <button class="btn btn-primary"> <i class="glyphicon glyphicon-plus"> </i> Conferma inserimento </button>
  </div>
  
  <div>
  <div style="width: 40%;display: inline-block; float:left;">
  <table class="table">
  <thead>
  <tr>
  <td> <b>Ingrediente</b> </td>
  <td> <b>Quantità</b> </td>
  <td> <b>Aggiungi</b> </td>
  </tr>
  </thead>
  <tbody id="myTable">
  <tr id="1">
  <td> Uova </td>
  <td> <input type="number" min="0" value="0" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;"></td>
  <td> <button type="button" class="btn btn-primary" onClick="addIngredientToRicetta('1','Uova');"> Aggiungi </button> </td>
  </tr>
  <tr id="2">
  <td> Farina </td>
  <td> <input type="number" min="0" value="0" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;"></td>
  <td> <button type="button" class="btn btn-primary" onClick="addIngredientToRicetta('2','Farina');"> Aggiungi </button> </td>
  </tr>
  <tr id="3">
  <td> Acqua </td>
  <td> <input type="number" min="0" value="0" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;"></td>
  <td> <button type="button" class="btn btn-primary" onClick="addIngredientToRicetta('3','Acqua');"> Aggiungi </button> </td>
  </tr>
  </tbody>
  </table>
  </div>
  <div style="width: 40%;display: inline-block;margin-left: 30px;">
  <!-- Tabella composizione ricetta -->
  <table class="table" id="tableRicetta">
  <thead>
  <tr>
  <td> <b>Ingrediente</b> </td>
  <td> <b>Quantità</b> </td>
  <td> <b>Rimuovi</b> </td>
  </tr>
  </thead>
  <tbody>
  </tbody>
  </table>
  </div>
  </div>
</form>