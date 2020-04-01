package org.oslomet.ComponentRegistry;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class AdminDialog {

    public static Dialog addComponentDialog() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Create new component");

        ButtonType add = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(add, ButtonType.CANCEL);
        return dialog;
    }

    public static GridPane addComponentGridPane() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Name:"), 0, 0);
        grid.add(new Label("Brand:"), 0, 1);
        grid.add(new Label("Price:"), 0, 2);
        grid.add(new Label("Performance-value (0-100):"), 0, 3);


        return grid;
    }

}
