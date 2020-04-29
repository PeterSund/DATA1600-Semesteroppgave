package org.oslomet.Dialogs;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class HelpDialog {

    public void helpDialog(String helpText, String header) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Help");
        window.setMinWidth(600);
        window.setMinHeight(300);

        GridPane grid = new GridPane();
        Button btnOK = new Button("OK");
        grid.setPadding(new Insets(15));

        window.setTitle("Help");

        Label headerHelp = new Label();
        Label text = new Label();

        headerHelp.setText(header);
        text.setText(helpText);

        headerHelp.setStyle("-fx-font-size: 20px; -fx-font-weight: bold");
        text.setStyle("-fx-font-size: 14px;");

        grid.add(headerHelp,1,1);
        grid.add(text,1, 2);
        grid.add(btnOK, 2,3);

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
        String header = "My configurations";

        String helpText =
        "\nThis is an overview of all configurations." + "\n\n" +
        "Name can be edited in the table. Double-click the the cell you want to edit." + "\n\n" +
        "Edit configuration:\n" +
        "Select a computer from the table and press «Edit configuration» to edit" + "\n\n" +
        "New configuration:\n" +
        "Create a new configuration." + "\n\n" +
        "Delete configuration:\n" +
        "Select a computer from the table and press «Delete configuration» to delete" + "\n\n" +
        "Load configuration:\n" +
        "Load a .csv-file with an configuration" + "\n\n" +
        "Save configuration:\n" +
        "Saves selected configuration to a .cvs-file. Semicolon (;) is used as separator." + "\n\n" +
        "Admin login:\n" +
        "Enter username and password to access admin-page\n";
        helpDialog(helpText, header);
    }

    public void showEditConfigHelp() {
        String header = "Edit configuration";
        String helpText =
        "\nThis is a window for editing a configuration." + "\n\n" +
        "Name can be edited in the table. Double-click the the cell you want to edit." + "\n\n" +
        "Menu:\n" +
        "Select the component you wish to process by pressing the components buttons.\n" +
        "This will bring up a table of all available models of the selected component.\nDouble-click to add to the configuration. The table is sortable.\n" +
        "Press the red X to delete a component from your configuration. " + "\n\n" +
        "Performance value:\n" +
        "All components has a performance value which represent the performance a user can expect.\n " +
        "The total performance value is used illustrate the performance a user can expected from their configuration\n " +
        "depending on their choice of components. " +
        "This is shown graphical on the right side of the window. " + "\n\n" +
        "Save configuration:\n" +
        "Saves the configuration and brings the user back to the overview screen." + "\n\n" +
        "Admin login:\n" +
        "Enter username and password to access admin-page\n";
        helpDialog(helpText, header);
    }

    public void showAdminHelp() {
        String header = "Admin";
        String helpText =
        "\nThis is a window for editing components used in configurations" + "\n\n" +
        "Menu:\n" +
        "Select the type of component you wish to edit from the menu on the left side.\n" +
        "This will bring up a table of all available models of the selected component." + "\n\n" +
        "Table: " + "\n" +
        "The table is fully editable. Double-click the cell you wish to alter." + "\n\n" +
        "Filter:\n" +
        "Use the search input field to filter through the table.\n" +
        "Use the dropdown-menu to select which category you wish to filter.\n" +
        "The filter function shows every row that contains the input. " + "\n\n" +
        "Add component:\n" +
        "Add a new component of the type selected" + "\n\n" +
        "Delete component:\n" +
        "Select a component from the table to delete. Press «Delete component» to delete." + "\n\n" +
        "Load:\n" +
        "Load a .jobj-file with components" + "\n\n" +
        "Save:\n" +
        "Save all components to a .jobj-file. " + "\n\n" +
        "Logout:\n" +
        "Leave the admin page and return to «My configurations»\n";
        helpDialog(helpText, header);
    }

}
