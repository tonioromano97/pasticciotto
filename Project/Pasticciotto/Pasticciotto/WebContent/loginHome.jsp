<%@ include file="header.html" %>
<div id="sidebarLogin">
<button class="btn btn-primary" onClick="showPage('home.jsp')"> Home </button> <br>
<button class="btn btn-primary" onClick="showPage('finanze.jsp')"> Finanze </button> <br>
<button class="btn btn-primary" onClick="showPage('grafici.jsp')"> Grafici </button> <br>
<button class="btn btn-primary" onClick="showPage('inventario.jsp')"> Inventario </button> <br>
<button class="btn btn-primary" onClick="showPage('ricettario.jsp')"> Ricettario </button> <br>
<button class="btn btn-primary" onClick="showPage('prenotazioni.jsp')"> Prenotazioni </button> <br>
<button class="btn btn-primary" onClick="showPage('impostazioni.jsp')"> Impostazioni </button> <br>
</div>
<div id="viewOptionSidebar">
<%@ include file="loginPage/home.jsp" %> 
</div>
<%@ include file="footer.jsp" %>