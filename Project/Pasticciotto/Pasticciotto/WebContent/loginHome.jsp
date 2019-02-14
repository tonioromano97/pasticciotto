<%@ page import="bean.Utente" %>
<%
	Utente utente = (Utente) request.getSession().getAttribute("user");
	String ruolo = utente.getRuolo();
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
	    
	    <link rel="stylesheet" type="text/css" href="css/style_loginHome.css">
		
		
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
                
					<%
						Utente userLogin = (Utente) request.getSession(false).getAttribute("user");
					%>
					<nav id="menu1" class="bar bar-1 hidden-xs bg--dark">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-1 col-md-2 hidden-xs">
                                <div class="bar__module">
                                    <a href="/Pasticciotto/" class="btn btn--sm  type--uppercase"><span class="btn__text">
                                    Pasticciotto </span></a>
                                </div>
                            </div>
                            <div class="col-lg-11 col-md-12 text-right text-left-xs text-left-sm">
                                <div class="bar__module">
                                    <ul class="menu-horizontal text-left">
                                        <li> <a href="/Pasticciotto/" target="_self">
                                        CERCA UNA PASTICCERIA</a> </li>
                                        <li> <a href="newPasticceria.jsp" target="_self">
                                        AGGIUNGI LA TUA PASTICCERIA<br></a> </li>
                                        <li> <a href="contattaci.jsp" target="_self">
                                        CONTATTACI<br></a> </li>
                                    </ul>
                                </div>
                                <%
                                if(userLogin != null){
								%>
								<div class="bar__module">
                                    <a class="btn btn--sm btn--primary type--uppercase" href="logout.jsp"> <span class="btn__text">
                                    LOGOUT</span> </a>
                                </div>
								<%} else { %>
                                <div class="bar__module">
                                    <a class="btn btn--sm btn--primary type--uppercase" href="login.jsp"> <span class="btn__text">
                                    LOGIN</span> </a>
                                </div>
                                <%} %>
                            </div>
                        </div>
                    </div>
				</nav>
                
                
            </div>
        </div>
<div class="main-container">
            <section class="space--xxs bg--dark">
                <div class="container">        
<div id="sidebarLogin">
<%if(ruolo.equalsIgnoreCase("admin")){ %>
<button style="box-shadow:1px 1px 1px 1px #fff;" class="btn btn-primary" onClick="javascript:location.reload()"> Home </button> <br>
<button class="btn btn-primary" onClick="callServlet(this,'GetCakesControl','vetrina.jsp')"> Vetrina </button> <br>
<button class="btn btn-primary" onClick="callServlet(this,'GetFinanzeControl','finanze.jsp')"> Finanze </button> <br>
<button class="btn btn-primary" onClick="callServlet(this,'GetGraficiControl','grafici.jsp')"> Grafici </button> <br>
<button class="btn btn-primary" onClick="callServlet(this,'GetInventarioControl','inventario.jsp')"> Inventario </button> <br>
<button class="btn btn-primary" onClick="callServlet(this,'GetCakesControl','ricettario.jsp')"> Ricettario </button> <br>
<button class="btn btn-primary" onClick="callServlet(this,'GetPrenotazioniControl','prenotazioni.jsp')"> Prenotazioni </button> <br>
<button class="btn btn-primary" onClick="callServlet(this,'','impostazioni.jsp')"> Impostazioni </button> <br>
<%}else if(ruolo.equalsIgnoreCase("pasticciere")){ %> 
<button style="box-shadow:1px 1px 1px 1px #fff;" class="btn btn-primary" onClick="javascript:location.reload()"> Home </button> <br>
<button class="btn btn-primary disabled"> Vetrina </button> <br>
<button class="btn btn-primary disabled"> Finanze </button> <br>
<button class="btn btn-primary disabled"> Grafici </button> <br>
<button class="btn btn-primary disabled"> Inventario </button> <br>
<button class="btn btn-primary" onClick="callServlet(this,'GetCakesControl','ricettario.jsp')"> Ricettario </button> <br>
<button class="btn btn-primary" onClick="callServlet(this,'GetPrenotazioniControl','prenotazioni.jsp')"> Prenotazioni </button> <br>
<button class="btn btn-primary" onClick="callServlet(this,'','impostazioni.jsp')"> Impostazioni </button> <br>
<%}else if(ruolo.equalsIgnoreCase("magazziniere")){ %>
<button style="box-shadow:1px 1px 1px 1px #fff;" class="btn btn-primary" onClick="javascript:location.reload()"> Home </button> <br>
<button class="btn btn-primary disabled"> Vetrina </button> <br>
<button class="btn btn-primary disabled"> Finanze </button> <br>
<button class="btn btn-primary disabled"> Grafici </button> <br>
<button class="btn btn-primary" onClick="callServlet(this,'GetInventarioControl','inventario.jsp')"> Inventario </button> <br>
<button class="btn btn-primary disabled"> Ricettario </button> <br>
<button class="btn btn-primary disabled"> Prenotazioni </button> <br>
<button class="btn btn-primary" onClick="callServlet(this,'','impostazioni.jsp')"> Impostazioni </button> <br>
<%} %>
</div>
<div id="viewOptionSidebar">
<%@ include file="loginPage/home.jsp" %> 
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
        
    </body>

</html>