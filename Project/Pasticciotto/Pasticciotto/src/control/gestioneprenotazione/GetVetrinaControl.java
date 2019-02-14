package control.gestioneprenotazione;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import bean.Pasticceria;
import bean.Ricetta;
import model.BookingManager;


/**
 * Servlet implementation class GetPasticcerieControl
 */
@WebServlet("/GetVetrinaControl")
public class GetVetrinaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetVetrinaControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<Ricetta> vetrina = null;
		Iterator<Ricetta> iRicetta = null;
		Pasticceria p = null;
		
		try {
			p = BookingManager.getBakery(Integer.parseInt(request.getParameter("code")));
			vetrina = BookingManager.getProducts(p);
			iRicetta = vetrina.iterator();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject obj = new JSONObject();
		JSONObject product = null;
		
		//try {
			JSONArray arrayProducts = new JSONArray();
			try{
					for (;iRicetta.hasNext();)
					{
						Ricetta r = iRicetta.next();
						product = new JSONObject();
						product.put("nome", r.getNome());
						product.put("prezzo", r.getPrezzoVendita());
						product.put("codice", r.getCodice());
						arrayProducts.put(product);
					}
					
					obj.put("nome", p.getNome());
					obj.put("prodotti", arrayProducts);
				}
				catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			/*for (int i = 0;  i<pastries.get(0).getProdotti().size(); i++)
			{
				array.put(pastries.get(0).getProdotti().get(i));
			}
			obj.put("nome", pastries.get(0).getNome());
			obj.put("prodotti",array); 
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} */
		response.setStatus(202);
		response.getWriter().print(obj);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
