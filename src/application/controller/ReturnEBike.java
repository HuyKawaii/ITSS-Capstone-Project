package application.controller;
import application.entity.*;

public class ReturnEBike implements IReturnBike{
	public float returnBike(Bike bike, Dock dock, float deposite, CreditCard crCard) {
		ICalculator calculator = new EBikeCalculator();
		float rentTime = bike.getRentingTime();
		float rentAmount = 0;
		if(rentTime >= 10) {
			rentAmount = calculator.rentFees(rentTime);	
		}else {
			rentAmount = 0; 
		}
		float returnMoney = deposite - rentAmount;
		// calll deduce money api
		
//		PaymentTransactionController p = new PaymentTransactionController();
//		p.confirm(null);
		
		System.out.println("rent fee : " + rentAmount + "$");
		//		System.out.println("deduct money of standard bike: " + returnMoney + " $");
		// add bike to dock
		dock.addBikeToDock(bike);
		return returnMoney;
	}
}
