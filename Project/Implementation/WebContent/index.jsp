<%@ include file="header.html" %>
            <div id="searchPosition">
             <div class="input-group">
			    <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
			    <input id="searchPasticceria" type="text" class="form-control" placeholder="Salerno">
			  </div>
			</div>
			
        <div id="slider">
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
			  <ol class="carousel-indicators">
			    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
			    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			  </ol>
			  <div class="carousel-inner">
			    <div class="carousel-item active">
			      <img class="d-block w-100" src="img/cake.png" alt="First slide">
			      <div class="carousel-caption d-none d-md-block">
    				<h5>Pasticceria Cake</h5>
    				<p> Ciao cio</p>
  				</div>
			    </div>
			    <div class="carousel-item">
			      <img class="d-block w-100" src="img/sweets.png" alt="Second slide">
			      <div class="carousel-caption d-none d-md-block">
    				<h5>Pasticceria Sweets</h5>
    				<p> Ciao cio</p>
  				</div>
			    </div>
			    <div class="carousel-item">
			      <img class="d-block w-100" src="img/logo.png" alt="Third slide">
			      <div class="carousel-caption d-none d-md-block">
    				<h5>Pasticceria mamt</h5>
    				<p> Ciao cio</p>
  				</div>
			    </div>
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
    	
    	<div id="information">
				<h3 id="nome"> Cake </h3> <h3 id="via"> Via Roma,  Salerno </h3> <span class="glyphicon glyphicon-road"></span> <h3 id="telefono"> 0899876543 </h3> <span class="glyphicon glyphicon-earphone"></span> <h3 id="email"> info@cake.com  </h3> <span class="glyphicon glyphicon-envelope"></span>
				<div id="viewInformationOrProducts" class="panel panel-default">
						<div class="panel-body">Informazioni pasticceria
						<button onClick="viewProducts()" type="button" class="btn btn-primary">Consulta prodotti</button>
						</div>
					</div>
    	</div>
<%@ include file="footer.jsp" %>    