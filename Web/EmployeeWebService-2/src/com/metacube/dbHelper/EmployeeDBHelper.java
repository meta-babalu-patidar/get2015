/****************************************************************************************
Name            : EmployeeDBHelper
Revision Log    : 2015-11-02: Babalu patidar : created.
                : 
                : 
Use             : This class is used to handle database.
                :
****************************************************************************************/
package com.metacube.dbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.metacube.EmployeeSystemException;
import com.metacube.ConnectionUtill.ConnectionUtill;
import com.metacube.model.Employee;


public class EmployeeDBHelper {
	
	//AddEmployee method take employee object and add in to database.
	//Method return number of rows updated.
	public boolean addEmployee(Employee employee) throws EmployeeSystemException{
		
		ConnectionUtill connectionUtill = new ConnectionUtill();
		Connection connection = connectionUtill.getConnection();
		PreparedStatement prepareStatement = null;
		boolean result = false;
		try{
			
			connection.setAutoCommit(false);
			// query for inserting data
			String query = "INSERT INTO Employee VALUES(?,?,?)";
			// make prepare statement object
			prepareStatement = connection.prepareStatement(query); 
			prepareStatement.setString(1, employee.getName());
			prepareStatement.setString(2, employee.getId());
			prepareStatement.setInt(3, employee.getAge());
			// execute query
			prepareStatement.execute(); 
			result = true;

			connection.commit();
		}
		catch (SQLException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new EmployeeSystemException("Could not roll back : "+e1.getMessage());
			}
			throw new EmployeeSystemException("Could not insert due to : "+e.getMessage());
		}
		finally{
			try {
				
				if(prepareStatement != null){
					prepareStatement.close();
				}
				connection.close();
			} catch (SQLException e) {
				throw new EmployeeSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return result;
	}
	//End of addEmployee method.

	//returnEmployee method take id as input.
	//Method return employee object of that id.
	public Employee returnEmployee(String id) throws EmployeeSystemException{
		
		String query = "SELECT * from Employee WHERE id='"+id+"'";
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement =null;
		Employee employee =new Employee();
		ConnectionUtill conUtil = new ConnectionUtill();
		try {
			connection = conUtil.getConnection();
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			resultSet.next();
			employee.setId(resultSet.getString("id"));
			employee.setName(resultSet.getString("name"));
			employee.setAge(resultSet.getInt("age"));
			connection.commit();
			
		}catch (SQLException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new EmployeeSystemException("Could not roll back : "+e1.getMessage());
			}
			throw new EmployeeSystemException("Could not return  Employee due to : "+e.getMessage());
		}
		finally{
			try {
				
				if(statement != null){
					statement.close();
				}
				connection.close();
			} catch (SQLException e) {
				throw new EmployeeSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return employee;
		
	}
	//End of return employee by id
	
	
	//Method return all employee .
	public List<Employee> returnAllEmployee() throws EmployeeSystemException{
		
		String query = "SELECT * from Employee";
		List<Employee> list = new ArrayList<Employee>();
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement =null;
		ConnectionUtill conUtil = new ConnectionUtill();
		try {
			connection = conUtil.getConnection();
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				Employee employee =new Employee();
				employee.setId(resultSet.getString("id"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getInt("age"));
				list.add(employee);
			
			}
			connection.commit();
			
		}catch (SQLException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new EmployeeSystemException("Could not roll back : "+e1.getMessage());
			}
			throw new EmployeeSystemException("Could not Return ALL employee due to : "+e.getMessage());
		}
		finally{
			try {
				
				if(statement != null){
					statement.close();
				}
				connection.close();
			} catch (SQLException e) {
				throw new EmployeeSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return list;
		
	}
	//End of all Employee method
	
	//Method takes input as name.
	//Method return list of all employee..
	public List<Employee> returnAllEmployee(String name) throws EmployeeSystemException{
		
		String query = "SELECT * from Employee where name='"+name+"'";
		List<Employee> list = new ArrayList<Employee>();
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement =null;
		ConnectionUtill conUtil = new ConnectionUtill();
		try {
			connection = conUtil.getConnection();
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				Employee employee =new Employee();
				employee.setId(resultSet.getString("id"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getInt("age"));
				list.add(employee);
			
			}
			connection.commit();
			
		}catch (SQLException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new EmployeeSystemException("Could not roll back : "+e1.getMessage());
			}
			throw new EmployeeSystemException("Could not return all employee by name due to : "+e.getMessage());
		}
		finally{
			try {
				
				if(statement != null){
					statement.close();
				}
				connection.close();
			} catch (SQLException e) {
				throw new EmployeeSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return list;
		
	}
	//End of allemployee method..
	
	//Method deleteEmployee takes string as input..
	//Return true if deleted otherwise false
	public boolean deleteEmployee(String id) throws EmployeeSystemException{
		
		String query = "Delete from Employee where id='"+id+"'";
		Connection connection = null;
		int resultSet = 0;
		boolean result = false;
		Statement statement =null;
		ConnectionUtill conUtil = new ConnectionUtill();
		try {
			connection = conUtil.getConnection();
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			resultSet = statement.executeUpdate(query);
			if(resultSet == 1){
				result = true;
			}
			connection.commit();
			
		}catch (SQLException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new EmployeeSystemException("Could not roll back : "+e1.getMessage());
			}
			throw new EmployeeSystemException("Could not delete due to : "+e.getMessage());
		}
		finally{
			try {
				
				if(statement != null){
					statement.close();
				}
				connection.close();
			} catch (SQLException e) {
				throw new EmployeeSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return result;
	}
	//End of delete employee..

}
//End of class
