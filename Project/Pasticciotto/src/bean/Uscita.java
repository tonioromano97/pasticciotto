package bean;

import java.util.GregorianCalendar;

public class Uscita extends Finanza {

	public Uscita(Pasticceria p, String descrizione, GregorianCalendar data, double importo, String tipo) {
		super(p, descrizione, data, importo);
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	private String tipo;

}
