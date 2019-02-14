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
@WebServlet("/RemoveProductToCakesControl")
public class RemoveProductToCakesControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveProductToCakesControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Ricetta recipe = new Ricetta(Integer.parseInt(request.getParameter("KeyRecipe")), null, 0);
		Prodotto product = new Prodotto(Integer.parseInt(request.getParameter("keyProduct")), null, 0);
		try{
			if(RecipeManager.removeProduct(recipe, product)){
				response.getWriter().print("done");
			}
			else response.getWriter().print("fail");
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
