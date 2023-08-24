package application.controller;

import application.entity.*;
import application.subsystem.Interbank;
import application.subsystem.Response;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import application.util.OpenNewScene;
import javafx.scene.Node;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static application.util.Setting.*;

//import subsystem.interbank.TransactionProcess;


public class PaymentTransactionController {
    protected PaymentTransaction paymentTransaction;


    private Bike bike;	
    double rentedFees;	
    String type;
    public void setPaymentTransaction(PaymentTransaction paymentTransaction, Bike bike, double rentedFees) {	
        this.paymentTransaction = paymentTransaction;	
        tblTransaction.getItems().add(this.paymentTransaction);	
        this.bike = bike;	
        this.rentedFees = rentedFees;	
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

        // Define a custom cell value factory for the deposit column
        depositColumn.setCellValueFactory(cellData -> {
            PaymentTransaction paymentTransaction = cellData.getValue();
            double deposit = paymentTransaction.getBike().getDeposit();
            return new ReadOnlyObjectWrapper<>(deposit);
        });

    }

    private List<PaymentTransaction> paymentTransactionHistory = new ArrayList<>();

    ////
    @FXML
    void confirm(ActionEvent event) throws IOException {
        Interbank interbank = new Interbank();
        Response response;
        // Get necessary data
        String cardCode = this.paymentTransaction.getCard().getCardNumber(); // Get the card code
        String owner = this.paymentTransaction.getCard().getCardHolderName(); // Get the owner
        //        String cvvCode = ...; // Get the CVV code
        String dateExpired = this.paymentTransaction.getCard().getExpirationDate(); // Get the expiration date
        String transactionContent = this.paymentTransaction.getContent(); // Get the transaction content
        ////
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define a formatter for the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format the current date and time using the formatter
        String createdAt = currentDateTime.format(formatter);
        if (this.paymentTransaction.getBike().isStatus()) {
//      Call API deduct Deposit
            String command = "pay"; // Get the command

            double amount = this.paymentTransaction.getBike().getDeposit(); // Get the amount
            // Call the performTransaction method
            response = interbank.performTransaction(this.paymentTransaction, cardCode, owner, dateExpired, command, transactionContent, amount, createdAt);
            int errorCode = response.getErrorCode();
            if (errorCode == 0) {
	            BikeController bControl = new BikeController();	
            bControl.rentBike(bike);
//            	bikeController.rentBike(this.paymentTransaction.getBike());
                paymentTransactionHistory.add(this.paymentTransaction);
                response.getTransaction().getBike().setStatus(false);
                System.out.println(paymentTransactionHistory.get(0).getBike().getDeposit());
            }
        }
        else{
            String command = "refund";
//            double amount = this.paymentTransaction.getBike().getRetingFee();
            double amount = this.rentedFees;
            response = interbank.performTransaction(this.paymentTransaction, cardCode, owner, dateExpired, command, transactionContent, amount, createdAt);
            int errorCode = response.getErrorCode();
            if (errorCode == 0) {
                paymentTransactionHistory.add(this.paymentTransaction);
                response.getTransaction().getBike().setStatus(true);
                System.out.println(paymentTransactionHistory.get(0).getBike().getRetingFee());
            }
        }
        // move to Response Screen	
        FXMLLoader loader = OpenNewScene.inOldWindow(RESPONSE_VIEW_FXML, event, this);	
        ResponseController responseController = loader.getController();	
        responseController.setResponse(response, bike);	
    }
    public void returnToPreviousScene(ActionEvent event) throws IOException {	
        FXMLLoader loader = new FXMLLoader(getClass().getResource(CARD_INFORMATION_VIEW_FXML));	
        Parent root = loader.load();	
        CreditCardController creditCardController = loader.getController();	
        creditCardController.setBike(this.bike);	
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();	
        currentStage.close(); // Close the current stage	
        Stage stage = new Stage();	
        stage.setScene(new Scene(root));	
        stage.setTitle("Credit Card Information");	
        stage.show();	
    }	
}	
