package application;
	
import static application.util.Setting.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import application.controller.DockController;
import application.controller.DockViewController;
import application.entity.Bike;
import application.entity.Dock;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	DockController dockController = new DockController();
	DockViewController dockViewController;
	
	@Override
	public void start(Stage primaryStage) {
		try {
		      File myFile = new File(INPUTFILE);
		      //String currentPath = myFile.getAbsolutePath();
		      //System.out.println("current path is: " + currentPath);
		      Scanner myReader = new Scanner(myFile);
		      int num = myReader.nextInt();
		      myReader.nextLine();
		      for (int i = 0; i < num; i++) {
		    	  String dockName = myReader.nextLine();
		    	  String dockArea = myReader.nextLine();
		    	  int dockLimit = myReader.nextInt();
		    	  Dock newDock = new Dock();
		    	  newDock.setName(dockName);
		    	  newDock.setAddress(dockArea);
		    	  newDock.setDockSize(dockLimit);
		    	  
		    	  int numberOfBike = myReader.nextInt();
		    	  myReader.nextLine();
		    	  for (int j = 0; j < numberOfBike; j++) {
		    		  int bikeType = myReader.nextInt();
		    		  try {
		    			  myReader.nextLine();  
		    		  }catch(Exception e){
		    			  
		    		  }
		    		
		    		  Bike newBike = new Bike(bikeType);
		    		  newDock.addBikeToDock(newBike);
		    	  }
		    	  
		    	  dockController.addDockToList(newDock);
		      }
		      
		      List<Dock> dockList = dockController.getAllDock();
		      for (int i = 0; i < num; i++) {
		    	  Dock dock = dockList.get(i);
		    	  List<Bike> bikes = dock.getAllBikes();
		    	  for (int j = 0; j < bikes.size(); j++) {
		    		  System.out.println("Bike: " + bikes.get(j).getBikeType().toString() + "\n"); 
		    	  }
		      }
		      myReader.close();
		} catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(DOCK_VIEW_FXML));
			Parent root = loader.load();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			dockViewController = loader.getController();
			dockViewController.setDockController(dockController);
			dockViewController.displayDocks();
	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
