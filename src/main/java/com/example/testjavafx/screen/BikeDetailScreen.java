package com.example.testjavafx.screen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BikeDetailScreen extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(BikeDetailScreen.class.getResource("/com/example/testjavafx/bikeDetail.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        primaryStage.setTitle("EcoBike");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

