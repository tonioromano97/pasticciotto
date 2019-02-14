package control.gestioneprenotazione;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Local;

import bean.Prenotazione;
import bean.Prodotto;
import bean.Ricetta;
import bean.Utente;
import model.BookingManager;

/**
 * Servlet implementation class EffettuaPrenotazioneControl
 */
@WebServlet("/EffettuaPrenotazioneControl")
public class EffettuaPrenotazioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EffettuaPrenotazioneControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Utente utente = new Utente();
		utente.setEmail(request.getParameter("email"));
		
		String noteP = request.getParameter("note");
		
		Prenotazione prenotazione = new Prenotazione(-1,Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now()), noteP);
		
		int nProdotti = Integer.parseInt(request.getParameter("nProdotti"));
		String prodotti = request.getParameter("prodotti");
		String products[] = prodotti.split(",");
		ArrayList<Ricetta> ricette = new ArrayList<Ricetta>();
		for(int i=0; i<nProdotti; i++){
			ricette.add(new Ricetta(Integer.parseInt(products[i])));
		}
	
		prenotazione.setUtente(utente);
		prenotazione.setProdotti(ricette);
		
		try {
			if(BookingManager.bookCakes(prenotazione))
				response.getWriter().print("done");
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
