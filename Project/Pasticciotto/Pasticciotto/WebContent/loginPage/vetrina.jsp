<%@ page import="bean.Ricetta,java.util.Collection,java.util.Iterator" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	@SuppressWarnings("unchecked")
	Collection<Ricetta> ricette = (Collection<Ricetta>) request.getSession().getAttribute("endProduct");
	Iterator<Ricetta> i = ricette.iterator();
%>
<div id="vetrina">
	<button class="btn btn-primary" onClick="callServlet(this,'GetCakesControl','newEndProduct.jsp');"> &nbsp;&nbsp; <i class="glyphicon glyphicon-plus"> </i>&nbsp;&nbsp;  Nuovo Prodotto &nbsp;&nbsp; </button>
	<table class="table">
		<thead>
			<tr>
				<td> <b>Nome</b> </td>
				<td> <b> Prezzo Acquisto</b> </td>
				<td> <b>Prezzo Vendita</b> </td>
				<td> <b>Opzioni</b> </td>
			</tr>
		</thead>
		<tbody id="myTable">
		<%
		for(;i.hasNext();){
			Ricetta r = i.next();
		%>
			<tr id="<%=r.getCodice() %>">
				<td id="nome"><%=r.getNome()%></td>
				<td id="pA"><%=r.getPrezzoAcquisto()%></td>
				<td id="pV"><%=r.getPrezzoVendita()%></td>
				<td> <i id="modify" style="display:inline;" class="glyphicon glyphicon-pencil" onClick="modifyPriceEndProduct(<%=r.getCodice() %>)"> </i> &nbsp; <i id="remove" style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeEndProduct(<%=r.getCodice() %>)"> </i> <button class="btn btn-primary" id="save" style="display:none;" onClick="savePriceEndProduct(<%=r.getCodice() %>)">&nbsp;&nbsp; Salva &nbsp;&nbsp;</button></td>
			</tr>
		<%}%>
		</tbody>
	</table>
</div>