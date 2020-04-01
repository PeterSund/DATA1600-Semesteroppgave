package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.GPUModel;
import org.oslomet.ComponentClasses.HarddriveModel;

public class HardDriveRegistry implements RegistryMethods {

    //Initialize array
    private static ObservableList<HarddriveModel> hardDriveArray = FXCollections.observableArrayList();

    public static void attachTableView(TableView tv) {
        tv.setItems(hardDriveArray);
    }

    //Add component to array
    public static void addComponent(HarddriveModel hardDrive) {
        hardDriveArray.add(hardDrive);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(HarddriveModel hardDrive) {
        for (HarddriveModel obj : hardDriveArray) {
            if (obj.getName().equals(hardDrive.getName())) {
                hardDriveArray.remove(hardDrive);
            }
        }
    }
}
