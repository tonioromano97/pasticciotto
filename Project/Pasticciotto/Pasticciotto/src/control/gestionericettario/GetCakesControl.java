package control.gestionericettario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Pasticceria;
import bean.Prodotto;
import bean.Ricetta;
import bean.Utente;
import model.ProductManager;
import model.RecipeManager;

/**
 * Servlet implementation class GetCakesControl
 */
@WebServlet("/GetCakesControl")
public class GetCakesControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCakesControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Pasticceria p = ((Utente)request.getSession().getAttribute("user")).getPasticceria();
			ArrayList<Ricetta> recipes = RecipeManager.getRecipes(p);
			HashMap<Integer, Prodotto> productsMap = new HashMap<Integer,Prodotto>();
			for(Prodotto prodotto : ProductManager.getProducts(p))
				productsMap.put(prodotto.getCodice(), prodotto);
			request.getSession().setAttribute("cakes", recipes);
			request.getSession().setAttribute("products", productsMap);
			
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
