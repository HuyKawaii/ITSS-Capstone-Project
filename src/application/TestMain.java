package application;
import application.controller.*;
import application.entity.*;


public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BikeController b = new BikeController();
//		b.returnStandardBike(91, 1000000, null);
		Bike b = new Bike();
		b.setRentingTime(70);
		
		ReturnController r = new ReturnController(new ReturnStdBike());
		r.proceedReturnBike(b, new Dock(),100000, null);
	}	

}
