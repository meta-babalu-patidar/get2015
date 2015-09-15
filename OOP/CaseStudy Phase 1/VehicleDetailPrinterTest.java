/****************************************************************************************
Name            : VehicleDetailPrinterTest
Revision Log    : 2015-09-14: Babalu patidar : created.
                : 
                : 
Use             : This class is used to test VehicleDetailPrinter.
                :
****************************************************************************************/

import static org.junit.Assert.*;


import org.junit.Test;

public class VehicleDetailPrinterTest {

	//test for bike
	@Test
	public void testVehicalDetailPrinterForBike() {

		Vehicle vehicle = VehicleHelper.createVehicle("bike", "apacheRTR",
				"TVS");
		String expected = "make=TVS, model=apacheRTR, enginInCC=500, fuelCapacity=50, milage=17, "
				+ "price=800000.0, roadTax=10000.0 selfStart=true, helmetPrize=100.0";

		assertEquals(expected, vehicle.toString());

	}

	//Test for car
	@Test
	public void testVehicalDetailPrinterFoCar() {

		Vehicle vehicle = VehicleHelper.createVehicle("car", "ecosports",
				"ford");
		String expected = "make=ford, model=ecosports, enginInCC=500, fuelCapacity=50, milage=17, price=800000.0, "
				+ "roadTax=10000.0 AC=true, powerSteering=true, accessoryKit=true";

		assertEquals(expected, vehicle.toString());

	}

}
