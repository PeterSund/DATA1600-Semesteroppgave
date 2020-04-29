package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.oslomet.ComponentClasses.MotherboardModel;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
        motherboardArray.remove(motherboard);
    }

    public static ArrayList returnArray() {
        ArrayList motherboardList = new ArrayList();
        for (MotherboardModel motherboard : motherboardArray) {
            motherboardList.add(motherboard);
        }
        return motherboardList;
    }

    public static void removeAll() {
        motherboardArray.clear();
    }

    //Adds objects from jobj files to array (register) when they are read in filehandling
    public static  void addMotherboardFromJobjToArray(ArrayList<MotherboardModel> list) {
        for (MotherboardModel motherboard : list) {
            motherboardArray.add(motherboard);
        }
    }


    public ObservableList<MotherboardModel> filterByName(String name) {
        return motherboardArray.stream().filter(mb -> mb.getName().
                toLowerCase().matches(String.format("%s%s%s", ".*", name.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public ObservableList<MotherboardModel> filterByBrand(String brand) {
        return motherboardArray.stream().filter(mb -> mb.getBrand().
                toLowerCase().matches(String.format("%s%s%s", ".*", brand.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public ObservableList<MotherboardModel> filterByPrice(String price) {
        return motherboardArray.stream().
                filter(mb -> String.valueOf(mb.getPrice()).contains(price)).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public ObservableList<MotherboardModel> filterByPerformanceValue(String performanceValue) {
        return motherboardArray.stream().
                filter(mb -> String.valueOf(mb.getPerformanceValue()).contains(performanceValue)).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public ObservableList<MotherboardModel> filterByType(String type) {
        return motherboardArray.stream().filter(mb -> mb.getBrand().
                toLowerCase().matches(String.format("%s%s%s", ".*", type.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public static MotherboardModel motherBoardExists(String motherBoardName) {

        for (MotherboardModel motherBoard : motherboardArray) {
            if (motherBoard.getName().equals(motherBoardName)) {
                return motherBoard;
            }
        }

        return null;
    }
}
