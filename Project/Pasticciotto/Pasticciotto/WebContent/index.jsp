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
			      <img class="d-block w-100" src="img/cake.png" alt="First slide">
			      <div class="carousel-caption d-none d-md-block carouselInformation">
    				<h5>Dolce Tentazioni</h5>
    				<span class="glyphicon glyphicon-road"> Via Roma, Salerno, 0000 </span>
    				<span class="glyphicon glyphicon-phone"> 0890000000 </span>
    				<span class="glyphicon glyphicon-envelope"> info@cake.com </span>
    				<p> La pasticceria è il miglior allenamento anche per gli chef di cucina grazie alla precisione e alla perfezione necessaria; il pasticciere invece deve conoscere i sapori e giocare con gli abbinamenti andando anche oltre la classica dolcezza.</p>
    				<button onClick="viewProducts()" type="button" class="btn btn-primary">Consulta prodotti</button>
  				</div>
			    </div>
			    <div class="carousel-item">
			      <img class="d-block w-100" src="img/sweets.png" alt="Second slide">
			      <div class="carousel-caption d-none d-md-block carouselInformation">
    				<h5>Dolce Tentazioni</h5>
    				<span class="glyphicon glyphicon-road"> Via Roma, Salerno, 0000 </span>
    				<span class="glyphicon glyphicon-phone"> 0890000000 </span>
    				<span class="glyphicon glyphicon-envelope"> info@cake.com </span>
    				<p> Grande pasticceria del mediterraneo</p>
    				<button onClick="viewProducts()" type="button" class="btn btn-primary">Consulta prodotti</button>
  				</div>
			    </div>
			    <div class="carousel-item">
			      <img class="d-block w-100" src="img/logo.png" alt="Third slide">
			      <div class="carousel-caption d-none d-md-block carouselInformation">
    				<h5>Dolce Tentazioni</h5>
    				<span class="glyphicon glyphicon-road"> Via Roma, Salerno, 0000 </span>
    				<span class="glyphicon glyphicon-phone"> 0890000000 </span>
    				<span class="glyphicon glyphicon-envelope"> info@cake.com </span>
    				<p> Grande pasticceria del mediterraneo</p>
    				<button onClick="viewProducts()" type="button" class="btn btn-primary">Consulta prodotti</button>
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
    	
    	<div id="information" style="display:none;">
				<div id="viewInformationOrProducts" class="panel panel-default">
				</div>
		</div>
<%@ include file="footer.jsp" %>    