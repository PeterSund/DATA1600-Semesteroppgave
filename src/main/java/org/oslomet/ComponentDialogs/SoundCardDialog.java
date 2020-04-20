package org.oslomet.ComponentDialogs;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.SoundCardModel;
import org.oslomet.ComponentRegistry.SoundCardRegistry;
import org.oslomet.ExceptionClasses.InvalidBrandException;
import org.oslomet.ExceptionClasses.InvalidNameException;
import org.oslomet.ExceptionClasses.InvalidPerformanceValueException;
import org.oslomet.ExceptionClasses.InvalidPriceException;

public class SoundCardDialog {

    DialogTemplate dialogTemplate = new DialogTemplate();

    //Combo boxes
    ComboBox surround = new ComboBox();
    ComboBox bassboost = new ComboBox();

    //Buttons
    Button btnSubmit = new Button("Submit");
    Button btnCancel = new Button("Cancel");

    public void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Sound card");
        window.setMinWidth(600);
        window.setMinHeight(300);

        GridPane gridPane = dialogTemplate.addComponentGridPane();

        surround.getItems().addAll("Yes", "No");
        surround.setValue("Yes");

        bassboost.getItems().addAll("Yes", "No", "Mega");
        bassboost.setValue("Yes");

        gridPane.add(new Label("Surround: "), 0, 4);
        gridPane.add(surround, 1,4);
        gridPane.add(new Label("Bassboost: "), 0, 5);
        gridPane.add(bassboost, 1,5);

        gridPane.add(btnSubmit, 0, 6);
        gridPane.add(btnCancel, 1, 6);
        btnSubmit.setOnAction(e -> submitSoundCard(window));
        btnCancel.setOnAction(e -> window.close());

        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.showAndWait();
    }

    private void submitSoundCard(Stage window) {

        try {
            dialogTemplate.clearErrorLabels();
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

            SoundCardRegistry.addComponent(new SoundCardModel(dialogTemplate.getName(), dialogTemplate.getBrand(), priceDouble, pvDouble, surround.getValue().toString(), bassboost.getValue().toString()));
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
