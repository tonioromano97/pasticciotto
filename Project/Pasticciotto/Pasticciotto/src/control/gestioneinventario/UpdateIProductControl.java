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
 * Servlet implementation class UpdateIProductControl
 */
@WebServlet("/UpdateIProductControl")
public class UpdateIProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateIProductControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Pasticceria p = ((Utente)request.getSession().getAttribute("user")).getPasticceria();
		int codice = Integer.parseInt(request.getParameter("code"));
		String nome = request.getParameter("name");
		int quantita = Integer.parseInt(request.getParameter("stock"));
		int minScorta = Integer.parseInt(request.getParameter("minStock"));
		double prezzo = Double.parseDouble(request.getParameter("price"));
		Prodotto prodotto = new Prodotto(p, codice, nome, quantita, minScorta, prezzo);
		try{
		ProductManager.modifyName(prodotto);
		ProductManager.modifyQuantity(prodotto);
		ProductManager.modifyMinStock(prodotto);
		ProductManager.modifyPrice(prodotto);
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
