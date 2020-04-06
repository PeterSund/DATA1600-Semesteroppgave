package org.oslomet.ComputerClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import java.io.Serializable;

public class ComputerRegistry {

    //Initialize array
    private static ObservableList<ComputerModel> computerArray = FXCollections.observableArrayList();
    public static void attachTableView(TableView tv) {
        tv.setItems(computerArray);
    }

    //Add computer
    public static void addComputer(ComputerModel computer) {
        computerArray.add(computer);
    }

    public static String getValue() {
       String test = computerArray.get(0).getConfigName();
       return test;
    }

    //Returns index of computer if name matches
    public static int findComputer(ComputerModel inputComputer) {
        for (ComputerModel computer : computerArray) {
            if (computer.getConfigName().equals(inputComputer.getConfigName())) {
                return computerArray.indexOf(computer);
            }
        }
        return -1;
    }

    //Replaces computer in the array with a new compuer in the position of a given index
    public static void replaceComputer(ComputerModel inputComputer, int index) {
        computerArray.set(index, inputComputer);
    }
}
