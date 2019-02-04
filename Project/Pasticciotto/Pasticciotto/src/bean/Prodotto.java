package bean;

import java.util.ArrayList;
/**
 * This bean represents the inventory product of a bakery
 * @author giulio
 *
 */
public class Prodotto {
	
	/**
	 * Constructor for a new Prodotto object
	 * @param codice the code of the product
	 */
	public Prodotto(int codice)
	{
		this.codice = codice;
	}
	
	/**
	 * Constructor of the new Prodotto object
	 * @param codice code of the product
	 * @param nome name of the product
	 */
	public Prodotto(int codice, String nome){
		this.codice = codice;
		this.nome=nome;
		this.pasticceria=null;
		this.ricette=null;
		this.quantita=0;
		this.minScorta=0;
		this.prezzo=0;
	}

	/**
	 * Constructor of the new Prodotto object
	 * @param codice code of the product
	 * @param nome name of the product
	 * @param quantita quantity of the product
	 */
	public Prodotto(int codice, String nome, int quantita){
		this.codice = codice;
		this.nome=nome;
		this.quantita=quantita;
	}
	
	/**
	 * Constructor of the new Prodotto object
	 * @param pasticceria bakery associated to the product
	 * @param codice code of the product
	 * @param nome name of the product
	 * @param quantita quantity of the product
	 * @param minScorta minimum quantity of the product in stock
	 * @param prezzo price of the product
	 */
	public Prodotto(Pasticceria pasticceria, int codice, String nome, int quantita, int minScorta, double prezzo){
		this.pasticceria=pasticceria;
		this.codice=codice;
		this.nome=nome;
		this.quantita=quantita;
		this.minScorta=minScorta;
		this.prezzo=prezzo;
	}
	
	/**
	 * Get the bakery associated to the product
	 * @return a Pasticceria object that represents the bakery associated to the product
	 */
	public Pasticceria getPasticceria() {
		return pasticceria;
	}

	/**
	 * Get the code of the product
	 * @return a integer that represents the code of the product
	 */
	public int getCodice() {
		return codice;
	}
	
	/**
	 * Set the code of the product
	 * @param codice code of the product
	 */
	public void setCodice(int codice) {
		this.codice = codice;
	}
	
	/**
	 * Get the name of the product
	 * @return a string that represents the name of the product
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Set the name of the product
	 * @param nome name of the product
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Get the quantity of the product
	 * @return an integer that represents the quantity of the product
	 */
	public int getQuantita() {
		return quantita;
	}
	
	/**
	 * Set the quantity of the product
	 * @param quantita quantity of the product
	 */
	public void setQuantita(int quantita) {
		if(quantita<0) throw new IllegalArgumentException("Quantita prodotto minore di 0");
		this.quantita = quantita;
	}
	
	/**
	 * Get the minimum quantity of the product in stock
	 * @return an integer that represents the minimum quantity of the product in stock
	 */
	public int getMinScorta() {
		return minScorta;
	}
	
	/**
	 * Set the minimum quantity of the product in stock
	 * @param minScorta the minimum quantity of the product in stock
	 */
	public void setMinScorta(int minScorta) {
		if(minScorta<0) throw new IllegalArgumentException("Scorta minima prodotto minore di 0");
		this.minScorta = minScorta;
	}
	
	/**
	 * Get the price of the product
	 * @return a double that represents the price of the product
	 */
	public double getPrezzo() {
		return prezzo;
	}
	
	/**
	 * Set the price of the product
	 * @param prezzo price of the product
	 */
	public void setPrezzo(double prezzo) {
		if(prezzo<0) throw new IllegalArgumentException("Prezzo prodotto minore di 0");
		this.prezzo = prezzo;
	}

	/**
	 * Get the collection of recipes associated  ????
	 * @return
	 */
	public ArrayList<Ricetta> getRicette() {
		return ricette;
	}

	/**
	 * ?????
	 * @param ricette
	 */
	public void setRicette(ArrayList<Ricetta> ricette) {
		this.ricette = ricette;
	}

	//Instance variables
	private Pasticceria pasticceria;
	private ArrayList<Ricetta> ricette;
	private String nome;
	private int codice,quantita,minScorta;
	private double prezzo;
}
