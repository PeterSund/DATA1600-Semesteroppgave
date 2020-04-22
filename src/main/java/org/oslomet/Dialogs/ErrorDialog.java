package org.oslomet.Dialogs;

import javafx.scene.control.Alert;

public class ErrorDialog {

    public static void showErrorDialog(String content, String header) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }
}
