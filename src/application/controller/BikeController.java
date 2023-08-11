package application.controller;
import application.entity.*;

public class BikeController {
	// resolve control coupling
	// only passing enough parameters, not the whole object
//	public void returnStandardBike(float rentTime, float depositeMoney,Card userCard) {
//		float rentFees = 0;
//		if(rentTime >= 10) {
//			rentFees = standardBikeRentFee(rentTime);	
//		}else {
//			rentFees = 0; 
//		}
//		float returnMoney = depositeMoney - rentFees;
//		// calll deduce money api
//		// 
//		System.out.println("rent fee : " + rentFees + "$");
////		System.out.println("deduct money of standard bike: " + returnMoney + " $");
//	}
//	
//	public void returnE_Bike(float rentTime, float depositeMoney, Card userCard) {
//		float rentFees = 0;
//		if(rentTime >= 10) {
//			rentFees = E_BikeRentFee(rentTime);	
//		}else {
//			rentFees = 0; 
//		}
//		float returnMoney = depositeMoney - rentFees;
//		// calll deduce money api
//		// 
//		System.out.println("deduct money of e bike: " + returnMoney + " $");
//	}
//	
//	public void returnTwinBike(float rentTime, float depositeMoney, Card userCard) {
//		float rentFees = 0;
//		if(rentTime >= 10) {
//			rentFees = TwinBikeRentFee(rentTime);	
//		}else {
//			rentFees = 0; 
//		}
//		float returnMoney = depositeMoney - rentFees;
//		// calll deduce money api
//		// 
//		System.out.println("deduct money of twin bike: " + returnMoney + " $");
//	}
//	
//	private float standardBikeRentFee(float rentTime) {
//		if(rentTime <= 30) {
//			return (float)10000;
//		}else {
//			float fees = 10000;
//			float temp = rentTime - 30;
//			
//			int factor = (int) (temp / 15);
//			float remainder = (temp % 15);
//			
//			if(remainder == 0) {
//				fees += factor * 3000;
//			}else {
//				fees += (factor + 1) * 3000;
//			}
//			return fees;
//		}	
//	}
//	
//	private float E_BikeRentFee(float rentTime) {
//		return (float) (standardBikeRentFee(rentTime) * 1.5);
//	}
//	
//	private float TwinBikeRentFee(float rentTime) {
//		return (float)(standardBikeRentFee(rentTime) * 1.5);
//	}
}

