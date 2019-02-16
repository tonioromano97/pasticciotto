package control.gestioneaccount;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Pasticceria;
import bean.Utente;
import model.UserManager;

/**
 * @author giulio
 * This servlet lets the registration of a new user
 */
@WebServlet("/Register")
public class RegisterControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterControl() {
        super();

    }

	/**
	 * In the request of this Servlet, given the user data, the control register the new user and
	 * redirect the user to the personal homepage
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		if (nome.equals(""))
			nome = null;
		String cognome = request.getParameter("cognome");
		if (cognome.equals(""))
			cognome = null;
		String email = request.getParameter("email");
		if (email.equals(""))
			email = null;
		String password = request.getParameter("password");
		if (password.equals(""))
			password = null;
		String telefono = request.getParameter("telefono");
		String ruolo = request.getParameter("ruolo");
		if (ruolo.equals(""))
			ruolo = null;
		Pasticceria pasticceria = null;
		if(ruolo.equalsIgnoreCase("magazziniere")||ruolo.equalsIgnoreCase("pasticciere")){
			 pasticceria = new Pasticceria(Integer.parseInt(request.getParameter("pasticceria")));
			 System.out.println(""+request.getParameter("pasticceria"));
		}
		
		Utente u = new Utente(nome,cognome,email,password,telefono,pasticceria,ruolo,0);
		
		try {
			UserManager.register(u);
			response.sendRedirect("registerok.jsp?nome="+u.getNome()+"&cognome="+u.getCognome()+"&email="+u.getEmail());
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
