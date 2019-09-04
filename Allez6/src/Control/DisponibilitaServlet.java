package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Beans.Item;
import Model.ModelItem;

/**
 * Servlet implementation class DisponibilitaServlet
 */
@WebServlet("/DisponibilitaServlet")
public class DisponibilitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisponibilitaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        
	        
	        
	        
	        
	        
	        
	        String taglia = request.getParameter("taglia");
	        String colore = request.getParameter("colore");
	        int codProd = Integer.parseInt(request.getParameter("prodotto"));
	        
	       
	        
	        
	        ModelItem model = new ModelItem();
	        
	        try {
				Item i = model.doRetrieveByKey(taglia, colore, codProd);
				
				System.out.println(i.getImmagine());
				
				String jItem = new Gson().toJson(i);
				
				response.getWriter().write(jItem);
				
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
