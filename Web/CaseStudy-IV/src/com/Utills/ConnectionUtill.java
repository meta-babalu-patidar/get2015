/****************************************************************************************
Name            : ConnectionUtill
Revision Log    : 2015-10-24: Babalu patidar : created.
                : 
                : 
Use             : This class is used to establish connection from database.
                :
****************************************************************************************/


package com.Utills;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtill {

	
	private String DB_URL;
	private String USER;
	private String PASSWORD;
			
	private Connection con = null;
	
	public Connection getConnection(){
		// get URL
		DB_URL = "jdbc:mysql://localhost:3306/Vehicle"; 
		// get USERNAME
	    USER = "root"; 
	    // get PASSWORD
		PASSWORD = "mysql";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
}
