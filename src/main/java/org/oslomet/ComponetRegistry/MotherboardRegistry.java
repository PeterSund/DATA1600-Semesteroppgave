package org.oslomet.ComponetRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.oslomet.ComponentClasses.MotherboardModel;

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
