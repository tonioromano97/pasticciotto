package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import bean.Entrata;
import bean.Finanza;
import bean.Pasticceria;
import bean.Ricetta;
import bean.Uscita;

public class FinanceManager 
{
	
	public static synchronized Collection<Finanza> getFinances(Pasticceria p) throws SQLException
	{
		if(p == null)
			return null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs;
		ArrayList<Finanza> finances = new ArrayList<Finanza>();
		

		String selectSQL = "SELECT * FROM Entrata WHERE pasticceria = ?";
		String selectSQL2 = "SELECT * FROM Uscita WHERE pasticceria = ?";
		

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
			while (rs.next())
			{
				int codice = rs.getInt("id");
				String descrizione = rs.getString("descrizione");
				Date data = rs.getDate("data");
				double importo = rs.getDouble("importo");
			
				finances.add(new Entrata(codice,p,descrizione,data,importo));
			}
			preparedStatement.close();
			preparedStatement = connection.prepareStatement(selectSQL2);
			preparedStatement.setInt(1, p.getCodice());
			rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				int codice = rs.getInt("id");
				String descrizione = rs.getString("descrizione");
				Date data = rs.getDate("data");
				double importo = rs.getDouble("importo");
				String tipo = rs.getString("tipo");
			
				finances.add(new Uscita(codice,p,descrizione,data,importo,tipo));
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
		return finances;
	}
	
	public static synchronized boolean addEntrata(Entrata finance) throws SQLException
	{
		if (finance == null || finance.getPasticceria() == null)
			return false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO Entrata" 
				+ "(descrizione,data,importo,pasticceria)"
				+" VALUES (?, ?, ?, ?)";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, finance.getDescrizione());
			preparedStatement.setDate(2, finance.getData());
			preparedStatement.setDouble(3, finance.getImporto());
			preparedStatement.setInt(4, finance.getPasticceria().getCodice());
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
	
	public static synchronized boolean addUscita(Uscita finance) throws SQLException
	{
		if (finance == null || finance.getPasticceria() == null)
			return false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO Uscita" 
				+ "(descrizione,data,importo,tipo,pasticceria)"
				+" VALUES (?, ?, ?, ?, ?)";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, finance.getDescrizione());
			preparedStatement.setDate(2, finance.getData());
			preparedStatement.setDouble(3, finance.getImporto());
			preparedStatement.setString(4, finance.getTipo());
			preparedStatement.setInt(5, finance.getPasticceria().getCodice());
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
	
	public static synchronized boolean deleteFinance(Finanza f) throws SQLException
	{
		if (f== null)
			return false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String deleteSQL;
		if(f instanceof Entrata)
			deleteSQL = "DELETE FROM Entrata WHERE id = ?";
		else
			deleteSQL = "DELETE FROM Uscita WHERE id = ?";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(deleteSQL);
				preparedStatement.setInt(1, f.getCodice());
				if (preparedStatement.executeUpdate() > 0)
					return true;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
	
}
