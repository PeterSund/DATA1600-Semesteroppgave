package org.oslomet.ComponetRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.oslomet.ComponentClasses.MouseModel;

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
}


