package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.oslomet.ComponentClasses.RAMModel;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
        ramArray.remove(ram);
    }

    public static void removeAll() {
        ramArray.clear();
    }

    public static ArrayList returnArray() {
        ArrayList ramList = new ArrayList();
        for (RAMModel ram : ramArray) {
            ramList.add(ram);
        }
        return ramList;
    }

    public static void addRAMFromJobjToArray(ArrayList<RAMModel> list) {
        for (RAMModel ram : list) {
            ramArray.add(ram);
        }
    }


    public ObservableList<RAMModel> filterByName(String name) {
        return ramArray.stream().filter(r -> r.getName().
                toLowerCase().matches(String.format("%s%s%s", ".*", name.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<RAMModel> filterByBrand(String brand) {
        return ramArray.stream().filter(r -> r.getBrand().
                toLowerCase().matches(String.format("%s%s%s", ".*", brand.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<RAMModel> filterByPrice(double price) {
        return ramArray.stream().
                filter(r -> r.getPrice() == price).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<RAMModel> filterByPerformanceValue(double performanceValue) {
        return ramArray.stream().
                filter(r -> r.getPerformanceValue() == performanceValue).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<RAMModel> filterByMemory(int memory) {
        return ramArray.stream().
                filter(r -> r.getMemory() == memory).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<RAMModel> filterByMemorySpeed(double memorySpeed) {
        return ramArray.stream().
                filter(r -> r.getPerformanceValue() == memorySpeed).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public static RAMModel ramExists(String ramName) {

        for (RAMModel ram : ramArray) {
            if (ram.getName().equals(ramName)) {
                return ram;
            }
        }

        return null;
    }
}

