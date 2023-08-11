package application.controller;
import static application.util.Setting.*;

import application.entity.Bike;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BikeInfoViewController {
    
    @FXML
    TextArea bikeInfoTextArea;

    @FXML
    Label bikeCodeLabel;
    
    @FXML
    Label messageLabel;
    
    @FXML
    TextField codeSearch;

    private Bike bike;
    
    private Scene previousScene;
    
    public void setPreviousScene(Scene scene) {
        this.previousScene = scene;
    }

    public void displayBikeInfo(Bike bike) {
        this.bike = bike;

        String bikeInfo = "Brand: " + bike.getBrand() + "\n" +
                          "Type: " + bike.getBikeType() + "\n" +
                          "Battery Percentage: " + bike.getBatteryPercentage() + "%\n" +
                          "Estimated Time Remain: " + bike.getTimeRemain() + " minutes";
        
        bikeInfoTextArea.setText(bikeInfo);
    }
    
    @FXML 
    private void receiveCode(ActionEvent event) {
    	bike.generateBikeCode();
        bikeCodeLabel.setText(bike.getBikeCode());
    }
    
    @FXML
    private void sendCode(ActionEvent event) {
        String enteredCode = codeSearch.getText();

        if (enteredCode.equals(bike.getBikeCode())) {
            switchToRentSuccessScene();
        } else {
            messageLabel.setText("Wrong code. Please try again!");
        }
    }

    private void switchToRentSuccessScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(BIKE_DETAIL_VIEW_FXML));
            Scene scene = new Scene(root);
            Stage stage = (Stage) bikeInfoTextArea.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML 
    private void returnToPreviousScene(ActionEvent event) {
        if(previousScene != null) {
            Stage stage = (Stage) bikeInfoTextArea.getScene().getWindow();
            stage.setScene(previousScene);
            stage.show();
        }
    }

}
