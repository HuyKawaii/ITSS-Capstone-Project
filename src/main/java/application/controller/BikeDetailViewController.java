package application.controller;
import static application.entity.Bike.BikeType.StandardBike;
import static application.util.Setting.*;

import application.entity.*;
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


public class BikeDetailViewController {
    Bike bike = new Bike(1);
    @FXML
    private TableView<Bike> tblBikeDetail;
    @FXML
    private TableColumn<Bike, Float> priceColumn; // Reference to the TableColumn defined in the FXML
    @FXML
    private TableColumn<Bike, Float> depositColumn; // Reference to the TableColumn defined in the FXML

    void displayBikeDetail(Bike bike) {
    	this.bike = bike;
//        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//        depositColumn.setCellValueFactory(new PropertyValueFactory<>("deposit"));
//        tblBikeDetail.getItems().add(bike);
    }
    @FXML
    void initialize() {
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        depositColumn.setCellValueFactory(new PropertyValueFactory<>("deposit"));
        tblBikeDetail.getItems().add(bike);
    }
    
    @FXML
    void rentBike(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(CARD_INFORMATION_VIEW_FXML));
        Parent root = loader.load();

        CreditCardController creditCardController = loader.getController();
        creditCardController.setBike(bike);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Credit Card information");
        stage.show();
    }


}