package application.controller;
import static application.util.Setting.*;

import application.entity.Bike;
import application.entity.Bike.BikeType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
    
    @FXML
    ImageView bikeImage;

    private Bike bike;
    private BikeController bikeController = new BikeController();
    private boolean hasCodeBeenReceived = false; 
    
    private Scene previousScene;
    
    public void setPreviousScene(Scene scene) {
        this.previousScene = scene;
    }

    public void displayBikeInfo(Bike bike) {
        this.bike = bike;
        System.out.println("Bike Details: " + bike.getBrand()+ ", " + bike.getPrice());
        String bikeInfo = "Brand: " + bike.getBrand() + "\n" +
                          "Type: " + bike.getBikeType() + "\n" +
                          "Battery Percentage: " + bike.getBatteryPercentage() + "%\n" +
                          "Estimated Time Remain: " + bike.getTimeRemain() + " minutes";
        
        bikeInfoTextArea.setText(bikeInfo);
        setImageBasedOnBikeType(bike.getBikeType());
    }
    
    private void setImageBasedOnBikeType(BikeType bikeType) {
    	String imagePath = "pictures/" + bikeType + ".png";
        System.out.println("Loading image from: " + imagePath);
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        bikeImage.setImage(image);
    }
    
    @FXML 
    private void receiveCode(ActionEvent event) {
        if (!hasCodeBeenReceived) {
            bikeCodeLabel.setText(bike.getBikeCode());
            hasCodeBeenReceived = true;
        } else {
            bikeController.generateBikeCode(bike);// Generate new code on second press
            bikeController.updateBike(bike);
            bikeCodeLabel.setText(bike.getBikeCode());
        }
    }
    
    @FXML
    private void sendCode(ActionEvent event) {
        String enteredCode = codeSearch.getText();

        if (enteredCode.equals(bike.getBikeCode())) {
            switchToRentSuccessScene(event);
        } else {
            messageLabel.setText("Wrong code. Please try again!");
        }
    }

    private void switchToRentSuccessScene(ActionEvent e) {
        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource(BIKE_DETAIL_VIEW_FXML));
            Scene bikeDetailScene = new Scene(loader.load());
            BikeDetailViewController bikeDetailViewController = loader.getController();
            bikeDetailViewController.displayBikeDetail(bike);
          
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(bikeDetailScene);
        } catch (Exception ex) {
            ex.printStackTrace();
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
