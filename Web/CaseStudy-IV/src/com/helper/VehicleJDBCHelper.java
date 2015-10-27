/****************************************************************************************
Name            : VehicleJDBCHelper
Revision Log    : 2015-10-24: Babalu patidar : created.
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
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.Utills.ConnectionUtill;
import com.model.Bike;
import com.model.Car;
import com.model.Vehicle;
import com.model.VehicleDekhoSystemException;

public class VehicleJDBCHelper {
	
	
	@SuppressWarnings("resource")
	public static boolean create( Vehicle vehicle ) throws VehicleDekhoSystemException
	{
		// Creating connection
		ConnectionUtill connectionUtill = new ConnectionUtill();
		Connection connection = connectionUtill.getConnection();
		PreparedStatement prepareStatement = null;
		Statement statement = null;
		ResultSet resultSet = null;
		boolean isInsert = false;
		try{
			// take data from vehicle to corresponding variables
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
				prepareStatement = connection.prepareStatement(query); 
				prepareStatement.setString(1, author);
				prepareStatement.setTimestamp(2, new Timestamp(vehicle.getCreated_Time().getTime()));
				prepareStatement.setString(3, make);
				prepareStatement.setString(4, model);
				prepareStatement.setInt(5, engineCC);
				prepareStatement.setInt(6, fuelCapacity);
				prepareStatement.setInt(7, milage);
				prepareStatement.setDouble(8, price);
				prepareStatement.setDouble(9, roadTax);
				// execute query
				prepareStatement.execute(); 
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
					prepareStatement = connection.prepareStatement(query);
					prepareStatement.setString(1, ac);
					prepareStatement.setString(2, powerSteering);
					prepareStatement.setString(3, accessoryKit);
					prepareStatement.setInt(4, vehicleId);
					// execute query
					prepareStatement.execute();			
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
					prepareStatement = connection.prepareStatement(query);
					prepareStatement.setString(1, selfStart);
					prepareStatement.setDouble(2, helmetprice);
					prepareStatement.setInt(3, vehicleId);
					prepareStatement.execute();
				}
			} 
			connection.commit();
		}
		catch (SQLException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			throw new VehicleDekhoSystemException("Could not insert due to : "+e.getMessage());
		}
		finally{
			try {
				if(statement != null){
					statement.close();
				}
				if(prepareStatement != null){
					prepareStatement.close();
				}
				connection.close();
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return isInsert;
	}
	
	// Method to search vehicles in database
	@SuppressWarnings("resource")
	public static List<Vehicle> searchByMakeAndModel(String make, String model) {
		// query for search
		String query = "SELECT * FROM vehicle WHERE make = '"+make+"' AND model = '"+model+"'"; 
		Statement statement = null, statement2 = null;
		ResultSet resultSetVehicle = null;
		ResultSet resultSetSpecific = null;
		String selfStart = "", ac, powerSteering, accessoryKit, createdBy;
		int engineCC, fuelCapacity, mileage;
		Date createdTime;
		double price, roadTax, helmetPrice= 0;
		ConnectionUtill conUtil = new ConnectionUtill();
		Connection con = conUtil.getConnection();
		List<Vehicle> vehicles = null;
		try {
			statement = con.createStatement();
			statement2 = con.createStatement();
			// execute the query and take data in resultset
			resultSetVehicle = statement.executeQuery(query); 
			// make a list which holds results
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
				
				resultSetSpecific = statement2.executeQuery(query);
				// if vehicle is not a car than it will be bike
				if(resultSetSpecific.next() == false) {
					query = "SELECT * FROM Bike WHERE vehicle_id = "+vehicle_id;
					resultSetSpecific = statement2.executeQuery(query);
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
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(statement != null)
					statement.close();
				if(statement2 != null)
					statement2.close();
				if(resultSetSpecific != null)
					resultSetSpecific.close();
				if(resultSetVehicle != null)
					resultSetVehicle.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return vehicles;
	}
	
	// method used for delete data from database based on make
	public static int deleteByMake(String make) throws VehicleDekhoSystemException {
		String query = "DELETE FROM Vehicle where make = '"+make+"'";
		ConnectionUtill connectionUtill = new ConnectionUtill();
		Connection connection = connectionUtill.getConnection();
		int numberOfrecordsDeleted;
		try {
			Statement stmt = connection.createStatement();
			numberOfrecordsDeleted = stmt.executeUpdate(query);
			
		} catch(Exception e) {
			numberOfrecordsDeleted=-1;
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());		
		}
		return numberOfrecordsDeleted;
	}
	
	// method used for delete data from database based on model
	public static int deleteByModel(String model) throws VehicleDekhoSystemException {
		String query = "DELETE FROM Vehicle where model = '"+model+"'";
		ConnectionUtill connectionUtill = new ConnectionUtill();
		Connection connection = connectionUtill.getConnection();
		int numberOfrecordsDeleted;
		try {
			Statement statement = connection.createStatement();
			
			numberOfrecordsDeleted = statement.executeUpdate(query);
		} catch(Exception e) {
			numberOfrecordsDeleted=-1;
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());	
		}
		return numberOfrecordsDeleted;
		
	}
	
	// method used for delete data from database based on make and model
	public static int deleteByMakeModel(String make, String model) throws VehicleDekhoSystemException {
		String query = "DELETE FROM Vehicle WHERE make = '"+make+"' AND model = '"+model+"'";
		ConnectionUtill connectionUtill = new ConnectionUtill();
		Connection connection = connectionUtill.getConnection();
		int numberOfrecordsDeleted;
		try {
			Statement statement = connection.createStatement();
			numberOfrecordsDeleted = statement.executeUpdate(query);
		} catch(Exception e) {
	
			numberOfrecordsDeleted=-1;
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());	
		}

		return numberOfrecordsDeleted;
	}
	
	// method for update data in database
	public static int updateByMakeAndModel(Vehicle vehicle) throws VehicleDekhoSystemException {
		String query = "UPDATE Vehicle SET engine_cc="+vehicle.getEnginInCC()+",fuel_capacity="+vehicle.getFuelCapacity()+",milage="+vehicle.getMilage()+",price="+vehicle.getPrice()+",roadTax="+vehicle.getRoadTax()+" where make = '"+vehicle.getMake()+"' AND model='"+vehicle.getModel()+"'";
		ConnectionUtill connectionUtill = new ConnectionUtill();

		int numberOfrecordsUpdated;
		Connection connection = connectionUtill.getConnection();
		try {
			Statement statement = connection.createStatement();
			numberOfrecordsUpdated = statement.executeUpdate(query);
			query = "SELECT vehicle_id FROM Vehicle WHERE make='"+vehicle.getMake()+"' AND model='"+vehicle.getModel()+"'";
			ResultSet resultSet = statement.executeQuery(query);
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
			statement.executeUpdate(query);
		} catch(Exception e) {
			numberOfrecordsUpdated = -1;
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		}
		return numberOfrecordsUpdated;
	}
	
	//Method return profile of admin
	public static ResultSet adminProfile() throws VehicleDekhoSystemException {
		String query = "SELECT * FROM Admin";
		Connection connection = null;
		ResultSet resultSet = null;
		ConnectionUtill connectionUtil = new ConnectionUtill();
		try {
			connection = connectionUtil.getConnection();
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		}
		return resultSet;
	}
	
	//Method return result set of distinct make
	public static ResultSet distictMake() throws VehicleDekhoSystemException {
		String query = "SELECT DISTINCT make from Vehicle";
		Connection connection = null;
		ResultSet ResultSet = null;
		ConnectionUtill connectionUtill = new ConnectionUtill();
		try {
			connection = connectionUtill.getConnection();
			Statement statement = connection.createStatement();
			ResultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not search due to : "+e.getMessage());
		}
		return ResultSet;
	}
	
	//mehod is for search model.
	public static ResultSet searchModel(String make) throws VehicleDekhoSystemException {
		String query = "SELECT model from Vehicle WHERE make='"+make+"'";
		Connection connection = null;
		ResultSet resultSet = null;
		ConnectionUtill conUtil = new ConnectionUtill();
		try {
			connection = conUtil.getConnection();
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new VehicleDekhoSystemException("Could not search due to : "+e.getMessage());
		}
		return resultSet;
	}
	
	//Method is used to update admin profile.
	public static int updateAdminProfile(HttpServletRequest request) throws VehicleDekhoSystemException {
		String query = "UPDATE Admin SET name='"+request.getParameter("name")+"', contact='"+request.getParameter("contact")+"', address='"+request.getParameter("address")+"' WHERE email='"+request.getParameter("email")+"'";
		Connection connection = null;
		Statement statement = null;
		ConnectionUtill connectionUtill = new ConnectionUtill();
		connection = connectionUtill.getConnection();
		int update;
		try{
			statement = connection.createStatement();
			update = statement.executeUpdate(query);
		} catch(Exception e) {
			update = -1;
			throw new VehicleDekhoSystemException("Could not update due to : "+e.getMessage());
		}
		return update;
	}
	
	//Method is for login check than admin is Authentic OR not
	public static boolean loginCheck(HttpServletRequest request) throws VehicleDekhoSystemException {
		boolean isAdmin = false;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String query = "SELECT * FROM Admin WHERE email='"+email+"' AND password='"+password+"'";
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		ConnectionUtill connectionUtill = new ConnectionUtill();
		connection = connectionUtill.getConnection();
		try{
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if( resultSet.next() ) {
					isAdmin = true;
			}
		} catch(Exception e) {
			throw new VehicleDekhoSystemException("Could not search admin due to : "+e.getMessage());
		}
		return isAdmin;
	}
	//End of isAdmin method
}
//End of class
