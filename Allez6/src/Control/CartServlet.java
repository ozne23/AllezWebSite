package Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Cart;

import Beans.Item;
import Model.ModelItem;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		System.out.println("oo");
		
		Cart cart = null;
		
		String colore = request.getParameter("colore");
		String taglia = request.getParameter("taglia");
		int codProd = Integer.parseInt(request.getParameter("prodotto"));
		
		System.out.println(colore + " "+ taglia + " "+codProd);
		
		ModelItem model = new ModelItem();
		
		if (session.getAttribute("cart") == null) {
            //if not exist session cart
            //add new product to cart
            cart = new Cart();
        }else {
        	
        	cart = (Cart) session.getAttribute("cart");
        	
        }
         
		
		try {
			Item i = model.doRetrieveByKey(taglia, colore, codProd);
			cart.addItem(i);
			ArrayList<Item> items = cart.getItems();
			for(Item p: items) {
				System.out.println(p.getProdotto() +" "+p.getColore());
			}
			session.setAttribute("cart", cart);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
