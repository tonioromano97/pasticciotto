package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import bean.Pasticceria;
import bean.Utente;
import connectionPool.JDBCConnectionPool;

public class UserManager 
{
	
	public synchronized static boolean register(Utente user) throws SQLException {
	
		if (user == null || user.getRuolo() == null)
			return false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO Utente" 
				+ " (nome, cognome, email, password, telefono, pasticceria, ruolo, numprenotazioni)"
				+" VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getNome());
			preparedStatement.setString(2, user.getCognome());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getTelefono());
			if(user.getPasticceria()==null)
				preparedStatement.setNull(6, java.sql.Types.INTEGER);
			else preparedStatement.setInt(6, user.getPasticceria().getCodice());
			preparedStatement.setString(7, user.getRuolo());
			if(user.getRuolo().equalsIgnoreCase("cliente"))
				preparedStatement.setInt(8, user.getNumPrenotazioni());
			else preparedStatement.setNull(8, java.sql.Types.INTEGER); 
			if (preparedStatement.executeUpdate() > 0)
				return true;
			//connection.commit();
		}
		catch(SQLException s)
		{
			return false;
		}
		finally 
		{
			if(preparedStatement != null)
					preparedStatement.close();
			if (connection != null)
					connection.close();
		}
		return true;
	}
	
	public synchronized static Utente login(String email, String password) throws SQLException
	{
		if (email == null || password == null)
			return null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Utente logged = null;
		int bakeryCode = 0;

		String selectSQL = "SELECT * FROM Utente WHERE email= ? AND password= ?";
		String selectSQL2 = "SELECT * FROM Pasticceria WHERE id = ?";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			rs = preparedStatement.executeQuery();
			if(rs.first())
			{
				logged = new Utente();
				logged.setNome(rs.getString("nome"));
				logged.setCognome(rs.getString("cognome"));
				logged.setEmail(rs.getString("email"));
				bakeryCode = rs.getInt("pasticceria");
				logged.setNumPrenotazioni(rs.getInt("numPrenotazioni"));
				logged.setRuolo(rs.getString("ruolo"));
				logged.setTelefono(rs.getString("telefono"));
			}
			preparedStatement.close();
			
			preparedStatement = connection.prepareStatement(selectSQL2);
			preparedStatement.setInt(1, bakeryCode);
			rs = preparedStatement.executeQuery();
			if(rs.first())
			{
				int codice = rs.getInt("id");
				String nome = rs.getString("nome");
				String indirizzo = rs.getString("indirizzo");
				String emailp = rs.getString("email");
				String telefono = rs.getString("telefono");
				String descrizione = rs.getString("descrizione");
				String urlWebsite = rs.getString("urlWebsite");
				String urlLogo = rs.getString("urlLogo");
				logged.setPasticceria(new Pasticceria(codice,nome,indirizzo,emailp,telefono,descrizione,urlWebsite,urlLogo));
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
		return logged;
	}
	
	public synchronized static boolean addPasticceria(Pasticceria p, Utente u) throws SQLException {

		if (p == null || u == null)
			return false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO Pasticceria" 
				+ " (nome, indirizzo, email, telefono, descrizione, urlWebsite, urlLogo)"
				+" VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, p.getNome());
			preparedStatement.setString(2, p.getIndirizzo());
			preparedStatement.setString(3, p.getEmail());
			preparedStatement.setString(4, p.getTelefono());
			preparedStatement.setString(5, p.getDescrizione());
			preparedStatement.setString(6, p.getUrlWebSite());
			preparedStatement.setString(7, p.getUrlLogo());
			if (preparedStatement.executeUpdate() > 0){
				return UserManager.linkLastPasticceriaAddedToUser(u);
			}
				
			//connection.commit();
		} 
		catch(SQLException s)
		{
			return false;
		}
		finally {
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
	
	
	private static boolean linkLastPasticceriaAddedToUser(Utente u) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE Utente SET pasticceria = (SELECT MAX(id) FROM Pasticceria) WHERE email = ?";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, u.getEmail());
			if (preparedStatement.executeUpdate() > 0)
				return true;
			//connection.commit();
		} 
		catch(SQLException s)
		{
			return false;
		}
		finally {
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
	
	
	public synchronized static boolean modifyEmail(Utente u, String newEmail) throws SQLException {

		if (u == null)
			return false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE Utente SET email = ? WHERE email = ?";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, newEmail);
			preparedStatement.setString(2, u.getEmail());

			if (preparedStatement.executeUpdate() > 0)
				return true;
			//connection.commit();
		} 
		catch(SQLException s)
		{
			return false;
		}
		finally {
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
	
	public synchronized static boolean modifyPassword(Utente u, String newPassword) throws SQLException {

		if(u == null || u.getPassword().equals(newPassword))
			return false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE Utente SET password = ? WHERE email = ?";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, u.getEmail());

			if (preparedStatement.executeUpdate() > 0)
				return true;
			//connection.commit();
		} 
		catch(SQLException s)
		{
			return false;
		}
		finally {
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
