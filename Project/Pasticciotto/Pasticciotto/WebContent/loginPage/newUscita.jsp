<form id="formNewUscita">
<div class="form-group">
    <label for="exampleFormControlSelect1">Tipo: </label>
    <select class="form-control" style="height:35px;" id="tipo">
      <option>Bolletta</option>
      <option>Fornitura</option>
      <option>Altro</option>
    </select>
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput1">Descrizione Uscita: </label>
    <input type="text" class="form-control" id="descrizione" placeholder="Descrizione">
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput2">Data:</label>
    <input type="date" class="form-control" id="data">
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput3">&euro; Importo:</label>
    <input type="number" min="0" value="0" class="form-control" id="importo">
  </div>
  <div class="form-group">
    <button type="button" class="btn btn-primary" onClick="addUscita()"> &nbsp;&nbsp; <i class="glyphicon glyphicon-plus"> </i> Conferma inserimento &nbsp;&nbsp; </button>
  </div>
</form>