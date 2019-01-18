package bean;


public class Utente {
	public Utente(String nome, String cognome, String email, String pw, String telefono, Pasticceria pasticceria, String ruolo, int numPrenotazioni){
		this.nome=nome;
		this.cognome=cognome;
		this.email=email;
		this.password=pw;
		this.telefono=telefono;
		this.pasticceria=pasticceria;
		this.ruolo = ruolo;
		this.numPrenotazioni = numPrenotazioni;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPw(String pw) {
		password = pw;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}


	public int getNumPrenotazioni() {
		return numPrenotazioni;
	}

	public void setNumPrenotazioni(int numPrenotazioni) {
		this.numPrenotazioni = numPrenotazioni;
	}


	public Pasticceria getPasticceria() {
		return pasticceria;
	}

	public void setPasticceria(Pasticceria pasticceria) {
		this.pasticceria = pasticceria;
	}


	private String nome,cognome,email,password,telefono,ruolo;
	private int numPrenotazioni;
	private Pasticceria pasticceria;
}
