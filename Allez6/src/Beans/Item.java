package Beans;

import java.util.ArrayList;

public class Item {
	
	public Item(String taglia, String colore, int prodotto, int sconto, int disponibilità, double prezzo,
			String immagine) {
		super();
		this.taglia = taglia;
		this.colore = colore;
		this.prodotto = prodotto;
		this.sconto = sconto;
		this.disponibilità = disponibilità;
		this.prezzo = prezzo;
		this.immagine = immagine;
	}
	
	public Item() {
	}
	
	private String taglia;
	private String colore;
	private int prodotto;
	private int sconto;
	private int disponibilità;
	private double prezzo;
	private String immagine;
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
	public int getProdotto() {
		return prodotto;
	}
	public void setProdotto(int prodotto) {
		this.prodotto = prodotto;
	}
	public int getSconto() {
		return sconto;
	}
	public void setSconto(int sconto) {
		this.sconto = sconto;
	}
	public int getDisponibilità() {
		return disponibilità;
	}
	public void setDisponibilità(int disponibilità) {
		this.disponibilità = disponibilità;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	
	public boolean equalsItem(Item i) {
		if(this.taglia.equals(i.getTaglia()) && this.colore.equals(i.getColore()) && (this.prodotto == i.getProdotto()))
			return true;
		return false;
	}
	
	public static Item cercaItem(ArrayList<Item> items,String taglia, String colore, int prod) {
		
		for(Item i : items){
			if(taglia.equalsIgnoreCase(i.getTaglia()) && colore.equalsIgnoreCase(i.getColore()) && (prod == i.getProdotto())){
				return i;
			}
		}
		
		return null;
		
	}

}
