package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
}
