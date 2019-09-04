package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Utente;
import Model.ModelUtente;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static ModelUtente model = new ModelUtente();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println("metodo chimato");
		
		try {
			Utente usr = model.doRetrieveByKey(request.getParameter("username"));
			
			if(usr.getTipo() == 1) {
				//admin login
				if(usr.getUsername() != null && usr.getPassword().equals(request.getParameter("password"))) {
					session.setAttribute("utente", usr);
					session.setMaxInactiveInterval(60*20); //20 min
					System.out.println("OK");
					response.sendRedirect(request.getContextPath() + "/AdminPage.jsp");
				
				}
				
			}
			
			else if(usr.getUsername() != null && usr.getPassword().equals(request.getParameter("password"))) {
				session.setAttribute("utente", usr);
				session.setMaxInactiveInterval(60*20); //20 min
				System.out.println("OK");
				response.sendRedirect(request.getContextPath() + "/Home.jsp");
			
			}
			
			
			else
			{
				System.out.println("non OK");
				response.sendRedirect(request.getContextPath() + "/Loginjsp.jsp");
				
			}
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect(request.getContextPath() + "/Loginjsp.jsp");
			System.out.println("Eccezione SQL");
		}
		
		
		
	}

}
