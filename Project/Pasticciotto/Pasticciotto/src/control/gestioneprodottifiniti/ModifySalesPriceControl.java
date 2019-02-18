package control.gestioneprodottifiniti;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Ricetta;
import model.VetrinaManager;

/**
 * Servlet implementation class ModifySalesPriceControl
 */
@WebServlet("/ModifySalesPriceControl")
public class ModifySalesPriceControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifySalesPriceControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Ricetta r = new Ricetta(Integer.parseInt(request.getParameter("codeRecipe")));
		r.setPrezzoVendita(Double.parseDouble(request.getParameter("price")));
		try {
			if(VetrinaManager.modifySalesPrice(r)) response.getWriter().print("done");
			else response.getWriter().print("fail");
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
