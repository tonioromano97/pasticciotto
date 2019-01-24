<%@ page import="bean.Finanza,bean.Entrata,bean.Uscita,java.util.ArrayList" %>
<%
	@SuppressWarnings("unchecked")
	ArrayList<Entrata> entrate = (ArrayList<Entrata>) request.getSession().getAttribute("entrate");
	@SuppressWarnings("unchecked")
	ArrayList<Uscita> uscite = (ArrayList<Uscita>) request.getSession().getAttribute("uscite");
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