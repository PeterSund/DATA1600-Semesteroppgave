package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.HarddriveModel;
import org.oslomet.ComponentClasses.KeyboardModel;

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
}