<!doctype html>
<html lang="it">
    <head>
        <meta charset="utf-16">
        <title></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/stack-interface.css" rel="stylesheet" type="text/css" media="all">
        <link href="css/socicon.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/stack-interface.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/theme.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/custom.css" rel="stylesheet" type="text/css" media="all" />
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:200,300,400,400i,500,600,700" rel="stylesheet">

    </head>
    <body data-smooth-scroll-offset="77">
        <div class="nav-container">
            <div class="via-1549796496992" via="via-1549796496992" vio="Header Pasticciotto">
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
            <section class="switchable bg--dark space--xxs">
                <div class="container">
                    <div class="row justify-content-between">
                        <div class="col-md-7"> <img alt="Image" class="border--round box-shadow-wide" src="img/blau/12.jpg"> </div>
                        <div class="col-md-5" id="formAddedPasticceria">
                        	<p class="lead"> Gestisci la tua pasticceria al meglio ! </p>
                			Inserisci la tua username e la password per associare la pasticceria al tuo account.
               				<hr class="short">
                            <div class="row mx-0  flex-column">
                                <form action="AddPasticceriaControl" method="POST" class="row" encType="multipart/form-data">
                                    <div class="col-md-6"> <label><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Email:</font></font></label> <input type="text" name="email" required> </div>
                                    <div class="col-md-6"> <label><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Password:</font></font></label> <input id="password" type="password" name="pw" required> </div>
                                    <div class="col-md-4"> <label><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Nome Pasticceria:</font></font></label> <input type="text" name="nomeP" required> </div>
                                    <div class="col-md-8"> <label>Email:</label> <input type="email" name="emailP" required> </div>
                                    <div class="col-md-7"> <label>Indirizzo:</label> <input type="text" name="indirizzoP" required> </div>
                                    <div class="col-md-5"> <label>Telefono:</label> <input type="text" name="telefonoP" required> </div>
                                    <div class="col-md-5"> <label>Sito Web:</label> <input type="text" name="urlWebsiteP"> </div>
                                    <div class="col-md-7"> <label>Immagine:</label> <input type="file" name="urlLogoP" required> </div>
                                    <div class="col-md-12"> <label>Descrizione:</label> <textarea rows="2" name="descrizioneP" required></textarea> </div>
                                    <div class="col-md-7 col-lg-6"> <button type="submit" class="btn type--uppercase btn--primary" onClick="crypt()"> &nbsp;&nbsp; Registra &nbsp;&nbsp;</button> </div>
                                </form>
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
        <script src="js/jquery.md5.js"> </script>
		<script>
			function crypt(){
				if($("#password").val().length==0) return;
				$("#password").val($.md5($("#password").val())); 
				//$("#formAddedPasticceria form").submit();
			}
		</script>

    </body>

</html>