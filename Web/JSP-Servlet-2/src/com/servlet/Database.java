/****************************************************************************************
Name            : Database
Revision Log    : 2015-10-14: Babalu patidar : created.
                : 
                : 
Use             : This class is used to insert an search query to database.
                :
****************************************************************************************/

package com.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Database {

	//insert method is used for insert name ,email and password in table.
	//It return true if data is inserted successfully.
	public static boolean insert(String name, String email, String password) {
		
		boolean flag=false;	
		Connection connection = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		connection = conUtil.getConnection();
		String query = "INSERT INTO userdetail VALUES(?,?,?)";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,email);
			preparedStatement.setString(3,password);
			preparedStatement.executeUpdate();
			flag=true;
		}
		
		catch (SQLException e) {
		
			flag=false;
			
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return flag;
	}
	//End of insert method.

	//search method is used ti search email and password in table.
	//It return true if email and password match in table.
	public static int search(String email, String password) throws SQLException {

		ResultSet resultSet=null;
		String query = "select * from userdetail where email='"+email+"' and password='"+password+"';";
		int flag=0;
	
		Connection connection = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		connection = conUtil.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				flag=1;
			}
			else {
				flag=0;
			}
		}
		
		catch (SQLException e) {
			resultSet=null;	
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return flag;
	}	
	//End of search method.

}
//End of class.
