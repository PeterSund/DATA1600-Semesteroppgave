package org.oslomet.Dialogs;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.PSUModel;
import org.oslomet.ComponentRegistry.PSURegistry;
import org.oslomet.ExceptionClasses.*;
import org.oslomet.Validation.AdminInputValidation;

public class PSUDialog {

    DialogTemplate dialogTemplate = new DialogTemplate();

    //Text fields
    TextField watt = new TextField();

    //Error labels
    Label wattErrorLbl = new Label("");

    //Buttons
    Button btnSubmit = new Button("Submit");
    Button btnCancel = new Button("Cancel");

    public void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("PSU");
        window.setMinWidth(650);
        window.setMinHeight(350);

        GridPane gridPane = dialogTemplate.addComponentGridPane();

        gridPane.add(new Label("Watt: "), 0, 5);
        gridPane.add(watt, 1,5);
        gridPane.add(wattErrorLbl, 2,5);
        watt.setPromptText("Watt");
        wattErrorLbl.setStyle("-fx-text-fill: red;");
        wattErrorLbl.setWrapText(true);

        gridPane.add(btnSubmit, 0, 8);
        gridPane.add(btnCancel, 1, 8);
        btnSubmit.setStyle("-fx-background-color: lightgreen; -fx-border-color: black;");
        btnCancel.setStyle("-fx-background-color: #B30000; -fx-text-fill: white; -fx-border-color: black");
        btnSubmit.setOnAction(e -> submitPSU(window));
        btnCancel.setOnAction(e -> window.close());

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

    private void submitPSU(Stage window) {

        try {
            dialogTemplate.clearErrorLabels();
            double priceDouble = 0;
            double pvDouble = 0;
            int wattInt = 0;

            try {
                priceDouble = Double.parseDouble(dialogTemplate.getPrice());
            } catch (NumberFormatException nfe) {
                dialogTemplate.setPriceErrorLbl("Price cannot be blank and must be between 0 and " + AdminInputValidation.MAX_PRICE + ". Use \".\" for decimals.");
            }
            try {
                pvDouble = Double.parseDouble(dialogTemplate.getPerformanceValue());
            } catch (NumberFormatException nfe) {
                dialogTemplate.setPerformanceValueErrorLbl("Performancevalue cannot be blank and must be between 0 and " + AdminInputValidation.MAX_PERFORMANCE_VALUE + ". Use \".\" for decimals.");
            }
            try {
                wattInt = Integer.parseInt(watt.getText());
            } catch (NumberFormatException nfe) {
                wattErrorLbl.setText("Watt must be a number");
            }

            PSURegistry.addComponent(new PSUModel(dialogTemplate.getName(), dialogTemplate.getBrand(), priceDouble, pvDouble, wattInt));
            window.close();

        } catch (InvalidNameException ine) {
            dialogTemplate.setNameErrorLblName(ine.getMessage());
        } catch (InvalidBrandException ibe) {
            dialogTemplate.setBrandErrorLblName(ibe.getMessage());
        } catch (InvalidPriceException ipe) {
            dialogTemplate.setPriceErrorLbl(ipe.getMessage());
        } catch (InvalidPerformanceValueException ipve) {
            dialogTemplate.setPerformanceValueErrorLbl(ipve.getMessage());
        } catch (InvalidWattException iwe) {
            wattErrorLbl.setText(iwe.getMessage());
        }
    }
}
