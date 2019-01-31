package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Pasticceria;
import bean.Prodotto;
import bean.Ricetta;
import connectionPool.JDBCConnectionPool;

public class RecipeManager 
{
	public static synchronized boolean update(Ricetta recipe)
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean ricettaDone = false, ingredientiDone = false;

		String updateSQL = "UPDATE Ricetta" 
				+ "SET 'nome' = ? , 'ore' = ? , 'minuti' = ? , 'prezzoVendita' = ? , 'prezzoAcquisto' = ? , 'pasticceria' = ?"
				+" WHERE 'codice' = ?";
		
			try {
				connection = JDBCConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(updateSQL);
				preparedStatement.setString(1, recipe.getNome());
				preparedStatement.setInt(1, recipe.getH());
				preparedStatement.setInt(3, recipe.getM());
				preparedStatement.setDouble(4, recipe.getPrezzoVendita());
				preparedStatement.setDouble(5, recipe.getPrezzoAcquisto());
				preparedStatement.setInt(6, recipe.getPasticceria().getCodice());
				if (preparedStatement.executeUpdate() > 0)
					ricettaDone = true;
				preparedStatement.close();
				connection.close();
				ingredientiDone = updateComposition(recipe);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return ricettaDone && ingredientiDone;
				
	}
	

	
	public static synchronized boolean add(Ricetta recipe) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO Ricetta" 
				+ "(nome, ore, minuti, prezzoVendita, prezzoAcquisto, pasticceria)"
				+" VALUES (?, ?, ?, ?, ?, ?)";
		
		String insertSQL2 = "INSERT INTO Prodotto_Ricetta (ricetta,prodotto,quantita) VALUES ((SELECT MAX(codice) FROM Ricetta),?,?)";

		try {
			try {
				connection = JDBCConnectionPool.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, recipe.getNome());
			preparedStatement.setInt(2, recipe.getH());
			preparedStatement.setInt(3, recipe.getM());
			preparedStatement.setDouble(4, recipe.getPrezzoVendita());
			preparedStatement.setDouble(5, recipe.getPrezzoAcquisto());
			preparedStatement.setInt(6, recipe.getPasticceria().getCodice());
			if (preparedStatement.executeUpdate() > 0){
				preparedStatement = connection.prepareStatement(insertSQL2);
				for(Prodotto prodotto : recipe.getComposizione()){
					preparedStatement.setInt(1, prodotto.getCodice());
					preparedStatement.setDouble(2, prodotto.getQuantita());
					preparedStatement.executeUpdate();
				}
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
		return false;
	}
	/*public static synchronized Ricetta getRecipe(Pasticceria p)
	{
		
	} */
	public static synchronized ArrayList<Ricetta> getRecipes(Pasticceria p) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		ResultSet rs = null, rs2 = null;
		Ricetta ricetta;
		
		ArrayList<Ricetta> ricette = new ArrayList<Ricetta>();
		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();

		String selectSQL = "SELECT * FROM Ricetta WHERE pasticceria = ?";
		String selectSQL2 = "SELECT pr.codice AS codiceP, pr.nome AS nomeP, pa_pr.quantita AS qP FROM Ricetta r, Prodotto pr, Prodotto_Ricetta pa_pr "
				+ "WHERE pa_pr.ricetta = r.codice AND pa_pr.prodotto = pr.codice AND r.pasticceria = ? AND r.codice= ?";
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
				prodotti = new ArrayList<>();
				int codice = rs.getInt("codice");
				String nome = rs.getString("nome");
				int h = rs.getInt("ore");
				int m = rs.getInt("minuti");
				double prezzoVendita = rs.getDouble("prezzoVendita");
				double prezzoAcquisto = rs.getDouble("prezzoAcquisto");
				ricetta = new Ricetta(codice,nome,h,m,prezzoVendita,prezzoAcquisto,p);
				preparedStatement2 = connection.prepareStatement(selectSQL2);
				preparedStatement2.setInt(1, p.getCodice());
				preparedStatement2.setInt(2, ricetta.getCodice());
				rs2 = preparedStatement2.executeQuery();
				while(rs2.next())
				{
					int codiceP = rs2.getInt("codiceP");
					String nomeP = rs2.getString("nomeP");
					int quantitaP = rs2.getInt("qP");
					prodotti.add(new Prodotto(codiceP,nomeP, quantitaP));
				}
				ricetta.setComposizione(prodotti);
				ricette.add(ricetta);
				
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
	
	
	private static boolean updateComposition(Ricetta recipe)
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean deleted = false, updated = false;

		String deleteSQL = "DELETE FROM Prodotto_Ricetta"
				+ "WHERE ricetta = ?";
		String insertSQL = "INSERT INTO Prodotto_Ricetta (ricetta,prodotto,quantita)"
				+ " VALUES (?,?,?)";
		
			try {
				//Delete first the old associations
				connection = JDBCConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(deleteSQL);
				preparedStatement.setInt(1,recipe.getCodice());
				if (preparedStatement.executeUpdate() > 0)
					deleted = true;
				preparedStatement.close();
				connection.close();
				//Add new associations
				connection = JDBCConnectionPool.getConnection();
				updated = true;
				for (Prodotto p : recipe.getComposizione())
				{
					preparedStatement = connection.prepareStatement(insertSQL);
					preparedStatement.setInt(1,recipe.getCodice());
					preparedStatement.setInt(2, p.getCodice());
					preparedStatement.setDouble(3, p.getQuantita());
					if (preparedStatement.executeUpdate() <= 0)
					{
						updated = false;
						preparedStatement.close();
						break;
					}
					preparedStatement.close();
				}
				connection.close();
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return deleted && updated;
				
	}
	
}
