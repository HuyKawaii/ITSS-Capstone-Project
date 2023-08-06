package com.example.testjavafx.tablerowdata;

public class PaymentDetailData {
    private String content;
    private double deposit;

    public PaymentDetailData(String content, double deposit) {
        this.content = content;
        this.deposit = deposit;
    }

    public String getContent() {
        return content;
    }

    public double getDeposit() {
        return deposit;
    }
}
