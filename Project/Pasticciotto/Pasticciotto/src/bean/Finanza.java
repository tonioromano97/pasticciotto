package bean;

import java.sql.Date;
/**
 * This bean represents a finance of the associated bakery
 * @author giulio
 *
 */
public abstract class Finanza {
	
	/**
	 * Constructor of the new Finanza object
	 * @param codice code of the finance
	 */
	public Finanza(int codice)
	{
		this.codice = codice;
	}
	
	/**
	 * Constructor of the new Finanza object
	 * @param codice code of the finance
	 * @param pasticceria bakery associated to the finance
	 * @param descrizione description of the finance
	 * @param data date of the finance
	 * @param importo amount of the finance
	 */
	public Finanza(int codice, Pasticceria pasticceria, String descrizione, Date data, double importo){
		this.codice = codice;
		this.descrizione = descrizione;
		this.data=data;
		this.importo=importo;
		this.pasticceria = pasticceria;
	}
	
	/**
	 * Get the description of the finance
	 * @return a string that represents the description of the finance
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	/**
	 * Sets the description of the finance
	 * @param descrizione the description of the finance
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	/**
	 * Get the date of the finance
	 * @return a Date object that represents the date of the finance
	 */
	public Date getData() {
		return data;
	}
	
	/**
	 * Sets the date of the finance
	 * @param data the date of the finance
	 */
	public void setData(Date data) {
		this.data = data;
	}
	
	/**
	 * Get the amount of the finance
	 * @return a double that represents the amount of the finance
	 */
	public double getImporto() {
		if(importo<0) throw new IllegalArgumentException("Importo minore di 0");
		return importo;
	}
	
	/**
	 * Sets the amount of the finance
	 * @param importo amount of the finance
	 */
	public void setImporto(double importo) {
		this.importo = importo;
	}
	
	/**
	 * Get the bakery associated to the finance
	 * @return a Pasticceria object that represents the bakery associated to the finance
	 */
	public Pasticceria getPasticceria(){
		return pasticceria;
	}
	
	/**
	 * Set the bakery associated to the finance 
	 * @param p the Pasticceria object associated to the finance
	 */
	public void setPasticceria(Pasticceria p)
	{
		pasticceria = p;
	}
	
	/**
	 * Get the code of the finance
	 * @return a integer that represents the code of the finance
	 */
	public int getCodice() {
		return codice;
	}

	/**
	 * Sets the code of the finance
	 * @param codice the code of the finance
	 */
	public void setCodice(int codice) {
		this.codice = codice;
	}

	//Instance variables
	private Pasticceria pasticceria;
	private String descrizione;
	private Date data;
	private int codice;
	private double importo;
}
