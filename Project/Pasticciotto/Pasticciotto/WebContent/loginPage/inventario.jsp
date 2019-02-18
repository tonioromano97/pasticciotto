<%@ page import="bean.Prodotto,java.util.Collection,java.util.Iterator" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	@SuppressWarnings("unchecked")
	Collection<Prodotto> products = (Collection<Prodotto>) request.getSession().getAttribute("inventory");
	Iterator<Prodotto> i = products.iterator();

%>
<div id="headerInventario">
<button class="btn btn-primary" onClick="showPage('newProduct.jsp');">&nbsp;&nbsp;  <i class="glyphicon glyphicon-plus"> </i> &nbsp;&nbsp; Nuovo prodotto &nbsp;&nbsp;</button>
<input class="form-control" id="mySearch" onkeyup="filterTable(event);" type="text" placeholder="Search.."> 
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
<%
for(;i.hasNext();){
	Prodotto p = (Prodotto) i.next();
	if(p.getQuantita()>p.getMinScorta()){ %>
		<tr id="<%=p.getCodice() %>">
	<% } else{ %>
		<tr id="<%=p.getCodice() %>" class="table-danger">
	<%} %>
	<td id="codice"><%=p.getCodice() %></td>
	<td id="nome"><%=p.getNome() %></td>
	<td id="quantita"><%=p.getQuantita() %></td>
	<td id="scorta"><%=p.getMinScorta() %></td>
	<td id="prezzo"><%=p.getPrezzo() %></td>
	<td> <i style="display:inline;" class="glyphicon glyphicon-pencil" onClick="modifyInventario(<%=p.getCodice() %>)"> </i>&nbsp;<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeProduct(<%=p.getCodice() %>)"> </i> <button class="btn btn-primary" style="display:none;" onClick="saveInventario(<%=p.getCodice() %>)"> Salva </button></td>
	</tr>
<%} %>
</tbody>
</table>
</div>