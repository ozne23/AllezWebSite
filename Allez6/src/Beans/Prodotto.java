package Beans;

public class Prodotto {

	public Prodotto(int codice, String nome, String marca, String immagine, String descrizione) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.marca = marca;
		this.immagine = immagine;
		this.descrizione = descrizione;
		this.cancellato = 0;
	}
	
	public Prodotto() {
		this.cancellato = 0;
	}
	
	private int codice;
	private String nome;
	private String marca;
	private String immagine;
	private String descrizione;
	private String categoria;
	private int cancellato;
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int isCancellato() {
		return cancellato;
	}

	public void setCancellato(int cancellato) {
		this.cancellato = cancellato;
	}
}
