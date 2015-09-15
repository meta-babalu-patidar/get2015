/****************************************************************************************
Name            : Bike
Revision Log    : 2015-09-14: Babalu patidar : created.
                : 
                : 
Use             : This class is used to define a bike properties.
                :
****************************************************************************************/

// @param selfStart : specify bike is self start or not
// @Param helmetPric : specify helmet will be gifted with bike or not
public class Bike extends Vehicle {

	private boolean selfStart;     		

	private double helmetPrice;			

	public boolean isSelfStart() {
		return selfStart;
	}

	public void setSelfStart(boolean selfStart) {
		this.selfStart = selfStart;
	}

	public double getHelmetPrize() {
		return helmetPrice;
	}

	public void setHelmetPrize(double helmetPrice) {
		this.helmetPrice = helmetPrice;
	}

	@Override
	public double calculateOnRoadPrice() {
		double onRoadPrice = 0;
		if (isSelfStart()) {			
			onRoadPrice = onRoadPrice + 1000;
		}
		onRoadPrice = onRoadPrice + getHelmetPrize();
		return super.calculateOnRoadPrice() + onRoadPrice;
	}

	@Override
	public String toString() {
		return super.toString() + " selfStart=" + selfStart + ", helmetPrize="
				+ helmetPrice;
	}

}
//End of bike class 
