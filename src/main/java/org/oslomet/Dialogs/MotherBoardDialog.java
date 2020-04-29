package org.oslomet.Dialogs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.MotherboardModel;
import org.oslomet.ComponentRegistry.MotherboardRegistry;
import org.oslomet.ExceptionClasses.InvalidBrandException;
import org.oslomet.ExceptionClasses.InvalidNameException;
import org.oslomet.ExceptionClasses.InvalidPerformanceValueException;
import org.oslomet.ExceptionClasses.InvalidPriceException;

public class MotherBoardDialog {

    DialogTemplate dialogTemplate = new DialogTemplate();

    //Combo boxes
    ComboBox type = new ComboBox();

    //Buttons
    Button btnSubmit = new Button("Submit");
    Button btnCancel = new Button("Cancel");

    public void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Mother board");
        window.setMinWidth(650);
        window.setMinHeight(400);

        GridPane gridPane = dialogTemplate.addComponentGridPane();

        type.getItems().addAll("ATX", "mini-ATX", "E-ATX");
        type.setValue("ATX");
        gridPane.add(new Label("Type:"), 0, 5);
        gridPane.add(type, 1, 5);

        gridPane.add(btnSubmit, 0, 8);
        gridPane.add(btnCancel, 1, 8);
        btnSubmit.setStyle("-fx-background-color: lightgreen; -fx-border-color: black;");
        btnCancel.setStyle("-fx-background-color: #B30000; -fx-text-fill: white; -fx-border-color: black");
        btnCancel.setOnAction(e -> window.close());
        btnSubmit.setOnAction(e -> submitMotherBoard(window));

        gridPane.setAlignment(Pos.CENTER);

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

    private void submitMotherBoard(Stage window) {

        try {
            dialogTemplate.clearErrorLabels();
            double priceDouble = 0;
            double pvDouble = 0;
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

            MotherboardRegistry.addComponent(new MotherboardModel(dialogTemplate.getName(), dialogTemplate.getBrand(), priceDouble, pvDouble, typeString));
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

    }
}
