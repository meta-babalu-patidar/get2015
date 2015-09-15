/****************************************************************************************
Name            : VehicleHelper
Revision Log    : 2015-09-14: Babalu patidar : created.
                : 
                : 
Use             : This class is used to test VehicleHelper.
                :
****************************************************************************************/

import org.junit.Test;

public class VehicleHelperTest {

	
	//Test For bike
	@Test
	public void testVehicleHelperForBike() {

		Vehicle vehicle = VehicleHelper.createVehicle("bike", "Shine", "Honda ");
		assert (vehicle instanceof Bike);

	}

	//Test for Car
	@Test
	public void testVehicleHelperForCar() {

		Vehicle vehicle = VehicleHelper.createVehicle("car", "Bolt XE", "Tata ");
		assert (vehicle instanceof Car);

	}

}
//End of viechleHelperTest  class
