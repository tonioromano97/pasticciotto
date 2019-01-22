<%@ page import="bean.*,java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%
	ArrayList<Pasticceria> Pasticcerie = new ArrayList<Pasticceria>();
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
			  <!-- 
			    <div class="carousel-item active">
			      <img class="d-block w-100" src="img/cake.png" alt="First slide">
			      <div class="carousel-caption d-none d-md-block carouselInformation">
    				<h5><%//Pasticcerie.get(0).getNome();%></h5>
    				<span class="glyphicon glyphicon-road"> Via Roma, Salerno, 0000 </span>
    				<span class="glyphicon glyphicon-phone"> 0890000000 </span>
    				<span class="glyphicon glyphicon-envelope"> info@cake.com </span>
    				<p> La pasticceria è il miglior allenamento anche per gli chef di cucina grazie alla precisione e alla perfezione necessaria; il pasticciere invece deve conoscere i sapori e giocare con gli abbinamenti andando anche oltre la classica dolcezza.</p>
    				<button onClick="showProducts('P0001')" type="button" class="btn btn-primary">Consulta prodotti</button>
  				</div>
			    </div>
			     -->
			    <% for(Pasticceria p : Pasticcerie) { %>
			    <div class="carousel-item">
			      <img class="d-block w-100" src="<%p.getUrlLogo();%>" alt="Second slide">
			      <div class="carousel-caption d-none d-md-block carouselInformation">
    				<h5><%p.getNome();%></h5>
    				<span class="glyphicon glyphicon-road"> <%p.getIndirizzo();%></span>
    				<span class="glyphicon glyphicon-phone"> <%p.getTelefono();%></span>
    				<span class="glyphicon glyphicon-envelope"><%p.getTelefono();%></span>
    				<p><%p.getDescrizione();%></p>
    				<button onClick="showProducts('<%p.getCodice();%>')" type="button" class="btn btn-primary">Consulta prodotti</button>
  				</div>
			    </div>
			    <% } %>
			    
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
			<h1 id="nome"> Nome pasticceria </h1>
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
			<td> Ricotta e Pera </td>
			<td> &euro; 10.00 /kg </td>
			<td> <button style="float:left;" class="btn btn-primary"> &euro; Prenota</button> </td>
			</tr>
			<tr>
			<td> Panna e Nutella</td>
			<td> &euro; 8.00 /kg </td>
			<td> <button style="float:left;" class="btn btn-primary"> &euro; Prenota</button> </td>
			</tr>
			</tbody>
			</table>
		</div>      
    </div>
  </div>
</div>
<%@ include file="footer.jsp" %>    