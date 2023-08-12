package application.controller;
import application.entity.*;

public class ReturnController {
	private IReturnBike returner;
	
	public ReturnController(IReturnBike returner) {
		this.returner = returner;
	}
	
	public void proceedReturnBike(Bike bike, Dock dock, float deposite, Card card) {
		returner.returnBike(bike, dock,deposite, card);
	}
}
