/****************************************************************************************
Name            : VehicleDekhoService
Revision Log    : 2015-10-30: Babalu patidar : created.
                : 
                : 
Use             : This class is used to establish connection and after completing task closed that connection.
                :
****************************************************************************************/
package com.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.Exceptions.VehicleDekhoSystemException;
import com.facade.VehicleDekhoFacade;
import com.factory.ConnectionFactory;
import com.model.Vehicle;

public class VehicleDekhoService {

	//this method is used to create vehicle in database.
	public boolean createVehicle(Vehicle vehicle) throws VehicleDekhoSystemException {
		boolean resultDB = false;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection(); 
			resultDB = facade.createVehicle(connection, vehicle);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not create vehicle due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		
		return resultDB;
	}

	//this method updates the vehicle attributes in database
	public int updateVehicle(Vehicle vehicle) throws VehicleDekhoSystemException {
		int resultDB = 0;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			resultDB = facade.updateVehicle(connection, vehicle);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not Update vehicle due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		return resultDB;
	}

	//this method get list of all distinct makes from database 
	public List<String> getMake() throws VehicleDekhoSystemException {
		List<String> resultDB = null;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			resultDB = facade.getMake(connection);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not retrive list of make due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		return resultDB;
	}

	//this methods get list of all models corresponding to make from database
	public List<String> getModel(String make) throws VehicleDekhoSystemException {
		List<String> resultDB = null;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			resultDB = facade.getModel(connection, make);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not retrive list of model due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		return resultDB;
	}

	//this method get list of vehicles corresponding to make and model from database
	public List<Vehicle> getVehicle(String make, String model) throws VehicleDekhoSystemException {
		List<Vehicle> resultDB = null;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			resultDB = facade.getVehicle(connection, make, model);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not retrive Vehicle due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		return resultDB;
	}

	//delete vehicle entry from database 
	public int deleteVehicle(String make, String model) throws VehicleDekhoSystemException {
		int resultDB = 0;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection  = null;
		try {
			connection = ConnectionFactory.getConnection();
			resultDB = facade.deleteVehicle(connection, make, model);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not delete Vehicle due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		return resultDB;
	}

	//get profile of administrator
	public Map<String, String> getProfile() throws VehicleDekhoSystemException {
		Map<String, String> resultDB = null;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			resultDB = facade.getProfile(connection);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not get Admin Profile due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		return resultDB;
	}

	//this method update profile of administrator
	public int updateProfile(List<String> profileData) throws VehicleDekhoSystemException {
		int resultDB = 0;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			resultDB = facade.updateProfile(connection, profileData);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not Update Admin Profile due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		return resultDB;
	}
	
	//IsAdmin method for check admin login details.
	public boolean isAdmin(String email, String password) throws VehicleDekhoSystemException {
		boolean resultDB = false;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			resultDB = facade.isAdmin(connection, email, password);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not validate admin due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		return resultDB;
	}

}
//End of class