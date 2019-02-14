package control.gestionegrafici;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.omg.CORBA.ParDescriptionSeqHelper;

import bean.Entrata;
import bean.Finanza;
import bean.Pasticceria;
import bean.Uscita;
import bean.Utente;
import model.FinanceManager;
import sun.misc.UCDecoder;

/**
 * Servlet implementation class GetDataGraficiControl
 */
@WebServlet("/GetDataGraficiControl")
public class GetDataGraficiControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDataGraficiControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Pasticceria p = ((Utente)request.getSession().getAttribute("user")).getPasticceria();
			Collection<Finanza> cFinanzas = FinanceManager.getFinances(p);
			Iterator<Finanza> iF = cFinanzas.iterator();
			ArrayList<Entrata> entry = new ArrayList<Entrata>();
			ArrayList<Uscita> out= new ArrayList<Uscita>();
			double Gen=0,Feb=0,Mar=0,Apr=0,Mag=0,Giu=0,Lug=0,Ago=0,Set=0,Ott=0,Nov=0,Dic=0;
			while(iF.hasNext()){
				Finanza finanza = iF.next();
				if(finanza instanceof Entrata) entry.add((Entrata)finanza);
				else out.add((Uscita)finanza);
			}
			for(Entrata entrata : entry){
				Date d = entrata.getData(); 
				if(d.after(Date.valueOf("2019-1-1"))&&d.before(Date.valueOf("2019-1-31"))) Gen = Gen+entrata.getImporto();
				if(d.after(Date.valueOf("2019-2-1"))&&d.before(Date.valueOf("2019-2-31"))) Feb = Feb+entrata.getImporto();
				if(d.after(Date.valueOf("2019-3-1"))&&d.before(Date.valueOf("2019-3-31"))) Mar = Mar+entrata.getImporto();
				if(d.after(Date.valueOf("2019-4-1"))&&d.before(Date.valueOf("2019-4-31"))) Apr = Apr+entrata.getImporto();
				if(d.after(Date.valueOf("2019-5-1"))&&d.before(Date.valueOf("2019-5-31"))) Mag = Mag+entrata.getImporto();
				if(d.after(Date.valueOf("2019-6-1"))&&d.before(Date.valueOf("2019-6-31"))) Giu = Giu+entrata.getImporto();
				if(d.after(Date.valueOf("2019-7-1"))&&d.before(Date.valueOf("2019-7-31"))) Lug = Lug+entrata.getImporto();
				if(d.after(Date.valueOf("2019-8-1"))&&d.before(Date.valueOf("2019-8-31"))) Ago = Ago+entrata.getImporto();
				if(d.after(Date.valueOf("2019-9-1"))&&d.before(Date.valueOf("2019-9-31"))) Set = Set+entrata.getImporto();
				if(d.after(Date.valueOf("2019-10-1"))&&d.before(Date.valueOf("2019-10-31"))) Ott = Ott+entrata.getImporto();
				if(d.after(Date.valueOf("2019-11-1"))&&d.before(Date.valueOf("2019-11-31"))) Nov = Nov+entrata.getImporto();
				if(d.after(Date.valueOf("2019-12-1"))&&d.before(Date.valueOf("2019-12-31"))) Dic = Dic+entrata.getImporto();
			}
			String dataEntry = ""+Gen+","+Feb+","+Mar+","+Apr+","+Mag+","+Giu+","+Lug+","+Ago+","+Set+","+Ott+","+Nov+","+Dic;
			request.getSession().setAttribute("entry", dataEntry);
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
