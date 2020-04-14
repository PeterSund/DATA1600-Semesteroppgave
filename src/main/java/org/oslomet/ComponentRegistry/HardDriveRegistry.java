package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.CPUModel;
import org.oslomet.ComponentClasses.GPUModel;
import org.oslomet.ComponentClasses.HarddriveModel;

import java.util.stream.Collectors;

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

    public static ObservableList returnArray() {
        return hardDriveArray;
    }

    public ObservableList<HarddriveModel> filterByName(String name) {
        return hardDriveArray.stream().filter(hd -> hd.getName().
                toLowerCase().matches(String.format("%s%s%s", ".*", name.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<HarddriveModel> filterByBrand(String brand) {
        return hardDriveArray.stream().filter(hd -> hd.getBrand().
                toLowerCase().matches(String.format("%s%s%s", ".*", brand.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<HarddriveModel> filterByPrice(double price) {
        return hardDriveArray.stream().
                filter(hd -> hd.getPrice() == price).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<HarddriveModel> filterByPerformanceValue(double performanceValue) {
        return hardDriveArray.stream().
                filter(hd -> hd.getPerformanceValue() == performanceValue).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<HarddriveModel> filterByType(String type) {
        return hardDriveArray.stream().filter(hd -> hd.getBrand().
                toLowerCase().matches(String.format("%s%s%s", ".*", type.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<HarddriveModel> filterByCapacity(int capacity) {
        return hardDriveArray.stream().
                filter(gpu -> gpu.getCapacity() == capacity).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public static HarddriveModel hardDriveExists(String hardDriveName) {

        for (HarddriveModel hardDrive : hardDriveArray) {
            if (hardDrive.getName().equals(hardDriveName)) {
                return hardDrive;
            }
        }

        return null;
    }
}
