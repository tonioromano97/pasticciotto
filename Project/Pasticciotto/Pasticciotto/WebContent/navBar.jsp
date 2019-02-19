<%@ page import="bean.Utente" %>
<%
	Utente userLogin = (Utente) request.getSession().getAttribute("user");
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
                                    <%
                                if(userLogin != null){
                                	if(userLogin.getRuolo().equalsIgnoreCase("cliente")){
								%>
                                        <li> <a href="/Pasticciotto/" target="_self">
                                        CERCA UNA PASTICCERIA</a> </li>
                                        
                                        <%}} else{ %>
                                        <li> <a href="/Pasticciotto/" target="_self">
                                        CERCA UNA PASTICCERIA</a> </li>
                                        <%} %>
                                        <li> <a href="newPasticceria.jsp" target="_self">
                                        AGGIUNGI LA TUA PASTICCERIA<br></a> </li>
                                        <!-- <li> <a href="contattaci.jsp" target="_self">
                                        CONTATTACI<br></a> </li> -->
                                    </ul>
                                </div>
                                <%
                                if(userLogin != null){
                                	if(userLogin.getRuolo().equalsIgnoreCase("cliente")){
								%>
								<div class="bar__module">
                                    <a class="btn btn--sm btn--primary type--uppercase" href="LogoutControl"> <span class="btn__text">
                                    LOGOUT</span> </a>
                                </div>
								<%} else { %>
								
								<div class="bar__module">
                                    <a class="btn btn--sm btn--primary type--uppercase" href="loginHome.jsp"> <span class="btn__text">
                                    HOME PAGE PERSONALE</span> </a>
                                </div>
                                <%} %>
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