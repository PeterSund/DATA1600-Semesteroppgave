package org.oslomet.ComponentDialogs;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.oslomet.ComponentClasses.CPUModel;
import org.oslomet.ComponentRegistry.CPURegistry;
import org.oslomet.ExceptionClasses.*;

public class CPUDialog {

    //TextFields for CPU dialog-box
    private TextField name = new TextField();
    private TextField brand = new TextField();
    private TextField price = new TextField();
    private TextField performanceValue = new TextField();
    private TextField clockSpeed = new TextField();
    private TextField cores = new TextField();

    //Labels for displaying error in CPU dialog-box
    private Label nameErrorLbl = new Label();
    private Label brandErrorLbl = new Label();
    private Label priceErrorLbl = new Label();
    private Label performanceValueErrorLbl = new Label();
    private Label coresErrorLbl = new Label("");
    private Label clockspeedErrorLbl = new Label("");

    //Buttons
    private Button btnSubmit = new Button("Submit");
    private Button btnCancel = new Button("Cancel");

    //Template grid for dialog-box
    public GridPane addComponentGridPane() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(name, 1, 0);
        grid.add(brand, 1,1);
        grid.add(price, 1,2);
        grid.add(performanceValue, 1,3);

        grid.add(nameErrorLbl, 2, 0);
        grid.add(brandErrorLbl, 2, 1);
        grid.add(priceErrorLbl, 2,2);
        grid.add(performanceValueErrorLbl, 2, 3);

        name.setPromptText("Name");
        brand.setPromptText("Brand");
        price.setPromptText("Price");
        performanceValue.setPromptText("Performance-value");

        grid.add(new Label("Name:"), 0, 0);
        grid.add(new Label("Brand:"), 0, 1);
        grid.add(new Label("Price:"), 0, 2);
        grid.add(new Label("Performance-value (0-100):"), 0, 3);

        return grid;
    }

    public void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("CPU");
        window.setMinWidth(600);
        window.setMinHeight(300);

        GridPane gridPane = addComponentGridPane();
        gridPane.add(clockspeedErrorLbl, 2, 4);
        gridPane.add(coresErrorLbl,2,5);
        gridPane.add(new Label("Clockspeed:"), 0, 4);
        gridPane.add(clockSpeed, 1,4);
        gridPane.add(new Label("No. cores:"), 0, 5);
        gridPane.add(cores, 1,5);
        gridPane.add(btnSubmit, 0, 6);
        gridPane.add(btnCancel, 1, 6);
        gridPane.setAlignment(Pos.CENTER);

        clockSpeed.setPromptText("Clockspeed (GHz)");
        cores.setPromptText("No. cores");

        btnCancel.setOnAction(e -> window.close());
        btnSubmit.setOnAction(e -> submitCPU(window));

        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.showAndWait();
    }

    private void submitCPU(Stage window) {
        //clearErrorLabels();
        //clockspeedErrorLbl.setText("");
        //coresErrorLbl.setText("");
        double priceDouble = 0;
        double pvDouble = 0;
        double clockSpeedDouble = 0;
        int coresInt = 0;

        try {
            try {
                priceDouble = Double.parseDouble(price.getText());
            } catch (NumberFormatException nfe) {
                priceErrorLbl.setText("Price must be a number");
            }
            try {
                pvDouble = Double.parseDouble(performanceValue.getText());
            } catch (NumberFormatException nfe) {
                performanceValueErrorLbl.setText("Performancevalue must be a number");
            }
            try {
                clockSpeedDouble = Double.parseDouble(clockSpeed.getText());
            } catch (NumberFormatException nfe) {
                clockspeedErrorLbl.setText("Clockspeed must be a number");
            }
            try {
                coresInt = Integer.parseInt(cores.getText());
            } catch (NumberFormatException nfe) {
                coresErrorLbl.setText("Cores must be a number");
            }

            CPURegistry.addComponent(new CPUModel(name.getText(), brand.getText(), priceDouble, pvDouble, clockSpeedDouble, coresInt));
            window.close();
        }

        catch (InvalidNameException ine) {
            nameErrorLbl.setText(ine.getMessage());
        } catch (InvalidBrandException ibe) {
            brandErrorLbl.setText(ibe.getMessage());
        } catch (InvalidPriceException ipe) {
            priceErrorLbl.setText(ipe.getMessage());
        } catch (InvalidPerformanceValueException ipve) {
            performanceValueErrorLbl.setText(ipve.getMessage());
        } catch (InvalidClockSpeedException icse) {
            clockspeedErrorLbl.setText(icse.getMessage());
        } catch (InvalidCoresException ice) {
            coresErrorLbl.setText(ice.getMessage());
        }
    }

}


