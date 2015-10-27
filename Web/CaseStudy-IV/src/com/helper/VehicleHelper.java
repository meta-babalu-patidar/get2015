/****************************************************************************************
Name            : VehicleHelper
Revision Log    : 2015-10-24: Babalu patidar : created.
                : 
                : 
Use             : This class is used to create a Vehicle object and add its attribute value.
                :
****************************************************************************************/
package com.helper;

import com.model.Bike;
import com.model.Car;
import com.model.Vehicle;

public class VehicleHelper {

	public static Vehicle createVehicle(VehicleType vehicleType, String model,
			String make) {
		// if vehicle type is car than call createCar
		if (vehicleType.equals(VehicleType.Car)) {		
			return createCar(model, make);

		} 
		// else call method createBike
		else {
			return createBike(model, make);	

		}

	}

	private static Vehicle createCar(String model, String make) {
		// make object of vehicle and give it to reference of Car
		Vehicle vehicle = new Car();		 
		// set the variables of car
		java.util.Date today = new java.util.Date();
		java.sql.Date date = new java.sql.Date(today.getTime());
		vehicle.setCreated_By("Babalu");
		vehicle.setCreated_Time(date);
		vehicle.setEnginInCC(500);
		vehicle.setFuelCapacity(50);
		vehicle.setMake(make);
		vehicle.setMilage(17);
		vehicle.setModel(model);
		vehicle.setPrice(800000.00);
		vehicle.setRoadTax(10000);
		((Car) vehicle).setAC(true);
		((Car) vehicle).setAccessoryKit(true);
		((Car) vehicle).setPowerSteering(true);

		return vehicle;

	}
	//End of createcar method

	private static Vehicle createBike(String model, String make) {
		// make object of vehicle and give it to reference of Bike
		Vehicle vehicle = new Bike();	
		// set the variables of Bike
		java.util.Date today = new java.util.Date();
		java.sql.Date date = new java.sql.Date(today.getTime());
		vehicle.setCreated_By("Babalu");
		vehicle.setCreated_Time(date);
		vehicle.setEnginInCC(500);
		vehicle.setFuelCapacity(50);
		vehicle.setMake(make);
		vehicle.setMilage(17);
		vehicle.setModel(model);
		vehicle.setPrice(800000.00);
		vehicle.setRoadTax(10000);
		((Bike) vehicle).setHelmetPrize(100);
		((Bike) vehicle).setSelfStart(true);

		return vehicle;

	}
	//End of create bike method
}
//End of class
