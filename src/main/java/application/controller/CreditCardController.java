package application.controller;

import static application.util.Setting.*;

import application.entity.PaymentTransaction;
import application.entity.Bike;
import application.entity.CreditCard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
        //if (!card.isExpired() && card.isValidCardNumber()) {
        //if (checkSufficientBalance(card, bike.getDeposit())) {
//                if (card.isStatus()) {
        PaymentTransaction paymentTransaction;
        if (this.bike.isStatus()) {
            paymentTransaction = new PaymentTransaction("Rent", bike, card);
            System.out.println(paymentTransaction.getCard().getCardNumber());
        } else {
            paymentTransaction = new PaymentTransaction("Return", bike, card);
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource(PAYMENT_TRANSACTION_VIEW_FXML));
        Parent root = loader.load();

        PaymentTransactionController paymentTransactionController = loader.getController();
        paymentTransactionController.setPaymentTransaction(paymentTransaction);

<<<<<<< Updated upstream
=======
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close(); // Close the current stage

>>>>>>> Stashed changes
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Payment Transaction");
        stage.show();


//                } else {
        // Create and show an alert informing the user they need to return the bike first
//                    Alert alert = new Alert(Alert.AlertType.WARNING);
//                    alert.setTitle("Alert");
//                    alert.setHeaderText(null);
//                    alert.setContentText("You cannot rent another bike until you return the current one.");
//                    alert.showAndWait();

//            } else {
//                // Create and show an alert informing the user that their balance is not sufficient
//                Alert alert = new Alert(Alert.AlertType.WARNING);
//                alert.setTitle("Alert");
//                alert.setHeaderText(null);
//                alert.setContentText("Your balance is not sufficient for this transaction.");
//                alert.showAndWait();
//            }
//        } else {
//            // Create and show an alert for invalid card format
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Alert");
//            alert.setHeaderText(null);
//            alert.setContentText("Invalid card format.");
//            alert.showAndWait();
//        }
    }
}



