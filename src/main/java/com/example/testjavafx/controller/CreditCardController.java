package com.example.testjavafx.controller;

import com.example.testjavafx.entities.PaymentTransaction;
import com.example.testjavafx.screen.PaymentTransactionScreen;
import com.example.testjavafx.entities.Bike;
import com.example.testjavafx.entities.CreditCard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreditCardController {

    protected Bike bike;
    @FXML
    private TextField cardHolderNameField;
    @FXML
    private TextField cardNumberField;
    @FXML
    private TextField issuingBankField;
    @FXML
    private TextField expirationDateField;
    @FXML
    private TextField securityCodeField;

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    @FXML
    void submit(ActionEvent event) throws IOException {
        String cardHolderName = cardHolderNameField.getText();
        String cardNumber = cardNumberField.getText();
        String issuingBank = issuingBankField.getText();
        String expirationDate = expirationDateField.getText();
        String securityCode = securityCodeField.getText();
        // Create a new CreditCard instance with the retrieved values
        CreditCard card = new CreditCard(cardHolderName, cardNumber, securityCode, expirationDate, issuingBank);
        if (!card.isExpired() && card.isValidCardNumber()) {
            if (checkSufficientBalance(card, bike.deposit)) {
                if (card.isStatus()) {
                    PaymentTransaction paymentTransaction = new PaymentTransaction("Rent", bike.getDeposit(), card);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/testjavafx/paymentTransaction.fxml"));
                    Parent root = loader.load();

                    PaymentTransactionController paymentTransactionController = loader.getController();
                    paymentTransactionController.setPaymentTransaction(paymentTransaction);

                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Payment Transaction");
                    stage.show();


                } else {
                    // Create and show an alert informing the user they need to return the bike first
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Alert");
                    alert.setHeaderText(null);
                    alert.setContentText("You cannot rent another bike until you return the current one.");
                    alert.showAndWait();
                }
            } else {
                // Create and show an alert informing the user that their balance is not sufficient
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Alert");
                alert.setHeaderText(null);
                alert.setContentText("Your balance is not sufficient for this transaction.");
                alert.showAndWait();
            }
        } else {
            // Create and show an alert for invalid card format
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText("Invalid card format.");
            alert.showAndWait();
        }
    }

    public boolean checkSufficientBalance(CreditCard card, double deposit) {
        double balance = card.getBalance();
        return balance >= deposit;
    }
}
