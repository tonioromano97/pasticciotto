<%@ page import="bean.*,java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%
	@SuppressWarnings("unchecked")
	ArrayList<Pasticceria> Pasticcerie = (ArrayList<Pasticceria>) request.getSession().getAttribute("pasticcerie");	
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
			      <img class="d-block w-100" src="<%=Pasticcerie.get(0).getUrlLogo() %>" alt="First slide">
			      <div class="carousel-caption d-none d-md-block carouselInformation">
    				<h5><%=Pasticcerie.get(0).getNome() %></h5>
    				<span class="glyphicon glyphicon-road"><%=Pasticcerie.get(0).getIndirizzo() %></span>
    				<span class="glyphicon glyphicon-phone"><%=Pasticcerie.get(0).getTelefono() %></span>
    				<span class="glyphicon glyphicon-envelope"><%=Pasticcerie.get(0).getEmail() %></span>
    				<p><%=Pasticcerie.get(0).getDescrizione() %></p>
    				<button onClick="showProducts(<%=Pasticcerie.get(0).getCodice() %>)" type="button" class="btn btn-primary">Consulta prodotti</button>
  				</div>
			    </div>
			    
			    <%for(int i=1; i<Pasticcerie.size(); i++){ %>
			    <div class="carousel-item">
			      <img class="d-block w-100" src="<%=Pasticcerie.get(i).getUrlLogo() %>" alt="First slide">
			      <div class="carousel-caption d-none d-md-block carouselInformation">
    				<h5><%=Pasticcerie.get(i).getNome() %></h5>
    				<span class="glyphicon glyphicon-road"><%=Pasticcerie.get(i).getIndirizzo() %></span>
    				<span class="glyphicon glyphicon-phone"><%=Pasticcerie.get(i).getTelefono() %></span>
    				<span class="glyphicon glyphicon-envelope"><%=Pasticcerie.get(i).getEmail() %></span>
    				<p><%=Pasticcerie.get(i).getDescrizione() %></p>
    				<button onClick="showProducts(<%=Pasticcerie.get(i).getCodice() %>)" type="button" class="btn btn-primary">Consulta prodotti</button>
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