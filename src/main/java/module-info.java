module demo.conart {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.slf4j;


    opens demo.conart to javafx.fxml;
    exports demo.conart;
}