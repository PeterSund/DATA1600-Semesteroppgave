package org.oslomet.Dialogs;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.RAMModel;
import org.oslomet.ComponentRegistry.RAMRegistry;
import org.oslomet.ExceptionClasses.*;

public class RAMDialog {

    DialogTemplate dialogTemplate = new DialogTemplate();

    //Text fields
    TextField memory = new TextField();
    TextField memorySpeed = new TextField();

    //Error labels
    Label memoryErrorLbl = new Label("");
    Label memoryspeedErrorLbl = new Label("");

    //Buttons
    Button btnSubmit = new Button("Submit");
    Button btnCancel = new Button("Cancel");

    public void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("RAM");
        window.setMinWidth(600);
        window.setMinHeight(300);

        GridPane gridPane = dialogTemplate.addComponentGridPane();

        gridPane.add(new Label("Memory:"), 0, 4);
        gridPane.add(memory, 1, 4);
        gridPane.add(memoryErrorLbl, 2, 4);
        memory.setPromptText("Memory (MB)");

        gridPane.add(new Label("Memoryspeed (MHz): "), 0, 5);
        gridPane.add(memorySpeed, 1, 5);
        gridPane.add(memoryspeedErrorLbl, 2, 5);
        memorySpeed.setPromptText("Memoryspeed (MHz)");

        gridPane.add(btnSubmit, 0, 6);
        gridPane.add(btnCancel, 1, 6);
        btnSubmit.setOnAction(e -> submitRAM(window));
        btnCancel.setOnAction(e -> window.close());

        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.showAndWait();
    }

    private void submitRAM(Stage window) {

        try {
            dialogTemplate.clearErrorLabels();
            memoryErrorLbl.setText("");
            memoryspeedErrorLbl.setText("");
            double priceDouble = 0;
            double pvDouble = 0;
            int memoryInt = 0;
            double memorySpeedDouble = 0;
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
                memoryInt = Integer.parseInt(memory.getText());
            } catch (NumberFormatException nfe) {
                memoryErrorLbl.setText("Memory must be a number");
            }
            try {
                memorySpeedDouble = Double.parseDouble(memorySpeed.getText());
            } catch (NumberFormatException nfe) {
                memoryspeedErrorLbl.setText("Memoryspeed must be a number");
            }

            RAMRegistry.addComponent(new RAMModel(dialogTemplate.getName(), dialogTemplate.getBrand(), priceDouble, pvDouble, memoryInt, memorySpeedDouble));
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
        } catch (InvalidMemoryException ime) {
            memoryErrorLbl.setText(ime.getMessage());
        } catch (InvalidMemorySpeedException imse) {
            memoryspeedErrorLbl.setText(imse.getMessage());
        }
    }
}
