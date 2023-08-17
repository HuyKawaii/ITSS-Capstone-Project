package application.controller;
import application.dao.DockDAO;
import application.entity.Bike;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import application.entity.Dock;
import java.util.List;

import java.io.IOException;

import application.util.*;	
import static application.util.Setting.CARD_INFORMATION_VIEW_FXML;	
import static application.util.Setting.RETURN_VIEW_FXML;

public class BikeDetailWhileRentingController {
    private Bike bike;
    public void setBike(Bike bike){
        this.bike=bike;
    }

    @FXML
    void returnBike(ActionEvent event) throws IOException {
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
