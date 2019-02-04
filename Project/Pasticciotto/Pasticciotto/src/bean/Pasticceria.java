package bean;

import java.util.ArrayList;
/**
 * This bean represents a bakery in the system
 * @author giulio
 *
 */
public class Pasticceria {
	
	/**
	 * Constructor of the new Pasticceria object
	 * @param codice code of the bakery
	 */
	public Pasticceria(int codice){
		this.codice = codice; 
		this.nome="";
		utenti = new ArrayList<Utente>();
		prodotti = new ArrayList<Prodotto>();
		ricette = new ArrayList<Ricetta>();
		finanze = new ArrayList<Finanza>();
	}
	
	/**
	 * Constructor of the new Pasticceria object
	 * @param nome name of the bakery
	 */
	public Pasticceria(String nome){
		this.nome=nome;
		utenti = new ArrayList<Utente>();
		prodotti = new ArrayList<Prodotto>();
		ricette = new ArrayList<Ricetta>();
		finanze = new ArrayList<Finanza>();
	}
	
	/**
	 * Constructor of the new Pasticceria object
	 * @param codice code of the bakery
	 * @param nome name of the bakery
	 * @param indirizzo address of the bakery
	 * @param email email of the bakery
	 * @param telefono phone number of the bakery
	 * @param descrizione description of the bakery
	 * @param urlWebSite website url of the bakery
	 * @param urlLogo logo url of the bakery
	 */
	public Pasticceria(int codice,String nome,String indirizzo,String email,String telefono,String descrizione,String urlWebSite, String urlLogo){
		this.codice = codice;
		this.nome=nome;
		this.indirizzo=indirizzo;
		this.email=email;
		this.telefono=telefono;
		this.descrizione=descrizione;
		this.urlWebSite=urlWebSite;
		this.urlLogo=urlLogo;
		utenti = new ArrayList<Utente>();
		prodotti = new ArrayList<Prodotto>();
		finanze = new ArrayList<Finanza>();
	}
	
	/**
	 * Get the collection of users
	 * @return the collection of Utente objects 
	 */
	public ArrayList<Utente> getUtenti() {
		return utenti;
	}
	
	/**
	 * Get the collection of products
	 * @return the collection of Prodotto objects 
	 */
	public ArrayList<Prodotto> getProdotti() {
		return prodotti;
	}
	
	/**
	 * Set the products of the bakery
	 * @param prodotti the collection of products associated to the bakery
	 */
	public void setProdotti(ArrayList<Prodotto> prodotti)
	{
		this.prodotti = prodotti;
	}
	
	/**
	 * Get the collection of finances
	 * @return the collection of Finanza objects 
	 */
	public ArrayList<Finanza> getFinanze() {
		return finanze;
	}

	/**
	 * Get the name of the bakery
	 * @return a string that represents the name of the bakery
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Set the name of the bakery
	 * @param nome name of the bakery
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Get the address of the bakery
	 * @return a string that represents the address of the bakery
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * Set the address of the bakery
	 * @param indirizzo address of the bakery
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * Get the email of the bakery
	 * @return a string that represents the email of the bakery
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of the bakery
	 * @param email 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the phone number of the bakery
	 * @return a string that represents the phone number of the bakery
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Set the phone nummber of the bakery
	 * @param telefono the phone number of the bakery
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Get the description of the bakery
	 * @return a string that represents the description of the bakery
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * Set the description of the bakery
	 * @param descrizione description of the bakery
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * Get the website url of the bakery
	 * @return a string that represents the website url of the bakery
	 */
	public String getUrlWebSite() {
		return urlWebSite;
	}

	/**
	 * Set the website url of bakery
	 * @param urlWebSite website url of bakery
	 */
	public void setUrlWebSite(String urlWebSite) {
		this.urlWebSite = urlWebSite;
	}

	/**
	 * Get the code of the bakery
	 * @return an integer that represents the code of the bakery
	 */
	public int getCodice() {
		return codice;
	}
	
	/**
	 * Set the code of bakery
	 * @param codice code of the bakery
	 */
	public void setCodice(int codice) {
		this.codice = codice;
	}

	/**
	 * Get the logo url of the bakery
	 * @return a string that represents the logo url of the bakery
	 */
	public String getUrlLogo() {
		return urlLogo;
	}
	
	/**
	 * Set the logo url of bakery
	 * @param urlLogo logo url of bakery
	 */
	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}

	/**
	 * Get the collection of bakery's recipes
	 * @return the collection of Ricetta objects
	 */
	public ArrayList<Ricetta> getRicette() {
		return ricette;
	}
	
	/**
	 * Set the collection of bakery's recipes
	 * @param ricette a collection of Ricetta objects
	 */
	public void setRicette(ArrayList<Ricetta> ricette) {
		this.ricette = ricette;
	}

	//Instance variables
	private String nome,indirizzo, email, telefono, descrizione, urlWebSite, urlLogo;
	private int codice;
	private ArrayList<Utente> utenti = null;
	private ArrayList<Prodotto> prodotti = null;
	private ArrayList<Finanza> finanze = null;
	private ArrayList<Ricetta> ricette = null;
}
