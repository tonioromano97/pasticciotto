package bean;

import java.sql.Date;

public abstract class Finanza {
	
	public Finanza(int codice)
	{
		this.codice = codice;
	}
	
	public Finanza(int codice, Pasticceria pasticceria, String descrizione, Date data, double importo){
		this.codice = codice;
		this.descrizione = descrizione;
		this.data=data;
		this.importo=importo;
		this.pasticceria = pasticceria;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public double getImporto() {
		if(importo<0) throw new IllegalArgumentException("Importo minore di 0");
		return importo;
	}
	
	public void setImporto(double importo) {
		this.importo = importo;
	}
	
	public Pasticceria getPasticceria(){
		return pasticceria;
	}
	
	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	private Pasticceria pasticceria;
	private String descrizione;
	private Date data;
	private int codice;
	private double importo;
}
