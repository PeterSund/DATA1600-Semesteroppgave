package org.oslomet.Dialogs;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.MonitorModel;
import org.oslomet.ComponentRegistry.MonitorRegistry;
import org.oslomet.ExceptionClasses.*;

public class MonitorDialog {
    DialogTemplate dialogTemplate = new DialogTemplate();

    //Buttons
    Button btnSubmit = new Button("Submit");
    Button btnCancel = new Button("Cancel");

    //Text fields
    TextField size = new TextField();

    //Labels
    Label sizeErrorLlb = new Label("");

    public void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("CPU");
        window.setMinWidth(650);
        window.setMinHeight(350);

        GridPane gridPane = dialogTemplate.addComponentGridPane();

        gridPane.add(sizeErrorLlb, 2, 5);
        gridPane.add(new Label("Size:"), 0, 5);
        gridPane.add(size, 1, 5);
        size.setPromptText("Size (inches)");
        sizeErrorLlb.setStyle("-fx-text-fill: red;");
        sizeErrorLlb.setWrapText(true);

        gridPane.add(btnSubmit, 0, 8);
        gridPane.add(btnCancel, 1, 8);
        btnSubmit.setStyle("-fx-background-color: lightgreen; -fx-border-color: black;");
        btnCancel.setStyle("-fx-background-color: #B30000; -fx-text-fill: white; -fx-border-color: black");
        btnSubmit.setOnAction(e -> submitMonitor(window));
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

    private void submitMonitor(Stage window) {
        try {
            dialogTemplate.clearErrorLabels();
            sizeErrorLlb.setText("");
            double priceDouble = 0;
            double pvDouble = 0;
            int sizeInt = 0;
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
                sizeInt = Integer.parseInt(size.getText());
            } catch (NumberFormatException nfe) {
                sizeErrorLlb.setText("Size must be a number");
            }

            MonitorRegistry.addComponent(new MonitorModel(dialogTemplate.getName(), dialogTemplate.getBrand(), priceDouble, pvDouble, sizeInt));
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
        } catch (InvalidSizeException ise) {
            sizeErrorLlb.setText(ise.getMessage());
        }
    }
}
