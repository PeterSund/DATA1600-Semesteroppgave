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
        gridPane.add(yes, 1,2);
        gridPane.add(no, 2, 2);

        String userOutput = "You have not added the following components to your configuration:\n\n";
        for (int i=0; i<missingComponents.size(); i++) {
            if (i == missingComponents.size()-1) {
                userOutput += missingComponents.get(i);
            }
            else {
                userOutput += missingComponents.get(i) + ", ";
            }

        }
        userOutput += ".\n\nAre you sure you want to save the configuration?";

        gridPane.add(new Label(userOutput),1,1);

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
