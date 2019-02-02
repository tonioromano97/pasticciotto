package bean;

import java.sql.Date;

public class Entrata extends Finanza {

	public Entrata(int codice)
	{
		super(codice);
	}
	
	public Entrata(int codice, Pasticceria p, String descrizione, Date data, double importo) {
		super(codice, p, descrizione, data, importo);
	
	}

}
