package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Via;
import Model.ModelVia;

/**
 * Servlet implementation class RegViaServlet
 */
@WebServlet("/RegViaServlet")
public class RegViaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static ModelVia model = new ModelVia();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegViaServlet() {
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
		// TODO Auto-generated method stub
		
		Via via = new Via();
		
		via.setNome(request.getParameter("nome"));
		via.setFalesia(Integer.parseInt(request.getParameter("falesia")));
		via.setGrado(request.getParameter("grado"));
		via.setSettore(request.getParameter("settore"));
		via.setLunghezza(Integer.parseInt(request.getParameter("lunghezza")));
		via.setDescrizione(request.getParameter("descrizione"));
		
		
		try {
			model.doSave(via);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect(request.getContextPath() +"/RegistrazioneVia.jsp");
		}
		
	}

}
