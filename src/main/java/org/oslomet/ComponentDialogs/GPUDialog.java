package org.oslomet.ComponentDialogs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.CPUModel;
import org.oslomet.ComponentClasses.GPUModel;
import org.oslomet.ComponentRegistry.CPURegistry;
import org.oslomet.ComponentRegistry.GPURegistry;
import org.oslomet.ExceptionClasses.*;

public class GPUDialog {

    DialogTemplate dialogTemplate = new DialogTemplate();

    //TextFields for GPU dialog-box
    private TextField clockSpeed = new TextField();
    private TextField memory = new TextField();

    //Labels for displaying error in GPU dialog-box
    private Label clockSpeedErrorLbl = new Label("");
    private Label memoryErrorLbl = new Label("");

    //Buttons
    private Button btnSubmit = new Button("Submit");
    private Button btnCancel = new Button("Cancel");

    public void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("GPU");
        window.setMinWidth(600);
        window.setMinHeight(300);

        GridPane gridPane = dialogTemplate.addComponentGridPane();

        gridPane.add(new Label("Clockspeed:"), 0, 4);
        gridPane.add(clockSpeed, 1,4);
        gridPane.add(clockSpeedErrorLbl, 2, 4);
        clockSpeed.setPromptText("Clockspeed (GHz)");

        gridPane.add(new Label("Memory:"), 0, 5);
        gridPane.add(memory, 1,5);
        gridPane.add(memoryErrorLbl,2,5);
        memory.setPromptText("Memory (MB)");

        gridPane.add(btnSubmit, 0, 6);
        gridPane.add(btnCancel, 1, 6);

        gridPane.setAlignment(Pos.CENTER);

        btnCancel.setOnAction(e -> window.close());
        btnSubmit.setOnAction(e -> submitGPU(window));

        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.showAndWait();
    }

    private void submitGPU(Stage window) {
        dialogTemplate.clearErrorLabels();
        clockSpeedErrorLbl.setText("");
        memoryErrorLbl.setText("");
        double priceDouble = 0;
        double pvDouble = 0;
        double clockSpeedDouble = 0;
        int memoryInt = 0;

        try {
            try {
                priceDouble = Double.parseDouble(dialogTemplate.getPrice());
            } catch (NumberFormatException nfe) {
                dialogTemplate.setPriceErrorLbl("Price must be a number");
            }
            try {
                pvDouble = Double.parseDouble(dialogTemplate.getPerformanceValue());
            } catch (NumberFormatException nfe) {
                dialogTemplate.setPerformanceValueErrorLbl("Performance value must be a number");
            }
            try {
                clockSpeedDouble = Double.parseDouble(clockSpeed.getText());
            } catch (NumberFormatException nfe) {
                clockSpeedErrorLbl.setText("Clockspeed must be a number");
            }
            try {
                memoryInt = Integer.parseInt(memory.getText());
            } catch (NumberFormatException nfe) {
                memoryErrorLbl.setText("Memory must be a number");
            }

            GPURegistry.addComponent(new GPUModel(dialogTemplate.getName(), dialogTemplate.getBrand(), priceDouble, pvDouble, clockSpeedDouble, memoryInt));
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
            clockSpeedErrorLbl.setText(icse.getMessage());
        } catch (InvalidMemoryException ice) {
            memoryErrorLbl.setText(ice.getMessage());
        }
    }

}
