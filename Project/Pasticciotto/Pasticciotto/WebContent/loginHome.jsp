<!DOCTYPE html>
<html>
    <title> Pasticciotto </title>
<head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>        
	    <link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
		<link rel="stylesheet" type="text/plain" href="bootstrap/css/bootstrap.css.map">
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/plain" href="bootstrap/css/bootstrap.min.css.map">		
		<script src="js/jquery-3.3.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <script src="js/function.js"></script>   
        <script src="js/Chart.js"></script>
		<script src="js/Chart.min.js"></script>
		<script src="js/Chart.min.js"></script>
		<script src="js/Chart.bundle.js"></script>
		<script src="js/Chart.bundle.js"></script>
		<script src="js/utils.js"></script>     
</head>
<body>
<div id="header">
                <div id="logo"> <a href="/Pasticciotto/"> <img src="img/logo.png"/> </a> </div>
                <div id="userLogin"> <div><img src="img/user.png"/> </div> <div id="buttonLogin"> <a href="logout.jsp"> <button type="button" class="btn btn-primary"> LOGOUT </button> </a> </div> </div>
</div>
<div id="sidebarLogin">
<button style="box-shadow:1px 1px 1px 1px #fff;" class="btn btn-primary" onClick="javascript:location.reload()"> Home </button> <br>
<button class="btn btn-primary" onClick="callServlet(this,'GetCakesControl','vetrina.jsp')"> Vetrina </button> <br>
<button class="btn btn-primary" onClick="callServlet(this,'GetFinanzeControl','finanze.jsp')"> Finanze </button> <br>
<button class="btn btn-primary" onClick="callServlet(this,'GetGraficiControl','grafici.jsp')"> Grafici </button> <br>
<button class="btn btn-primary" onClick="callServlet(this,'GetInventarioControl','inventario.jsp')"> Inventario </button> <br>
<button class="btn btn-primary" onClick="callServlet(this,'GetCakesControl','ricettario.jsp')"> Ricettario </button> <br>
<!--
<button class="btn btn-primary" onClick="showPage(this,'GetPrenotazioniControl','prenotazioni.jsp')"> Prenotazioni </button> <br>
<button class="btn btn-primary" onClick="showPage(this,'GetImpostazioniControl','impostazioni.jsp')"> Impostazioni </button> <br>
-->
<button class="btn btn-primary disabled"> Prenotazioni </button> <br>
<button class="btn btn-primary disabled"> Impostazioni </button> <br>
</div>
<div id="viewOptionSidebar">
<%@ include file="loginPage/home.jsp" %> 
</div>
<%@ include file="footer.jsp" %>