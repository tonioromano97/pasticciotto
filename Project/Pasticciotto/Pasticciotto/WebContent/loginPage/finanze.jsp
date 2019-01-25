<%@ page import="bean.Utente,bean.Finanza,bean.Entrata,bean.Uscita,java.util.ArrayList" %>
<%
	@SuppressWarnings("unchecked")
	ArrayList<Finanza> finanze = (ArrayList<Finanza>) request.getSession().getAttribute("finances");
	ArrayList<Entrata> entrate = new ArrayList<Entrata>();
	ArrayList<Uscita> uscite = new ArrayList<Uscita>();
	for(Finanza f : finanze){
		if(f instanceof Entrata) entrate.add((Entrata)f);
		else uscite.add((Uscita)f);
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
    </tr>
    </thead>
    <tbody>
    <%for(Entrata e : entrate){ %>
    <tr>
    <td><%=e.getDescrizione() %></td>
    <td><%=e.getData() %></td>
    <td><%=e.getImporto() %> &euro; / kg </td>
    </tr>
    <%} %>
    </tbody>
    </table>
    <button class="btn btn-primary" onClick="showPage(false,'newEntrata.jsp')"> Nuova Entrata</button>
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
    </tr>
    </thead>
    <tbody>
    <%for(Uscita u : uscite){ %>
    <tr>
    <td><%=u.getTipo() %></td>
    <td><%=u.getDescrizione() %></td>
    <td><%=u.getData() %></td>
    <td> &euro; <%=u.getImporto() %></td>
    </tr>
    <%} %>
    </tbody>
    </table>
    <button class="btn btn-primary" onClick="showPage(false,'newUscita.jsp')"> Nuova Uscita</button>
    </div>