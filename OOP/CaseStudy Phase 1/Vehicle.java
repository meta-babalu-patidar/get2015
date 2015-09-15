/****************************************************************************************
Name            : Vehicle
Revision Log    : 2015-09-14: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement Vechile properties.
                :
****************************************************************************************/

//@param make : Specify company name
//@param model : Specify name of product
//@param enginInCC : Specify capicity of engine
//@param fuelCapacity : Specify capicity of fuel tank
//@param milage : Specify milage of vehicle
//@param price : Specify price of vehicle
//@param roadTax : Specify road Tax on vehicle
public class Vehicle {

	private String make;				
	private String model;				
	private int enginInCC;					
	private int fuelCapacity;			
	private int milage;					
	private double price;				
	private double roadTax;				

	//Getter setter methods for data members of class
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getEnginInCC() {
		return enginInCC;
	}

	public void setEnginInCC(int enginInCC) {
		this.enginInCC = enginInCC;
	}

	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public int getMilage() {
		return milage;
	}

	public void setMilage(int milage) {
		this.milage = milage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRoadTax() {
		return roadTax;
	}

	public void setRoadTax(double roadTax) {
		this.roadTax = roadTax;
	}

	public double calculateOnRoadPrice() {
		return price + roadTax;
	}
	
	//End of getter Setter 

	// over ride toString method to display the details of vehicle
	@Override
	public String toString() {
		return "make=" + make + ", model=" + model + ", enginInCC=" + enginInCC
				+ ", fuelCapacity=" + fuelCapacity + ", milage=" + milage
				+ ", price=" + price + ", roadTax=" + roadTax;
	}
	//End of toString method
	
}

//End of class Vehicle
