<!doctype html>
<html lang="it">
    <head>
        <meta charset="utf-8">
        <title></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/stack-interface.css" rel="stylesheet" type="text/css" media="all">
        <link href="css/socicon.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/stack-interface.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/theme.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/custom.css" rel="stylesheet" type="text/css" media="all" />
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:200,300,400,400i,500,600,700" rel="stylesheet">
		<style type="text/css">
			#failAccount{
				display:block;
				background-color: rgb(200,39,39,0.8);
				box-shadow: 2px 1px 30px #b00;
				border-radius: 5px;
				color: white;
				font-style: italic;
				font-weight: bold;
				padding: 5px;
				margin-bottom: 20px;
			}
		</style>
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
            <section class="height-100 imagebg text-center" data-overlay="4">
                <div class="background-image-holder"><img alt="background" src="img/blau/treCocktail.jpg"></div>
                <div class="container pos-vertical-center">
                    <div class="row">
                        <div class="col-md-7 col-lg-5" id="formLogin">
                            <h2>Bentornato!</h2>
                            <p class="lead"> Accedi per continuare</p>
                            <div style="height:50px;">
	                            <div id="failAccount" style="display:none;">
									Ops! Sembra che questo account non esista
								</div>
							</div>
                            <form action="javascript:send()">
                                <div class="row">
                                    <div class="col-md-12"> <input type="text" placeholder="Email" id="email" name="email" required> </div>
                                    <div class="col-md-12"> <input type="password" placeholder="Password" id="password" name="password" required> </div>
                                    <div class="col-md-12"> <button class="btn btn--primary type--uppercase" type="submit">&nbsp; &nbsp; Login &nbsp;&nbsp;</button> </div>
                                </div>
                            </form> 
                            <span class="type--fine-print block">Non hai ancora un account ? <a href="register.jsp" target="_self">Crea account</a></span>
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
			function send(){
				var e = $("#email").val();
				var p = $.md5($("#password").val());
				$.post("Login",{
				email: e,
				password: p
				}, function(data){
					if(data.length!=0) location.href = data;
					else{
						//$("#failAccount").css('display','block');
						$("#failAccount").fadeIn();
					}
				});
			}
		</script>

    </body>

</html>