package application.controller;

import application.dao.DockDAO;
import application.entity.Bike;
import application.entity.Bike.BikeType;
import application.entity.Dock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import application.util.*;
import static application.util.Setting.CARD_INFORMATION_VIEW_FXML;
import static application.util.Setting.RETURN_VIEW_FXML;;

public class BikeDetailWhileRentingController {
    private Bike bike;
    public void setBike(Bike bike){
        this.bike=bike;
    }
    
    @FXML
    void returnBike(ActionEvent event) throws IOException {
    	
        FXMLLoader loader = OpenNewScene.inOldWindow(RETURN_VIEW_FXML, event, this);
        BikeType t1 = BikeType.E_bike;
        BikeType t2 = BikeType.StandardBike;
        BikeType t3 = BikeType.Twin_bike;
        
        IReturnBike returnBikeType;
        if(bike.getBikeType().compareTo(t3) == 0) {
        	returnBikeType = new ReturnTwinBike();
        }else if(bike.getBikeType().compareTo(t2) == 0) {
        	returnBikeType = new ReturnStdBike();
        }else if(bike.getBikeType().compareTo(t1) == 0){
        	returnBikeType = new ReturnEBike();
        }else {
        	returnBikeType = new ReturnStdBike();
        }
        
        System.out.print("running in return view\n");
        System.out.println("bike info: " + bike.getBikeId() + " type: " + bike.getBrand() + " rented time: " + bike.getRentedTime());
        ReturnController returner = new ReturnController(returnBikeType, bike);
        ReturnViewController returnViewController;
        
//		DockController dockController = new DockController();
//		DockViewController dockViewController;
		
		try {
	        DockDAO dockDAO = new DockDAO();
	        List<Dock> dockList = dockDAO.getAllDocks();
	        for (Dock dock : dockList) {
	            returner.addDockToList(dock);
	        }
		} catch (Exception e) { 
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		returnViewController = loader.getController();
		returnViewController.setReturnController(returner);
		returnViewController.displayDocks();
        
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root));
//        stage.setTitle("Choose Dock to return");
//        stage.show();
    }

}
