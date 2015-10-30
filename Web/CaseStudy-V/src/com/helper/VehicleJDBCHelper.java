/****************************************************************************************
Name            : VehicleJDBCHelper
Revision Log    : 2015-10-30: Babalu patidar : created.
                : 
                : 
Use             : This class is used to create a Vehicle object and add its attribute value.
                :
****************************************************************************************/

package com.helper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import com.model.Bike;
import com.model.Car;
import com.model.Vehicle;
import com.Exceptions.VehicleDekhoSystemException;

public class VehicleJDBCHelper {
	
	@SuppressWarnings("resource")
	public static boolean create( Connection connection, Vehicle vehicle ) throws VehicleDekhoSystemException
	{
	
		PreparedStatement preparedStatement = null;
		Statement statement = null;
		ResultSet resultSet = null;
		boolean isInsert = false;
		try{
			//take data from vehicle to corresponding variables
			String author = vehicle.getCreated_By();
			String make = vehicle.getMake();
			String model = vehicle.getModel();
			int engineCC = vehicle.getEnginInCC();
			int fuelCapacity = vehicle.getFuelCapacity();
			int milage = vehicle.getMilage();
			double price = vehicle.getPrice();
			double roadTax = vehicle.getRoadTax();
			// query for inserting data
			String query = "SELECT * FROM Vehicle WHERE make='"+make+"' AND model='"+model+"'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if(!resultSet.next()) {
				isInsert = true;
				query = "INSERT INTO Vehicle(created_by,created_time,make,model,engine_cc,fuel_capacity,milage,price,roadTax) VALUES(?,?,?,?,?,?,?,?,?)";
				// make prepare statement object
				preparedStatement = connection.prepareStatement(query); 
				preparedStatement.setString(1, author);
				preparedStatement.setTimestamp(2, new Timestamp(vehicle.getCreated_Time().getTime()));
				preparedStatement.setString(3, make);
				preparedStatement.setString(4, model);
				preparedStatement.setInt(5, engineCC);
				preparedStatement.setInt(6, fuelCapacity);
				preparedStatement.setInt(7, milage);
				preparedStatement.setDouble(8, price);
				preparedStatement.setDouble(9, roadTax);
				preparedStatement.execute(); // execute query
				//take vehicle id for current inserting data
				query = "SELECT vehicle_id FROM Vehicle ORDER BY vehicle_id DESC"; 
				int vehicleId;
				
				resultSet = statement.executeQuery(query);
				resultSet.next();
				vehicleId = resultSet.getInt(1);
				// check if vehicle is instance of car than entry do in car table
				if(vehicle instanceof Car) 
				{
					String ac = "NO", powerSteering = "NO", accessoryKit = "NO";
					if(((Car)vehicle).isAC())
					{
						ac = "YES";
					}
					if(((Car)vehicle).isPowerSteering())
					{
						powerSteering = "YES";
					}
					if(((Car)vehicle).isAccessoryKit())
					{
						accessoryKit = "YES";
					}
					 // query for inserting data in car table
					query = "INSERT INTO Car(ac,powersteering,accessorykit,vehicle_id) VALUES(?,?,?,?)";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, ac);
					preparedStatement.setString(2, powerSteering);
					preparedStatement.setString(3, accessoryKit);
					preparedStatement.setInt(4, vehicleId);
					// execute query
					preparedStatement.execute();			
				}
				// otherwise do in bike table
				else				
				{
					String selfStart = "NO";
					double helmetprice = ((Bike)vehicle).getHelmetPrize();
					if(((Bike)vehicle).isSelfStart())
					{
						selfStart = "YES";
					}
					// query for inserting data in Bike table
					query = "INSERT INTO Bike(selfstart,helmetprice,vehicle_id) VALUES(?,?,?)"; 
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, selfStart);
					preparedStatement.setDouble(2, helmetprice);
					preparedStatement.setInt(3, vehicleId);
					preparedStatement.execute();
				}
			}
			connection.commit();
		}
		catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not insert due to : "+e.getMessage());
		}
		finally{
			try {
				if(statement != null){
					statement.close();
				}
				if(preparedStatement != null){
					preparedStatement.close();
				}
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return isInsert;
	}
	
	// Method to search vehicles in database
	@SuppressWarnings("resource")
	public static List<Vehicle> searchByMakeAndModel(Connection connection, String make, String model) throws VehicleDekhoSystemException {
		String query = "SELECT * FROM vehicle WHERE make = '"+make+"' AND model = '"+model+"'"; // query for search
		Statement statement = null, stmt2 = null;
		ResultSet resultSetVehicle = null;
		ResultSet resultSetSpecific = null;
		String selfStart = "", ac, powerSteering, accessoryKit, createdBy;
		int engineCC, fuelCapacity, mileage;
		Date createdTime;
		double price, roadTax, helmetPrice= 0;
		List<Vehicle> vehicles = null;
		try {
			statement = connection.createStatement();
			stmt2 = connection.createStatement();
			resultSetVehicle = statement.executeQuery(query); 
			vehicles = new ArrayList<Vehicle>();  
			Vehicle vehicle = null;
			while(resultSetVehicle.next()) {
				// put data from result set to corresponding variables
				createdBy = resultSetVehicle.getString("created_by");
				createdTime = resultSetVehicle.getDate("created_time");
				model = resultSetVehicle.getString("model");
				engineCC = resultSetVehicle.getInt("engine_cc");
				fuelCapacity = resultSetVehicle.getInt("fuel_capacity");
				mileage = resultSetVehicle.getInt("milage");
				price = resultSetVehicle.getDouble("price");
				roadTax = resultSetVehicle.getDouble("roadTax");
				
				int vehicle_id = resultSetVehicle.getInt("vehicle_id");
				
				query = "SELECT * FROM Car WHERE vehicle_id = "+vehicle_id;
				
				resultSetSpecific = stmt2.executeQuery(query);
				// if vehicle is not a car than it will be bike
				if(resultSetSpecific.next() == false) {
					query = "SELECT * FROM Bike WHERE vehicle_id = "+vehicle_id;
					resultSetSpecific = stmt2.executeQuery(query);
					if(resultSetSpecific.next()) {
						vehicle = new Bike();
						boolean b1 = false;
						selfStart = resultSetSpecific.getString("selfstart");
						helmetPrice = resultSetSpecific.getDouble("helmetprice");
						if( selfStart.equals("YES") )
							b1 = true;;
						((Bike)vehicle).setSelfStart(b1);
						((Bike)vehicle).setHelmetPrize(helmetPrice);
					}
				}
				// otherwise it is a car than put specific attributes of car in vehicle
				else {
					vehicle = new Car();
					boolean b1 = false, b2 = false, b3 = false;
					ac = resultSetSpecific.getString("ac");
					powerSteering = resultSetSpecific.getString("powersteering");
					accessoryKit = resultSetSpecific.getString("accessorykit");
					if( ac.equals("YES") ) b1 = true;
					if( powerSteering.equals("YES") ) b2 = true;
					if( accessoryKit.equals("YES") ) b3 = true;
					((Car)vehicle).setAC(b1);
					((Car)vehicle).setPowerSteering(b2);
					((Car)vehicle).setAccessoryKit(b3);
				}
				// set all the attributes of vehicle
				vehicle.setCreated_By(createdBy);
				vehicle.setCreated_Time(createdTime);
				vehicle.setEnginInCC(engineCC);
				vehicle.setFuelCapacity(fuelCapacity);
				vehicle.setMake(make);
				vehicle.setMilage(mileage);
				vehicle.setModel(model);
				vehicle.setPrice(price);
				vehicle.setRoadTax(roadTax);
				// add vehicle object in a list
				vehicles.add(vehicle);				
			}
		} catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not search due to : "+e.getMessage());
		}
		finally {
			try {
				if(statement != null)
					statement.close();
				if(stmt2 != null)
					stmt2.close();
				if(resultSetSpecific != null)
					resultSetSpecific.close();
				if(resultSetVehicle != null)
					resultSetVehicle.close();
			} catch(Exception e) {
				throw new VehicleDekhoSystemException("Could not close due to : "+e.getMessage());
			}
		}
		// return the list
		return vehicles;	
	}
	 
	// method used for delete data from database based on make and model
	public static int deleteByMakeModel(Connection connection, String make, String model) throws VehicleDekhoSystemException {
		String query = "DELETE FROM Vehicle WHERE make = '"+make+"' AND model = '"+model+"'";
		int numberOfrecordsDeleted = 0;
		Statement statement = null;
		try {
			statement = connection.createStatement();
			numberOfrecordsDeleted = statement.executeUpdate(query);
			connection.commit();
		} catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		} finally{
			try {
				if(statement != null){
					statement.close();
				}
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return numberOfrecordsDeleted;
	}
	
	// method for update data in database
	public static int updateByMakeAndModel(Connection connection, Vehicle vehicle) throws VehicleDekhoSystemException {
		String query = "UPDATE Vehicle SET engine_cc="+vehicle.getEnginInCC()+",fuel_capacity="+vehicle.getFuelCapacity()+",milage="+vehicle.getMilage()+",price="+vehicle.getPrice()+",roadTax="+vehicle.getRoadTax()+" where make = '"+vehicle.getMake()+"' AND model='"+vehicle.getModel()+"'";
		Statement statementt = null;
		ResultSet resultSet = null;
		try {
			statementt = connection.createStatement();
			int numberOfrecordsUpdated;
			numberOfrecordsUpdated = statementt.executeUpdate(query);
			query = "SELECT vehicle_id FROM Vehicle WHERE make='"+vehicle.getMake()+"' AND model='"+vehicle.getModel()+"'";
			resultSet = statementt.executeQuery(query);
			resultSet.next();
			int id = resultSet.getInt("vehicle_id");
			String ac = "NO", powerSteering = "NO", accessoryKit = "NO";
			if(((Car)vehicle).isAC())
			{
				ac = "YES";
			}
			if(((Car)vehicle).isPowerSteering())
			{
				powerSteering = "YES";
			}
			if(((Car)vehicle).isAccessoryKit())
			{
				accessoryKit = "YES";
			}
			query = "UPDATE Car SET ac='"+ac+"',powersteering='"+powerSteering+"',accessorykit='"+accessoryKit+"' WHERE vehicle_id="+id;
			statementt.executeUpdate(query);
			connection.commit();
			return numberOfrecordsUpdated;
		} catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		} finally{
			try {
				if(statementt != null){
					statementt.close();
				}
				if(resultSet != null){
					resultSet.close();
				}
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
	}

	//Method return profile of admin
	public static Map<String, String> adminProfile(Connection connection) throws VehicleDekhoSystemException {
		String query = "SELECT * FROM Admin";
		ResultSet resultSet = null;
		Statement statement = null;
		Map<String, String> profile = new HashMap<String, String>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			resultSet.next();
			profile.put("email", resultSet.getString("email"));
			profile.put("name", resultSet.getString("name"));
			profile.put("password", resultSet.getString("password"));
			profile.put("contact", resultSet.getString("contact"));
			profile.put("address", resultSet.getString("address"));
		} catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		} finally{
			try {
				if(statement != null){
					statement.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return profile;
	}

	//Method return result set of distinct make
	public static List<String> distictMake(Connection connection) throws VehicleDekhoSystemException {
		String query = "SELECT DISTINCT make from Vehicle";
		ResultSet resultSet = null;
		Statement statement = null;
		List<String> make = new ArrayList<String>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				make.add(resultSet.getString("make"));
			}
		} catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		} finally{
			try {
				if(statement != null){
					statement.close();
				}
				if(resultSet != null){
					resultSet.close();
				}
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return make;
	}
	
	//mehod is for search model.
	public static List<String> searchModel(Connection connection, String make) throws VehicleDekhoSystemException {
		String query = "SELECT model from Vehicle WHERE make='"+make+"'";
		ResultSet resultSet = null;
		Statement statement = null;
		List<String> model = new ArrayList<String>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				model.add(resultSet.getString("model"));
			}
		} catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		} finally{
			try {
				if(statement != null){
					statement.close();
				}
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return model;
	}
	
	//Method is used to update admin profile.
	public static int updateAdminProfile(Connection connection, List<String> profileData) throws VehicleDekhoSystemException {
		Iterator<String> iterator = profileData.iterator();
		iterator.hasNext();
		String email = iterator.next();
		String name = iterator.next();
		String password = iterator.next();
		String contact = iterator.next();
		String address = iterator.next();
		String query = "UPDATE Admin SET email='"+email+"', name='"+name+"', password='"+password+"', contact='"+contact+"', address='"+address+"'";
		Statement statement = null;
		int update = 0;
		try{
			statement = connection.createStatement();
			update = statement.executeUpdate(query);
			connection.commit();
		} catch (SQLException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		} finally{
			try {
				if(statement != null){
					statement.close();
				}
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return update;
	}

	//Method is for login check than admin is Authentic OR not
	public static boolean loginCheck(Connection connection, String email, String password) throws VehicleDekhoSystemException {
		boolean isAdmin = false;
		String query = "SELECT * FROM Admin WHERE email='"+email+"' AND password='"+password+"'";
		ResultSet resultSet = null;
		Statement statement = null;
		try{
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if( resultSet.next() ) {
					isAdmin = true;
			}
		} catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		} finally{
			try {
				if(statement != null){
					statement.close();
				}
				if(resultSet != null){
					resultSet.close();
				}
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return isAdmin;
	}
	//End of isAdmin method
}
//End of class
