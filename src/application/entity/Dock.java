package application.entity;

import java.util.ArrayList;
import java.util.List;

public class Dock {
	private String name;
	private String address;
	private List<Bike> listOfBikesBike = new ArrayList<Bike>();
	private int dockSize;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Bike> getListOfBikesBike() {
		return listOfBikesBike;
	}
	public boolean isFreeSpotAvailable() {
		return (dockSize > listOfBikesBike.size());
	}
	public boolean addBikeToDock(Bike bike) {
		if (!isFreeSpotAvailable())
			return false;
		listOfBikesBike.add(bike);
		return true;
	}
	public boolean removeBikeFromDock(Bike bike) {
		return listOfBikesBike.remove(bike);
	}

}
