package control.gestioneaccount;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import bean.Pasticceria;
import bean.Utente;
import model.UserManager;

/**
 * Servlet implementation class AddPasticceriaControl
 */
@WebServlet("/AddPasticceriaControl")
@MultipartConfig(location="/Users/antonioromano/Documents/GitHub/pasticciotto/Project/Pasticciotto/Pasticciotto/WebContent/img/pasticcerie", fileSizeThreshold=1024*1024, maxFileSize=1024*1024*15, maxRequestSize=1024*1024*15*15)
public class AddPasticceriaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPasticceriaControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean done = false;
		int isCliente = 0;
		Utente utente = null;
		Pasticceria pasticceria = null;
		String email = request.getParameter("email");
		String password = request.getParameter("pw");
		String nomeP = request.getParameter("nomeP");
		if(nomeP.equals(""))
			nomeP=null;
		String indirizzoP = request.getParameter("indirizzoP");
		if(indirizzoP.equals(""))
			indirizzoP = null;
		String emailP = request.getParameter("emailP");
		String telefonoP = request.getParameter("telefonoP");
		String descrizioneP = request.getParameter("descrizioneP");
		String urlWebsiteP = request.getParameter("urlWebsiteP");
		Part filePart = request.getPart("urlLogoP");
		try {
			utente = UserManager.login(email, password);
			if(utente!=null){
				if(utente.getRuolo().equalsIgnoreCase("cliente")) { done = false; isCliente=1; }
				else{
					String nomeFile = filePart.getSubmittedFileName();
					String estensione = nomeFile.substring(nomeFile.indexOf('.'));
					System.out.println("Dimensione file: "+filePart.getSize());
					System.out.println("Scrivo file su disco...");
					filePart.write(utente.getEmail()+estensione);
					System.out.println("Scritto!");
					pasticceria = new Pasticceria(0,nomeP,indirizzoP,emailP,telefonoP,descrizioneP,urlWebsiteP, "img/pasticcerie/"+utente.getEmail()+estensione);
					done = UserManager.addPasticceria(pasticceria,utente);
				}
			}
			else done = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (done == true)
		{
			//Redirect to personal homepage
			String cn = utente.getCognome()+" "+utente.getNome();
			String nP = pasticceria.getNome();
			response.sendRedirect("addedPasticceria.jsp?done=true&user="+cn+"&pasticceria="+nP);
		}
		else response.sendRedirect("addedPasticceria.jsp?done=false&isCliente="+isCliente);	
		// else redirect to error
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
