package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.sun.org.apache.xml.internal.security.keys.content.RetrievalMethod;

import bean.Pasticceria;
import bean.Prenotazione;
import bean.Ricetta;
import bean.Utente;

public class BookingManager 
{
	
	public static synchronized Pasticceria getBakery(int key) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs;
		Pasticceria p = null;

		String selectSQL = "SELECT * FROM Pasticceria WHERE id = ?";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, key);
			rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				int codice = rs.getInt("id");
				String nome = rs.getString("nome");
				String indirizzo = rs.getString("indirizzo");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				String descrizione = rs.getString("descrizione");
				String urlWebsite = rs.getString("urlWebsite");
				String urlLogo = rs.getString("urlLogo");
				p = new Pasticceria(codice,nome,indirizzo,email,telefono,descrizione,urlWebsite,urlLogo);
			}
			
			//connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return p;
	}
	
	public static synchronized Collection<Pasticceria> getBakeries() throws SQLException
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet rs;
		ArrayList<Pasticceria> bakeries = new ArrayList<Pasticceria>();
		

		String selectSQL = "SELECT * FROM Pasticceria";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			statement = connection.createStatement();
			rs = statement.executeQuery(selectSQL);
			while (rs.next())
			{
				int codice = rs.getInt("id");
				String nome = rs.getString("nome");
				String indirizzo = rs.getString("indirizzo");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				String descrizione = rs.getString("descrizione");
				String urlWebsite = rs.getString("urlWebsite");
				String urlLogo = rs.getString("urlLogo");
				bakeries.add(new Pasticceria(codice,nome,indirizzo,email,telefono,descrizione,urlWebsite,urlLogo));
			}
			
			//connection.commit();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return bakeries;
	}
	
	
	public static synchronized Collection<Ricetta> getProducts(Pasticceria bakery) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<Ricetta> ricette = new ArrayList<Ricetta>();

		String selectSQL = "SELECT * FROM Ricetta WHERE pasticceria = ?";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, bakery.getCodice());
			rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				int codice = rs.getInt("codice");
				String nome = rs.getString("nome");
				double prezzoVendita = rs.getDouble("prezzoVendita");
				ricette.add(new Ricetta(codice,nome,prezzoVendita));
			}
			
			//connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return ricette;
	}
	
	public static synchronized Collection<Prenotazione> getBooking(Pasticceria p) throws SQLException{
		ArrayList<Prenotazione> codesBook = BookingManager.getCodeBookofBakery(p);
		for(Prenotazione pr : codesBook){
			BookingManager.setDataWidthoutRecipes(pr);
			BookingManager.setRecipesofBook(pr,p);
		}
		return codesBook;
	}
		
	
	private static synchronized ArrayList<Prenotazione> getCodeBookofBakery(Pasticceria p) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<Prenotazione> codeBook = new ArrayList<Prenotazione>();
		String selectSQL = "select distinct(prenotazione) as codeBook"
						 + " from ricetta r, prenotazione p, ricetta_prenotazione rp"
						 + " where r.codice = rp.ricetta and p.codice = rp.prenotazione and r.pasticceria = ?";
		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1,p.getCodice());
			rs = preparedStatement.executeQuery();
			while(rs.next()){
				codeBook.add(new Prenotazione(rs.getInt("codeBook")));
			}
			return codeBook;
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}
	
	private static synchronized void setDataWidthoutRecipes(Prenotazione p) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String selectSQL = "select *"
						 + " from prenotazione join utente"
						 + " on prenotazione.utente = utente.email"
						 + " and prenotazione.codice = ?";
		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1,p.getCodice());
			rs = preparedStatement.executeQuery();
			if(rs.first()){
				p.setDataPrenotazione(rs.getDate("dataPrenotazione"));
				p.setDataRitiro(rs.getDate("dataRitiro"));
				p.setNote(rs.getString("note"));
				Utente u = new Utente();
				u.setCognome(rs.getString("cognome"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setTelefono(rs.getString("telefono"));
				p.setUtente(u);
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}
	
	private static synchronized void setRecipesofBook(Prenotazione p, Pasticceria P) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<Ricetta> recipes = new ArrayList<Ricetta>(); 
		String selectSQL = "select *"
						 + " from ricetta JOIN ricetta_prenotazione"
						 + " on ricetta.codice = Ricetta_Prenotazione.ricetta"
						 + " and prenotazione = ? and pasticceria = ?";
		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1,p.getCodice());
			preparedStatement.setInt(2,P.getCodice());
			rs = preparedStatement.executeQuery();
			while(rs.next()){
				if(rs.getInt("effettuata")==0) p.setEffettuata(false);
				else p.setEffettuata(true);
				int codice = rs.getInt("codice");
				String nome = rs.getString("nome");
				int h = rs.getInt("ore");
				int m = rs.getInt("minuti");
				double prezzoAcquisto = rs.getDouble("prezzoAcquisto");
				double prezzoVendita = rs.getDouble("prezzoVendita");
				recipes.add(new Ricetta(codice, nome, h, m, prezzoVendita, prezzoAcquisto, P));
			}
			p.setProdotti(recipes);
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}
	
	public static synchronized boolean bookCakes(Prenotazione p) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		//Manca aggiunta del numPrenotazioni al cliente
		String insertPrenotazione = "INSERT INTO Prenotazione (dataPrenotazione,dataRitiro,note,effettuata,utente) VALUES (?, ?, ?, ?, ?)";
		String insertRicetta = "";
		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(insertPrenotazione);
			//preparedStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
			preparedStatement.setDate(1,p.getDataPrenotazione());
			preparedStatement.setDate(2,p.getDataRitiro());
			preparedStatement.setString(3,p.getNote());
			preparedStatement.setInt(4,0);
			preparedStatement.setString(5, p.getUtente().getEmail());
			preparedStatement.executeUpdate();
			insertRicetta = "INSERT INTO Ricetta_Prenotazione (prenotazione,ricetta,effettuata) VALUES ((SELECT MAX(codice) FROM Prenotazione),?,0)";
			for(Ricetta r : p.getProdotti()) {
				preparedStatement = connection.prepareStatement(insertRicetta);
				preparedStatement.setInt(1, r.getCodice());
				preparedStatement.executeUpdate();
			}
			return true;
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}
	
	public static synchronized boolean doBooking(Prenotazione p, Ricetta r)
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean done = false;

		String updateSQL = "UPDATE ricetta_prenotazione" 
				+ " SET effettuata = ?"
				+" WHERE prenotazione = ? AND ricetta = ?";
		
			try {
				connection = JDBCConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(updateSQL);
				if(p.isEffettuata())
					preparedStatement.setInt(1, 1);
				else preparedStatement.setInt(1, 0);
				preparedStatement.setInt(2, p.getCodice());
				preparedStatement.setInt(3, r.getCodice());
				if (preparedStatement.executeUpdate() > 0)
					done = true;
				preparedStatement.close();
				connection.close();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return done;

	}
	
}
