package control.gestionericettario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Pasticceria;
import bean.Prodotto;
import bean.Ricetta;
import bean.Utente;
import model.RecipeManager;

/**
 * Servlet implementation class NewCakesControl
 */
@WebServlet("/NewCakesControl")
public class NewCakesControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCakesControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Pasticceria p = ((Utente)request.getSession().getAttribute("user")).getPasticceria();
		String nome = request.getParameter("name");
		int ore = Integer.parseInt(request.getParameter("h"));
		int minuti = Integer.parseInt(request.getParameter("m"));
		String procedimento = request.getParameter("procedimento");
		double prezzoVendita = Double.parseDouble(request.getParameter("pV"));
		double prezzoAcquisto = Double.parseDouble(request.getParameter("pA"));
		int ingredienti = Integer.parseInt(request.getParameter("i"));
		
		Ricetta recipe = new Ricetta(6, nome, ore, minuti, prezzoVendita, prezzoAcquisto, p);
		recipe.setProcedimento(procedimento);
		
		ArrayList<Prodotto> products = new ArrayList<Prodotto>();
	
		for(int i=0; i<ingredienti; i++){
			int code = Integer.parseInt(request.getParameter("c"+i));
			int dose = Integer.parseInt(request.getParameter("d"+i));
			products.add(new Prodotto(code, null, dose));
		}
		recipe.setComposizione(products);
		try{
		RecipeManager.add(recipe);
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
