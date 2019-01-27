package control.gestionefinanze;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Entrata;
import bean.Finanza;
import bean.Pasticceria;
import bean.Uscita;
import bean.Utente;
import model.FinanceManager;

/**
 * Servlet implementation class AddFinanzaControl
 */
@WebServlet("/AddFinanzaControl")
public class AddFinanzaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFinanzaControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Finanza finances;
		Pasticceria p = ((Utente)request.getSession().getAttribute("user")).getPasticceria();
		String finanza = request.getParameter("finanza");
		String descrizione = request.getParameter("descrizione");
		Date data = Date.valueOf(request.getParameter("data"));
		double importo = Double.parseDouble(request.getParameter("importo"));
		if(finanza.equalsIgnoreCase("entrata"))
			finances = new Entrata(-1, p, descrizione, data, importo);
		else {
			String tipo = request.getParameter("tipo");
			finances = new Uscita(-1, p, descrizione, data, importo, tipo);
		}
		try {
			if(finances instanceof Entrata)
				FinanceManager.addEntrata((Entrata)finances);
			else FinanceManager.addUscita((Uscita)finances); 
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
