package connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionPool
{
	static final String driver = "com.mysql.jdbc.Driver";	
	static final String url = "jdbc:mysql://localhost/pasticciotto";
	static final String user = "root";
	static final String password="pasticciotto";
	
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
}