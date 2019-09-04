package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelProdotto;

/**
 * Servlet implementation class CancProdServlet
 */
@WebServlet("/CancProdServlet")
public class CancProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ModelProdotto model = new ModelProdotto();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancProdServlet() {
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
		
		String codiceProdotto = request.getParameter("cod");
		int codice = Integer.parseInt(codiceProdotto);
		System.out.println(codice);    // funziona arriva il codice inserito.
		try {
			System.out.println("prima");
			model.Cancella(codice);
			System.out.println("dopo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ciao");
			response.sendRedirect(request.getContextPath() + "/CancellaProdotto.jsp");
		}
	}

}
