package Control;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Beans.Prodotto;
import Model.ModelProdotto;

/**
 * Servlet implementation class ModProdottoServlet
 */
@WebServlet("/ModProdottoServlet")
public class ModProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ModelProdotto model = new ModelProdotto();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModProdottoServlet() {
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
		Prodotto prod = new Prodotto();
		System.out.print("1");
		prod.setNome(request.getParameter("nome"));
		prod.setMarca(request.getParameter("marca"));
		prod.setDescrizione(request.getParameter("descrizione"));
		prod.setImmagine(request.getParameter("img"));
		prod.setCategoria(request.getParameter("categoria"));
		System.out.println(request.getParameter("codice"));
		int codice = Integer.parseInt(request.getParameter("codice"));
		prod.setCodice(codice);
		
		System.out.print("2");
		try {
			System.out.print("entra");
			model.doMod(prod);
			System.out.print("Fatto?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			response.sendRedirect(request.getContextPath() + "/CercaProdotto.jsp");
		}
	}

}
