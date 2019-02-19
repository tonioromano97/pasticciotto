package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class JDBCConnectionPool  {

	private static List<Connection> freeDbConnections;

	static {
		freeDbConnections = new LinkedList<Connection>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("DB driver not found:"+ e.getMessage());
		} 
	}
//	jdbc:mysql://127.0.0.1:3306/?user=root
	private static synchronized Connection createDBConnection() throws SQLException{
		Connection newConnection = null;
		String ip = "127.0.0.1";
		String port = "3306";
		String db = "pasticciotto";
		String username = "root";
		String password = "pasticciotto";

		newConnection = DriverManager.getConnection("jdbc:mysql://"+ ip+":"+ port+"/"+db, username, password);

		newConnection.setAutoCommit(true);
		return newConnection;
	}


	public static synchronized Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection connection;

		if (!freeDbConnections.isEmpty()) {
			connection = (Connection) freeDbConnections.get(0);
			freeDbConnections.remove(0);

			try {
				if (connection.isClosed())
					connection = getConnection();
			} catch (SQLException e) {
				connection.close();
				connection = getConnection();
			}
		} else {
			connection = createDBConnection();		
		}

		return connection;
	}

	public static synchronized void releaseConnection(Connection connection) throws SQLException {
		if(connection != null) freeDbConnections.add(connection);
	}
}