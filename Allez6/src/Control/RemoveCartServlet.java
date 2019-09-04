package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Cart;

/**
 * Servlet implementation class RemoveCartServlet
 */
@WebServlet("/RemoveCartServlet")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Cart cart = (Cart) session.getAttribute("cart");
		String flag =  request.getParameter("all");
		
		if(flag.equals("false"))
		{
			System.out.println("falseee");
			cart.removeAnItem(request.getParameter("taglia"), request.getParameter("colore"), Integer.parseInt(request.getParameter("prodotto")));
		}else{
			cart.removeAllItem(request.getParameter("taglia"), request.getParameter("colore"), Integer.parseInt(request.getParameter("prodotto")));
		}
		
		session.setAttribute("cart", cart);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Cart cart = (Cart) session.getAttribute("cart");
		
		cart.removeAnItem(request.getParameter("taglia"), request.getParameter("colore"), Integer.parseInt(request.getParameter("prodotto")));
		
		session.setAttribute("cart", cart);
		
	}

}
