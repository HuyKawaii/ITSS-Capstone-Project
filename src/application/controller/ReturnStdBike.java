package application.controller;
import application.entity.*;

public class ReturnStdBike implements IReturnBike{
	public float returnBike(Bike bike, Dock dock, float deposite, CreditCard crCard) {
		ICalculator calculator = new StdBikeCalculator();
		float rentTime = bike.getRentingTime();
		float rentAmount = 0;
		if(rentTime >= 10) {
			rentAmount = calculator.rentFees(rentTime);	
		}else {
			rentAmount = 0; 
		}
		float returnMoney = deposite - rentAmount;
		System.out.println("\nrent fee : " + rentAmount + "$");
		System.out.println("\nreturn money: " + returnMoney + " $");
		// add bike to dock
		dock.addBikeToDock(bike);
		return returnMoney;
	}
}