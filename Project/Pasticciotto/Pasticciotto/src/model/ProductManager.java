package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import bean.Pasticceria;
import bean.Prodotto;
import connectionPool.JDBCConnectionPool;

public class ProductManager 
{
	public static synchronized boolean add(Prodotto product) throws SQLException
	{
		if (product == null || product.getPasticceria() == null)
			return false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO Prodotto" 
				+ "(nome, quantita, minScorta, prezzo, pasticceria)"
				+" VALUES (?, ?, ?, ?, ?)";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, product.getNome());
			preparedStatement.setInt(2, product.getQuantita());
			preparedStatement.setInt(3, product.getMinScorta());
			preparedStatement.setDouble(4, product.getPrezzo());
			preparedStatement.setInt(5,product.getPasticceria().getCodice());
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
	
	
	public static synchronized boolean delete(Prodotto p) throws SQLException
	{
		if(p == null)
			return false;
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
			preparedStatement.setInt(1, p.getCodice());
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
	
	
	
	
	public static synchronized boolean modifyProduct(Prodotto p) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE Prodotto SET nome = ? , quantita = ? , minScorta = ? , prezzo = ? WHERE codice = ?";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, p.getNome());
			preparedStatement.setInt(2, p.getQuantita());
			preparedStatement.setInt(3, p.getMinScorta());
			preparedStatement.setDouble(4, p.getPrezzo());
			preparedStatement.setInt(5, p.getCodice());

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
	
	public static synchronized Collection<Prodotto> getProducts(Pasticceria p) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<Prodotto> products = new ArrayList<Prodotto>();

		String selectSQL = "SELECT * FROM Prodotto WHERE pasticceria = ?";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, p.getCodice());
			rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				int codice = rs.getInt("codice");
				String nome = rs.getString("nome");
				int quantita = rs.getInt("quantita");
				int minScorta = rs.getInt("minScorta");
				double prezzo = rs.getDouble("prezzo");
				
				products.add(new Prodotto(p,codice,nome,quantita,minScorta,prezzo));
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
		return products;
	}
	/* public synchronized ArrayList<Prodotto> searchProducts(Pasticceria p, String name) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<Prodotto> products = new ArrayList<Prodotto>();

		String selectSQL = "SELECT * FROM Prodotto WHERE nome LIKE ? AND pasticceria = ?";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1,"%"+name+"%");
			preparedStatement.setInt(2, p.getCodice());
			rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				int codice = rs.getInt("codice");
				String nome = rs.getString("nome");
				int quantita = rs.getInt("quantita");
				int minScorta = rs.getInt("minScorta");
				double prezzo = rs.getDouble("prezzo");
				products.add(new Prodotto(p,codice,nome,quantita,minScorta,prezzo));
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
		return products;
	} */
	
}
