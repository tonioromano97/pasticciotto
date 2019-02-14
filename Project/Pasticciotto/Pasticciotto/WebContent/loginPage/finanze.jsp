<%@page import="java.util.HashSet"%>
<%@page import="java.util.Collection,java.util.Iterator"%>
<%@ page import="bean.Utente,bean.Finanza,bean.Entrata,bean.Uscita,java.util.ArrayList" %>
<%
	@SuppressWarnings("unchecked")
	ArrayList<Finanza> finanze = (ArrayList<Finanza>) request.getSession().getAttribute("finances");
	@SuppressWarnings("unchecked")
	Collection<Finanza> finacesCollection = (Collection<Finanza>) request.getSession().getAttribute("finances");
	Collection<Entrata> entry = new HashSet<Entrata>();
	Collection<Uscita> outs = new HashSet<Uscita>();
	Iterator<Finanza> i = finacesCollection.iterator();
	for(;i.hasNext();){
		Finanza f = (Finanza) i.next();
		if(f instanceof Entrata) entry.add((Entrata) f);
		else outs.add((Uscita) f);
	}
%>
<div id="entrate">
    <h4> Entrate </h4>
    <table class="table">
    <thead>
    <tr>
    <td> Descrizione </td>
    <td> Data </td>
    <td> Importo </td>
    <td> Elimina </td>
    </tr>
    </thead>
    <tbody>
    <%
    Iterator<Entrata> iE = entry.iterator();
    for(;iE.hasNext();){ 
    Entrata e = (Entrata) iE.next();
    %>
    <tr id="<%=e.getCodice() %>">
    <td><%=e.getDescrizione() %></td>
    <td><%=e.getData() %></td>
    <td><%=e.getImporto() %> &euro; / kg </td>
    <td><i class="glyphicon glyphicon-trash" onClick="removeEntrata(<%=e.getCodice() %>)"> </i> </td>
    </tr>
    <%} %>
    </tbody>
    </table>
    <button class="btn btn-primary" onClick="showPage('newEntrata.jsp')"> &nbsp;&nbsp; Nuova Entrata &nbsp;&nbsp;</button>
    </div>
    <div id="uscite">
    <h4> Uscite </h4>
    <table class="table">
    <thead>
    <tr>
    <td> Tipo </td>
    <td> Descrizione </td>
    <td> Data </td>
    <td> Importo </td>
    <td> Elimina </td>
    </tr>
    </thead>
    <tbody>
    <%
    Iterator<Uscita> iU = outs.iterator();
    for(;iU.hasNext();){
    	Uscita u = (Uscita) iU.next();
    %>
    <tr id="<%=u.getCodice() %>">
    <td><%=u.getTipo() %></td>
    <td><%=u.getDescrizione() %></td>
    <td><%=u.getData() %></td>
    <td> &euro; <%=u.getImporto() %></td>
    <td><i class="glyphicon glyphicon-trash" onClick="removeUscita(<%=u.getCodice() %>)"> </i></td>
    </tr>
    <%} %>
    </tbody>
    </table>
    <button class="btn btn-primary" onClick="showPage('newUscita.jsp')"> &nbsp;&nbsp; Nuova Uscita &nbsp;&nbsp;</button>
    </div>