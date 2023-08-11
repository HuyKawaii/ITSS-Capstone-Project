package application.entity;

import java.util.Random;

public class Bike {
	public enum BikeType{
		StandardBike,
		E_bike,
		Twin_bike
	}

	private BikeType bikeType;
	private float price;
	private float rentingTime;
	private float batteryPercentage;
	private float timeRemain;
	private Dock dock;
	private String bikeCode;
	private String brand;
	
	private static final float MAX_TIME = 120;
	
	public Bike(int bikeType) {
		this.bikeType = BikeType.values()[bikeType];
		this.batteryPercentage = 100;
		this.rentingTime = 0;
		this.timeRemain = 120;
	}
	
	public float getPrice() {
		return price;
	}
	
	public float getDeposit() {
		return price * (float)0.4;
	}
	
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
		this.timeRemain = MAX_TIME - rentingTime;
		this.batteryPercentage = (this.timeRemain / MAX_TIME) * 100;
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
	public String getBikeStatus() {
		return bikeType.toString() + "\n" + (bikeType == BikeType.E_bike ? batteryPercentage + "%\n" : "");
	}
	
	public void generateBikeCode() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		this.setBikeCode(String.format("%06d", number));
	}

	public String getBikeCode() {
		return bikeCode;
	}

	public void setBikeCode(String bikeCode) {
		this.bikeCode = bikeCode;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getTimeRemain() {
		return timeRemain;
	}

	public void setTimeRemain(int timeRemain) {
		this.timeRemain = timeRemain;
	}
}
