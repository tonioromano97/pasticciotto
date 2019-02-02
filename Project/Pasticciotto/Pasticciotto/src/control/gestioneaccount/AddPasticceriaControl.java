package control.gestioneaccount;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Pasticceria;
import model.UserManager;

/**
 * Servlet implementation class AddPasticceriaControl
 */
@WebServlet("/AddPasticceriaControl")
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
		int codice = Integer.parseInt(request.getParameter("codice"));
		String nome = request.getParameter("nome");
		String indirizzo = request.getParameter("indirizzo");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String descrizione = request.getParameter("descrizione");
		String urlWebsite = request.getParameter("urlWebsite");
		String urlLogo = request.getParameter("urlLogo");
		
		try {
			done = UserManager.addPasticceria(new Pasticceria(codice,nome,indirizzo,email,telefono,descrizione,urlWebsite, urlLogo));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (done == true)
		{
			//Redirect to personal homepage
		}
			
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
