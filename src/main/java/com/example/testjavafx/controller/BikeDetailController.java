package com.example.testjavafx.controller;
import com.example.testjavafx.entities.Bike;
import com.example.testjavafx.entities.PaymentTransaction;
import com.example.testjavafx.screen.CreditCardScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;


public class BikeDetailController {
    Bike bike = new Bike(400.000);
    @FXML
    private TableView<Bike> tblBikeDetail;
    @FXML
    private TableColumn<Bike, Double> priceColumn; // Reference to the TableColumn defined in the FXML
    @FXML
    private TableColumn<Bike, Double> depositColumn; // Reference to the TableColumn defined in the FXML

    @FXML
    void initialize() {
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        depositColumn.setCellValueFactory(new PropertyValueFactory<>("deposit"));
        tblBikeDetail.getItems().add(bike);
    }
    @FXML
    void rentBike(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/testjavafx/cardInfomation.fxml"));
        Parent root = loader.load();

        CreditCardController creditCardController = loader.getController();
        creditCardController.setBike(bike);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Credit Card information");
        stage.show();
    }


}
