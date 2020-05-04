package org.oslomet.Dialogs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.HarddriveModel;
import org.oslomet.ComponentRegistry.HardDriveRegistry;
import org.oslomet.ExceptionClasses.*;
import org.oslomet.Validation.AdminInputValidation;

public class HardDriveDialog {

    DialogTemplate dialogTemplate = new DialogTemplate();

    //TextFields and combo boxes
    ComboBox type = new ComboBox();
    TextField capacity = new TextField();

    //Error labels
    Label typeErrorLBl = new Label("");
    Label capacityErrorLbl = new Label("");

    //Buttons
    private Button btnSubmit = new Button("Submit");
    private Button btnCancel = new Button("Cancel");

    public void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Hard drive");
        window.setMinWidth(650);
        window.setMinHeight(400);

        GridPane gridPane = dialogTemplate.addComponentGridPane();

        type.getItems().addAll("HDD", "SSD");
        type.setValue("HDD");

        gridPane.add(new Label("Type:"), 0, 5);
        gridPane.add(type, 1, 5);
        gridPane.add(typeErrorLBl, 2, 5);
        typeErrorLBl.setStyle("-fx-text-fill: red;");

        gridPane.add(new Label("Capacity:"), 0, 6);
        gridPane.add(capacity, 1, 6);
        gridPane.add(capacityErrorLbl, 2, 6);
        capacity.setPromptText("Capacity (GB)");
        capacityErrorLbl.setStyle("-fx-text-fill: red;");
        capacityErrorLbl.setWrapText(true);

        gridPane.add(btnSubmit, 0, 9);
        gridPane.add(btnCancel, 1, 9);
        btnSubmit.setStyle("-fx-background-color: lightgreen; -fx-border-color: black;");
        btnCancel.setStyle("-fx-background-color: #B30000; -fx-text-fill: white; -fx-border-color: black");

        gridPane.setAlignment(Pos.CENTER);

        btnCancel.setOnAction(e -> window.close());
        btnSubmit.setOnAction(e -> submitHardDrive(window));

        Scene scene = new Scene(gridPane);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                btnSubmit.fire();
            }
            else if (e.getCode() == KeyCode.ESCAPE) {
                btnCancel.fire();
            }
        });

        window.setScene(scene);
        window.showAndWait();
    }

    private void submitHardDrive(Stage window) {

        try {
            dialogTemplate.clearErrorLabels();
            typeErrorLBl.setText("");
            capacityErrorLbl.setText("");
            double priceDouble = 0;
            double pvDouble = 0;
            int capacityInt = 0;
            String typeString = type.getValue().toString();
            try {
                priceDouble = Double.parseDouble(dialogTemplate.getPrice());
            } catch (NumberFormatException nfe) {
                dialogTemplate.setPriceErrorLbl("Price cannot be blank and must be between 0.1 and " + AdminInputValidation.MAX_PRICE + ". Use \".\" for decimals.");
            }
            try {
                pvDouble = Double.parseDouble(dialogTemplate.getPerformanceValue());
            } catch (NumberFormatException nfe) {
                dialogTemplate.setPerformanceValueErrorLbl("Performancevalue cannot be blank and must be between 0.1 and " + AdminInputValidation.MAX_PERFORMANCE_VALUE + ". Use \".\" for decimals.");
            }
            try {
                capacityInt = Integer.parseInt(capacity.getText());
            } catch (NumberFormatException nfe) {
                capacityErrorLbl.setText("Capacity must be a number greater then 0 and maximum " + AdminInputValidation.MAX_CAPACITY + ".");
            }

            HardDriveRegistry.addComponent(new HarddriveModel(dialogTemplate.getName(), dialogTemplate.getBrand(), priceDouble, pvDouble, typeString, capacityInt));
            window.close();

        } catch (InvalidNameException ine) {
            dialogTemplate.setNameErrorLblName(ine.getMessage());
        } catch (InvalidBrandException ibe) {
            dialogTemplate.setBrandErrorLblName(ibe.getMessage());
        } catch (InvalidPriceException ipe) {
            dialogTemplate.setPriceErrorLbl(ipe.getMessage());
        } catch (InvalidPerformanceValueException ipve) {
            dialogTemplate.setPerformanceValueErrorLbl(ipve.getMessage());
        }
        catch (InvalidCapacityException ice) {
            capacityErrorLbl.setText(ice.getMessage());
        }
    }
}
