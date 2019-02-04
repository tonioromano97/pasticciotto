package bean;

import java.sql.Date;
/**
 * Sub-class of Finanza
 * This bean represents an income of the associated bakery.
 * @author giulio
 *
 */
public class Entrata extends Finanza {

	/**
	 * Constructor of the new Entrata object
	 * @param codice code of the income
	 */
	public Entrata(int codice)
	{
		super(codice);
	}
	
	/**
	 * Constructor of the new Entrata object
	 * @param codice code of the income
	 * @param p bakery associated to the income
	 * @param descrizione description of the income
	 * @param data date of the income
	 * @param importo amount of the income
	 */
	public Entrata(int codice, Pasticceria p, String descrizione, Date data, double importo) {
		super(codice, p, descrizione, data, importo);
	
	}

}
