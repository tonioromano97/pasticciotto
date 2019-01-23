package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Pasticceria;
import bean.Prodotto;
import connectionPool.JDBCConnectionPool;

public class PastryManager {

	public static synchronized boolean add(Pasticceria pastry) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO Pasticceria" 
				+ "(nome, indirizzo, email, telefono, descrizione, urlWebsite)"
				+" VALUES (?, ?, ?, ?, ?, ?)";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, pastry.getNome());
			preparedStatement.setString(2, pastry.getIndirizzo());
			preparedStatement.setString(3, pastry.getEmail());
			preparedStatement.setString(4, pastry.getTelefono());
			preparedStatement.setString(5, pastry.getDescrizione());
			preparedStatement.setString(6, pastry.getUrlWebSite());
			if (preparedStatement.executeUpdate() > 0)
				return true;
			
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
		return false;
	}
	
	public static synchronized Pasticceria retrieve(int key) throws SQLException
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
				p = new Pasticceria(codice,nome,indirizzo,email,telefono,descrizione,urlWebsite,null);
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
	
}
