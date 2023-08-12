/**
 * 
 */
/**
 * 
 */
module CapstoneProject {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	opens application.controller to javafx.fxml;
	opens application.entity to javafx.base;
}