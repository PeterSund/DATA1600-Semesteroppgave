package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import org.oslomet.ComponentClasses.ComputerCaseModel;

import java.util.Optional;

public class ComputerCaseRegistry implements RegistryMethods {

    //Initialize array
    private static ObservableList<ComputerCaseModel> computerCaseArray = FXCollections.observableArrayList();
    public static void attachTableView(TableView tv) {
        tv.setItems(computerCaseArray);
    }

    //Creates component
    public static Dialog createComponent(Dialog addComponentDialog, GridPane grid) {

        addComponentDialog.setHeaderText("Create new computer-case component");

        TextField dimensions = new TextField();
        dimensions.setPromptText("H x L x D");
        TextField color = new TextField();
        color.setPromptText("Color");

        grid.add(new Label("Dimensions (HxLxD):"), 0, 4);
        grid.add(dimensions, 1,4);
        grid.add(new Label("Color:"), 0, 5);
        grid.add(color, 1,5);
        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();
        String info =  ", "
                + dimensions.getText() + ", " + color.getText();
        System.out.print(info);
        return addComponentDialog;
    }

    //Add component to array
    public static void addComponent(ComputerCaseModel computerCase) {
        computerCaseArray.add(computerCase);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(ComputerCaseModel computerCase) {
        for(ComputerCaseModel obj : computerCaseArray) {
            if(obj.getName().equals(computerCase.getName())) {
                computerCaseArray.remove(computerCase);
            }
        }
    }
}


