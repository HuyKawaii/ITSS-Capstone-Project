package application.controller;


import static application.util.Setting.BIKE_DETAIL_WHILE_RENTING_VIEW_FXML;	
import static application.util.Setting.DOCK_VIEW_FXML;	
import java.io.IOException;	
import application.entity.Bike;	
import application.subsystem.Response;	
import application.util.OpenNewScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import static application.util.Setting.BIKE_DETAIL_WHILE_RENTING_VIEW_FXML;
//import static application.util.Setting.DOCK_VIEW_FXML;

public class ResponseController {

    protected Response response;
    private Bike bike;	
    public void setResponse(Response response, Bike bike) {	
    this.response = response;	
    tblResponse.getItems().add(this.response);	
    this.bike = bike;	
}

    @FXML
    private TableColumn<Response, Double> amount;

    @FXML
    private TableColumn<Response, String> cardCode;

    @FXML
    private TableColumn<Response, String> createdAt;

    @FXML
    private TableColumn<Response, Integer> errorCode;

    @FXML
    private TableColumn<Response, String> expiratedDate;

    @FXML
    private TableColumn<Response, String> owner;

    @FXML
    private TableView<Response> tblResponse;

    @FXML
    private TableColumn<Response, String> transactionContent;

    @FXML
    private TableColumn<Response, String> transactionId;


    @FXML
    void initialize() {
        errorCode.setCellValueFactory(new PropertyValueFactory<>("errorCode"));
        cardCode.setCellValueFactory(new PropertyValueFactory<>("cardCode"));
        owner.setCellValueFactory(new PropertyValueFactory<>("owner"));
        expiratedDate.setCellValueFactory(new PropertyValueFactory<>("dateExpired"));
        transactionId.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        transactionContent.setCellValueFactory(new PropertyValueFactory<>("transactionContent"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        createdAt.setCellValueFactory(new PropertyValueFactory<>("createdAt"));


    }

    @FXML
    void confirm(ActionEvent event) throws IOException {

        // move to BikeDetailWhileRenting Screen if error Code is success
        if (this.response.getErrorCode() == 0 && this.response.getTransaction().getContent().equals("Rent") ) {
        	//            FXMLLoader loader = new FXMLLoader(getClass().getResource(BIKE_DETAIL_WHILE_RENTING_VIEW_FXML));	
        	
            FXMLLoader loader = OpenNewScene.inOldWindow(BIKE_DETAIL_WHILE_RENTING_VIEW_FXML, event, this);	
//            Parent root = loader.load();	
            BikeDetailWhileRentingController bikeDetailWhileRentingController = loader.getController();	
            bikeDetailWhileRentingController.setBike(this.bike);	
//            Stage stage = new Stage();	
//            stage.setScene(new Scene(root));	
//            stage.setTitle("Bike Detail while renting");	
//            stage.show();	
        }	
        else {	
//            FXMLLoader loader = new FXMLLoader(getClass().getResource(DOCK_VIEW_FXML));	
            FXMLLoader loader = OpenNewScene.inOldWindow(DOCK_VIEW_FXML, event, this);	
            	
//            Parent root = loader.load();	
//            Stage stage = new Stage();	
//            stage.setScene(new Scene(root));	
//            stage.setTitle("EcoBike");	
//            stage.show();
        }
    }

}