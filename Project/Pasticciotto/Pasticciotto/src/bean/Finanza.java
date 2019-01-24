package bean;

import java.sql.Date;

public class Finanza {
	
	public Finanza(Pasticceria pasticceria, String descrizione, Date data, double importo){
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
	
	private Pasticceria pasticceria;
	private String descrizione;
	private Date data;
	private double importo;
}
