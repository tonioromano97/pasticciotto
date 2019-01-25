<%@ page import="bean.Pasticceria,bean.Utente" %>
<%
	Utente u = (Utente) request.getSession().getAttribute("user");
	Pasticceria p = u.getPasticceria();
%>
<div>
	<div>
	<%if(!(p==null)){ %>
		<h1><%=p.getNome() %></h1>
		<span class="glyphicon glyphicon-road"><%=p.getIndirizzo() %></span>
		<span class="glyphicon glyphicon-phone"><%=p.getTelefono() %></span>
		<span class="glyphicon glyphicon-envelope"><%=p.getEmail() %></span>
		<p><%=p.getDescrizione() %></p>
	</div>
	<div style="width:50%;">
		<img src="<%=p.getUrlLogo() %>" style="border-radius:10px; box-shadow: 5px 10px 18px #000;"/>
	</div>
	<%} else{ %>
	<p> Non hai pasticcerie registrate </p>
	<%} %>
</div>