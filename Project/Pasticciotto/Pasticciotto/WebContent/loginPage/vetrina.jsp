<%@ page import="bean.Ricetta,java.util.ArrayList" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	@SuppressWarnings("unchecked")
	ArrayList<Ricetta> ricette = (ArrayList<Ricetta>) request.getSession().getAttribute("cakes");
%>
<div id="vetrina">
<table class="table">
<thead>
<tr>
<td> <b>Nome</b> </td>
<td> <b> Prezzo Acquisto</b> </td>
<td> <b>Prezzo Vendita</b> </td>
</tr>
</thead>
<tbody id="myTable">
<%for(Ricetta r : ricette){ %>
<tr>
<td id="nome"><%=r.getNome()%></td>
<td id="pA"><%=r.getPrezzoAcquisto()%></td>
<td id="pV"><%=r.getPrezzoVendita()%></td>
</tr>
<%}%>
</tbody>
</table>
</div>