<%@ page import="bean.*,java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%
	@SuppressWarnings("unchecked")
	Collection<Pasticceria> Pasticcerie = (Collection<Pasticceria>) request.getSession().getAttribute("bakeries");
	Iterator i = Pasticcerie.iterator();
	Pasticceria first = (Pasticceria)i.next();
%>

<%@ include file="header.html" %>
            <div id="searchPosition">
             <div class="input-group">
			    <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
			    <input id="searchPasticceria" type="text" class="form-control" placeholder="Salerno">
			  </div>
			</div>
			
        <div id="slider">
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
			  
			  <div class="carousel-inner">
			  
			    <div class="carousel-item active">
			      <img class="d-block w-100" src="<%=first.getUrlLogo() %>" alt="First slide">
			      <div class="carousel-caption d-none d-md-block carouselInformation">
    				<h5><%=first.getNome() %></h5>
    				<span class="glyphicon glyphicon-road"><%=first.getIndirizzo() %></span>
    				<span class="glyphicon glyphicon-phone"><%=first.getTelefono() %></span>
    				<span class="glyphicon glyphicon-envelope"><%=first.getEmail() %></span>
    				<p><%=first.getDescrizione() %></p>
    				<button onClick="showProducts(<%=first.getCodice() %>)" type="button" class="btn btn-primary">Consulta prodotti</button>
  				</div>
			    </div>
			    
			    <%for(;i.hasNext();)
			    { 
			    	Pasticceria p = (Pasticceria)i.next();%>
			    <div class="carousel-item">
			      <img class="d-block w-100" src="<%=p.getUrlLogo() %>" alt="First slide">
			      <div class="carousel-caption d-none d-md-block carouselInformation">
    				<h5><%=p.getNome() %></h5>
    				<span class="glyphicon glyphicon-road"><%=p.getIndirizzo() %></span>
    				<span class="glyphicon glyphicon-phone"><%=p.getTelefono() %></span>
    				<span class="glyphicon glyphicon-envelope"><%=p.getEmail() %></span>
    				<p><%=p.getDescrizione() %></p>
    				<button onClick="showProducts(<%=p.getCodice() %>)" type="button" class="btn btn-primary">Consulta prodotti</button>
  				</div>
			    </div>
			    <%} %>
			    
			    
			  </div>
			  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
		</div>
		</div>
    	
    	<div id="information" style="display:none;">
				<div id="viewInformationOrProducts" class="panel panel-default">
				</div>
		</div>

<div id="viewProductsOfPasticceria" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
		<div id="details" style="background-color: rgb(40,130,160); color:rgb(245,245,245); padding:30px;">
			<h1 id="nomeP"></h1>
			<table class="table">
			<thead>
			<tr>
			<th> Nome </th>
			<th> Prezzo </th>
			<th> Prenota </th>
			</tr>
			</thead>
			<tbody id="products">
			<tr>
			</tr>
			</tbody>
			</table>
		</div>      
    </div>
  </div>
</div>
<%@ include file="footer.jsp" %>    