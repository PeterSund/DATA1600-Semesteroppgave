package org.oslomet;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.oslomet.ComputerClasses.ComputerModel;
import org.oslomet.ComputerClasses.ComputerRegistry;

import java.io.IOException;
import java.time.format.TextStyle;

public class ComputerNameDialog {

    @FXML
    private TextField txtName;

    @FXML
    private Label lblError;

    @FXML
    private Button btnSubmit, btnCancel;


    String computerName = null;

    public String display() throws IOException {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Enter a name");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("nameDialog.fxml"));
        Parent root = loader.load();
        ComputerNameDialog controller = loader.getController();

        controller.btnCancel.setOnAction(e -> window.close());
        controller.btnSubmit.setOnAction(e -> submitName(window, controller.txtName, controller.lblError));

        Scene scene = new Scene(root);
        window.setScene(scene);
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

    @FXML
    void fireSubmitOrCancel(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            btnSubmit.fire();
        }
        else if (event.getCode() == KeyCode.ESCAPE) {
            btnCancel.fire();
        }
    }





}
