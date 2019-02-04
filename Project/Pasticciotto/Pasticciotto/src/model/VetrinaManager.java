package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import bean.Pasticceria;
import bean.Prodotto;
import bean.Ricetta;
import connectionPool.JDBCConnectionPool;

public class VetrinaManager 
{
	public static synchronized Collection<Ricetta> getVetrinaProducts(Pasticceria p) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		Ricetta ricetta;
		ArrayList<Ricetta> vetrinaProducts = new ArrayList<Ricetta>();
		//resume in this point
		String selectSQL = "SELECT nome,prezzoVendita,prezzoAcquisto FROM Ricetta WHERE pasticceria = ? AND insale = 1";

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
				String nome = rs.getString("nome");
				double prezzoVendita = rs.getDouble("prezzoVendita");
				double prezzoAcquisto = rs.getDouble("prezzoAcquisto");
				ricetta = new Ricetta(nome,prezzoVendita,prezzoAcquisto);
				vetrinaProducts.add(ricetta);
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
		return vetrinaProducts;

	}
	
	public static synchronized boolean add(Ricetta r) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean done = false;
		
		String updateSQL = "UPDATE Ricetta SET insale = 1 WHERE codice = ?";
		

			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setInt(1, r.getCodice());
			
			if (preparedStatement.executeUpdate() > 0)
				done = true;
			preparedStatement.close();
			connection.close();
			
		return done;
	}
	
	public static synchronized boolean remove(Ricetta r) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean done = false;
		
		String updateSQL = "UPDATE Ricetta SET insale = 0 WHERE codice = ?";
		

			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setInt(1, r.getCodice());
			
			if (preparedStatement.executeUpdate() > 0)
				done = true;
			preparedStatement.close();
			connection.close();
			
		return done;
	}
	
	public static synchronized boolean modifySalesPrice(Ricetta r) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean done = false;
		
		String updateSQL = "UPDATE Ricetta SET prezzoVendita = ? WHERE codice = ?";
		

			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setDouble(1, r.getPrezzoVendita());
			preparedStatement.setInt(2, r.getCodice());
			
			if (preparedStatement.executeUpdate() > 0)
				done = true;
			preparedStatement.close();
			connection.close();
			
		return done;
	}
	
}