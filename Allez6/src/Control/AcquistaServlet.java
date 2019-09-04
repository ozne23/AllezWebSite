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

import Beans.Acquisto;
import Beans.Fattura;
import Beans.Utente;
import Beans.Vendita;
import Model.ModelFattura;
import Model.ModelItem;
import Model.ModelVendita;

/**
 * Servlet implementation class AcquistaServlet
 */
@WebServlet("/AcquistaServlet")
public class AcquistaServlet extends HttpServlet {
	private static  ModelFattura modelFattura = new ModelFattura();
	private static  ModelVendita modelVendita = new ModelVendita();
	private static  ModelItem modelItem = new ModelItem();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcquistaServlet() {
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
		
		HttpSession session = request.getSession();
		double totale = 0;
		double temp = 0 ;
		String utente = ((Utente)session.getAttribute("utente")).getUsername();
		
		Fattura fattura = new Fattura();
		
		
		
		ArrayList<Acquisto> acquisti = (ArrayList<Acquisto>) session.getAttribute("acquisti");
		
		for(Acquisto a : acquisti){
			
			if(a.getItem().getSconto() <= 0)
			{
				totale += (a.getItem().getPrezzo() * a.getQuantità());
			}else {
				temp = (a.getItem().getPrezzo() * a.getQuantità());
				
				totale += temp - (temp*a.getItem().getSconto())/100;
			}
			
			
			
			
		}
		
		
		
		fattura.setUtente(utente);
		fattura.setTotale(totale);
		
		try {
			
			
			
			modelFattura.doSave(fattura);
			

				try
				{
				    Thread.sleep(1000);
				}
				catch(InterruptedException ex)
				{
				    Thread.currentThread().interrupt();
				}
			
			
			for(Acquisto a : acquisti){
				Vendita v = new Vendita();
				
				v.setIva(22);
				v.setFattura(modelFattura.ultimaFatturaUtente(utente).getID());
				v.setPrezzoVendita(a.getItem().getPrezzo());
				v.setQuantità(a.getQuantità());
				v.setProdotto(a.getItem().getProdotto());
				v.setTaglia(a.getItem().getTaglia());
				v.setColore(a.getItem().getColore());
				
				modelVendita.doSave(v);
				
				modelItem.doModDisponibilita(a.getItem(), (a.getItem().getDisponibilità()-a.getQuantità()));
			}
			
			
			session.removeAttribute("cart");
			session.removeAttribute("acquisti");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
