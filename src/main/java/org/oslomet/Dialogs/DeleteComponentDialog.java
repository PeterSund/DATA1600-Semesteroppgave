package org.oslomet.Dialogs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.oslomet.AdminController;

import java.util.Optional;

public class DeleteComponentDialog {

    private boolean deleteConfirmed = false;

    public boolean confirmDeleteDialog() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Confirm delete");
        window.setMinWidth(600);
        window.setMinHeight(300);

        GridPane gridPane = new GridPane();

        Button yes = new Button("Yes");
        Button no = new Button("No");
        gridPane.add(yes, 2,2);
        gridPane.add(no, 3, 2);

        gridPane.add(new Label("Are you sure you want to delete component?"),1,2);

        gridPane.setAlignment(Pos.CENTER);

        yes.setOnAction(e -> changeValueDeleteConfirmed(window));
        no.setOnAction(e -> window.close());

        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.showAndWait();

        return deleteConfirmed;
    }

    public void changeValueDeleteConfirmed(Stage window) {
        window.close();
        deleteConfirmed = true;
    }

    public static void noComponentSelected() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Component not selected");
        alert.setContentText("Select a component to delete");

        alert.showAndWait();
    }
}
