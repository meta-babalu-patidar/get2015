/****************************************************************************************
Name            : ConnectionUtil
Revision Log    : 2015-09-16: Babalu patidar : created.
                : 
                : 
Use             : This class is used to create connection
                :
****************************************************************************************/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/library2";
	private static final String USER = "root";
	private static final String PASSWORD = "mysql";
			
	private Connection connection = null;
	
	public Connection getConnection() {	
		//open connection 
		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
}
//End of class