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
				ricetta = new Ricetta(codice,nome,h,m,prezzoVendita,prezzoAcquisto);
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
}
