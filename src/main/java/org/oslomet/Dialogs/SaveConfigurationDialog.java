package org.oslomet.Dialogs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class SaveConfigurationDialog {
    private boolean submitConfirmed = false;

    public boolean display(List missingComponents) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Confirm");
        window.setMinWidth(600);
        window.setMinHeight(300);

        GridPane gridPane = new GridPane();

        Button yes = new Button("Yes");
        Button no = new Button("No");
        yes.setStyle("-fx-background-color: lightgreen; -fx-border-color: black;");
        no.setStyle("-fx-background-color: #B30000; -fx-text-fill: white; -fx-border-color: black");
        gridPane.add(yes, 1,5);
        gridPane.add(no, 2, 5);

        String msgMissingComp = "";
        for (int i=0; i<missingComponents.size(); i++) {
            if (i == missingComponents.size()-1) {
                msgMissingComp += missingComponents.get(i);
            }
            else {
                msgMissingComp += missingComponents.get(i) + ", ";
            }
        }
        msgMissingComp += "\n\n";

        Label msg = new Label("You have not added the following components to your configuration:\n\n");
        Label missingComp = new Label(msgMissingComp);
        Label confirm = new Label("Are you sure you want to save the configuration?\n\n");
        missingComp.setStyle("-fx-text-fill: red;");

        gridPane.add(msg, 1,1);
        gridPane.add(missingComp,1,2);
        gridPane.add(confirm,1,3);


        gridPane.setAlignment(Pos.CENTER);

        yes.setOnAction(e -> {
            window.close();
            submitConfirmed = true;
        });
        no.setOnAction(e -> window.close());

        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.showAndWait();

        return submitConfirmed;
    }

}
