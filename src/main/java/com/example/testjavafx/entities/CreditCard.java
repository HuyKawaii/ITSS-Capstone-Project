package com.example.testjavafx.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditCard {
    private String cardHolderName;
    private String cardNumber;
    private String securityCode;
    private java.util.Date expirationDate;
    private String issuingBank;
    private double balance;
    private boolean status;

    public CreditCard(String cardHolderName, String cardNumber, String securityCode, String expirationDate, String issuingBank) throws IllegalArgumentException {

        //khởi tạo thuộc tính cho CreditCard
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        setExpirationDate(expirationDate);
        this.issuingBank = issuingBank;
        this.balance = 1000000;
        this.status = true;
    }

    public boolean isValidCardNumber() {
        String regex = "139396_group09_2022";
        return this.cardNumber.matches(regex);
    }
    public boolean isExpired() {
        Date currentDate = new Date();
        return expirationDate.before(currentDate);
    }

    private void setExpirationDate(String expirationDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
            this.expirationDate = dateFormat.parse(expirationDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid expiration date format");
        }
    }
    // Method to deduct balance by deposit amount
    public void deductBalance(double depositAmount) {
        if (balance >= depositAmount) {
            balance -= depositAmount;
        } else {
            throw new IllegalArgumentException("Insufficient balance");
        }
    }
    // Add other validation methods as needed



    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public double getBalance() {
        return balance;
    }
}
