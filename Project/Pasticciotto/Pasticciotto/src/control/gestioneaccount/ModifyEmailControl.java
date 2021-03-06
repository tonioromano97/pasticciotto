package control.gestioneaccount;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Utente;
import model.UserManager;

/**
 * @author giulio
 * This servlet lets modify the personal email of an user
 */
@WebServlet("/ModifyEmailControl")
public class ModifyEmailControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ModifyEmailControl() {
        super();
    }

    /**
     *In the request of this Servlet, given the user and the new email, the control do the change and set the new email
	 * also in the session object
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utente u = (Utente)request.getSession().getAttribute("user");
		String newEmail = request.getParameter("newEmail");
		if(newEmail.equals(""))
			newEmail = null;
		
		boolean done = false;
		
		try {
			done = UserManager.modifyEmail(u,newEmail);
			if(done){
			u.setEmail(newEmail);
			request.getSession().setAttribute("user", u);
			response.getWriter().print("done");
			}
			else response.getWriter().print("fail");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
