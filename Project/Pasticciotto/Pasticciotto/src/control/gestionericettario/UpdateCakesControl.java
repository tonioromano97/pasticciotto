package control.gestionericettario;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Savepoint;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Prodotto;
import bean.Ricetta;
import model.RecipeManager;

/**
 * Servlet implementation class UpdateCakesControl
 */
@WebServlet("/UpdateCakesControl")
public class UpdateCakesControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCakesControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int type = Integer.parseInt(request.getParameter("type"));
		if(type==0){
			//add
			Ricetta recipe = new Ricetta(Integer.parseInt(request.getParameter("recipeKey")), null, 0);
			Prodotto product = new Prodotto(Integer.parseInt(request.getParameter("keyProduct")), null, Integer.parseInt(request.getParameter("quantity")));
			try{
				if(RecipeManager.updateComposition(recipe, product, type)){
					response.getWriter().print("Ingrediente aggiunto");
				}
				else response.getWriter().print("Si è verificato un errore");
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			//remove
			Ricetta recipe = new Ricetta(Integer.parseInt(request.getParameter("KeyRecipe")), null, 0);
			Prodotto product = new Prodotto(Integer.parseInt(request.getParameter("keyProduct")), null, 0);
			try{
				if(RecipeManager.updateComposition(recipe, product, type)){
					response.getWriter().print("done");
				}
				else response.getWriter().print("fail");
			}catch (SQLException e) {
				e.printStackTrace();
			}
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
