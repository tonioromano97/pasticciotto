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
                        <div class="col-md-7"> <img alt="Image" class="border--round box-shadow-wide" src="img/blau/11.jpg"> </div>
                        <div class="col-md-5">
                            <div class="row mx-0 flex-column">
                            	<p class="lead">Non esitare a contattarci </p>
                                Invia una mail a info@pasticciotto.com oppure compila il form.
                                <hr class="short">
                                <form action="thanksContact.jsp" class="row">
                                    <div class="col-md-6"> <label>Nome:</label> <input type="text" name="name"  placeholder="Mario Rossi" required> </div>
                                    <div class="col-md-6"> <label>Email:</label> <input type="email" name="email" placeholder="mario.rossi@mail.it" required> </div>
                                    <div class="col-md-12"> <label>Messaggio:</label> <textarea rows="4" name="Message" placeholder="Scrivi qui il tuo messaggio" required></textarea> </div>
                                    <div class="col-md-5 col-lg-4"> <button type="submit" class="btn type--uppercase btn--primary">&nbsp;CONTATTACI&nbsp;</button> </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <br><br><br><br><br>
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
    </body>

</html>