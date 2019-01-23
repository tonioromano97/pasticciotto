package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Pasticceria;
import bean.Prodotto;
import bean.Ricetta;
import connectionPool.JDBCConnectionPool;

public class VetrinaManager 
{
	public static synchronized ArrayList<Ricetta> retrieve(Pasticceria bakery) throws SQLException
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
				ricette.add(new Ricetta(nome,"",prezzoVendita,-1));
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

}
