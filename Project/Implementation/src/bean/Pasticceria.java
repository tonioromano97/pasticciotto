package bean;

import java.util.ArrayList;

public class Pasticceria {
	public Pasticceria(String nome){
		this.nome=nome;
		utenti = new ArrayList<Utente>();
		prodotti = new ArrayList<Prodotto>();
		finanze = new ArrayList<Finanza>();
	}
	public Pasticceria(String nome,String indirizzo,String email,String telefono,String descrizione,String urlWebSite){
		this.nome=nome;
		this.indirizzo=indirizzo;
		this.email=email;
		this.telefono=telefono;
		this.descrizione=descrizione;
		this.urlWebSite=urlWebSite;
		utenti = new ArrayList<Utente>();
		prodotti = new ArrayList<Prodotto>();
		finanze = new ArrayList<Finanza>();
	}
	
	public ArrayList<Utente> getUtenti() {
		return utenti;
	}

	public ArrayList<Prodotto> getProdotti() {
		return prodotti;
	}
	
	public ArrayList<Finanza> getFinanze() {
		return finanze;
	}

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getIndirizzo() {
		return indirizzo;
	}



	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getDescrizione() {
		return descrizione;
	}



	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}



	public String getUrlWebSite() {
		return urlWebSite;
	}



	public void setUrlWebSite(String urlWebSite) {
		this.urlWebSite = urlWebSite;
	}

	private String nome,indirizzo, email, telefono, descrizione, urlWebSite;
	private ArrayList<Utente> utenti = null;
	private ArrayList<Prodotto> prodotti = null;
	private ArrayList<Finanza> finanze = null;
}
