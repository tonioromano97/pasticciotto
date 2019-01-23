package bean;

import java.util.ArrayList;

public class Ricetta {
	public Ricetta(String nome){
		this.nome=nome;
		this.composizione = new ArrayList<Prodotto>();
	}
	public Ricetta(String nome,String tempoMedio,double prezzoVendita,double prezzoAcquisto){
		this.nome=nome;
		this.tempoMedio=tempoMedio;
		this.prezzoAcquisto=prezzoAcquisto;
		this.prezzoVendita=prezzoVendita;
		this.composizione = new ArrayList<Prodotto>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTempoMedio() {
		return tempoMedio;
	}
	public void setTempoMedio(String tempoMedio) {
		//if(tempoMedio<0) throw new IllegalArgumentException("Tempo medio ricetta minore di 0");
		this.tempoMedio = tempoMedio;
	}
	public double getPrezzoVendita() {
		return prezzoVendita;
	}
	public void setPrezzoVendita(double prezzoVendita) {
		if(prezzoVendita<0) throw new IllegalArgumentException("Prezzo vendita minore di 0");
		this.prezzoVendita = prezzoVendita;
	}
	public double getPrezzoAcquisto() {
		return prezzoAcquisto;
	}
	public void setPrezzoAcquisto(double prezzoAcquisto) {
		if(prezzoAcquisto<0) throw new IllegalArgumentException("Prezzo acquisto minore di 0");
		this.prezzoAcquisto = prezzoAcquisto;
	}
	public ArrayList<Prodotto> getComposizione() {
		return composizione;
	}
	
	private ArrayList<Prodotto> composizione;
	private String nome;
	private String tempoMedio;
	double prezzoVendita,prezzoAcquisto;
}
