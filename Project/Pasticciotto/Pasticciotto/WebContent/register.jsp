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
            <section class="height-100 imagebg text-center" data-overlay="4">
                <div class="background-image-holder"><img alt="background" src="img/pasticceria.jpg"></div>
                <div class="container pos-vertical-center">
                    <div class="row">
                        <div class="col-md-7 col-lg-5" id="formRegister">
                            <h2>Registrati subito.</h2>
                            <p class="lead"> Unisci a noi </p>
                            <form action="Register" method="POST">
                                <div class="row">
                                    <div class="col-md-6"> <input type="text" placeholder="Nome" name="nome" required> </div>
                                    <div class="col-md-6"> <input type="text" placeholder="Cognome" name="cognome" required> </div>
                                    <div class="col-md-12"> <input type="email" placeholder="Email" name="email" required> </div>
                                    <div class="col-md-6"> <input id="phone" type="text" placeholder="Telefono" name="telefono"> </div>
                                    <div class="col-md-6"> 
                                        <select name="ruolo" onChange="codeP(this)" required>
                                            <option value=""> Sono un ...</option>
                                            <option value="cliente"> Cliente</option>
                                            <option value="admin"> Proprietario </option>
                                            <option value="magazziniere"> Magazziniere </option>
                                            <option value="pasticciere"> Pasticciere</option>
                                        </select>
                                    </div>
                                    <div class="col-md-12" id="codiceP" style="display:none;"> <input type="text" name="pasticceria" placeholder="Codice pasticceria"> </div>
                                    <div class="col-md-12"> <input id="password" type="password" title="La password deve contenere 8 o più caratteri composti di almeno un numero, una lettera maiuscola e una lettera minuscola." placeholder="Password" name="password" required> </div>
                                    <div class="col-md-12"> <button style="width:100%;" class="btn btn--primary type--uppercase" type="submit" onClick="crypt()">Registrati</button> </div>
                                </div>
                            </form>
                            <span class="type--fine-print block">Hai già  un account ? <a href="login.jsp" target="_self">Accedi </a></span>
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
		<script>
			function codeP(show){
				if(($(show).val()==="magazziniere")||($(show).val()==="pasticciere")) {
					$("#codiceP input").prop('required',true);
					$("#codiceP").fadeIn();
				}
				else {
					$("#codiceP input").prop('required',false);
					$("#codiceP").fadeOut(); 
				}
			}
		</script>
		<script src="js/jquery.md5.js"> </script>
		<script>
			function crypt(){
				
				var T = $("#phone").val();
				var lT = T.length;
				if(lT>10) {
					alert("Il telefono deve avere non più di 11 cifre");
					$("#phone").val('');
					$("#password").val('');
					return;
				}
				var p = $("#password").val();
				if(p.length==0||p.length==32) return;
				var regex = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/;
				if(regex.test(p)){
					$("#password").val($.md5($("#password").val())); 
					//$("#formRegister form").submit();	
				}
				else {
					alert("La password deve contenere 8 o più caratteri composti di almeno un numero, una lettera maiuscola e una lettera minuscola.");
					$("#password").val('');
				}
			}
		</script>
    </body>

</html>