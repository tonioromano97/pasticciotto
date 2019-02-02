package bean;

/**
 * This bean represents an user of the system
 * @author giulio
 *
 */
public class Utente {
	
	//Empty constructor
	public Utente()
	{
		this.nome="";
		this.cognome="";
		this.email="";
		this.password="";
		this.telefono="";
		this.pasticceria=null;
		this.ruolo = "";
		this.numPrenotazioni = -1;
	}
	/**
	 * Constructor of the new Utente object
	 * @param nome Name of the user
	 * @param cognome Surname of the user
	 * @param email Email of the user
	 * @param pw Password of the user
	 * @param telefono Cellphone of the user
	 * @param pasticceria Bakery that user has got
	 * @param ruolo Role that user plays in the bakery
	 * @param numPrenotazioni the number of reservations
	 */
	public Utente(String nome, String cognome, String email, String pw, String telefono, Pasticceria pasticceria, String ruolo, int numPrenotazioni){
		this.nome=nome;
		this.cognome=cognome;
		this.email=email;
		this.password=pw;
		this.telefono=telefono;
		this.pasticceria=pasticceria;
		this.ruolo = ruolo;
		this.numPrenotazioni = numPrenotazioni;
	}
	/**
	 * Get the name of the user
	 * @return a string that represents the name of the user
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Set the name of the user
	 * @param nome the name associated to the user
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Get the surname of the user
	 * @return a string that represents the surname of the user
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * Set the surname of the user
	 * @param cognome the surname associated to the user
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	/**
	 * Get the email of the user
	 * @return a string that represents the email of the user
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of the user
	 * @param email the email associated to the user
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the password of the user
	 * @return a string that represents the password of the user
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password of the user
	 * @param pw the password associated to the user
	 */
	public void setPw(String pw) {
		password = pw;
	}
	
	/**
	 * Get the phone number of the user
	 * @return a string that represents the phone number of the user
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Set the phone number of the user
	 * @param telefono the phone number associated to the user
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Get the role of the user
	 * @return a string that represents the role of the user
	 */
	public String getRuolo() {
		return ruolo;
	}

	/**
	 * Set the number of reservations of the user
	 * @param ruolo the role of the user that can be {'Proprietario','Magazziniere','Pasticciere', 'Cliente'}
	 */
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	/**
	 * Get the number of reservations of the user
	 * @return an integer that represents the number of reservations
	 */
	public int getNumPrenotazioni() {
		return numPrenotazioni;
	}

	/**
	 * Set the number of reservations of the user
	 * @param numPrenotazioni the number of reservations done from the user
	 */
	public void setNumPrenotazioni(int numPrenotazioni) {
		this.numPrenotazioni = numPrenotazioni;
	}

	/**
	 * Get the bakery referenced to the user
	 * @return the Pasticceria object that represents the bakery associated to the user
	 */
	public Pasticceria getPasticceria() {
		return pasticceria;
	}

	/**
	 * Set the bakery associated to the user
	 * @param pasticceria the Pasticceria object associated to the user
	 */
	public void setPasticceria(Pasticceria pasticceria) {
		this.pasticceria = pasticceria;
	}

	//Instance variables
	private String nome,cognome,email,password,telefono,ruolo;
	private int numPrenotazioni;
	private Pasticceria pasticceria;
}
