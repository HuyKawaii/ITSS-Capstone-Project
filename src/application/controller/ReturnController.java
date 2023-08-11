package application.controller;
import application.entity.*;

public class ReturnController {
	private IReturnBike returner;
	
	public ReturnController(IReturnBike returner) {
		this.returner = returner;
	}
	
	public void proceedReturnBike(Bike bike, float deposite, Card card) {
		returner.returnBike(bike, deposite, card);
	}
}
