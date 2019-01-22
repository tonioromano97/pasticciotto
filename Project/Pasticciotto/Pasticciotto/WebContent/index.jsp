<!DOCTYPE>
<html>
<head>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
    $.ajax({url: "UploadPasticcerie", success: function(result,status){
    	alert(status);
    	if(status.toLowerCase() === "success") location.href="searchPasticcerie.jsp";
    },error: function(){
    	alert("Errore nel caricamento delle pasticcerie");
    }});
});
</script>
</head>
<title> Pasticciotto </title>
<body>
<h1> Errore nel caricamento delle pasticcerie </h1>
</body>
</html>