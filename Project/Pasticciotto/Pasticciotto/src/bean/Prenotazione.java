package bean;

import java.sql.Date;
import java.util.ArrayList;

public class Prenotazione {
	public Prenotazione(int codice, Date dataPrenotazione, Date dataRitiro, String note){
		this.codice=codice;
		this.dataPrenotazione= dataPrenotazione;
		this.dataRitiro=dataRitiro;
		this.note=note;
		this.effettuata=false;
		this.prodotti = new ArrayList<Ricetta>();
	}
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}
	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	public Date getDataRitiro() {
		return dataRitiro;
	}
	public void setDataRitiro(Date dataRitiro) {
		//check dataRitiro>dataPrenotazione
		this.dataRitiro = dataRitiro;
	}
	public boolean isEffettuata() {
		return effettuata;
	}
	public void setEffettuata(boolean effettuata) {
		this.effettuata = effettuata;
	}
	public ArrayList<Ricetta> getProdotti(){
		return prodotti;
	}
	
	public void setProdotti(ArrayList<Ricetta> p){
		this.prodotti = p;
	}
	
	public Utente getUtente() {
		return u;
	}
	public void setUtente(Utente u) {
		this.u = u;
	}

	private int codice;
	private Utente u;
	private ArrayList<Ricetta> prodotti;
	private String note;
	private Date dataPrenotazione, dataRitiro;
	boolean effettuata;
}
