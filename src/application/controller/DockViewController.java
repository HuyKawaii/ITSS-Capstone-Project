package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DockViewController implements Initializable {
	@FXML
	private TextField tf1;
	
	@FXML
	private Button bt1;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {};
	
	public void click() {
		tf1.setText("You just click the button");
		
	}
}
