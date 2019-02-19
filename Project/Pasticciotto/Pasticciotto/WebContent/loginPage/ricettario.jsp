<%@page import="bean.Pasticceria"%>
<%@ page import="bean.Prodotto,bean.Ricetta,java.util.Collection,java.util.Iterator,java.util.HashMap,java.util.Map" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	@SuppressWarnings("unchecked")
	Collection<Ricetta> ricette = (Collection<Ricetta>) request.getSession().getAttribute("cakes");
	Iterator<Ricetta> iRicetta = ricette.iterator();	
	
	@SuppressWarnings("unchecked")
	HashMap<Integer,Prodotto> tabHashMap = (HashMap<Integer,Prodotto>) request.getSession().getAttribute("products"); 
	
	Collection<Prodotto> composition = null;
	Iterator<Prodotto> iComposizione;
%>
<div id="headerRicettario">
	<button class="btn btn-primary" onClick="callServlet(this,'GetInventarioControl','newRicetta.jsp');"> &nbsp;&nbsp; <i class="glyphicon glyphicon-plus"> </i>&nbsp;&nbsp;  Nuova ricetta &nbsp;&nbsp; </button>
	<input class="form-control" id="mySearch" onkeyup="filterTable(event);" type="text" placeholder="Search.."> 
</div>
<div id="ricettario">
	<table class="table">
		<thead>
			<tr>
				<td> <b>Nome</b> </td>
				<td> <b>Tempo medio</b> </td>
				<td> <b>Azione</b> </td>
			</tr>
		</thead>
		<tbody id="myTable">
		<%
		for(;iRicetta.hasNext();){
			Ricetta r = (Ricetta) iRicetta.next();
			composition = r.getComposizione();
			iComposizione = composition.iterator();
		%>
			<tr id="<%=r.getCodice() %>">
			<td id="nome"><%=r.getNome() %></td>
			<td id="tempo"> <span id="ore"><%=r.getH() %></span>h:<span id="minuti"><%=r.getM() %></span>m <i class="glyphicon glyphicon-dashboard"> </i></td>
			<td> <i id="endModify" style="display:none" class="glyphicon glyphicon-arrow-up" onClick="endModifyRicetta('<%=r.getCodice() %>')" > </i> <i id="modify" style="display:inline;" class="glyphicon glyphicon-pencil" onClick="modifyRicetta('<%=r.getCodice() %>')"> </i> <i style="display:inline;" class="glyphicon glyphicon-list-alt" onClick="showRicetta('<%=r.getCodice() %>')"> </i></td>
			</tr>
			<tr id="Composition<%=r.getCodice() %>" style="display:none;">
				<td colspan="3">
					<div style="display:none;">
						<div>
							<table class="table" style="background-color: rgb(37,37,37);">
							  <thead>
								  <tr>
									  <td> <b>Ingrediente</b> </td>
									  <td> <b>Quantità</b> </td>
									  <td> <b>Elimina</b> </td>
								  </tr>
							  </thead>
							  <tbody>
							  <%
							  for(;iComposizione.hasNext();){
								  Prodotto p = (Prodotto) iComposizione.next();
							  %>
								  <tr id="<%=p.getCodice() %>">
									  <td> <%=p.getNome() %> </td>
									  <td> <span><%=p.getQuantita() %> </span> <!-- <input type="number" min="0" value="" class="form-control" style="width:50px; height:20px;">  --></td>
									  <td>
											<i style="display:inline;" class="glyphicon glyphicon-trash" onClick="removeIngredient(<%=r.getCodice() %>,<%=p.getCodice() %>,'<%=p.getNome() %>')"> </i> 
									  </td>
								  </tr>
							  <%}%>
								  <tr>
									  <td>
										  <select id="addOneIngredient" class="form-control" style="color:black; height:35px;">
										  <option> Seleziona un ingrediente...</option>
										  
										  <%
										  iComposizione = composition.iterator();
										  @SuppressWarnings("unchecked")
										  HashMap<Integer,Prodotto> cloneHash = (HashMap<Integer,Prodotto>) tabHashMap.clone();
										  for(;iComposizione.hasNext();){
											  Prodotto p = (Prodotto) iComposizione.next();
											  if(cloneHash.containsKey(p.getCodice())) cloneHash.remove(p.getCodice());
										  }
										  @SuppressWarnings("rawtypes")
										  Iterator it = cloneHash.entrySet().iterator();
										  while (it.hasNext()) {
											    @SuppressWarnings("rawtypes")
											    Map.Entry entry = (Map.Entry)it.next();
											    Prodotto p = (Prodotto) entry.getValue();
										  %>
										  <option id="<%=p.getCodice() %>"><%=p.getNome() %>  </option>
										  <%
										  }
										  
										  %>
										  
										  
										  
										  </select>
									  </td>
									  <td> 
									  	<input id="quantityProduct" type="number" min="0" value="0" class="form-control" id="exampleFormControlInput1" style="width:50px; height:20px;">
									  </td>
									  <td>
										<button class="btn btn-primary" onClick="addOneIngredientToRicetta(<%=r.getCodice() %>)">&nbsp; Aggiungi &nbsp;</button> 
								  	  </td>
								  </tr>
							  </tbody>
							  </table>
						  </div>
					</div>
				</td>
			</tr>
		<%} %>
		</tbody>
	</table>
</div>

<!-- Aggiungo la lettera R prima dell'id per identificare il modal -->
<%
iRicetta = ricette.iterator();
for(;iRicetta.hasNext();){
	Ricetta r = (Ricetta) iRicetta.next();
	composition = r.getComposizione();
	iComposizione = composition.iterator();
%>
<div id="R<%=r.getCodice() %>" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
		<div id="details" style="background-color: rgb(37,37,37); color:rgb(245,245,245); padding:30px;">
			<h1><%=r.getNome() %></h1>
			<table class="table">
				<thead>
					<tr>
						<td> <b>Ingrediente</b> </td>
						<td> <b>Quantità</b> </td>
					</tr>
				</thead>
				<tbody>
				<%for(;iComposizione.hasNext();){
					Prodotto p = (Prodotto) iComposizione.next();
					%>
						<tr>
						<td><%=p.getNome() %></td>
						<td><%=p.getQuantita() %></td>
					</tr>
				<%} %>
				</tbody>
			</table>
			<h5>Procedimento: </h5><br>
			<h6><%=r.getProcedimento() %></h6>
		</div>      
    </div>
  </div>
</div>
<%} %>