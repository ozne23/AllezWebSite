package Beans;

public class Notizia {
	public Notizia() {
		super();
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getNotizia() {
		return notizia;
	}
	
	public void setNotizia(String notizia) {
		this.notizia = notizia;
	}
	public String getImmagine() {
		return immagine;
	}
	
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	
	
	
	
	
	
	
	
	private String titolo;
	private String notizia;
	private String immagine;
}
