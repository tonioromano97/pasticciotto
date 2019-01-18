<%@ include file="header.html" %>
<div id="formLogin">
<form action="Login">
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      <input id="email" type="text" class="form-control" name="email" placeholder="Email">
    </div>
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      <input id="password" type="password" class="form-control" name="password" placeholder="Password">
    </div>
    <div class="input-group">
    	<input type="submit" class="btn btn-primary" value="Accedi"/>
    	<a href="register.jsp"> <button id="nearSubmit" class="btn btn-primary"> Non sei registrato ? Registrati subito </button> </a> 
    </div>
    <div class="input-group">
    </div>
    <br>
  </form>
</div>
<%@ include file="footer.jsp" %>