package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.ModelItem;
import Beans.Item;

/**
 * Servlet implementation class ModItemServlet
 */
@WebServlet("/ModItemServlet")
public class ModItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ModelItem model = new ModelItem();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModItemServlet() {
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
		Item item = new Item();
		
		item.setTaglia(request.getParameter("taglia"));
		item.setColore(request.getParameter("colore"));
		item.setProdotto(Integer.parseInt(request.getParameter("prodotto")));
		item.setSconto(Integer.parseInt(request.getParameter("sconto")));
		item.setDisponibilità(Integer.parseInt(request.getParameter("disp")));
		item.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
		item.setImmagine(request.getParameter("img"));
		System.out.println("1");
		try {
			System.out.print("entra");
			model.doMod(item);
			System.out.print("Fatto?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			response.sendRedirect(request.getContextPath() + "/CercaItem.jsp");
		}




	}

}
