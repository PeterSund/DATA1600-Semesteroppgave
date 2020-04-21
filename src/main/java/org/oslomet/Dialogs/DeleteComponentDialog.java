package org.oslomet.Dialogs;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import org.oslomet.AdminController;

import java.util.Optional;

public class DeleteComponentDialog {

    public static boolean confirmDeleteDialog() {
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete component?", yes, no);
        alert.setTitle("Delete component");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void noComponentSelected() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Component not selected");
        alert.setContentText("Select a component to delete");

        alert.showAndWait();
    }
}
