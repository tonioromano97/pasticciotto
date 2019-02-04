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
 * This servlet manage the login of an user
 */
@WebServlet("/Login")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoginControl() {
        super();
       
    }

	/**
	 * In the request of this Servlet, given the email and the password of the user, the control create a User object 
	 * and redirect the user to personal homepage 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Utente user = null; 
		
		
		try {
			user = UserManager.login(email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user!=null)
		{
			request.getSession().setAttribute("user", user);
			if(user.getRuolo().equalsIgnoreCase("cliente"))
				response.sendRedirect("index.jsp");
			else response.sendRedirect("loginHome.jsp");
		}
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
