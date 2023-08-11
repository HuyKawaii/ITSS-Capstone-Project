package application.entity;

import java.time.LocalDateTime;

public class Bike {
	public enum BikeType{
		StandardBike,
		E_bike,
		Twin_bike
	}
	private int bikeId;
	private BikeType bikeType;
	private float price;
	private float rentingTime;
	private float batteryPercentage;
	private float timeRemain;
	private Dock dock;
	private String bikeCode;
	private String brand;
	private LocalDateTime rentedTime;
	
	private static final float MAX_TIME = 120;
	
	public Bike(int bikeType) {
		this.bikeType = BikeType.values()[bikeType-1];
		this.batteryPercentage = 100;
		this.rentingTime = 0;
		this.timeRemain = MAX_TIME;
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

	public String getBikeStatus() {
		return bikeType.toString() + "\n" + (bikeType == BikeType.E_bike ? batteryPercentage + "%\n" : "");
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
	
	public LocalDateTime getRentedTime() {
	    return rentedTime;
	}

	public void setRentedTime(LocalDateTime rentedTime) {
	    this.rentedTime = rentedTime;
	}

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}

	public float getDeposit() {
		return price * (float)0.4;
	}
}
