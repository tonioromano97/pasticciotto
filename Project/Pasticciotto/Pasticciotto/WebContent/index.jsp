<%@ page import="bean.*,java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%
	@SuppressWarnings("unchecked")
	Collection<Pasticceria> Pasticcerie = (Collection<Pasticceria>) request.getSession().getAttribute("bakeries");
	Iterator<Pasticceria> i = Pasticcerie.iterator();
%>
<!doctype html>
<html lang="it">
    <head>
        <meta charset="utf-8">
        <title></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/stack-interface.css" rel="stylesheet" type="text/css" media="all">
        <link href="css/socicon.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/flickity.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/stack-interface.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/theme.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/custom.css" rel="stylesheet" type="text/css" media="all" />
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:200,300,400,400i,500,600,700" rel="stylesheet">
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>    
        
        
    </head>
    <body data-smooth-scroll-offset="77">
        <div class="nav-container">
            <div class="via-1549796496992">
                <div class="bar bar--sm visible-xs">
                    <div class="container">
                        <div class="row">
                            <div class="col-3 col-md-2">
                                <a href="index.jsp"> <img class="logo logo-dark" alt="logo" src="img/pasticciotto/Pasticciotto.png"> <img class="logo logo-light" alt="logo" src="img/pasticciotto/Pasticciotto.png"> </a>
                            </div>
                            <div class="col-9 col-md-10 text-right">
                                <a href="#" class="hamburger-toggle" data-toggle-class="#menu1;hidden-xs hidden-sm"> <i class="icon icon--sm stack-interface stack-menu"></i> </a>
                            </div>
                        </div>
                    </div>
                </div>
                <%@ include file="navBar.jsp" %>
            </div>
        </div>
        <div class="main-container">
            <section class="space--xxs bg--dark">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="slider slider--ken-burns" data-timing="4000" data-arrows="false" data-paging="true">
                                <ul class="slides" style="box-shadow: 10px 10px 10px 10px #000;">
                                    <%
                                    while(i.hasNext()){
                                    	Pasticceria p = i.next();
                                    %>
                                    <li> 

                                                <div style="position: absolute; top: 30px; left: 10px;">
                                                  <div>
                                                  <h3><%=p.getNome() %></h3>
                                                  <span><%=p.getIndirizzo() %></span> <br>
                                                  <span><%=p.getTelefono() %></span> <br>
                                                  <span><%=p.getEmail() %></span> <br>
                                                  <p><%=p.getDescrizione() %></p>
                                                  </div>
                                                  <div class="row">
                                                        <div class="col-md-12">
                                                            <div> <br>
                                                                <a onClick="showProducts(<%=p.getCodice() %>)" class="btn btn--sm btn--primary type--uppercase">
                                                                    <span class="btn__text">
                                                                            &nbsp; Consulta prodotti &nbsp;
                                                                    </span>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <img alt="Image" src="<%=p.getUrlLogo() %>">
									
                                    </li>
                                    <%} %>
                                </ul>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </section>
            <footer class="footer-7 text-center-xs bg--dark">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6"> <span class="type--fine-print">© <span class="update-year">2019</span> Antonio Romano e Giulio Varone - All Rights Reserved</span>
                        </div>
                    </div>
                </div>
            </footer>
            
                                                               <!-- Modal -->
<div class="modal fade" id="viewProductsOfPasticceria" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content" style="background-color:rgb(37,37,37); color:white;">
      <div class="modal-header">
        <h5 class="modal-title" id="nomeP" style="color:white"></h5>
      </div>
      <div id="testo" class="modal-body">
		<table>
			<thead>
				<tr>
					<td> Nome </td>
					<td> Prezzo </td>
					<td> Prenota </td>
				</tr>
			</thead>
			<tbody id="products">
				<tr>
				</tr>
			</tbody>
		</table>
      </div>
      <div class="modal-footer">
	    
	    <span id="alertLogin" style="display:none; float:left;" class="type--fine-print block">Prima di poter prenotare devi effettuare il login ! <a href="login.jsp" target="_self">Accedi </a></span>
	    <div id="books" style="display:none;float:left;" class="type--fine-print">
	    <span style="float:left;">Nel carrello c'è: </span><br>
	    <ul style="float:left;">
	    </ul>
	    </div>
      	<button class="btn btn-btn-secondary" onClick="sendBooks()">&nbsp;&nbsp;Prenota&nbsp;&nbsp;</button>
        <button type="button" class="btn btn-btn-secondary" data-dismiss="modal">&nbsp;&nbsp;Chiudi&nbsp;&nbsp;</button>
      </div>
    </div>
  </div>
</div>
            
            
        </div>
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/flickity.min.js"></script>
        <script src="js/parallax.js"></script>
        <script src="js/smooth-scroll.min.js"></script>
        <script src="js/scripts.js"></script>
        <script src="js/function.js"></script>
      
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>          
        <script src="js/Chart.js"></script>
		<script src="js/Chart.min.js"></script>
		<script src="js/Chart.min.js"></script>
		<script src="js/Chart.bundle.js"></script>
		<script src="js/Chart.bundle.js"></script>
		<script src="js/utils.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script>
        function alertLogin(){
        	$("#alertLogin").fadeIn();
        }
        function prenota(codice,nome,pasticceria){
        	<%
        	if(userLogin==null){
        	%>
        	$("#alertLogin").fadeIn();
        	<%} else{%>        	
        	$.when($("#books").slideDown())
        	.done(function(){
        		$('#books ul').append('<li style="display:none;text-align:left;" id="'+codice+'"> <i class="glyphicon glyphicon-remove"> </i>&nbsp; &nbsp;'+pasticceria+': '+nome+'</li>');
        		$('#books ul #'+codice).fadeIn();
        	});
        	
        	<%}%>
        }
        
        function sendBooks(){
        	alert("effettuo la prenotazione");
        }
        </script>
    </body>

</html>