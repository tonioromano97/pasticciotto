<%@ page import="bean.Prenotazione,bean.Ricetta,java.util.ArrayList" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	@SuppressWarnings("unchecked")
	ArrayList<Prenotazione> prenotazioni = (ArrayList<Prenotazione>) request.getSession().getAttribute("prenotazioni"); 
%>
<ul class="nav nav-tabs">
	<li class="active"><a data-toggle="tab" href="#<%=prenotazioni.get(0).getCodice() %>"><%=prenotazioni.get(0).getUtente().getCognome()+" "+prenotazioni.get(0).getUtente().getNome() %><br><%=prenotazioni.get(0).getDataRitiro() %></a></li>
	<%for(int i=1; i<prenotazioni.size(); i++){ %>
	<li><a data-toggle="tab" href="#<%=prenotazioni.get(i).getCodice() %>"><%=prenotazioni.get(i).getUtente().getCognome()+" "+prenotazioni.get(i).getUtente().getNome() %><br><%=prenotazioni.get(i).getDataRitiro() %></a></li>
    <%} %>
</ul>


  <div class="tab-content">
  	<div id="<%=prenotazioni.get(0).getCodice() %>" class="tab-pane fade in active"> <br>
  		<div id="ricettePrenotate">
  		<h3>Ricette prenotate:</h3>
  		<%for(Ricetta r : prenotazioni.get(0).getProdotti() ) { %>
  		<h4> - <%=r.getNome() %></h4>
  		<% } %>
  		</div>
  		<div id="info">
  		<label> Cliente: </label> <span><%=prenotazioni.get(0).getUtente().getCognome()+" "+prenotazioni.get(0).getUtente().getNome() %></span> <br>
  		<label> Cellulare: </label> <span> <%=prenotazioni.get(0).getUtente().getTelefono() %> </span> <br>
  		<label> Ritira il: </label> <span><%=prenotazioni.get(0).getDataRitiro() %> </span> <br>
  		<label> Prenotata il: </label> <span><%=prenotazioni.get(0).getDataPrenotazione() %> </span> <br>
  		</div>
  		<div id="note">
  		<label> Note del cliente: </label> <br>
      	<p><%=prenotazioni.get(0).getNote() %></p>
      	</div>
      	<button class="btn btn-primary" onClick="callServlet(this,'GetCakesControl','ricettario.jsp')"> Consulta il ricettario</button>
      	<button class="btn btn-primary"> Segna come preparata</button>
    </div>
    
    <%for(int i=1; i<prenotazioni.size(); i++){ %>
	<div id="<%=prenotazioni.get(i).getCodice() %>" class="tab-pane fade in"> <br>
		<div id="ricettePrenotate">
  		<h3>Ricette prenotate:</h3>
  		<%for(Ricetta r : prenotazioni.get(i).getProdotti() ) { %>
  		<h4> - <%=r.getNome() %></h4>
  		<% } %>
  		</div>
  		<div id="info">
  		<label> Cliente: </label> <span><%=prenotazioni.get(i).getUtente().getCognome()+" "+prenotazioni.get(i).getUtente().getNome() %></span> <br>
  		<label> Cellulare: </label> <span> <%=prenotazioni.get(i).getUtente().getTelefono() %> </span> <br>
  		<label> Ritira il: </label> <span><%=prenotazioni.get(i).getDataRitiro() %> </span> <br>
  		<label> Prenotata il: </label> <span><%=prenotazioni.get(i).getDataPrenotazione() %> </span> <br>
  		</div>
  		<div id="note">
  		<label> Note del cliente: </label> <br>
      	<p><%=prenotazioni.get(i).getNote() %></p>
      	</div>
      	<button class="btn btn-primary" onClick="callServlet(this,'GetCakesControl','ricettario.jsp')"> Consulta il ricettario</button>
      	<button class="btn btn-primary"> Segna come preparata</button>
    </div>
    <%} %>
  </div>