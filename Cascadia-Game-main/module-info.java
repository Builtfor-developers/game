module com.cascadia.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cascadia.demo to javafx.fxml;
    exports com.cascadia.demo;
}