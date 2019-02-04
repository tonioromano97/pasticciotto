package control.gestionefinanze;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Entrata;
import bean.Pasticceria;
import bean.Uscita;
import bean.Utente;
import model.FinanceManager;

/**
 * Servlet implementation class AddUscitaControl
 */
@WebServlet("/AddUscitaControl")
public class AddUscitaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUscitaControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get the associated bakery from the user session object
		Pasticceria p = ((Utente)request.getSession().getAttribute("user")).getPasticceria();
				
		boolean done = false;
				
				
		String descrizione = request.getParameter("descrizione");
		Date data = Date.valueOf(request.getParameter("data"));
		double importo = Double.parseDouble(request.getParameter("importo"));
		String tipo = request.getParameter("tipo");
		
		Uscita uscita = new Uscita(-1,p,descrizione,data,importo,tipo);
				
		try {
			done = FinanceManager.addUscita(uscita);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
