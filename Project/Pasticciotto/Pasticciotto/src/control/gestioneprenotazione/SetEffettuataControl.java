package control.gestioneprenotazione;

import java.io.IOException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Prenotazione;
import bean.Ricetta;
import model.BookingManager;

/**
 * Servlet implementation class SetEffettuataControl
 */
@WebServlet("/SetEffettuataControl")
public class SetEffettuataControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetEffettuataControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int effettuata = Integer.parseInt(request.getParameter("e"));
		Prenotazione prenotazione = new Prenotazione(Integer.parseInt(request.getParameter("p")));
		
		if(effettuata==0)
			prenotazione.setEffettuata(false);
		else 
			prenotazione.setEffettuata(true);
		
		String ricette = request.getParameter("r");
		int nRicette = Integer.parseInt(ricette.substring(ricette.indexOf('.')+1));
		System.out.println("Prenotazione:"+prenotazione.getCodice());
		System.out.println("Numero ricette:"+nRicette);
		String composition[] = ricette.split(",");
		for(int i=0; i<nRicette; i++){
			System.out.println("Ricetta"+i+": "+composition[i]);
			Ricetta r = new Ricetta(Integer.parseInt(composition[i]));
			BookingManager.doBooking(prenotazione, r);
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
