package entity;

enum BikeType{
	StandardBike,
	E_bike,
	Twin_bike
}

public class Bike {
	private BikeType bikeType;
	private float rentingTime;
	private float batteryPercentage;
	private Dock dock;
	
	public Dock getDock() {
		return dock;
	}

	public void setDock(Dock dock) {
		this.dock = dock;
	}

	public BikeType getBikeType() {
		return bikeType;
	}

	public void setBikeType(BikeType bikeType) {
		this.bikeType = bikeType;
	}

	public float getRentingTime() {
		return rentingTime;
	}

	public void setRentingTime(float rentingTime) {
		this.rentingTime = rentingTime;
	}

	public float getBatteryPercentage() {
		return batteryPercentage;
	}
	
	public void setBatteryPercentage(float batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}

	public double getRetingFee() {
		double fee = 10000;
		if (rentingTime > 30)
			fee = Math.ceil((rentingTime - 30)/15) * 3000;
		
		if (bikeType == BikeType.E_bike || bikeType == BikeType.Twin_bike)
			fee = fee * 1.5;
		
		return fee;
	}
	
	

}
