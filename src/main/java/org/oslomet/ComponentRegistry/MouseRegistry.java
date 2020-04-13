package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.MouseModel;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MouseRegistry implements RegistryMethods  {
    //Initialize array
    private static ObservableList<MouseModel> mouseArray = FXCollections.observableArrayList();
    public static void attachTableView(TableView tv) {
        tv.setItems(mouseArray);
    }

    //Add component to array
    public static void addComponent(MouseModel mouse) {
        mouseArray.add(mouse);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(MouseModel mouse) {
        for (MouseModel obj : mouseArray) {
            if (obj.getName().equals(mouse.getName())) {
                mouseArray.remove(mouse);
            }
        }
    }

    public ObservableList<MouseModel> filterByName(String name) {
        return mouseArray.stream().filter(mm -> mm.getName().
                toLowerCase().matches(String.format("%s%s%s", ".*", name.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<MouseModel> filterByBrand(String brand) {
        return mouseArray.stream().filter(mm -> mm.getBrand().
                toLowerCase().matches(String.format("%s%s%s", ".*", brand.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<MouseModel> filterByPrice(double price) {
        return mouseArray.stream().
                filter(mm -> mm.getPrice() == price).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<MouseModel> filterByPerformanceValue(double performanceValue) {
        return mouseArray.stream().
                filter(mm -> mm.getPerformanceValue() == performanceValue).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<MouseModel> filterByType(String type) {
        return mouseArray.stream().filter(mm -> mm.getType().
                toLowerCase().matches(String.format("%s%s%s", ".*", type.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<MouseModel> filterByWireless(boolean wireless) {
        return mouseArray.stream().filter(mm -> mm.isWireless() == wireless).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

}







