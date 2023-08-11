package application.controller;
import application.entity.*;

public interface IReturnBike {
	public void returnBike(Bike bike, float deposite, Card card);
}
