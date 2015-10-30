/****************************************************************************************
Name            : VehicleDekhoFacade
Revision Log    : 2015-10-30: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement facade design pattern.
                :
****************************************************************************************/

package com.facade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.Exceptions.VehicleDekhoSystemException;
import com.helper.VehicleJDBCHelper;
import com.model.Vehicle;

public class VehicleDekhoFacade {
	
	
	//this method is used to create vehicle in database.
	public boolean createVehicle(Connection connection, Vehicle vehicle) throws VehicleDekhoSystemException {
		boolean resultDB = false;
		
		try {
			resultDB = VehicleJDBCHelper.create(connection, vehicle);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not create vehicle due to : "+e.getMessage());
		}
		
		return resultDB;
	}
	
	//this method updates the vehicle attributes in database
	public int updateVehicle(Connection connection, Vehicle vehicle) throws VehicleDekhoSystemException {
		int resultDB = 0;
		try {
			resultDB = VehicleJDBCHelper.updateByMakeAndModel(connection,vehicle);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not Update vehicle due to : "+e.getMessage());
		}
		return resultDB;
	}
	
	//this method get list of all distinct makes from database 
	public List<String> getMake(Connection connection) throws VehicleDekhoSystemException {
		List<String> resultDB = null;
		try {
			resultDB = VehicleJDBCHelper.distictMake(connection);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not retrive list of make due to : "+e.getMessage());
		}
		return resultDB;
	}
	
	//this methods get list of all models corresponding to make from database
	public List<String> getModel(Connection connection, String make) throws VehicleDekhoSystemException {
		List<String> resultDB = null;
		try {
			resultDB = VehicleJDBCHelper.searchModel(connection, make);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not retrive list of model due to : "+e.getMessage());
		}
		return resultDB;
	}
	
	//this method get list of vehicles corresponding to make and model from database
	public List<Vehicle> getVehicle(Connection connection, String make, String model) throws VehicleDekhoSystemException {
		List<Vehicle> resultDB = null;
		try {
			resultDB = VehicleJDBCHelper.searchByMakeAndModel(connection, make, model);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not retrive Vehicle due to : "+e.getMessage());
		}
		return resultDB;
	}
	
	//delete vehicle entry from database 
	public int deleteVehicle(Connection connection, String make, String model) throws VehicleDekhoSystemException {
		int resultDB = 0;
		try {
			resultDB = VehicleJDBCHelper.deleteByMakeModel(connection, make, model);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not delete Vehicle due to : "+e.getMessage());
		}
		return resultDB;
	}
	
	//get profile of administrator
	public Map<String, String> getProfile(Connection connection) throws VehicleDekhoSystemException {
		Map<String, String> resultDB = null;
		try {
			resultDB = VehicleJDBCHelper.adminProfile(connection);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not get Admin Profile due to : "+e.getMessage());
		}
		return resultDB;
	}
	
	//this method update profile of administrator
	public int updateProfile(Connection connection, List<String> profileData) throws VehicleDekhoSystemException {
		int resultDB = 0;
		try {
			resultDB = VehicleJDBCHelper.updateAdminProfile(connection, profileData);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not Update Admin Profile due to : "+e.getMessage());
		}
		return resultDB;
	}
	
	//This method validate administrator email and password
	public boolean isAdmin(Connection connection, String email, String password) throws VehicleDekhoSystemException {
		boolean resultDB = false;
		try {
			resultDB = VehicleJDBCHelper.loginCheck(connection, email, password);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not validate admin due to : "+e.getMessage());
		}
		return resultDB;
	}
	//End of isAdmin method

}
//End of class
