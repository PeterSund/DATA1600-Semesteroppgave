package org.oslomet.Dialogs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.CPUModel;
import org.oslomet.ComponentRegistry.CPURegistry;
import org.oslomet.ExceptionClasses.*;
import org.oslomet.Validation.AdminInputValidation;

public class CPUDialog {

    DialogTemplate dialogTemplate = new DialogTemplate();

    //TextFields for CPU dialog-box
    private TextField clockSpeed = new TextField();
    private TextField cores = new TextField();

    //Labels for displaying error in CPU dialog-box
    private Label coresErrorLbl = new Label("");
    private Label clockspeedErrorLbl = new Label("");

    //Buttons
    private Button btnSubmit = new Button("Submit");
    private Button btnCancel = new Button("Cancel");

    public void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("CPU");
        window.setMinWidth(650);
        window.setMinHeight(400);

        GridPane gridPane = dialogTemplate.addComponentGridPane();

        gridPane.add(new Label("Clockspeed:"), 0, 5);
        gridPane.add(clockspeedErrorLbl, 2, 5);
        gridPane.add(clockSpeed, 1,5);
        clockspeedErrorLbl.setStyle("-fx-text-fill: red;");
        cores.setPromptText("No. cores");
        clockspeedErrorLbl.setWrapText(true);

        gridPane.add(new Label("No. cores:"), 0, 6);
        gridPane.add(cores, 1,6);
        gridPane.add(coresErrorLbl,2,6);
        coresErrorLbl.setStyle("-fx-text-fill: red;");
        clockSpeed.setPromptText("Clockspeed (GHz)");
        coresErrorLbl.setWrapText(true);

        gridPane.add(btnSubmit, 0, 9);
        gridPane.add(btnCancel, 1, 9);
        btnSubmit.setStyle("-fx-background-color: lightgreen; -fx-border-color: black;");
        btnCancel.setStyle("-fx-background-color: #B30000; -fx-text-fill: white; -fx-border-color: black");

        gridPane.setAlignment(Pos.CENTER);

        btnCancel.setOnAction(e -> window.close());
        btnSubmit.setOnAction(e -> submitCPU(window));

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

    private void submitCPU(Stage window) {
        dialogTemplate.clearErrorLabels();
        clockspeedErrorLbl.setText("");
        coresErrorLbl.setText("");
        double priceDouble = 0;
        double pvDouble = 0;
        double clockSpeedDouble = 0;
        int coresInt = 0;

        try {
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
                clockSpeedDouble = Double.parseDouble(clockSpeed.getText());
            } catch (NumberFormatException nfe) {
                clockspeedErrorLbl.setText("Clockspeed must be a number greater then 0 and maximum " + AdminInputValidation.MAX_CLOCK_SPEED +". Use \".\" for decimals.");
            }
            try {
                coresInt = Integer.parseInt(cores.getText());
            } catch (NumberFormatException nfe) {
                coresErrorLbl.setText("Cores must be a even number greater then 0 and maximum " + AdminInputValidation.MAX_CORES + ".");
            }

            CPURegistry.addComponent(new CPUModel(dialogTemplate.getName(), dialogTemplate.getBrand(), priceDouble, pvDouble, clockSpeedDouble, coresInt));
            window.close();
        }

        catch (InvalidNameException ine) {
            dialogTemplate.setNameErrorLblName(ine.getMessage());
        } catch (InvalidBrandException ibe) {
            dialogTemplate.setBrandErrorLblName(ibe.getMessage());
        } catch (InvalidPriceException ipe) {
            dialogTemplate.setPriceErrorLbl(ipe.getMessage());
        } catch (InvalidPerformanceValueException ipve) {
            dialogTemplate.setPerformanceValueErrorLbl(ipve.getMessage());
        } catch (InvalidClockSpeedException icse) {
            clockspeedErrorLbl.setText(icse.getMessage());
        } catch (InvalidCoresException ice) {
            coresErrorLbl.setText(ice.getMessage());
        }
    }

}


