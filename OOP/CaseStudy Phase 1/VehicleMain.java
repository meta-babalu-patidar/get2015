/****************************************************************************************
Name            : VehicleMain
Revision Log    : 2015-09-14: Babalu patidar : created.
                : 
                : 
Use             : This class is used to create New vehicle.
                :
****************************************************************************************/


public class VehicleMain {

	//@Param Vehilce : SPecify an object of vehicle class 
	public static void main(String[] args) {
		
		// call create vehicle for bike
		Vehicle vehicle = VehicleHelper.createVehicle("bike", "Shine", "Honda "); 
		System.out.println("\n Details of Bike is : ");
		System.out.print(VehicleDetailPrinter.printVehicleSpecification(vehicle));
		
		// call create vehicle for car
		vehicle = VehicleHelper.createVehicle("car", "Bolt XE", "Tata ");		
		System.out.println("\n Details of Car is : ");
		System.out.print(VehicleDetailPrinter.printVehicleSpecification(vehicle));
	}

}
//End of class
