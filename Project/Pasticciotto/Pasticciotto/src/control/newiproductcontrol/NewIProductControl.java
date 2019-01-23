package control.newiproductcontrol;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Prodotto;
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
		
		String nome = request.getParameter("nome");
		int codice = Integer.parseInt(request.getParameter("codice"));
		int quantita = Integer.parseInt(request.getParameter("quantita"));
		int minScorta = Integer.parseInt(request.getParameter("minScorta"));
		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		
		Prodotto product = new Prodotto(null,codice,nome,quantita,minScorta,prezzo); //Aggiustare la pasticceria in tutti i control
		
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

