package org.oslomet.ComponetRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.oslomet.ComponentClasses.MonitorModel;

public class MonitorRegistry implements RegistryMethods  {

    //Initialize array
    private static ObservableList<MonitorModel> monitorArray = FXCollections.observableArrayList();
    public static void attachTableView(TableView tv) {
        tv.setItems(monitorArray);
    }

    //Add component to array
    public static void addComponent(MonitorModel monitor) {
        monitorArray.add(monitor);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(MonitorModel monitor) {
        for (MonitorModel obj : monitorArray) {
            if (obj.getName().equals(monitor.getName())) {
                monitorArray.remove(monitor);
            }
        }
    }
}

