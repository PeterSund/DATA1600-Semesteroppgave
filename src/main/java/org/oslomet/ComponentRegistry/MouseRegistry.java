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
import org.oslomet.ComponentClasses.MouseModel;
import org.oslomet.ComponentClasses.PSUModel;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
        mouseArray.remove(mouse);
    }

    public static void removeAll() {
        mouseArray.clear();
    }

    public static ArrayList returnArray() {
        ArrayList mouseList = new ArrayList();
        for (MouseModel mouse : mouseArray) {
            mouseList.add(mouse);
        }
        return mouseList;
    }

    public static  void addMouseFromJobjToArray(ArrayList<MouseModel> list) {
        for (MouseModel mouse : list) {
            mouseArray.add(mouse);
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
    public ObservableList<MouseModel> filterByWireless(String wireless) {
        return mouseArray.stream().filter(mm -> mm.getWireless().
                toLowerCase().matches(String.format("%s%s%s", ".*", wireless.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public static MouseModel mouseExists(String mouseName) {

        for (MouseModel mouse : mouseArray) {
            if (mouse.getName().equals(mouseName)) {
                return mouse;
            }
        }

        return null;
    }

}







