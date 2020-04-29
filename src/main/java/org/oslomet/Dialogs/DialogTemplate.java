package org.oslomet.Dialogs;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class DialogTemplate {

    Label header = new Label("Add component");

    TextField name = new TextField();
    TextField brand = new TextField();
    TextField price = new TextField();
    TextField performanceValue = new TextField();

    //Labels for displaying error in templae dialog-box
    Label nameErrorLbl = new Label();
    Label brandErrorLbl = new Label();
    Label priceErrorLbl = new Label();
    Label performanceValueErrorLbl = new Label();

    //Template grid for dialog-box
    public GridPane addComponentGridPane() {
        //TextFields for template dialog-box
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(25);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(25);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(50);
        grid.getColumnConstraints().addAll(col1,col2,col3);

        grid.add(header, 1,0,3,1);
        header.setStyle("-fx-font-size: 24px; -fx-font-weight: bold");

        grid.add(name, 1, 1);
        grid.add(brand, 1,2);
        grid.add(price, 1,3);
        grid.add(performanceValue, 1,4);

        grid.add(nameErrorLbl, 2, 1);
        grid.add(brandErrorLbl, 2, 2);
        grid.add(priceErrorLbl, 2,3);
        grid.add(performanceValueErrorLbl, 2, 4);

        nameErrorLbl.setWrapText(true);
        brandErrorLbl.setWrapText(true);
        priceErrorLbl.setWrapText(true);
        performanceValueErrorLbl.setWrapText(true);

        nameErrorLbl.setStyle("-fx-text-fill: red;");
        brandErrorLbl.setStyle("-fx-text-fill: red;");
        priceErrorLbl.setStyle("-fx-text-fill: red;");
        performanceValueErrorLbl.setStyle("-fx-text-fill: red;");

        name.setPromptText("Name");
        brand.setPromptText("Brand");
        price.setPromptText("Price");
        performanceValue.setPromptText("Performance-value");

        grid.add(new Label("Name:"), 0, 1);
        grid.add(new Label("Brand:"), 0, 2);
        grid.add(new Label("Price:"), 0, 3);
        grid.add(new Label("Performance-value (0-100):"), 0, 4);

        return grid;
    }

    public String getName() {
        return name.getText();
    }

    public String getBrand() {
        return brand.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getPerformanceValue() {
        return performanceValue.getText();
    }

    public void setNameErrorLblName(String name) {
        nameErrorLbl.setText(name);
    }

    public void setBrandErrorLblName(String brand) {
        brandErrorLbl.setText(brand);
    }

    public void setPriceErrorLbl(String price) {
        priceErrorLbl.setText(price);
    }

    public void setPerformanceValueErrorLbl(String performanceValue) {
        performanceValueErrorLbl.setText(performanceValue);
    }

    public void clearErrorLabels() {
        nameErrorLbl.setText("");
        brandErrorLbl.setText("");
        priceErrorLbl.setText("");
        performanceValueErrorLbl.setText("");
    }

}
