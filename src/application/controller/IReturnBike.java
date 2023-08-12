package application.controller;
import application.entity.*;

public interface IReturnBike {
	public void returnBike(Bike bike, Dock dock, float deposite, CreditCard crCard);
}
