package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.oslomet.ComponentClasses.HarddriveModel;

import java.util.ArrayList;
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
        hardDriveArray.remove(hardDrive);
    }

    public static void removeAll() {
        hardDriveArray.clear();
    }

    public static ArrayList returnArray() {

        ArrayList hardDriveList = new ArrayList();
        for (HarddriveModel hardDrive : hardDriveArray) {
            hardDriveList.add(hardDrive);
        }
        return hardDriveList;
    }

    //Adds objects from jobj files to array (register) when they are read in filehandling
    public static  void addHardDriveFromJobjToArray(ArrayList<HarddriveModel> list) {
        for (HarddriveModel hardDrive : list) {
            hardDriveArray.add(hardDrive);
        }
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
    public ObservableList<HarddriveModel> filterByPrice(String price) {
        return hardDriveArray.stream().
                filter(hd -> String.valueOf(hd.getPrice()).contains(price)).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<HarddriveModel> filterByPerformanceValue(String performanceValue) {
        return hardDriveArray.stream().
                filter(hd -> String.valueOf(hd.getPerformanceValue()).contains(performanceValue)).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<HarddriveModel> filterByType(String type) {
        return hardDriveArray.stream().filter(hd -> hd.getType().
                toLowerCase().matches(String.format("%s%s%s", ".*", type.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<HarddriveModel> filterByCapacity(String capacity) {
        return hardDriveArray.stream().
                filter(gpu -> String.valueOf(gpu.getCapacity()).contains(capacity)).
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
