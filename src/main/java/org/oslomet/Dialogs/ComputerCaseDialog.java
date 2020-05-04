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
import org.oslomet.ComponentClasses.ComputerCaseModel;
import org.oslomet.ComponentRegistry.ComputerCaseRegistry;
import org.oslomet.ExceptionClasses.*;
import org.oslomet.Validation.AdminInputValidation;

public class ComputerCaseDialog {

    DialogTemplate dialogTemplate = new DialogTemplate();

    //Textfields
    TextField dimensions = new TextField();
    TextField color = new TextField();

    //Error labels
    Label dimensionsErrorLbl = new Label("");
    Label colorErrorLbl = new Label("");

    //Buttons
    private Button btnSubmit = new Button("Submit");
    private Button btnCancel = new Button("Cancel");


    public void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Computer case");
        window.setMinWidth(650);
        window.setMinHeight(400);

        GridPane gridPane = dialogTemplate.addComponentGridPane();

        gridPane.add(new Label("Dimensions (HxLxD):"), 0, 5);
        gridPane.add(dimensions, 1,5);
        gridPane.add(dimensionsErrorLbl, 2, 5);
        dimensions.setPromptText("H x L x D");
        dimensionsErrorLbl.setStyle("-fx-text-fill: red;");
        dimensionsErrorLbl.setWrapText(true);

        gridPane.add(new Label("Color:"), 0, 6);
        gridPane.add(color, 1,6);
        gridPane.add(colorErrorLbl,2,6);
        color.setPromptText("Color");
        colorErrorLbl.setStyle("-fx-text-fill: red;");
        colorErrorLbl.setWrapText(true);

        gridPane.add(btnSubmit, 0, 9);
        gridPane.add(btnCancel, 1, 9);
        btnSubmit.setStyle("-fx-background-color: lightgreen; -fx-border-color: black;");
        btnCancel.setStyle("-fx-background-color: #B30000; -fx-text-fill: white; -fx-border-color: black");

        gridPane.setAlignment(Pos.CENTER);

        btnCancel.setOnAction(e -> window.close());
        btnSubmit.setOnAction(e -> submitComputerCase(window));

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

    private void submitComputerCase(Stage window) {

        try {
            dialogTemplate.clearErrorLabels();
            colorErrorLbl.setText("");
            dimensionsErrorLbl.setText("");
            double priceDouble = 0;
            double pvDouble = 0;

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

            ComputerCaseRegistry.addComponent(new ComputerCaseModel(dialogTemplate.getName(), dialogTemplate.getBrand(), priceDouble, pvDouble, dimensions.getText(),color.getText()));
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
        } catch (InvalidDimensionsException ide) {
            dimensionsErrorLbl.setText(ide.getMessage());
        } catch (InvalidColorException ise) {
            colorErrorLbl.setText(ise.getMessage());
        }
    }

}
