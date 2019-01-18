<%@ include file="header.html" %>
<div id="formLogin">
<form>
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      <input id="nome" type="text" class="form-control" name="nome" placeholder="Nome">
    </div>
    <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input id="cognome" type="text" class="form-control" name="cognome" placeholder="Cognome">
    </div>
    <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
            <input id="email" type="text" class="form-control" name="email" placeholder="Email">
    </div>
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      <input id="password" type="password" class="form-control" name="password" placeholder="Password">
    </div>
    <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
            <input id="telefono" type="text" class="form-control" name="telefono" placeholder="Telefono">
    </div>
    <div class="input-group">
    	<input type="submit" class="btn btn-primary" value="Registrati"/>
    	<a href="login.jsp"> <button id="nearSubmit" class="btn btn-primary"> Hai già  un account ? Accedi qui </button> </a>
    </div>
    <br>
  </form>
</div>
<%@ include file="footer.jsp" %>