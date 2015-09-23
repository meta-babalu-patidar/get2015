/****************************************************************************************
Name            : VehicleDetailPrinter
Revision Log    : 2015-09-21: Babalu patidar : created.
                : 
                : 
Use             : This class is used to dispaly details of Vehicle.
                :
****************************************************************************************/

package printer;

import model.Vehicle;

public class VehicleDetailPrinter {

	public static String printVehicleSpecification(Vehicle vehicle){
		return vehicle.toString();
	}
	
}
//End of class
