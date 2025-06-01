module demo.conart {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens demo.conart to javafx.fxml;
    exports demo.conart;
}