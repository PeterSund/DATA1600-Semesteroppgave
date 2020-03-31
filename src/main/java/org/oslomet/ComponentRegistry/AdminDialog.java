package org.oslomet.ComponentRegistry;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class AdminDialog {

    public static Dialog addComponentDialog() {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Create new component");

        ButtonType add = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(add, ButtonType.CANCEL);
        return dialog;
    }

    public static GridPane addComponentGridPane() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        TextField name = new TextField();
        name.setPromptText("Name");
        TextField brand = new TextField();
        brand.setPromptText("Brand");
        TextField price = new TextField();
        price.setPromptText("Price");
        TextField performanceValue = new TextField();
        performanceValue.setPromptText("Performance-value");

        grid.add(new Label("Name:"), 0, 0);
        grid.add(name, 1, 0);
        grid.add(new Label("Brand:"), 0, 1);
        grid.add(brand, 1,1);
        grid.add(new Label("Price:"), 0, 2);
        grid.add(price, 1,2);
        grid.add(new Label("Performance-value (0-100):"), 0, 3);
        grid.add(performanceValue, 1,3);

        return grid;
    }


}
