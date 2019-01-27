<%@ include file="header.html" %>
<style>
div{
color:white;
}
h1, h3{
padding: 10px;
}
</style>
<div>
<h1> Registrazione avvenuta con successo </h1>
<h3> Caro <%=request.getParameter("cognome")+" "+request.getParameter("nome") %>,</h3>
<h3> abbiamo inviato una mail di conferma all'indirizzo <%=request.getParameter("email") %>. </h3>
<h3> Conferma cliccando sul link per attivare il tuo account.</h3>
</div>
<%@ include file="footer.jsp" %>