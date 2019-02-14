package control.gestionericettario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;

import bean.Pasticceria;
import bean.Prodotto;
import bean.Ricetta;
import bean.Utente;
import model.RecipeManager;

/**
 * Servlet implementation class NewCakesControl
 */
@WebServlet("/AddProductToCakesControl")
public class AddProductToCakesControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductToCakesControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Ricetta recipe = new Ricetta(Integer.parseInt(request.getParameter("recipeKey")), null, 0);
		Prodotto product = new Prodotto(Integer.parseInt(request.getParameter("keyProduct")), null, Integer.parseInt(request.getParameter("quantity")));
		try{
			if(RecipeManager.addProduct(recipe, product)){
				response.getWriter().print("Ingrediente aggiunto");
			}
			else response.getWriter().print("Si è verificato un errore");
		}catch (SQLException e) {
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
