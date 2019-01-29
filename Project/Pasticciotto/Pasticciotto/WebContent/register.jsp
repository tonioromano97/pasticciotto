<%@ include file="header.html" %>
<div id="formLogin">
<form action="Register" method="POST">
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      <input id="nome" type="text" class="form-control" name="nome" placeholder="Nome" required>
    </div>
    <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input id="cognome" type="text" class="form-control" name="cognome" placeholder="Cognome" required>
    </div>
    <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
            <input id="email" type="text" class="form-control" name="email" placeholder="Email" required>
    </div>
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      <input id="password" type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="La password deve contenere 8 o più caratteri composti di almeno un numero, una lettera maiuscola e una lettera minuscola." class="form-control" name="password" placeholder="Password" required>
    </div>
    <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
            <input id="telefono" type="text" class="form-control" name="telefono" placeholder="Telefono" required>
    </div>
    <div class="input-group" style="color:white; font-size:15px;">
		<div class="radio">
		  <label id="c" onClick="codeP(false)" style="margin-right:10px; font-family:monospace;"><input type="radio" name="ruolo" value="cliente" checked>Cliente</label>
		  <label id="a" onClick="codeP(false)" style="margin-right:10px; font-family:monospace;"><input type="radio" name="ruolo" value="admin">Proprietario</label>
		  <label id="m" onClick="codeP(true)" style="margin-right:10px; font-family:monospace;"><input type="radio" name="ruolo" value="magazziniere">Magazziniere</label>
		  <label id="p" onClick="codeP(true)"style="font-family:monospace;"><input type="radio" name="ruolo" value="pasticciere">Pasticciere</label>
		</div>
    </div>
    <div class="input-group" id="codiceP" style="display:none;">
    	<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
		<input id="pasticceria" type="text" class="form-control" name="pasticceria" placeholder="Codice pasticceria">
    </div>
    <div class="input-group">
    	<input type="submit" class="btn btn-primary" value="Registrati"/>
    	<a href="login.jsp"> <button id="nearSubmit" type="button" class="btn btn-primary"> Hai già  un account ? Accedi qui </button> </a>
    </div>
    <br>
  </form>
</div>
<script>
function codeP(show){
	if(show) $("#codiceP").fadeIn();
	else $("#codiceP").fadeOut();
}
</script>
<%@ include file="footer.jsp" %>