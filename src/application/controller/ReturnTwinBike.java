package application.controller;
import application.entity.*;

public class ReturnTwinBike implements IReturnBike{
	public void returnBike(Bike bike, Dock dock, float deposite, Card card) {
		ICalculator calculator = new TwinBikeCalculator();
		float rentTime = bike.getRentingTime();
		float rentAmount = 0;
		if(rentTime >= 10) {
			rentAmount = calculator.rentFees(rentTime);	
		}else {
			rentAmount = 0; 
		}
		float returnMoney = deposite - rentAmount;
		// calll deduce money api
		// 
		System.out.println("rent fee : " + rentAmount + "$");
		//		System.out.println("deduct money of standard bike: " + returnMoney + " $");
		// add bike to dock
	}
}
