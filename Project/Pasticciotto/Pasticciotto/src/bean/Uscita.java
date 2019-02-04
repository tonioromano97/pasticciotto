package bean;

import java.sql.Date;
/**
 * Sub-class of Finanza
 * This bean represents an outflow of the associated bakery.
 * @author giulio
 *
 */
public class Uscita extends Finanza {

	/**
	 * Constructor of the new Uscita object
	 * @param codice code of the outflow
	 */
	public Uscita(int codice)
	{
		super(codice);
	}
	
	/**
	 * Constructor of the new Uscita object
	 * @param codice code of the outflow
	 * @param p bakery associated to the outflow
	 * @param descrizione description of the outflow
	 * @param data date of the outflow
	 * @param importo amount of the outflow
	 * @param tipo type of the outflow
	 */
	public Uscita(int codice, Pasticceria p, String descrizione, Date data, double importo, String tipo) {
		super(codice, p, descrizione, data, importo);
		this.tipo = tipo;
	}
	
	/**
	 * Gets the type of the outflow
	 * @return a string that represents the type of the outflow
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Sets the type of the outflow
	 * @param tipo the type of the outflow
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	//Instance variables
	private String tipo;

}
