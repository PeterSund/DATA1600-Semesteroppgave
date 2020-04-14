package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.CPUModel;
import org.oslomet.ComponentClasses.HarddriveModel;
import org.oslomet.ComponentClasses.KeyboardModel;

import java.util.stream.Collectors;

public class KeyboardRegistry implements RegistryMethods {

    //Initialize array
    private static ObservableList<KeyboardModel> keyboardArray = FXCollections.observableArrayList();
    public static void attachTableView(TableView tv) {
        tv.setItems(keyboardArray);
    }

    //Add component to array
    public static void addComponent(KeyboardModel keyboard) {
        keyboardArray.add(keyboard);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(KeyboardModel keyboard) {
        for (KeyboardModel obj : keyboardArray) {
            if (obj.getName().equals(keyboard.getName())) {
                keyboardArray.remove(keyboard);
            }
        }
    }

    public static ObservableList returnArray() {
        return keyboardArray;
    }

    public ObservableList<KeyboardModel> filterByName(String name) {
        return keyboardArray.stream().filter(k -> k.getName().
                toLowerCase().matches(String.format("%s%s%s", ".*", name.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<KeyboardModel> filterByBrand(String brand) {
        return keyboardArray.stream().filter(k -> k.getBrand().
                toLowerCase().matches(String.format("%s%s%s", ".*", brand.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<KeyboardModel> filterByPrice(double price) {
        return keyboardArray.stream().
                filter(k -> k.getPrice() == price).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<KeyboardModel> filterByPerformanceValue(double performanceValue) {
        return keyboardArray.stream().
                filter(k -> k.getPerformanceValue() == performanceValue).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<KeyboardModel> filterByType(String type) {
        return keyboardArray.stream().filter(k -> k.getBrand().
                toLowerCase().matches(String.format("%s%s%s", ".*", type.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<KeyboardModel> filterByLanguage(String language) {
        return keyboardArray.stream().filter(k -> k.getBrand().
                toLowerCase().matches(String.format("%s%s%s", ".*", language.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public static KeyboardModel keyBoardExists(String keyboardName) {

        for (KeyboardModel keyboard : keyboardArray) {
            if (keyboard.getName().equals(keyboardName)) {
                return keyboard;
            }
        }

        return null;
    }
}