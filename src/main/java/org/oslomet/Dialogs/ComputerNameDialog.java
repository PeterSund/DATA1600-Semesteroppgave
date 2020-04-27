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
import org.oslomet.ComputerClasses.ComputerRegistry;

public class ComputerNameDialog {

    private TextField txtName = new TextField();
    private Label lblError = new Label();
    private Button btnSubmit = new Button("Submit");
    private Button btnCancel = new Button("Cancel");

    String computerName = null;

    public String display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Enter a name");
        window.setMinWidth(600);
        window.setMinHeight(300);

        btnCancel.setOnAction(e -> window.close());
        btnSubmit.setOnAction(e -> submitName(window, txtName, lblError));

        GridPane gridPane = new GridPane();
        gridPane.add(txtName,1,1);
        gridPane.add(lblError, 2, 1);
        gridPane.add(btnSubmit,1,2);
        gridPane.add(btnCancel,2,2);

        gridPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(gridPane);
        window.setScene(scene);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                btnSubmit.fire();
            }
            else if (e.getCode() == KeyCode.ESCAPE) {
                btnCancel.fire();
            }
        });

        window.showAndWait();
        return computerName;
    }

    private void submitName(Stage window, TextField name, Label error) {
        String inputName = name.getText();
        if (ComputerRegistry.computerNameExists(inputName)) {
            error.setText(inputName + " is already in use. Please choose another name.");
        }
        else if (inputName.strip().equals("")) {
            error.setText("Computer name cannot be blank. Please choose another name.");
        }
        else {
            computerName = inputName;
            window.close();
        }
    }
}
