package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Prodotto;
import connectionPool.JDBCConnectionPool;

public class ProductManager 
{
	public static synchronized boolean delete(String key) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "DELETE FROM Prodotto WHERE codice = ?";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, key);
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
	
	public static synchronized boolean add(Prodotto product) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO Prodotto" 
				+ "(codice, nome, quantita, minScorta, prezzo, pasticceria)"
				+" VALUES (?, ?, ?, ?, ?, ?)";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, product.getCodice());
			preparedStatement.setString(2, product.getNome());
			preparedStatement.setInt(3, product.getQuantita());
			preparedStatement.setInt(4, product.getMinScorta());
			preparedStatement.setDouble(5, product.getPrezzo());
			preparedStatement.setInt(6,1);
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
