package org.oslomet.ComponentDialogs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.ComputerCaseModel;
import org.oslomet.ComponentRegistry.ComputerCaseRegistry;
import org.oslomet.ExceptionClasses.*;

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
        window.setMinWidth(600);
        window.setMinHeight(300);

        GridPane gridPane = dialogTemplate.addComponentGridPane();

        gridPane.add(new Label("Dimensions (HxLxD):"), 0, 4);
        gridPane.add(dimensions, 1,4);
        gridPane.add(dimensionsErrorLbl, 2, 4);
        dimensions.setPromptText("H x L x D");

        gridPane.add(new Label("Color:"), 0, 5);
        gridPane.add(color, 1,5);
        gridPane.add(colorErrorLbl,2,5);
        color.setPromptText("Color");

        gridPane.add(btnSubmit, 0, 6);
        gridPane.add(btnCancel, 1, 6);

        gridPane.setAlignment(Pos.CENTER);

        btnCancel.setOnAction(e -> window.close());
        btnSubmit.setOnAction(e -> submitComputerCase(window));

        Scene scene = new Scene(gridPane);
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
                dialogTemplate.setPriceErrorLbl("Price must be a number");
            }
            try {
                pvDouble = Double.parseDouble(dialogTemplate.getPerformanceValue());
            } catch (NumberFormatException nfe) {
                dialogTemplate.setPerformanceValueErrorLbl("Performancevalue must be a number");
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
