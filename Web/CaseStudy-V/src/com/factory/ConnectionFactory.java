/****************************************************************************************
Name            : ConnectionFactory
Revision Log    : 2015-10-30: Babalu patidar : created.
                : 
                : 
Use             : This class is used to establish connection from database.
                :
****************************************************************************************/
package com.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.Exceptions.VehicleDekhoSystemException;

public class ConnectionFactory {

	
	private static String DB_URL;
	private static String USER;
	private static String PASSWORD;
			
	private static Connection con = null;
	
	
	//This method establish connection from database
	public static Connection getConnection() throws VehicleDekhoSystemException{
		// get URL
		DB_URL = "jdbc:mysql://localhost:3306/Vehicle";
		// get USERNAME
	    USER = "root";
	    // get PASSWORD
		PASSWORD = "mysql";
		/* register driver */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new VehicleDekhoSystemException("Driver Class not found", e);
		}
		
		/* open connection */
		try {
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new VehicleDekhoSystemException("Error while make connection ", e);
		}
		return con;
	}
	
	//This method is used to connection object
	public static void closeConnection(Connection connection) throws VehicleDekhoSystemException {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Error while make connection ", e);
			}
		}
	}
	
}
