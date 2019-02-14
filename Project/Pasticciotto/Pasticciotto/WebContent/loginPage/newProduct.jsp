<form id="formNewProduct">
  <div class="form-group">
    <label for="exampleFormControlInput1">Nome</label>
    <input type="text" class="form-control" id="nome" placeholder="Nome prodotto">
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput1">Quantita</label>
    <input type="number" min="0" value="0" class="form-control" id="quantita">
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput1">Scorta Minima</label>
    <input type="number" min="0" value="0" class="form-control" id="scorta">
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput1">Prezzo</label>
    <input type="text" class="form-control" id="prezzo" placeholder="0.00">
  </div>
  <div class="form-group">
    <button class="btn btn-primary" type="button" onClick="addProduct()"> &nbsp; &nbsp; <i class="glyphicon glyphicon-plus"> </i> Conferma inserimento &nbsp; &nbsp;  </button>
  </div>
</form>