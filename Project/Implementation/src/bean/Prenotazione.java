package bean;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Prenotazione {
	public Prenotazione(String codice, GregorianCalendar dataPrenotazione, GregorianCalendar dataRitiro, String note){
		this.codice=codice;
		this.dataPrenotazione= dataPrenotazione;
		this.dataRitiro=dataRitiro;
		this.note=note;
		this.effettuata=false;
		this.prodotti = new ArrayList<Ricetta>();
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public GregorianCalendar getDataPrenotazione() {
		return dataPrenotazione;
	}
	public void setDataPrenotazione(GregorianCalendar dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	public GregorianCalendar getDataRitiro() {
		return dataRitiro;
	}
	public void setDataRitiro(GregorianCalendar dataRitiro) {
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
	
	private ArrayList<Ricetta> prodotti;
	private String codice,note;
	private GregorianCalendar dataPrenotazione, dataRitiro;
	boolean effettuata;
}
