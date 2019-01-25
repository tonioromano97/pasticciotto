package bean;

import java.util.ArrayList;

public class Ricetta {
	public Ricetta(String nome, double prezzoVendita){
		this.nome=nome;
		this.prezzoVendita = prezzoVendita;
	}
	public Ricetta(String nome,int h, int m,double prezzoVendita,double prezzoAcquisto){
		this.nome=nome;
		this.h=h;
		this.m=m;
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
	public void setComposizione(ArrayList<Prodotto> p) {
		this.composizione = p;
	}
	
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}

	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	
	public int getCodice() {
		return codice;
	}

	private ArrayList<Prodotto> composizione;
	private String nome;
	private int codice,h,m;
	double prezzoVendita,prezzoAcquisto;
}
