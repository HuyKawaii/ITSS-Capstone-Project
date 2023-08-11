package application.controller;
import application.entity.*;

public class ReturnStdBike implements IReturnBike{
	public void returnBike(Bike bike, float deposite, Card card) {
		ICalculator calculator = new StdBikeCalculator();
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
		System.out.println("deduct money of standard bike: " + returnMoney + " $");
	}
}
