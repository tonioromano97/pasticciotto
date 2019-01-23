package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Entrata;
import bean.Finanza;
import connectionPool.JDBCConnectionPool;

public class FinanceManager 
{
	public static synchronized boolean addEntrata(Entrata finance) throws SQLException
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
}
