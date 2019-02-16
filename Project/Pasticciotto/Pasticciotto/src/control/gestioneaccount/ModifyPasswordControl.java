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
 * This servlet lets modify the personal password of an user
 */
@WebServlet("/ModifyPasswordControl")
public class ModifyPasswordControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPasswordControl() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     *In the request of this Servlet, given the user and the new password, the control do the change and set the new password
	 * also in the session object
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Utente u = (Utente)request.getSession().getAttribute("user");
		String newPassword = request.getParameter("newPassword");
		if (newPassword.equals(""))
			newPassword = null;
		boolean done = false;
		
		try {
			done = UserManager.modifyPassword(u,newPassword);
			if(done){
			u.setPw(newPassword);
			request.getSession().setAttribute("user", u);
			response.getWriter().print("done");
			}
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
