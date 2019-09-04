package Control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import Beans.Acquisto;

/**
 * Servlet implementation class CambiaQuantitaMeno
 */
@WebServlet("/CambiaQuantitaMeno")
public class CambiaQuantitaMeno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiaQuantitaMeno() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
HttpSession session = request.getSession();
		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
		
		ArrayList<Acquisto> acquisti = (ArrayList<Acquisto>) session.getAttribute("acquisti");
		
		String colore = request.getParameter("colore");
		String taglia = request.getParameter("taglia");
		int prodotto = Integer.parseInt(request.getParameter("prodotto"));
		
		System.out.println(colore);
		System.out.println(taglia);
		System.out.println(prodotto);
		
		for(Acquisto a : acquisti){
					
					if(a.getItem().getColore().equalsIgnoreCase(colore) && a.getItem().getTaglia().equalsIgnoreCase(taglia) && a.getItem().getProdotto()==prodotto)
					{
						System.out.println("prima "+a.getQuantità());
						a.setQuantità(a.getQuantità()-1);
						System.out.println("dopo "+a.getQuantità());
						break;
					}
					
				}
		
		for(Acquisto a : acquisti){
			
			if(a.getItem().getColore().equalsIgnoreCase(colore) && a.getItem().getTaglia().equalsIgnoreCase(taglia) && a.getItem().getProdotto()==prodotto)
			{
				System.out.println("secondo for "+a.getQuantità());
				break;
			}
			
		}
		
		session.removeAttribute("acquisti");
		session.setAttribute("acquisti", acquisti);
		
		ArrayList<String> jsonArray = new ArrayList<String>();
		
		for(Acquisto a : acquisti){
			
			jsonArray.add(new Gson().toJson(a));
			
		}
		
		
		JsonArray jsonResp =  (JsonArray) new Gson().toJsonTree(jsonArray);
		
		
		response.getWriter().write(jsonResp.toString());
		
	}

}
