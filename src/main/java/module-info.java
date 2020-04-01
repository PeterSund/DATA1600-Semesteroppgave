module org.oslomet {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.oslomet to javafx.fxml, javafx.base;
    opens org.oslomet.ComponentClasses to javafx.base;
    opens org.oslomet.ComputerClasses to javafx.base;

    exports org.oslomet;
}