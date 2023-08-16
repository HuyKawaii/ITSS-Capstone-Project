module application {
    requires javafx.controls;
    requires javafx.fxml;
<<<<<<< Updated upstream
=======
    requires java.sql;
>>>>>>> Stashed changes


    opens application to javafx.fxml, javafx.graphics;
    opens application.controller to javafx.fxml;
    opens application.entity to javafx.base;
    opens application.subsystem to javafx.base;
    exports application;
    exports application.controller;
    exports application.util;

}