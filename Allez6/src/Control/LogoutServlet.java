package Control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false); // prende l'object session, non lo crea se non esiste
		
		if(session != null) 
		{
			session.invalidate(); // rimuove tutti gli attributi legati alla sessione
			req.setAttribute("errMessage", "Logout avvenuto con success!");
			RequestDispatcher rd = req.getRequestDispatcher("/Home.jsp");
			rd.forward(req,res);
		
		}
	}
}
