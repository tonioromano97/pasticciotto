package bean;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This bean represents a recipe of a bakery
 * @author giulio
 *
 */
public class Ricetta {
	
	/**
	 * Constructor for the new vetrina object (a vetrina object is a recipe also, but with only name and sale price)
	 * @param nome name of the recipe
	 * @param prezzoVendita sale price of the recipe
	 * @param prezzoAcquisto purchase price of the recipe
	 */
	public Ricetta(String nome, double prezzoVendita, double prezzoAcquisto){
		this.nome=nome;
		this.prezzoVendita = prezzoVendita;
		this.prezzoAcquisto = prezzoAcquisto;
	}
	
	/**
	 * Constructor for the product of the booking (a product of booking is a recipe also, but with only name and sale price)
	 * @param nome name of the recipe
	 * @param prezzoVendita sale price of the recipe
	 */
	public Ricetta(String nome, double prezzoVendita){
		this.nome=nome;
		this.prezzoVendita = prezzoVendita;
	}
	/**
	 * Constructor for the product of the booking (a product of booking is a recipe also, but with only name and sale price)
	 * @param codice code of the recipe
	 * @param nome name of the recipe
	 * @param prezzoVendita sale price of the recipe
	 */
	public Ricetta(int codice, String nome, double prezzoVendita){
		this.codice = codice;
		this.nome=nome;
		this.prezzoVendita = prezzoVendita;
	}
	
	public Ricetta(int codice){
		this.codice=codice;
	}
	
	/**
	 * Constructor for the new Ricetta object
	 * @param codice code of the recipe
	 * @param nome name of the recipe
	 * @param h hours of the recipe preparation
	 * @param m minutes of the recipe preparation
	 * @param prezzoVendita sale price of the recipe
	 * @param prezzoAcquisto purchase price of the recipe
	 * @param p the bakery associated to the recipe
	 */
	public Ricetta(int codice, String nome,int h, int m,double prezzoVendita,double prezzoAcquisto, Pasticceria p){
		this.codice=codice;
		this.nome=nome;
		this.h=h;
		this.m=m;
		this.prezzoAcquisto=prezzoAcquisto;
		this.prezzoVendita=prezzoVendita;
		this.pasticceria = p;
		this.composizione = new ArrayList<Prodotto>();
		
	}
	
	/**
	 * Get the name of the recipe
	 * @return a string that represents the name of the recipe
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Set the name of the recipe
	 * @param nome name of the recipe
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Get the sale price of the recipe
	 * @return a double that represents the sale price of the recipe
	 */
	public double getPrezzoVendita() {
		return prezzoVendita;
	}
	
	/**
	 * Set the sale price of the recipe
	 * @param prezzoAcquisto a double that represents the sale's price
	 */
	public void setPrezzoVendita(double prezzoVendita) {
		this.prezzoVendita = prezzoVendita;
	}
	
	/**
	 * Get the purchase price of the recipe
	 * @return a double that represents the purchase price of the recipe
	 */
	public double getPrezzoAcquisto() {
		return prezzoAcquisto;
	}
	
	/**
	 * Set the purchase price of the recipe
	 * @param prezzoAcquisto a double that represents the purchase's price
	 */
	public void setPrezzoAcquisto(double prezzoAcquisto) {
		this.prezzoAcquisto = prezzoAcquisto;
	}
	
	/**
	 * Get the ingredients of the recipe
	 * @return a collection of recipe's products
	 */
	public Collection<Prodotto> getComposizione() {
		return composizione;
	}
	
	/**
	 * Set the ingredients of the recipe
	 * @param p the collection of Prodotto objects
	 */
	public void setComposizione(ArrayList<Prodotto> p) {
		this.composizione = p;
	}
	
	/**
	 * Get the minutes of recipe's preparation 
	 * @return an integer that represents the minutes
	 */
	public int getM() {
		return m;
	}
	
	/**
	 * Set the minutes of the recipe's preparation
	 * @param m the minutes of the recipe's prepatation
	 */
	public void setM(int m) {
		this.m = m;
	}

	/**
	 * Get the hours of recipe's preparation 
	 * @return an integer that represents the hours
	 */
	public int getH() {
		return h;
	}
	
	/**
	 * Set the minutes of the recipe's preparation
	 * @param h the hours of the recipe's preparation
	 */
	public void setH(int h) {
		this.h = h;
	}
	
	/**
	 * Get the code of the recipe
	 * @return an integer that represents the code of the recipe
	 */
	public int getCodice() {
		return codice;
	}
	
	public void setCodice(int codice) {
		this.codice = codice;
	}
	
	/**
	 * Get the bakery associated to the recipe
	 * @return the Pasticceria object associated to the recipe
	 */
	public Pasticceria getPasticceria() {
		return pasticceria;
	} 
	
	/**
	 * Set the bakery associated to the recipe
	 * @param pasticceria the Pasticceria object associated to the recipe
	 */
	public void setPasticceria(Pasticceria pasticceria) {
		this.pasticceria = pasticceria;
	}

	private Pasticceria pasticceria;
	private ArrayList<Prodotto> composizione;
	private String nome;
	private int codice,h,m;
	double prezzoVendita,prezzoAcquisto;
}
