package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.CPUModel;
import org.oslomet.ComponentClasses.MotherboardModel;
import org.oslomet.ComponentClasses.PSUModel;

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
        for (MotherboardModel obj : motherboardArray) {
            if (obj.getName().equals(motherboard.getName())) {
                motherboardArray.remove(motherboard);
            }
        }
    }

    public static ObservableList returnArray() {
        return motherboardArray;
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

    public ObservableList<MotherboardModel> filterByPrice(double price) {
        return motherboardArray.stream().
                filter(mb -> mb.getPrice() == price).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public ObservableList<MotherboardModel> filterByPerformanceValue(double performanceValue) {
        return motherboardArray.stream().
                filter(mb -> mb.getPerformanceValue() == performanceValue).
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
