package bean;

import java.sql.Date;

public class Uscita extends Finanza {

	public Uscita(int codice)
	{
		super(codice);
	}
	
	public Uscita(int codice, Pasticceria p, String descrizione, Date data, double importo, String tipo) {
		super(codice, p, descrizione, data, importo);
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
