package control.gestionefinanze;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Entrata;
import bean.Uscita;
import model.FinanceManager;

/**
 * Servlet implementation class RemoveFinanzaControl
 */
@WebServlet("/RemoveFinanzaControl")
public class RemoveFinanzaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFinanzaControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tipo = request.getParameter("tipo");
		int key = Integer.parseInt(request.getParameter("code"));
		try{
		if(tipo.equalsIgnoreCase("entrata"))
			FinanceManager.deleteFinance(new Entrata(key));
		else FinanceManager.deleteFinance(new Uscita(key));
		}
		catch (SQLException e) {
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
