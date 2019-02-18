package control.gestionefinanze;

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
import com.sun.xml.internal.ws.addressing.EndpointReferenceUtil;

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
			double mesi[] = {0,0,0,0,0,0,0,0,0,0,0,0};
			String dataEntry = "";
			while(iF.hasNext()){
				Finanza finanza = iF.next();
				if(finanza instanceof Entrata) entry.add((Entrata)finanza);
				else out.add((Uscita)finanza);
			}
			for(Entrata entrata : entry){
				Date d = entrata.getData(); 
				System.out.println("Mese: "+d.getMonth());
				mesi[d.getMonth()] = mesi[d.getMonth()] + entrata.getImporto();
			}
			for(int i=0; i<12; i++){
				if(mesi[i]==0.00) dataEntry += ",";
				else dataEntry += ""+mesi[i]+",";
			}
			System.out.println("Data: "+ dataEntry);
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
