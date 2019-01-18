package bean;

import java.util.GregorianCalendar;

public class Entrata extends Finanza {

	public Entrata(Pasticceria p, String descrizione, GregorianCalendar data, double importo) {
		super(p, descrizione, data, importo);
	}

}
