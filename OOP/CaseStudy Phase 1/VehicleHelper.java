/****************************************************************************************
Name            : VehicleHelper
Revision Log    : 2015-09-14: Babalu patidar : created.
                : 
                : 
Use             : This class is used to create New vehicle.
                :
****************************************************************************************/

public class VehicleHelper {

	public static Vehicle createVehicle(String vehicleType, String model, String make) { // constructor
		 // if vehicle type is car than call createCar
		if (vehicleType.equals("car")) {   
			return createCar(model, make);

		} 
		// else call method createBike
		else {
			return createBike(model, make); 
		}

	}
	//End of method createVehicle 

	//createCar method is used to create a New Car objrect and return object 
	private static Vehicle createCar(String model, String make) { 
		Vehicle vehicle = new Car(); 
		// set the variables of car
		vehicle.setEnginInCC(700);
		vehicle.setFuelCapacity(40);
		vehicle.setMake(make);
		vehicle.setMilage(22);
		vehicle.setModel(model);
		vehicle.setPrice(750000.00);
		vehicle.setRoadTax(6000);
		((Car) vehicle).setAC(true);
		((Car) vehicle).setAccessoryKit(true);
		((Car) vehicle).setPowerSteering(true);

		return vehicle;

	}
	
	//createBike method is used to create a New Bike objrect and return object 
	private static Vehicle createBike(String model, String make) {
		Vehicle vehicle = new Bike(); 
		// set the variables of Bike
		vehicle.setEnginInCC(125);
		vehicle.setFuelCapacity(20);
		vehicle.setMake(make);
		vehicle.setMilage(75);
		vehicle.setModel(model);
		vehicle.setPrice(60000.00);
		vehicle.setRoadTax(2000);
		((Bike) vehicle).setHelmetPrize(250);
		((Bike) vehicle).setSelfStart(true);

		return vehicle;

	}
	
}
//End of vehicleHelper Class
