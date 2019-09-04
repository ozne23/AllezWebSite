package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Beans.Utente;
import Model.ModelUtente;;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {};
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException,IOException {
		//Salviamo i parametri di input i variabili locali
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//string tipo?? 
		String telefono = req.getParameter("telefono");
		String sesso = req.getParameter("sesso");
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String dataNascita = req.getParameter("dataNascita");
		int cap = Integer.parseInt(req.getParameter("cap"));
		String provincia = req.getParameter("provincia");
		String via = req.getParameter("via");
		String citta = req.getParameter("citta");
		String email = req.getParameter("email");
		String data = req.getParameter("data");
		
		
		
	//Usiamo un RegisterBean
		Utente utente = new Utente();
		utente.setUsername(username);
		utente.setPassword(password);
		utente.setTelefono(telefono);
		utente.setSesso(sesso);
		utente.setNome(nome);
		utente.setCognome(cognome);
		utente.setDataNascita(dataNascita);
		utente.setCap(cap);
		utente.setProvincia(provincia);
		utente.setVia(via);
		utente.setEmail(email);
		utente.setCittà(citta);
		utente.setDataNascita(data);
		
	//logica 
		ModelUtente registerDao = new ModelUtente();
		try {
			registerDao.doSave(utente);
			res.sendRedirect(req.getContextPath() + "/Home.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

