package org.oslomet.ComponentDialogs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.MonitorModel;
import org.oslomet.ComponentRegistry.MonitorRegistry;
import org.oslomet.ExceptionClasses.*;

import static org.oslomet.GenerateDialogBox.addComponentGridPane;

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
        window.setMinWidth(600);
        window.setMinHeight(300);

        GridPane gridPane = dialogTemplate.addComponentGridPane();
        size.setPromptText("Size (inches)");


        gridPane.add(sizeErrorLlb, 2, 4);
        gridPane.add(new Label("Size:"), 0, 4);
        gridPane.add(size, 1, 4);

        gridPane.add(btnSubmit, 0, 5);
        gridPane.add(btnCancel, 1, 5);
        btnSubmit.setOnAction(e -> submitMonitor(window));
        btnCancel.setOnAction(e -> window.close());

        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.showAndWait();
    }

    private void submitMonitor(Stage window) {
        try {
            //clearErrorLabels();
            //sizeErrorLlb.setText("");
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
