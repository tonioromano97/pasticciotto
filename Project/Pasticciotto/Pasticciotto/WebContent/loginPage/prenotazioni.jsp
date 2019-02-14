<%@ page import="bean.Prenotazione,bean.Ricetta,java.util.Collection,java.util.Iterator" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	@SuppressWarnings("unchecked")
	Collection<Prenotazione> prenotazioni = (Collection<Prenotazione>) request.getSession().getAttribute("prenotazioni");
	if(prenotazioni.size()>0){
	Iterator<Prenotazione> i = prenotazioni.iterator();
	Prenotazione first = (Prenotazione) i.next();
	String ricette = "r=";
%>
<ul class="nav nav-tabs">
	<%if(!first.isEffettuata()) {%>
	<li class="active"><a data-toggle="tab" href="#<%=first.getCodice() %>"><%=first.getUtente().getCognome()+" "+first.getUtente().getNome() %><br><%=first.getDataRitiro() %></a></li>
	<%} else{ %>
	<li class="active"><a data-toggle="tab" href="#<%=first.getCodice() %>"><%=first.getUtente().getCognome()+" "+first.getUtente().getNome() %><br> EFFETTUATA </a></li>
	<%}
	 for(;i.hasNext();){
		Prenotazione p = (Prenotazione) i.next();
		if(!p.isEffettuata()){
		%>
	<li><a data-toggle="tab" href="#<%=p.getCodice() %>"><%=p.getUtente().getCognome()+" "+p.getUtente().getNome() %><br><%=p.getDataRitiro() %></a></li>
    <%} else{%>
    <li><a data-toggle="tab" href="#<%=p.getCodice() %>"><%=p.getUtente().getCognome()+" "+p.getUtente().getNome() %><br>EFFETTUATA</a></li>
    <%} } %>
</ul>


  <div class="tab-content">
  	<div id="<%=first.getCodice() %>" class="tab-pane fade in active"> <br>
  		<div id="ricettePrenotate">
  		<h3>Ricette prenotate:</h3>
  		<%for(Ricetta r : first.getProdotti() ) { 
  			ricette += r.getCodice()+",";
  			ricette += "."+first.getProdotti().size();
  		%>
  		<h4> - <%=r.getNome() %></h4>
  		<% } %>
  		</div>
  		<div id="info">
  		<label> Cliente: </label> <span><%=first.getUtente().getCognome()+" "+first.getUtente().getNome() %></span> <br>
  		<label> Cellulare: </label> <span> <%=first.getUtente().getTelefono() %> </span> <br>
  		<label> Ritira il: </label> <span><%=first.getDataRitiro() %> </span> <br>
  		<label> Prenotata il: </label> <span><%=first.getDataPrenotazione() %> </span> <br>
  		</div>
  		<div id="note">
  		<label> Note del cliente: </label> <br>
      	<p><%=first.getNote() %></p>
      	</div>
      	<button class="btn btn-primary" onClick="callServlet(this,'GetCakesControl','ricettario.jsp')">&nbsp;&nbsp; Consulta il ricettario &nbsp;&nbsp;</button>
      	<%if(!first.isEffettuata()) {%>
      	<button class="btn btn-primary" onClick="setPreparata('SetEffettuataControl?e=1&p=<%=first.getCodice()%>&<%=ricette %>','prenotazioni.jsp')">&nbsp;&nbsp; Segna come preparata&nbsp;&nbsp;</button>
      	<%} %>
    </div>
    
    <%
    i = prenotazioni.iterator();
    i.next(); //scarto il primo che ho preso da first;
    for(;i.hasNext();){
    	Prenotazione p = (Prenotazione) i.next();
	%>
	<div id="<%=p.getCodice() %>" class="tab-pane fade in"> <br>
		<div id="ricettePrenotate">
  		<h3>Ricette prenotate:</h3>
  		<%
  		ricette = "r=";
  		for(Ricetta r : p.getProdotti() ) {
  			ricette += r.getCodice()+",";
  			ricette += "."+p.getProdotti().size();
  		%>
  		<h4> - <%=r.getNome() %></h4>
  		<% } %>
  		</div>
  		<div id="info">
  		<label> Cliente: </label> <span><%=p.getUtente().getCognome()+" "+p.getUtente().getNome() %></span> <br>
  		<label> Cellulare: </label> <span> <%=p.getUtente().getTelefono() %> </span> <br>
  		<label> Ritira il: </label> <span><%=p.getDataRitiro() %> </span> <br>
  		<label> Prenotata il: </label> <span><%=p.getDataPrenotazione() %> </span> <br>
  		</div>
  		<div id="note">
  		<label> Note del cliente: </label> <br>
      	<p><%=p.getNote() %></p>
      	</div>
      	<button class="btn btn-primary" onClick="callServlet(this,'GetCakesControl','ricettario.jsp')">&nbsp;&nbsp;Consulta il ricettario&nbsp;&nbsp;</button>
      	<%if(!p.isEffettuata()){ %>
      	<button class="btn btn-primary" onClick="setPreparata('SetEffettuataControl?e=1&p=<%=p.getCodice()%>&<%=ricette %>','prenotazioni.jsp')">&nbsp;&nbsp; Segna come preparata&nbsp;&nbsp;</button>
      	<%} %>
    </div>
    <%
     } 
	}
	else{
    %>
    <div> 
    Al momento non sono presenti prenotazioni di prodotti legati alla tua pasticceria.
    </div>
    <%} %>
  </div>