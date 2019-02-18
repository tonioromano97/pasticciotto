package control.gestioneprodottifiniti;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Pasticceria;
import bean.Ricetta;
import bean.Utente;
import model.VetrinaManager;

/**
 * Servlet implementation class GetProdottiFiniti
 */
@WebServlet("/GetProdottiFinitiControl")
public class GetProdottiFinitiControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProdottiFinitiControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Pasticceria p = ((Utente)request.getSession().getAttribute("user")).getPasticceria();
		try {
			Collection<Ricetta> cRicettas = VetrinaManager.getVetrinaProducts(p);
			request.getSession().setAttribute("endProduct", cRicettas);
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
