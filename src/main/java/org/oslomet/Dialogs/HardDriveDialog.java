package org.oslomet.Dialogs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.HarddriveModel;
import org.oslomet.ComponentRegistry.HardDriveRegistry;
import org.oslomet.ExceptionClasses.*;

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
        window.setMinWidth(600);
        window.setMinHeight(300);

        GridPane gridPane = dialogTemplate.addComponentGridPane();

        type.getItems().addAll("HDD", "SSD");
        type.setValue("HDD");

        gridPane.add(new Label("Type):"), 0, 4);
        gridPane.add(type, 1, 4);
        gridPane.add(typeErrorLBl, 2, 4);

        gridPane.add(new Label("Capacity:"), 0, 5);
        gridPane.add(capacity, 1, 5);
        gridPane.add(capacityErrorLbl, 2, 5);
        capacity.setPromptText("Capacity (GB)");

        gridPane.add(btnSubmit, 0, 6);
        gridPane.add(btnCancel, 1, 6);

        gridPane.setAlignment(Pos.CENTER);

        btnCancel.setOnAction(e -> window.close());
        btnSubmit.setOnAction(e -> submitHardDrive(window));

        Scene scene = new Scene(gridPane);
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
                dialogTemplate.setPriceErrorLbl("Price must be a number");
            }
            try {
                pvDouble = Double.parseDouble(dialogTemplate.getPerformanceValue());
            } catch (NumberFormatException nfe) {
                dialogTemplate.setPerformanceValueErrorLbl("Performancevalue must be a number");
            }
            try {
                capacityInt = Integer.parseInt(capacity.getText());
            } catch (NumberFormatException nfe) {
                capacityErrorLbl.setText("Capacity must be a number");
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
