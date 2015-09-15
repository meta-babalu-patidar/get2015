/****************************************************************************************
Name            : Car
Revision Log    : 2015-09-14: Babalu patidar : created.
                : 
                : 
Use             : This class is used to define a car properties.
                :
****************************************************************************************/

//@param AC: car contains Air conditioner or not
//@param powerSteering : car contains power steering or not 
//@param accessoryKit : car has accessories kit or not
public class Car extends Vehicle {
	

	private boolean AC;						
	private boolean powerSteering;			
	private boolean accessoryKit;			

	public boolean isAC() {
		return AC;
	}

	public void setAC(boolean aC) {
		AC = aC;
	}

	public boolean isPowerSteering() {
		return powerSteering;
	}

	public void setPowerSteering(boolean powerSteering) {
		this.powerSteering = powerSteering;
	}

	public boolean isAccessoryKit() {
		return accessoryKit;
	}

	public void setAccessoryKit(boolean accessoryKit) {
		this.accessoryKit = accessoryKit;
	}
	

	// over ride calcuale road price method
	@Override
	public double calculateOnRoadPrice() {
		double onRoadPrice = 0.0;
		// if car has AC than increase road price with 5000
		if (this.isAC()) {
			onRoadPrice = onRoadPrice + 5000; 

		}
		// if car has Accessory kit than increase road price with 10000
		if (isAccessoryKit()) {
			onRoadPrice = onRoadPrice + 10000; 

		}
		// if car has power steering than increase road price with 3000 
		if (isPowerSteering()) {
			onRoadPrice = onRoadPrice + 3000;		

		}
		return super.calculateOnRoadPrice() + onRoadPrice;
	}

	// override toString method
	@Override
	public String toString() {
		return super.toString() + " AC=" + AC + ", powerSteering="
				+ powerSteering + ", accessoryKit=" + accessoryKit;
	}

}
//End of class
