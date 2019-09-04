package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.CommentoFalesia;
import Model.ModelCommentoFalesia;

/**
 * Servlet implementation class SalvaCommentoFalesia
 */
@WebServlet("/SalvaCommentoFalesia")
public class SalvaCommentoFalesia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalvaCommentoFalesia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
ModelCommentoFalesia model = new ModelCommentoFalesia();
		
		CommentoFalesia commento = new CommentoFalesia();
		
		commento.setFalesia(Integer.parseInt(request.getParameter("falesia")));
		commento.setCommento(request.getParameter("commento"));
		
		try {
			model.doSave(commento);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
