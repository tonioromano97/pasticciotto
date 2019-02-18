<%@ page import="bean.Prodotto,java.util.Collection,java.util.Iterator" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	@SuppressWarnings("unchecked")
	Collection<Prodotto> products = (Collection<Prodotto>) request.getSession().getAttribute("inventory");
	Iterator<Prodotto> i = products.iterator(); 
%>
<form id="formNewRecipe">
  <div class="form-group">
    <label for="exampleFormControlInput1">Nome</label>
    <input type="text" class="form-control" id="nome" placeholder="Nome prodotto">
  </div>
  <div class="form-group">
    <label>Ore : Minuti</label>
    <br>
    <input type="number" min="0" value="0" class="form-control" id="ore" style="width:50px; height:20px; display:inline-block;">
    <input type="number" min="0" max="59" value="0" class="form-control" id="minuti" style="width:50px; height:20px; display:inline-block;">
  </div>
  <div class="form-group">
    <label>Procedimento</label>
    <br>
    <textarea id="procedimento" rows="3"></textarea>
  </div>
  <div class="form-group" style="display: inline-block;">
  <input class="form-control" id="mySearch" onkeyup="filterTable(event);" type="text" placeholder="Search...">
  </div>
  <div class="form-group">
    <button type="button" class="btn btn-primary" onClick="addRecipe()"> &nbsp; &nbsp;  <i class="glyphicon glyphicon-plus"> </i> Conferma inserimento  &nbsp; &nbsp; </button>
  </div>
  
  <div id="okok">
  <div style="width: 40%;display: inline-block; float:left;">
  <table class="table">
  <thead>
  <tr>
  <td> <b>Ingrediente</b> </td>
  <td> <b>Quantità</b> </td>
  <td> <b>Aggiungi</b> </td>
  </tr>
  </thead>
  <tbody id="myTable">
  <%
  for(;i.hasNext();){
	  Prodotto p = (Prodotto) i.next();
  %>
	  <tr id="<%=p.getCodice() %>">
	  <td><%=p.getNome() %></td>
	  <td> <input type="number" min="0" max="<%=p.getQuantita() %>" value="0" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;"></td>
	  <td> <button type="button" style="width:90px; text-align:center;" class="btn btn--sm btn--primary" onClick="addIngredientToRicetta('<%=p.getCodice() %>','<%=p.getNome() %>');"> Aggiungi </button> </td>
	  </tr>
  <%} %>
  </tbody>
  </table>
  </div>
  <div style="width: 40%;display: inline-block;margin-left: 30px;">
  <!-- Tabella composizione ricetta -->
  <table class="table" id="tableRicetta">
  <thead>
  <tr>
  <td> <b>Ingrediente</b> </td>
  <td> <b>Quantità</b> </td>
  <td> <b>Rimuovi</b> </td>
  </tr>
  </thead>
  <tbody id="compositionRicetta">
  </tbody>
  </table>
  </div>
  </div>
</form>