package bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
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
		utenti = new HashSet<Utente>();
		prodotti = new HashSet<Prodotto>();
		ricette = new HashSet<Ricetta>();
		finanze = new HashSet<Finanza>();
	}
	
	/**
	 * Constructor of the new Pasticceria object
	 * @param nome name of the bakery
	 */
	public Pasticceria(String nome){
		this.nome=nome;
		utenti = new HashSet<Utente>();
		prodotti = new HashSet<Prodotto>();
		ricette = new HashSet<Ricetta>();
		finanze = new HashSet<Finanza>();
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
		utenti = new HashSet<Utente>() {};
		prodotti = new HashSet<Prodotto>();
		finanze = new HashSet<Finanza>();
	}
	
	/**
	 * Get the collection of users
	 * @return the collection of Utente objects 
	 */
	public Collection<Utente> getUtenti() {
		return utenti;
	}
	
	/**
	 * Set the users of the bakery
	 * ADDED AFTER 
	 * @param utenti the collection of users associated to the bakery
	 */
	public void setUtenti(Set<Utente> utenti)
	{
		this.utenti = utenti;
	}
	
	/**
	 * Get the collection of products
	 * @return the collection of Prodotto objects 
	 */
	public Collection<Prodotto> getProdotti() {
		return prodotti;
	}
	
	/**
	 * Set the products of the bakery
	 * @param prodotti the collection of products associated to the bakery
	 */
	public void setProdotti(Set<Prodotto> prodotti)
	{
		this.prodotti = prodotti;
	}
	
	/**
	 * Get the collection of finances
	 * @return the collection of Finanza objects 
	 */
	public Collection<Finanza> getFinanze() {
		return finanze;
	}

	/**
	 * Set the finances of the bakery
	 * ADDED AFTERS
	 * @param finanze the collection of the finances associated to the bakery
	 */
	public void setFinanze(Set<Finanza> finanze)
	{
		this.finanze = finanze;
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
	public Collection<Ricetta> getRicette() {
		return ricette;
	}
	
	/**
	 * Set the collection of bakery's recipes
	 * @param ricette a collection of Ricetta objects
	 */
	public void setRicette(Set<Ricetta> ricette) {
		this.ricette = ricette;
	}

	//Instance variables
	private String nome,indirizzo, email, telefono, descrizione, urlWebSite, urlLogo;
	private int codice;
	private Set<Utente> utenti = null;
	private Set<Prodotto> prodotti = null;
	private Set<Finanza> finanze = null;
	private Set<Ricetta> ricette = null;
}
