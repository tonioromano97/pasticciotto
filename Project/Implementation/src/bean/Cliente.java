package bean;

import java.util.ArrayList;

public class Cliente extends Utente {
	
	public Cliente(String nome, String cognome, String email, String pw, String telefono){
		super(nome,cognome,email,pw,telefono);
		numPrenotazioni=0;
		prenotazioni = new ArrayList<Prenotazione>();
	}

	public int getNumPrenotazioni() {
		return numPrenotazioni;
	}

	public void setNumPrenotazioni(int numPrenotazioni) {
		if(numPrenotazioni<0) throw new IllegalArgumentException("Numero prenotazioni minore di 0");
		this.numPrenotazioni = numPrenotazioni;
	}

	public ArrayList<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
	
	private int numPrenotazioni;
	private ArrayList<Prenotazione> prenotazioni;
}
