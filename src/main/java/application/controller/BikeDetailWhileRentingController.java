package application.controller;

import application.entity.Bike;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
<<<<<<< Updated upstream
=======
import javafx.scene.Node;
>>>>>>> Stashed changes
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static application.util.Setting.CARD_INFORMATION_VIEW_FXML;

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

<<<<<<< Updated upstream
=======
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close(); // Close the current stage

>>>>>>> Stashed changes
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Credit Card information");
        stage.show();
    }

}
