module org.oslomet {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens org.oslomet to javafx.fxml, javafx.base;
    opens org.oslomet.ComponentClasses to javafx.base;
    opens org.oslomet.ComputerClasses to javafx.base;

    exports org.oslomet;
}