package org.oslomet.Dialogs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginDialog {

    //Textfields
    TextField username = new TextField();
    PasswordField password = new PasswordField();

    //Error labels
    Label usernameErrorLbl = new Label("");
    Label passwordErrorLbl = new Label("");

    //Buttons
    private Button btnLogin = new Button("Login");
    private Button btnCancel = new Button("Cancel");

    boolean loginCorrect = false;

    public boolean display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Login");
        window.setMinWidth(600);
        window.setMinHeight(300);

        GridPane gridPane = new GridPane();

        gridPane.add(new Label("Username"), 0, 4);
        gridPane.add(username, 1, 4);
        gridPane.add(usernameErrorLbl, 2, 4);
        username.setPromptText("Username");

        gridPane.add(new Label("Password"), 0, 5);
        gridPane.add(password, 1, 5);
        gridPane.add(passwordErrorLbl, 2, 5);
        password.setPromptText("Password");

        gridPane.add(btnLogin, 0, 7);
        gridPane.add(btnCancel, 1, 7);
        btnCancel.setOnAction(e -> window.close());
        btnLogin.setOnAction(e -> login(window));

        gridPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(gridPane);
        window.setScene(scene);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                btnLogin.fire();
            }
            else if (e.getCode() == KeyCode.ESCAPE) {
                btnCancel.fire();
            }
        });

        window.showAndWait();

        return loginCorrect;
    }

    private void login(Stage window) {
        boolean usernameCorrect = false;
        boolean passwordCorrect = false;

        if (username.getText().equals("Admin")) {
            usernameCorrect = true;
            usernameErrorLbl.setText("");
        } else {
            usernameErrorLbl.setText("Incorrect username");
        }

        if (password.getText().equals("pass")) {
            passwordCorrect = true;
            passwordErrorLbl.setText("");
        } else {
            passwordErrorLbl.setText("Incorrect password");
        }
        if (usernameCorrect && passwordCorrect) {
            window.close();
            loginCorrect = true;
        } else {
            loginCorrect = false;
        }
    }
}



