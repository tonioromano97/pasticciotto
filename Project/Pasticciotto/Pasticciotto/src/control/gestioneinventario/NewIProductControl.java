package control.gestioneinventario;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Pasticceria;
import bean.Prodotto;
import bean.Utente;
import model.ProductManager;

/**
 * Servlet implementation class NewIProductControl
 */
@WebServlet("/NewIProductControl")
public class NewIProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewIProductControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean done = false;
		Pasticceria p = ((Utente)request.getSession().getAttribute("user")).getPasticceria();
		String nome = request.getParameter("name");
		int quantita = Integer.parseInt(request.getParameter("stock"));
		int minScorta = Integer.parseInt(request.getParameter("minStock"));
		double prezzo = Double.parseDouble(request.getParameter("price"));
		Prodotto product = new Prodotto(p,-1,nome,quantita,minScorta,prezzo);
		try {
			done = ProductManager.add(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(done)
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
		else
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

