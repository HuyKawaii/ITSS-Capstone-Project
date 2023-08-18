/**
 * 
 */
/**
 * 
 */
module CapstoneProject {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
	opens application.controller to javafx.fxml;
	opens application.entity to javafx.base;
	opens application.subsystem to javafx.base;
	
    exports application;
    exports application.controller;
    exports application.util;
}