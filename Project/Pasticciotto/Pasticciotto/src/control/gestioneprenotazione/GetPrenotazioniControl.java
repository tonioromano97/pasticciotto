package control.gestioneprenotazione;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Pasticceria;
import bean.Prenotazione;
import bean.Ricetta;
import bean.Utente;

/**
 * Servlet implementation class GetPrenotazioniControl
 */
@WebServlet("/GetPrenotazioniControl")
public class GetPrenotazioniControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPrenotazioniControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
		Date dataPrenotazione = Date.valueOf("2017-11-11");
		Date dataRitiro = Date.valueOf("2019-12-11");
		Prenotazione prenotazione = new Prenotazione(1, dataPrenotazione, dataRitiro, "Si raccomanda il pasticciere di usare prodotti senza glutine. Grazie in anticipo!");
		Prenotazione prenotazione2 = new Prenotazione(2, dataPrenotazione, dataRitiro, "Srivere \"Auguri Marco\"");
		
		Ricetta r = new Ricetta("Millefoglie", 0);
		Ricetta r1 = new Ricetta("Panna e Nutella", 0);
		Ricetta r2 = new Ricetta("Delizia al limone", 0);
		Ricetta r3 = new Ricetta("Delizia al limone", 0);
		
		prenotazione.getProdotti().add(r);
		prenotazione.getProdotti().add(r1);
		prenotazione.getProdotti().add(r2);
		
		prenotazione2.getProdotti().add(r3);
		
		
		Utente u = ((Utente)request.getSession().getAttribute("user"));
		Utente u1 = new Utente();
		u1.setCognome("Varone");
		u1.setNome("Giulio");
		u.setTelefono("3887656432");
		
		prenotazione.setUtente(u);
		prenotazione2.setUtente(u1);
		
		
		prenotazioni.add(prenotazione);
		prenotazioni.add(prenotazione2);
		request.getSession().setAttribute("prenotazioni", prenotazioni);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
