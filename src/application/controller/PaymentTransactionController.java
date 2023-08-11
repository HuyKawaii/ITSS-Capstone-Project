package application.controller;

import application.entity.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

//import subsystem.interbank.TransactionProcess;


public class PaymentTransactionController {
    protected PaymentTransaction paymentTransaction;
    public void setPaymentTransaction(PaymentTransaction paymentTransaction) {
        this.paymentTransaction = paymentTransaction;
        tblTransaction.getItems().add(this.paymentTransaction);

    }
    @FXML
    private TableView<PaymentTransaction> tblTransaction;
    @FXML
    private TableColumn<PaymentTransaction, String> contentColumn;
    @FXML
    private TableColumn<PaymentTransaction, Double> depositColumn;

    @FXML
    void initialize() {
        contentColumn.setCellValueFactory(new PropertyValueFactory<>("content"));

        depositColumn.setCellValueFactory(new PropertyValueFactory<>("deposit"));

    }
    private List<PaymentTransaction> paymentTransactionHistory = new ArrayList<>();

    @FXML
    void confirm(ActionEvent event) {
//         Call API deduct Deposit
//        ...

        paymentTransactionHistory.add(paymentTransaction);
        System.out.println(paymentTransactionHistory.get(0).getDeposit());
    }



}
