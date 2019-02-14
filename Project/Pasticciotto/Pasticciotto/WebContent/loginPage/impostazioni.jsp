<%@ page import="bean.Pasticceria,bean.Utente" %>
<%
	Utente u = (Utente) request.getSession().getAttribute("user");
%>
<h1> Impostazioni </h1>
<div id="information" style="float:left; font-size:20px; margin-top:20px;">
<span> <%=u.getCognome() %>&nbsp;<%=u.getNome() %></span> <br>
<span> Ruolo&nbsp;: <%=u.getRuolo() %></span> <br>
<span> Cell&nbsp;&nbsp;&nbsp;&nbsp;: <%=u.getTelefono() %></span> <br>
<span> Email&nbsp;: <%=u.getEmail() %></span>
</div>
<div style="float:right;">
<button class="btn btn-primary" onClick="showModifyEmail()"> &nbsp; &nbsp; Modifica email &nbsp; &nbsp; </button> 
<button class="btn btn-primary" onClick="showModifyPassword()" style="margin-left:20px;">&nbsp; &nbsp;  Modifica password &nbsp; &nbsp; </button>
</div>
<br>
<div id="modifyPassword" style="display:none; margin-top:120px;">
<br>
<form action="javascript:savePassword()">
<input id="pw1" style="margin-bottom:10px;" class="form-control" title="La password deve contenere 8 o più caratteri composti di almeno un numero, una lettera maiuscola e una lettera minuscola." type="password" placeholder="Password"/>
<input id="pw2" style="margin-bottom:10px;" class="form-control" title="La password deve contenere 8 o più caratteri composti di almeno un numero, una lettera maiuscola e una lettera minuscola." type="password" placeholder="Conferma password"/>
<input class="btn btn-primary" type="submit" value="Salva"/>
</form>
</div>

<div id="modifyEmail" style="display:none; margin-top:120px;">
<br>
<form action="javascript:saveEmail()">
<input id="email" style="margin-bottom:10px;" class="form-control" type="text" placeholder="Email"/>
<input class="btn btn-primary" type="submit" value="Salva"/>
</form>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content" style="color:black;">
      <div class="modal-header">
        <h5 class="modal-title" id="titolo" style="color:black;">Informazioni</h5>
      </div>
      <div id="testo" class="modal-body">
        I tuoi dati sono stati salvati correttamente!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal" onClick="showPage('impostazioni.jsp')">&nbsp;&nbsp;Chiudi&nbsp;&nbsp;</button>
      </div>
    </div>
  </div>
</div>


<script src="js/jquery.md5.js"> </script>
<script type="text/javascript">
function savePassword(){
	$("#exampleModal #titolo").html('Cambio Password');
	var p = $("#pw1").val();
	var t = $("#exampleModal #testo");
	var regex = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/;
	if(!regex.test(p)) t.html('La password deve contenere 8 o più caratteri composti di almeno un numero, una lettera maiuscola e una lettera minuscola.');
	else {
		if(p!=$("#pw2").val()) t.html('Le due password non corrispondono !');
		else {
			var newP = $.md5(p);
			$.post("ModifyPasswordControl",{
				newPassword : newP
			},function(data){
				if(data==="done") t.html('La password è stata aggiornata correttamente');
				else t.html('Errore nell\'aggiornamento della password');
			});
		}
	}
	$("#exampleModal").modal('show');
	
}

function saveEmail(){
	$("#exampleModal #titolo").html('Cambio Email');
	var e = $("#email").val();
	var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if(!regex.test(e)) $("#exampleModal #testo").html('Inserisci una mail valida');
	else {
		$.post("ModifyEmailControl",{
			newEmail : e
		},function(data){
			if(data==="done") $("#exampleModal #testo").html('La email è stata aggiornata correttamente');
			else $("#exampleModal #testo").html('Errore nell\'aggiornamento della mail<br>Potrebbe essere che la mail inserita è già presente nei nostri archivi. <br> Se l\'errore persiste prova con un\'altra mail.');
		});
	}
	$("#exampleModal").modal('show');
}

function showModifyEmail(){
	$("#modifyPassword").css('display','none');
	$("#modifyEmail").fadeIn();
}

function showModifyPassword(){
	$("#modifyEmail").css('display','none');
	$("#modifyPassword").fadeIn();
}
</script>