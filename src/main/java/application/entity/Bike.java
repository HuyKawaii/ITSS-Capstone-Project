package application.entity;

import java.util.Random;

public class Bike {
<<<<<<< Updated upstream
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
	private boolean status;
=======
	protected int bikeId;
	protected String bikeType;
	protected String plate;
	protected float price;
	protected float rentingTime;
	protected Dock dock;
	protected String bikeCode;
	protected String brand;
	protected LocalDateTime rentedTime;
	protected boolean status;
>>>>>>> Stashed changes
	
	
<<<<<<< Updated upstream
	public Bike(int bikeType) {
		this.bikeType = BikeType.values()[bikeType];
		this.batteryPercentage = 100;
		this.rentingTime = 0;
		this.timeRemain = 120;
		this.status=true;
		setPrice();
	}
	private void setPrice() {
		switch (bikeType) {
			case StandardBike:
				this.price = 400000.0f;
				break;
			case E_bike:
				this.price = 700000.0f;
				break;
			case Twin_bike:
				this.price = 550000.0f;
				break;
			default:
				throw new IllegalArgumentException("Invalid bike type");
		}
=======
	public Bike(String bikeType) {
		this.bikeType = bikeType;
		this.rentingTime = 0;
		this.status=true;
		setPrice();
>>>>>>> Stashed changes
	}
	
	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}
	
    public String getBikeType() {
        return "StandardBike";
    }

	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}
	
    public String getPlate() {
        return plate;
    }

	public void setPlate(String plate) {
		this.plate = plate;
	}
	
    protected void setPrice() {
        this.price = 400000.0f;
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
	
	public void removeFromDock() {
	    this.dock = null;
	}

	public float getRentingTime() {
		return rentingTime;
	}

	public void setRentingTime(float rentingTime) {
		this.rentingTime = rentingTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
		return bikeType.toString();
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

<<<<<<< Updated upstream
	public float getTimeRemain() {
		return timeRemain;
	}

	public void setTimeRemain(int timeRemain) {
		this.timeRemain = timeRemain;
	}
=======
	public LocalDateTime getRentedTime() {
	    return rentedTime;
	}

	public void setRentedTime(LocalDateTime rentedTime) {
	    this.rentedTime = rentedTime;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public double getRetingFee() {
		double fee = 10000;
		if (rentingTime > 30)
			fee = Math.ceil((rentingTime - 30)/15) * 3000;
		
		return fee;
	}
	
    public String getAdditionalInfo() {
        return ""; // By default, no additional info for a generic Bike.
    }
>>>>>>> Stashed changes
}
