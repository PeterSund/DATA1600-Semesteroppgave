package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.RAMModel;

public class RAMRegistry implements RegistryMethods  {
    //Initialize array
    private static ObservableList<RAMModel> ramArray = FXCollections.observableArrayList();
    public static void attachTableView(TableView tv) {
        tv.setItems(ramArray);
    }

    //Add component to array
    public static void addComponent(RAMModel ram) {
        ramArray.add(ram);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(RAMModel ram) {
        for (RAMModel obj : ramArray) {
            if (obj.getName().equals(ram.getName())) {
                ramArray.remove(ram);
            }
        }
    }
}

