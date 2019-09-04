package Beans;

public class Fattura {
	
	public Fattura(int iD, String data, String ora, int iva, String pIva, double totale, String utente,
			String causale) {
		super();
		ID = iD;
		this.data = data;
		this.ora = ora;
		this.iva = iva;
		this.pIva = pIva;
		this.totale = totale;
		this.utente = utente;
		this.causale = causale;
	}
	
	public Fattura() {
		
	}
	
	private int ID;
	private String data;
	private String ora;
	private int iva;
	private String pIva;
	private double totale;
	private String utente;
	private String causale;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getOra() {
		return ora;
	}
	public void setOra(String ora) {
		this.ora = ora;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public String getpIva() {
		return pIva;
	}
	public void setpIva(String pIva) {
		this.pIva = pIva;
	}
	public double getTotale() {
		return totale;
	}
	public void setTotale(double totale) {
		this.totale = totale;
	}
	public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
	}
	public String getCausale() {
		return causale;
	}
	public void setCausale(String causale) {
		this.causale = causale;
	}
	

}
