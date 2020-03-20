module org.oslomet {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.oslomet to javafx.fxml;
    exports org.oslomet;
}