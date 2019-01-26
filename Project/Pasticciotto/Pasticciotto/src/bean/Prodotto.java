package bean;

import java.util.ArrayList;

public class Prodotto {

	public Prodotto(int codice, String nome, int quantita){
		this.codice = codice;
		this.nome=nome;
		this.quantita=quantita;
	}
	
	
	public Prodotto(Pasticceria pasticceria, int codice, String nome, int quantita, int minScorta, double prezzo){
		this.pasticceria=pasticceria;
		this.codice=codice;
		this.nome=nome;
		this.quantita=quantita;
		this.minScorta=minScorta;
		this.prezzo=prezzo;
	}
	
	public Pasticceria getPasticceria() {
		return pasticceria;
	}

	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		if(quantita<0) throw new IllegalArgumentException("Quantita prodotto minore di 0");
		this.quantita = quantita;
	}
	public int getMinScorta() {
		return minScorta;
	}
	public void setMinScorta(int minScorta) {
		if(minScorta<0) throw new IllegalArgumentException("Scorta minima prodotto minore di 0");
		this.minScorta = minScorta;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		if(prezzo<0) throw new IllegalArgumentException("Prezzo prodotto minore di 0");
		this.prezzo = prezzo;
	}

	public ArrayList<Ricetta> getRicette() {
		return ricette;
	}

	public void setRicette(ArrayList<Ricetta> ricette) {
		this.ricette = ricette;
	}

	private Pasticceria pasticceria;
	private ArrayList<Ricetta> ricette;
	private String nome;
	private int codice,quantita,minScorta;
	private double prezzo;
}
