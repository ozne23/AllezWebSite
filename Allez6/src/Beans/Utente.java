package Beans;

public class Utente {

	public Utente(String username, String password, int tipo, String telefono, String sesso, String nome,
			String cognome, String dataNascita, int cap, String provincia, String via, String città, String email) {
		super();
		this.username = username;
		this.password = password;
		this.tipo = tipo;
		this.telefono = telefono;
		this.sesso = sesso;
		this.nome = format(nome);
		this.cognome = format(cognome);
		this.dataNascita = dataNascita;
		this.cap = cap;
		this.provincia = format(provincia);
		this.via = format(via);
		this.città = format(città);
		this.email = email;
	}

	public String format(String s) {
		if (s != null && s != "") {
			s.trim();
			if (Character.isLowerCase(s.charAt(0)))
				s = s.substring(0, 1).toUpperCase() + s.substring(1);
			if (s.indexOf(' ') != -1) {
				for (int i = s.indexOf(' '); i <= s.lastIndexOf(' '); i++) {
					if (s.charAt(i) == ' ')
						if (Character.isLowerCase(s.charAt(i + 1)))
							s = s.substring(0, i + 1) + s.substring(i + 1, i + 2).toUpperCase() + s.substring(i + 2);
				}
			}
		}
		return s;
	}

	public Utente() {
	}

	private String email;
	private String username;
	private String password;
	private int tipo;
	private String telefono;
	private String sesso;
	private String nome;
	private String cognome;
	private String dataNascita;
	private int cap;
	private String provincia;
	private String via;
	private String città;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = format(nome);
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = format(cognome);
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = format(provincia);
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = format(via);
	}

	public String getCittà() {
		return città;
	}

	public void setCittà(String città) {
		this.città = format(città);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
