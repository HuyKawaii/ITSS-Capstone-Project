module com.example.testjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testjavafx to javafx.fxml;
    opens com.example.testjavafx.controller to javafx.fxml;
    exports com.example.testjavafx;
    exports com.example.testjavafx.controller;
    exports com.example.testjavafx.screen;
    opens com.example.testjavafx.screen to javafx.fxml;
    opens com.example.testjavafx.entities to javafx.base;

}