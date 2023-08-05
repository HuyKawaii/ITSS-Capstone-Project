package application.controller;

import static application.util.Setting.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.entity.Bike;
import application.entity.Dock;
import application.util.OpenNewScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DockInfoViewController implements Initializable {
	@FXML
	Text tx0, tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8, dockNameText;
	@FXML
	Button returnButton;
	
	Text bikeInfoText[];
	Scene previousScene;
	
	public void initialize(URL location, ResourceBundle resources) {
		bikeInfoText = new Text[]{tx0, tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8};
	};
	
	public void display(Dock dock) {
		dockNameText.setText(dock.getDockStatus());
		List<Bike> listOfBikes = dock.getAllBikes();
		for (int i = 0; i < NUMBER_OF_BIKES_IN_DOCK; i++) {
			bikeInfoText[i].setText("");
		}
		for (int i = 0; i < listOfBikes.size(); i++) {
			bikeInfoText[i].setText(listOfBikes.get(i).getBikeStatus());
		}
	}
	
	@FXML 
	private void returnToDockList(ActionEvent event) throws IOException {
		//FXMLLoader loader = OpenNewScene.inOldWindow(DOCK_VIEW_FXML, event, this);
		//DockViewController dockViewController = loader.getController();
		//dockViewController.displayDocks();
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(previousScene);
        stage.show();
		System.out.println("Returned");
	}
	
	public void setPreviosScene(Scene scene) {
		previousScene = scene;
	}
}
