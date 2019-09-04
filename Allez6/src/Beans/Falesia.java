package Beans;

public class Falesia {
	
	public Falesia(int indice, String nome, String regione, String descrizione, String immagine, String posizione) {
		super();
		this.indice = indice;
		this.nome = nome;
		this.regione = regione;
		this.descrizione = descrizione;
		this.immagine = immagine;
		this.posizione = posizione;
	}
	
	public Falesia() {
	}
	
	private int indice;
	private String nome;
	private String regione;
	private String descrizione;
	private String immagine;
	private String posizione;
	
	
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRegione() {
		return regione;
	}
	public void setRegione(String regione) {
		this.regione = regione;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	public String getPosizione() {
		return posizione;
	}
	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}
	

}
