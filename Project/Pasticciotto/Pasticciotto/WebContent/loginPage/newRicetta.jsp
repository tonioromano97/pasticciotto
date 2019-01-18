<form>
  <div class="form-group">
    <label for="exampleFormControlInput1">Nome</label>
    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Nome prodotto">
  </div>
  <div class="form-group">
    <label>Ore : Minuti</label>
    <br>
    <input type="number" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px; display:inline-block;">
    <input type="number" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px; display:inline-block;">
  </div>
  <div class="form-group" style="display: inline-block;">
  <input class="form-control" id="mySearch" onkeyup="filterTable();" type="text" placeholder="Cerca un ingrediente...">
  </div>
  <table class="table">
  <thead>
  <tr>
  <td> <b>Ingrediente</b> </td>
  <td> <b>Quantità</b> </td>
  <td> <b>Check</b> </td>
  </tr>
  </thead>
  <tbody id="myTable">
  <tr>
  <td> Uova </td>
  <td> <input type="number" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;"></td>
  <td> <input type="checkbox" id="exampleFormControlInput1" style="width:50px; height:20px;"> </td>
  </tr>
  <tr>
  <td> Farina </td>
  <td> <input type="number" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;"></td>
  <td> <input type="checkbox" id="exampleFormControlInput1" style="width:50px; height:20px;"> </td>
  </tr>
  <tr>
  <td> Acqua </td>
  <td> <input type="number" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;"></td>
  <td> <input type="checkbox" id="exampleFormControlInput1" style="width:50px; height:20px;"> </td>
  </tr>
  </tbody>
  </table>
  <div class="form-group">
    <button class="btn btn-primary"> <i class="glyphicon glyphicon-plus"> </i> Conferma inserimento </button>
  </div>
</form>