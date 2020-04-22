package org.oslomet.Dialogs;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class HelpDialog {

    public void helpDialog(String helpText) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Help");
        window.setMinWidth(600);
        window.setMinHeight(300);

        GridPane grid = new GridPane();
        Button btnOK = new Button("OK");

        grid.add(new Label(helpText), 1, 0);
        grid.add(btnOK, 1,1);


        btnOK.setOnAction(e -> window.close());


        Scene scene = new Scene(grid);
        window.setScene(scene);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                btnOK.fire();
            }    else if (e.getCode() == KeyCode.ESCAPE) {
                btnOK.fire();
            }
        });

        window.showAndWait();
    }

    public void showConfigHelp() {
        String helpText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque euismod libero id efficitur ultricies. " + "\n"
                + "Quisque faucibus nunc ut felis tincidunt egestas. Etiam convallis purus a purus faucibus venenatis. " + "\n" +
                "Integer tincidunt orci quis erat ultricies, et commodo odio eleifend. Curabitur vitae.";
        helpDialog(helpText);
    }

    public void showEditConfigHelp() {
        String helpText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque euismod libero id efficitur ultricies. " + "\n"
                + "Quisque faucibus nunc ut felis tincidunt egestas. Etiam convallis purus a purus faucibus venenatis. " + "\n" +
                "Integer tincidunt orci quis erat ultricies, et commodo odio eleifend. Curabitur vitae.";
        helpDialog(helpText);
    }

    public void showAdminHelp() {
        String helpText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque euismod libero id efficitur ultricies. " + "\n"
                + "Quisque faucibus nunc ut felis tincidunt egestas. Etiam convallis purus a purus faucibus venenatis. " + "\n" +
                "Integer tincidunt orci quis erat ultricies, et commodo odio eleifend. Curabitur vitae.";
        helpDialog(helpText);
    }

}
