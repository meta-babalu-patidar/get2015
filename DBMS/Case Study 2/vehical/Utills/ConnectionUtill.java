/****************************************************************************************
Name            : ConnectionUtill
Revision Log    : 2015-09-21: Babalu patidar : created.
                : 
                : 
Use             : This class is used to establish connection from database.
                :
****************************************************************************************/


package Utills;

import helper.MyException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import VehicleXML.*;

public class ConnectionUtill {

	
	private String DB_URL;
	private String USER;
	private String PASSWORD;
			
	private Connection con = null;
	
	public Connection getConnection() throws MyException {
		
		ConnectionItems connectionItem = new ConnectionItems();
		// make object of ReadConnectionXml
		ReadConnectionXml read = new ReadConnectionXml();
		 //call readConfig method and get connectionItem 
		connectionItem = read.readConfig("connection.xml");
		DB_URL = connectionItem.geturl();
	    USER = connectionItem.getUsername(); 
		PASSWORD = connectionItem.getPassword();
		//Register driver 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			throw new MyException(e);
		}
		
		//Open connection 
		try {
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} 
		catch (SQLException e) {
			throw new MyException(e);
		}
		return con;
	}
	
}
//End of connectionUtill class
