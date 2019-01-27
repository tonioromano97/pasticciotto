<%@ page import="bean.Prodotto,java.util.ArrayList" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	@SuppressWarnings("unchecked")
	ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) request.getSession().getAttribute("inventory"); 
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
  <div class="form-group" style="display: inline-block;">
  <input class="form-control" id="mySearch" onkeyup="filterTable();" type="text" placeholder="Cerca un ingrediente...">
  </div>
  <div class="form-group">
    <button type="button" class="btn btn-primary" onClick="addRecipe()"> <i class="glyphicon glyphicon-plus"> </i> Conferma inserimento </button>
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
  <%for(Prodotto p : prodotti){ %>
  <tr id="<%=p.getCodice() %>">
  <td><%=p.getNome() %></td>
  <td> <input type="number" min="0" max="<%=p.getQuantita() %>" value="0" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;"></td>
  <td> <button type="button" class="btn btn-primary" onClick="addIngredientToRicetta('<%=p.getCodice() %>','<%=p.getNome() %>');"> Aggiungi </button> </td>
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