package bean;

public class Prodotto {

	public Prodotto(Pasticceria pasticceria, String codice){
		this.pasticceria=pasticceria;
		this.codice=codice;
	}
	
	public Prodotto(Pasticceria pasticceria, String codice, String nome, int quantita, int minScorta, double prezzo){
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
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
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

	private Pasticceria pasticceria;
	String codice,nome;
	int quantita,minScorta;
	double prezzo;
}
