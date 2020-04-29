package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import org.oslomet.ComponentClasses.ComputerCaseModel;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
        computerCaseArray.remove(computerCase);
    }

    public static void removeAll() {
        computerCaseArray.clear();
    }

    public static ArrayList returnArray() {

        ArrayList computerCaseList = new ArrayList();
        for (ComputerCaseModel computerCase : computerCaseArray) {
            computerCaseList.add(computerCase);
        }
        return computerCaseList;
    }

    //Adds objects from jobj files to array (register) when they are read in filehandling
    public static  void addComputerCaseFromJobjToArray(ArrayList<ComputerCaseModel> list) {
        for (ComputerCaseModel computerCase : list) {
            computerCaseArray.add(computerCase);
        }
    }

    public ObservableList<ComputerCaseModel> filterByName(String name) {
        return computerCaseArray.stream().filter(cc -> cc.getName().
                toLowerCase().matches(String.format("%s%s%s", ".*", name.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<ComputerCaseModel> filterByBrand(String brand) {
        return computerCaseArray.stream().filter(cc -> cc.getBrand().
                toLowerCase().matches(String.format("%s%s%s", ".*", brand.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<ComputerCaseModel> filterByPrice(String price) {
        return computerCaseArray.stream().
                filter(cc -> String.valueOf(cc.getPrice()).contains(price)).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<ComputerCaseModel> filterByPerformanceValue(String performanceValue) {
        return computerCaseArray.stream().
                filter(cc -> String.valueOf(cc.getPerformanceValue()).contains(performanceValue)).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<ComputerCaseModel> filterByDimension(String dimension) {
        return computerCaseArray.stream().filter(cc -> cc.getDimensions().
                toLowerCase().matches(String.format("%s%s%s", ".*", dimension.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<ComputerCaseModel> filterByColor(String color) {
        return computerCaseArray.stream().filter(cc -> cc.getColor().
                toLowerCase().matches(String.format("%s%s%s", ".*", color.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public static ComputerCaseModel computerCaseExists(String computerCaseName) {
        for (ComputerCaseModel computerCase : computerCaseArray) {
            if (computerCase.getName().equals(computerCaseName)) {
                return computerCase;
            }
        }
        return null;
    }
}


