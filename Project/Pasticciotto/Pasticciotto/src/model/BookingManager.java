package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Pasticceria;
import bean.Prenotazione;
import bean.Ricetta;
import connectionPool.JDBCConnectionPool;

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
	
	public static synchronized ArrayList<Pasticceria> getBakeries() throws SQLException
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
	
	
	public static synchronized ArrayList<Ricetta> getProducts(Pasticceria bakery) throws SQLException
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
				String nome = rs.getString("nome");
				double prezzoVendita = rs.getDouble("prezzoVendita");
				ricette.add(new Ricetta(nome,prezzoVendita));
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
	
	public static synchronized boolean bookCakes(Prenotazione p) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		String insertPrenotazione = "INSERT INTO Prenotazione (dataPrenotazione,dataRitiro,note,effettuata,utente) VALUES (?, ?, ?, ?);";
		insertPrenotazione += "SELECT MAX(codice) FROM Prenotazione";
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
			rs = preparedStatement.executeQuery();
			rs.next();
			int code = rs.getInt(0);
			insertRicetta = "INSERT INTO Ricetta_Prenotazione (prenotazione,ricetta) VALUES (?,?)";
			for(Ricetta r : p.getProdotti()) {
				preparedStatement = connection.prepareStatement(insertRicetta);
				preparedStatement.setInt(1, code);
				preparedStatement.setInt(2, r.getCodice());
				preparedStatement.executeQuery();
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
		return false;
	}
	
}