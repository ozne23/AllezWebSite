package Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import Beans.Acquisto;
import Beans.Prodotto;
import Model.ModelProdotto;

/**
 * Servlet implementation class OrdinamentoServlet
 */
@WebServlet("/OrdinamentoServlet")
public class OrdinamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdinamentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModelProdotto model = new ModelProdotto();
		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
		
		
		try {
			ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) model.doRetrieveAll(request.getParameter("ord"),request.getParameter("cat"));
			
			ArrayList<String> jsonArray = new ArrayList<String>();
			
			for(Prodotto p : prodotti){
				
				jsonArray.add(new Gson().toJson(p));
				
			}
			
			
			JsonArray jsonResp =  (JsonArray) new Gson().toJsonTree(jsonArray);
			
			
			response.getWriter().write(jsonResp.toString());
			
			
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
