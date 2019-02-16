package connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionPool
{
	private static final String driver = "com.mysql.jdbc.Driver";	
	private static final String url = "jdbc:mysql://localhost/pasticciotto";
	private static final String user = "root";
	private static final String password="pasticciotto";
	
	public static Connection getConnection()throws SQLException, ClassNotFoundException
	{
		Connection connection = null;

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("MySQL JDBC Driver registrato!");
		connection = DriverManager.getConnection(url,user,password);
		if (connection != null) {
			System.out.println("Connesso al DB!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		return connection;
	}
	
	public static void releaseConnection(Connection c) throws SQLException
	{
		c.close();
	}
}