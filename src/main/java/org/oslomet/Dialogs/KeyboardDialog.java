package org.oslomet.Dialogs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.KeyboardModel;
import org.oslomet.ComponentRegistry.KeyboardRegistry;
import org.oslomet.ExceptionClasses.*;
import org.oslomet.Validation.AdminInputValidation;

public class KeyboardDialog {

    DialogTemplate dialogTemplate = new DialogTemplate();

    //Text fields and combo boxes
    ComboBox type = new ComboBox();
    TextField language = new TextField();
    ComboBox wireless = new ComboBox();

    //Error labels
    Label languageErrorLbl = new Label("");

    //Buttons
    Button btnSubmit = new Button("Submit");
    Button btnCancel = new Button("Cancel");

    public void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Keyboard");
        window.setMinWidth(650);
        window.setMinHeight(500);

        GridPane gridPane = dialogTemplate.addComponentGridPane();

        gridPane.add(new Label("Type:"), 0, 5);
        gridPane.add(type, 1, 5);
        type.getItems().addAll("Office", "Gaming", "Mechanical");
        type.setValue("Office");

        gridPane.add(language, 1, 6);
        gridPane.add(new Label("Language:"), 0, 6);
        gridPane.add(languageErrorLbl, 2, 6);
        language.setPromptText("Language");
        languageErrorLbl.setStyle("-fx-text-fill: red;");
        languageErrorLbl.setWrapText(true);

        gridPane.add(new Label("Wireless:"), 0, 7);
        gridPane.add(wireless, 1, 7);
        wireless.getItems().addAll("Yes", "No");
        wireless.setValue("Yes");

        gridPane.add(btnSubmit, 0, 10);
        gridPane.add(btnCancel, 1, 10);
        btnSubmit.setStyle("-fx-background-color: lightgreen; -fx-border-color: black;");
        btnCancel.setStyle("-fx-background-color: #B30000; -fx-text-fill: white; -fx-border-color: black");

        btnCancel.setOnAction(e -> window.close());
        btnSubmit.setOnAction(e -> submitKeyboard(window));

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

    private void submitKeyboard(Stage window) {

        try {
            dialogTemplate.clearErrorLabels();
            languageErrorLbl.setText("");
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

            KeyboardRegistry.addComponent(new KeyboardModel(dialogTemplate.getName(), dialogTemplate.getBrand(), priceDouble, pvDouble, type.getValue().toString(), language.getText(), wireless.getValue().toString()));
            window.close();

        } catch (InvalidNameException ine) {
            dialogTemplate.setNameErrorLblName(ine.getMessage());
        } catch (InvalidBrandException ibe) {
            dialogTemplate.setBrandErrorLblName(ibe.getMessage());
        } catch (InvalidPriceException ipe) {
            dialogTemplate.setPriceErrorLbl(ipe.getMessage());
        } catch (InvalidPerformanceValueException ipve) {
            dialogTemplate.setPerformanceValueErrorLbl(ipve.getMessage());
        } catch (InvalidLanguageException ile) {
            languageErrorLbl.setText(ile.getMessage());
        }

    }
}
