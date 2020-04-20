package org.oslomet.ComponentDialogs;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.PSUModel;
import org.oslomet.ComponentRegistry.PSURegistry;
import org.oslomet.ExceptionClasses.*;

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
        window.setMinWidth(600);
        window.setMinHeight(300);

        GridPane gridPane = dialogTemplate.addComponentGridPane();

        gridPane.add(new Label("Watt: "), 0, 4);
        gridPane.add(watt, 1,4);
        gridPane.add(wattErrorLbl, 2,4);
        watt.setPromptText("Watt");

        gridPane.add(btnSubmit, 0, 6);
        gridPane.add(btnCancel, 1, 6);
        btnSubmit.setOnAction(e -> submitPSU(window));
        btnCancel.setOnAction(e -> window.close());

        Scene scene = new Scene(gridPane);
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
                dialogTemplate.setPriceErrorLbl("Price must be a number");
            }
            try {
                pvDouble = Double.parseDouble(dialogTemplate.getPerformanceValue());
            } catch (NumberFormatException nfe) {
                dialogTemplate.setPerformanceValueErrorLbl("Performancevalue must be a number");
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
