package Beans;

public class Vendita {
	
	public Vendita(double prezzoVendita, int iva, int quantità, int prodotto, int fattura , String taglia, String colore) {
		super();
		this.prezzoVendita = prezzoVendita;
		this.iva = iva;
		this.quantità = quantità;
		this.prodotto = prodotto;
		this.fattura = fattura;
		this.taglia = taglia;
		this.colore = colore;
	}
	
	public Vendita() {
	}
	private double prezzoVendita;
	private int iva;
	private int quantità;
	private int prodotto;
	private int fattura;
	private String taglia;
	private String colore;
	
	public double getPrezzoVendita() {
		return prezzoVendita;
	}
	public void setPrezzoVendita(double prezzoVendita) {
		this.prezzoVendita = prezzoVendita;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public int getQuantità() {
		return quantità;
	}
	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}
	public int getProdotto() {
		return prodotto;
	}
	public void setProdotto(int prodotto) {
		this.prodotto = prodotto;
	}
	public int getFattura() {
		return fattura;
	}
	public void setFattura(int fattura) {
		this.fattura = fattura;
	}

	public String getTaglia() {
		return taglia;
	}

	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

}
