package control.gestioneprenotazione;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Finanza;
import bean.Pasticceria;
import bean.Prenotazione;
import bean.Ricetta;
import bean.Utente;
import model.BookingManager;
import model.FinanceManager;

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
		Pasticceria p = ((Utente)request.getSession().getAttribute("user")).getPasticceria();
		try {
			Collection<Prenotazione> books = BookingManager.getBooking(p);
			request.getSession().setAttribute("prenotazioni", books);
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
