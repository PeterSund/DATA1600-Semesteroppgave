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


