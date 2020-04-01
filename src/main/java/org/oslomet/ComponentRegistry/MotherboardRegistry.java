package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.MotherboardModel;
import org.oslomet.ComponentClasses.PSUModel;

public class MotherboardRegistry implements RegistryMethods {
    //Initialize array
    private static ObservableList<MotherboardModel> motherboardArray = FXCollections.observableArrayList();
    public static void attachTableView(TableView tv) {
        tv.setItems(motherboardArray);
    }




    //Add component to array
    public static void addComponent(MotherboardModel motherboard) {
        motherboardArray.add(motherboard);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(MotherboardModel motherboard) {
        for (MotherboardModel obj : motherboardArray) {
            if (obj.getName().equals(motherboard.getName())) {
                motherboardArray.remove(motherboard);
            }
        }
    }
}
