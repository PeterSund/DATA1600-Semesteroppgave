package org.oslomet.Dialogs;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class ErrorDialog {

    public static void showErrorDialog(String content, String header) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        Label error = new Label(content);
        error.setWrapText(true);
        alert.getDialogPane().setContent(error);

        alert.showAndWait();
    }
}
