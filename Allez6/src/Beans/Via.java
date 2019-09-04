package Beans;

public class Via {

	public Via(String nome, int falesia, String descrizione, String grado, int lunghezza, String settore) {
		super();
		this.nome = nome;
		this.falesia = falesia;
		this.descrizione = descrizione;
		this.grado = grado;
		this.lunghezza = lunghezza;
		this.settore = settore;
	}
	
	public Via() {
	}
	private String nome;
	private int falesia;
	private String descrizione;
	private String grado;
	private int lunghezza;
	private String settore;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getFalesia() {
		return falesia;
	}
	public void setFalesia(int falesia) {
		this.falesia = falesia;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}
	public int getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(int lunghezza) {
		this.lunghezza = lunghezza;
	}
	public String getSettore() {
		return settore;
	}
	public void setSettore(String settore) {
		this.settore = settore;
	}
}
