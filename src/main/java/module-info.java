module com.example.small_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires MaterialFX;


    opens com.example.small_project to javafx.fxml;
    exports com.example.small_project;
    exports com.example.small_project.Controllers;
    opens com.example.small_project.Controllers to javafx.fxml;
}