package bean;

import java.util.ArrayList;

public class Utente {
	public Utente(String nome, String cognome, String email, String pw, String telefono){
		this.nome=nome;
		this.cognome=cognome;
		this.email=email;
		this.password=pw;
		this.telefono=telefono;
		elencoPasticcerie = new ArrayList<Pasticceria>();
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
	
	public ArrayList<Pasticceria> getPasticcerie() {
		return this.elencoPasticcerie;
	}

	private String nome,cognome,email,password,telefono;
	private ArrayList<Pasticceria> elencoPasticcerie = null;
}
