<%@ page import="bean.Utente" %>
<%Utente u = (Utente)request.getSession().getAttribute("user");%>
<div>
	<div>
		<h1><%= u.getNome() +" "+u.getCognome() %></h1>
		<span class="glyphicon glyphicon-road"> Via Roma, Salerno, 0000 </span>
		<span class="glyphicon glyphicon-phone"> 0890000000 </span>
		<span class="glyphicon glyphicon-envelope"> info@cake.com </span>
		<p> La pasticceria è il miglior allenamento anche per gli chef di cucina grazie alla precisione e alla perfezione necessaria; il pasticciere invece deve conoscere i sapori e giocare con gli abbinamenti andando anche oltre la classica dolcezza.</p>
	</div>
	<div style="width:50%;">
		<img src="img/cake.png" style="border-radius:10px; box-shadow: 5px 10px 18px #000;"/>
	</div>
</div>