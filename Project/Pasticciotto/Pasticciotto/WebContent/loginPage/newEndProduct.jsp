<%@ page import="bean.Ricetta,java.util.Collection,java.util.Iterator" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	@SuppressWarnings("unchecked")
	Collection<Ricetta> products = (Collection<Ricetta>) request.getSession().getAttribute("cakes");
	Iterator<Ricetta> i = products.iterator(); 
%>

<form id="formNewEndProduct">
	<h4> Scegli il prodotto da vendere dal menù a tendina: </h4>
	<select id="product">
	<%
	while(i.hasNext()){
		Ricetta r = i.next();
		if(!r.isInsale()){
	%>
	<option value="<%=r.getCodice() %>"><%=r.getNome() %> | Prezzo Acquisto: <%=r.getPrezzoAcquisto() %></option>
	<%} }%>
	</select> <br><br>
	<h4> Inserisci il prezzo di vendita per il prodotto selezionato: </h4>
	<input type="number" id="price"/>
	<br><br>
	<button class="btn btn-primary" onClick="addEndProduct()">&nbsp;&nbsp;  Conferma inserimento &nbsp;&nbsp; </button>
</form>