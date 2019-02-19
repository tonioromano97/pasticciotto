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
import sun.security.timestamp.TSRequest;

public class RecipeManager 
{
	

	
	public static synchronized boolean add(Ricetta recipe) throws SQLException
	{
		if(recipe==null) return false;
	
		if(recipe.getPasticceria()==null) return false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO Ricetta" 
				+ "(nome, ore, minuti, prezzoVendita, prezzoAcquisto, procedimento, pasticceria)"
				+" VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		String insertSQL2 = "INSERT INTO Prodotto_Ricetta (ricetta,prodotto,quantita) VALUES ((SELECT MAX(codice) FROM Ricetta),?,?)";
		
		String updateSQL = " update ricetta as a inner join ricetta as b "
						 + " on a.codice = b.codice set a.prezzoAcquisto = "
						 + " (select sum(prodotto.prezzo*prodotto_ricetta.quantita ) "
						 + " from prodotto_ricetta, prodotto "
						 + " where prodotto.codice = prodotto_ricetta.prodotto and prodotto_ricetta.ricetta="
						 + " (select max(codice) from (select codice from ricetta) as c)) "
						 + " where a.codice = (select max(codice) from (select codice from ricetta) as c)";

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
			preparedStatement.setString(6, recipe.getProcedimento());
			preparedStatement.setInt(7, recipe.getPasticceria().getCodice());
			if (preparedStatement.executeUpdate() > 0){
				preparedStatement = connection.prepareStatement(insertSQL2);
				for(Prodotto prodotto : recipe.getComposizione()){
					preparedStatement.setInt(1, prodotto.getCodice());
					preparedStatement.setDouble(2, prodotto.getQuantita());
					preparedStatement.executeUpdate();
				}
				preparedStatement = connection.prepareStatement(updateSQL);
				if(preparedStatement.executeUpdate()>0) return true;
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
	public static synchronized Collection<Ricetta> getRecipes(Pasticceria p) throws SQLException
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
				String procedimento = rs.getString("procedimento");
				boolean insale = rs.getBoolean("insale");
				ricetta = new Ricetta(codice,nome,h,m,prezzoVendita,prezzoAcquisto,p);
				ricetta.setInsale(insale);
				ricetta.setProcedimento(procedimento);
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
	
	private static synchronized boolean addProduct(Ricetta recipe, Prodotto product) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean updated = false;
		
		String insertSQL = "INSERT INTO Prodotto_Ricetta (ricetta,prodotto,quantita)"
				+ " VALUES (?,?,?)";
		
			try {
				//Delete first the old associations
				connection = JDBCConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(insertSQL);
				preparedStatement.setInt(1,recipe.getCodice());
				preparedStatement.setInt(2,product.getCodice());
				preparedStatement.setInt(3,product.getQuantita());
				if (preparedStatement.executeUpdate() > 0)
					updated = true;
				preparedStatement.close();
				connection.close();				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return updated;		
	}
	
	private static synchronized boolean removeProduct(Ricetta recipe, Prodotto product) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean updated = false;
		
		String insertSQL = "DELETE FROM Prodotto_Ricetta WHERE ricetta = ? AND prodotto = ?";
		
			try {
				//Delete first the old associations
				connection = JDBCConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(insertSQL);
				preparedStatement.setInt(1,recipe.getCodice());
				preparedStatement.setInt(2,product.getCodice());	
				if (preparedStatement.executeUpdate() > 0)
					updated = true;
				preparedStatement.close();
				connection.close();				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return updated;		
	}
	
	public static synchronized boolean updateComposition(Ricetta recipe, Prodotto product, int type) throws SQLException {
		
		boolean state = false;
		
		if(recipe == null || product==null) return false;
		
		if(type==0) state = addProduct(recipe, product);
		else state = removeProduct(recipe, product);
		
		if(state){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateSQL = " update ricetta as a inner join ricetta as b "
				 + " on a.codice = b.codice set a.prezzoAcquisto = "
				 + " (select sum(prodotto.prezzo*prodotto_ricetta.quantita ) "
				 + " from prodotto_ricetta, prodotto "
				 + " where prodotto.codice = prodotto_ricetta.prodotto and prodotto_ricetta.ricetta="
				 + " (select max(codice) from (select codice from ricetta) as c)) "
				 + " where a.codice = (select max(codice) from (select codice from ricetta) as c)";
	
			try {
				connection = JDBCConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(updateSQL);
				if (preparedStatement.executeUpdate() > 0){
					preparedStatement.close();
					connection.close();
					return true;
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return state;
		}
		else {
			 return state;
		}
		
		
	}
	
}
