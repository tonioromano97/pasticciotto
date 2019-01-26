<%@ page import="bean.Prodotto,java.util.ArrayList" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	@SuppressWarnings("unchecked")
	ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) request.getSession().getAttribute("inventory"); 
%>
<div id="headerInventario">
<button class="btn btn-primary" onClick="showPage(false,'newProduct.jsp');"> <i class="glyphicon glyphicon-plus"> </i> Nuovo prodotto </button>
<input class="form-control" id="mySearch" onkeyup="filterTable();" type="text" placeholder="Search.."> 
</div>
<div id="inventario">
<table class="table">
<thead>
<tr>
<td> <b>Codice</b> </td>
<td> <b>Nome</b> </td>
<td> <b> Quantità</b> </td>
<td> <b>Scorta Minima</b> </td>
<td> <b>Prezzo</b> </td>
<td> <b>Azione</b> </td>
</tr>
</thead>
<!-- Non ci devono essere spazi nei campi di <td> -->
<tbody id="myTable">
<%for(Prodotto p : prodotti){ %>
<tr id="<%=p.getCodice() %>">
<td id="codice"><%=p.getCodice() %></td>
<td id="nome"><%=p.getNome() %></td>
<td id="quantita"><%=p.getQuantita() %></td>
<td id="scorta"><%=p.getMinScorta() %></td>
<td id="scorta">&euro; <%=p.getPrezzo() %></td>
<td> <i style="display:inline;" class="glyphicon glyphicon-pencil" onClick="modifyInventario(<%=p.getCodice() %>)"> </i>&nbsp;<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeProduct(<%=p.getCodice() %>)"> </i> <button class="btn btn-primary" style="display:none;" onClick="saveInventario(<%=p.getCodice() %>)"> Salva </button></td>
</tr>
<%} %>
</tbody>
</table>
</div>