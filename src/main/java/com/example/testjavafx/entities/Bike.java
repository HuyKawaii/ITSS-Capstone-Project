package com.example.testjavafx.entities;

public class Bike {

    private double price;
    public double deposit;
    private int rentingTimeInMinutes;
    private double rentalAmount;

    public Bike(double price) {
        this.price = price;
        this.deposit = calculateDeposit();
        this.rentingTimeInMinutes = 0;
        this.rentalAmount = 0.0; // Initialize rental amount to zero
    }

    // Add methods for bike actions and calculations here

    public double calculateDeposit() {
        // Calculate deposit as a percentage of the bike price
        double depositPercentage = 0.4; // 40% deposit
        return this.price * depositPercentage;
    }

    public double getPrice() {
        return price;
    }

    public double getDeposit() {
        return deposit;
    }

    public int getRentingTimeInMinutes() {
        return this.rentingTimeInMinutes;
    }
    public double getRentalAmount() {
        return this.rentalAmount;
    }

    public void setRentalAmount() {
        this.rentalAmount = calculateRentalAmount();
    }

    private double calculateRentalAmount() {
        // Calculate rental amount based on renting time
        double basePrice = 10000; // Base price for 30 minutes
        double additionalPrice = 3000; // Additional price for every 15 minutes

        int additionalPeriods = (rentingTimeInMinutes - 30) / 15;
        if (additionalPeriods < 0) {
            additionalPeriods = 0;
        }

        double calculatedRentalAmount = basePrice + additionalPeriods * additionalPrice;
        return calculatedRentalAmount;
    }

    // Add other methods as needed


}

