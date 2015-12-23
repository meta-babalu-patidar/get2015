/**
 * @author Babalu Patidar
 * 
 */


package DatabaseDeadlock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtill {

	private String DB_URL = "jdbc:mysql://localhost:3306/employee";
	private String USER = "root";
	private String PASSWORD = "mysql";
	private Connection connection = null;

	/**
	 * Method create connection for database. 
	 * @return Connection object.
	 */
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found..");

		}
		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("connection not found..");
		}
		return connection;
	}
}
