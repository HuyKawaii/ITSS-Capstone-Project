package application.controller;
<<<<<<< Updated upstream
import static application.entity.Bike.BikeType.StandardBike;
=======
//import static application.entity.Bike.BikeType.StandardBike;
>>>>>>> Stashed changes
import static application.util.Setting.*;

import application.entity.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;


public class BikeDetailViewController {
<<<<<<< Updated upstream
    Bike bike = new Bike(1);
=======
	Bike bike = null;
>>>>>>> Stashed changes
    @FXML
    private TableView<Bike> tblBikeDetail;
    @FXML
    private TableColumn<Bike, Float> priceColumn; // Reference to the TableColumn defined in the FXML
    @FXML
    private TableColumn<Bike, Float> depositColumn; // Reference to the TableColumn defined in the FXML

    void displayBikeDetail(Bike bike) {
    	this.bike = bike;
<<<<<<< Updated upstream
=======
    	tblBikeDetail.getItems().clear();  // Clear existing bike details.
        tblBikeDetail.getItems().add(bike); // Add the new bike's details.
>>>>>>> Stashed changes
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource(CARD_INFORMATION_VIEW_FXML));
        Parent root = loader.load();

        CreditCardController creditCardController = loader.getController();
        creditCardController.setBike(bike);

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close(); // Close the current stage

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Credit Card information");
        stage.show();
    }


}