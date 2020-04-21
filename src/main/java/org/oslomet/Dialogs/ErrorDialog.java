package org.oslomet.Dialogs;

import javafx.scene.control.Alert;

public class ErrorDialog {

    public static void showErrorDialog(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid input");
        alert.setContentText(msg);

        alert.showAndWait();
    }
}
