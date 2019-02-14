<%@ page import="bean.Pasticceria,bean.Utente" %>
<%
	Utente u = (Utente) request.getSession().getAttribute("user");
	Pasticceria p = u.getPasticceria();
%>
<div>
	<div style="">
	<%if(!(p==null)){ %>
		<h1><%=p.getNome() %></h1>
		<span class="glyphicon glyphicon-road">&nbsp;&nbsp;<%=p.getIndirizzo() %></span> <br><br>
		<span class="glyphicon glyphicon-phone">&nbsp;&nbsp;<%=p.getTelefono() %></span> <br><br>
		<span class="glyphicon glyphicon-envelope">&nbsp;&nbsp;<%=p.getEmail() %></span> <br><br>
		<p style="width:50%; text-align:justify;"><%=p.getDescrizione() %></p>
	</div>
	<div style="width: 450px; float: right; position: relative; bottom: 200px;">
		<img src="<%=p.getUrlLogo() %>" style="border-radius:10px; box-shadow: 5px 10px 18px #000;"/>
	</div>
	<%} else{ %>
	<p> Non hai pasticcerie registrate </p>
	<%} %>
</div>