package org.oslomet.Dialogs;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.oslomet.AdminController;

import java.util.Optional;

public class DeleteComponentDialog {

    Label header = new Label("Are you sure you want to delete?");

    private boolean deleteConfirmed = false;

    public boolean confirmDeleteDialog() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Confirm delete");
        window.setMinWidth(200);
        window.setMinHeight(200);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(25);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(25);
        gridPane.getColumnConstraints().addAll(col1,col2);

        Button yes = new Button("Yes");
        Button no = new Button("No");
        gridPane.add(yes, 1,4);
        gridPane.add(no, 2, 4);

        gridPane.add(header,1,1, 2,1);
        header.setStyle("-fx-font-size: 14px; -fx-font-weight: bold");
        header.setWrapText(true);

        yes.setStyle("-fx-background-color: lightgreen; -fx-border-color: black;");
        no.setStyle("-fx-background-color: #B30000; -fx-text-fill: white; -fx-border-color: black");
        yes.setOnAction(e -> {
            window.close();
            deleteConfirmed = true;
        });
        no.setOnAction(e -> window.close());

        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.showAndWait();

        return deleteConfirmed;
    }

    public static void noComponentSelected() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Component not selected");
        alert.setContentText("Select a component to delete");
        alert.showAndWait();
    }

    public static void noComputerSelected() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Computer not selected");
        alert.setContentText("Select a computer to delete");
        alert.showAndWait();
    }
}
