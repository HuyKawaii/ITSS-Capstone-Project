package application.controller;
import application.entity.*;

public class ReturnTwinBike implements IReturnBike{
	public float returnBike(Bike bike, Dock dock, float deposite, CreditCard crCard) {
		ICalculator calculator = new TwinBikeCalculator();
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
		dock.addBikeToDock(bike);
		return returnMoney;
	}
}
