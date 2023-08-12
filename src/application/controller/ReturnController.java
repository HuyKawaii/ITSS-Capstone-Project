package application.controller;
import application.entity.*;

public class ReturnController {
	private IReturnBike returner;
	
	public ReturnController(IReturnBike returner) {
		this.returner = returner;
	}
	
	public void proceedReturnBike(Bike bike, Dock dock, float deposite, CreditCard crCard) {
		returner.returnBike(bike, dock,deposite, crCard);
	}
}
