package application.entity;

import java.util.ArrayList;
import java.util.List;
public class PaymentTransaction {
    private String content;
    private double deposit;
    private CreditCard cCard;

    public PaymentTransaction(String content, double deposit, CreditCard cCard) {
        this.content = content;
        this.deposit = deposit;
        this.cCard = cCard;
    }
    public String getContent() {
        return this.content;
    }

    public double getDeposit() {
        return this.deposit;
    }
}
