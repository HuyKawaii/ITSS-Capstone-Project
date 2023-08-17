package application.controller;
//import static application.entity.Bike.BikeType.StandardBike;
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
import application.util.OpenNewScene;

import java.io.IOException;


public class BikeDetailViewController {
	Bike bike = null;
    @FXML
    private TableView<Bike> tblBikeDetail;
    @FXML
    private TableColumn<Bike, Float> priceColumn; // Reference to the TableColumn defined in the FXML
    @FXML
    private TableColumn<Bike, Float> depositColumn; // Reference to the TableColumn defined in the FXML

    void displayBikeDetail(Bike bike) {
    	this.bike = bike;
    	tblBikeDetail.getItems().clear();  // Clear existing bike details.
        tblBikeDetail.getItems().add(bike); // Add the new bike's details.
//        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//        depositColumn.setCellValueFactory(new PropertyValueFactory<>("deposit"));
//        tblBikeDetail.getItems().add(bike);
    }
    @FXML
    void initialize() {
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        depositColumn.setCellValueFactory(new PropertyValueFactory<>("deposit"));
//        tblBikeDetail.getItems().add(bike);
    }
    
    @FXML
    void rentBike(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(CARD_INFORMATION_VIEW_FXML));
    	FXMLLoader loader = OpenNewScene.inOldWindow(CARD_INFORMATION_VIEW_FXML, event, this);	
    	
        System.out.println("bike get rentedL: " + bike.getBikeId() + " type: " + bike.getBrand() + " rented time: " + bike.getRentedTime());	
//        Parent root = loader.load();
//        Parent root = loader.load();

        CreditCardController creditCardController = loader.getController();
        creditCardController.setBike(bike);

//        Stage stage = new Stage();
//        stage.setScene(new Scene(root));
//        stage.setTitle("Credit Card information");
//        stage.show();
    }


}