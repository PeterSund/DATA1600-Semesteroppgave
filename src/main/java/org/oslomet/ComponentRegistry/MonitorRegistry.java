package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.KeyboardModel;
import org.oslomet.ComponentClasses.MonitorModel;

import java.util.stream.Collectors;

public class MonitorRegistry implements RegistryMethods {

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

    public ObservableList<MonitorModel> filterByName(String name) {
        return monitorArray.stream().filter(m -> m.getName().
                toLowerCase().matches(String.format("%s%s%s", ".*", name.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public ObservableList<MonitorModel> filterByBrand(String brand) {
        return monitorArray.stream().filter(m -> m.getBrand().
                toLowerCase().matches(String.format("%s%s%s", ".*", brand.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public ObservableList<MonitorModel> filterByPrice(double price) {
        return monitorArray.stream().
                filter(m -> m.getPrice() == price).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public ObservableList<MonitorModel> filterByPerformanceValue(double performanceValue) {
        return monitorArray.stream().
                filter(m -> m.getPerformanceValue() == performanceValue).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public ObservableList<MonitorModel> filterBySize(int size) {
        return monitorArray.stream().
                filter(m -> m.getSize() == size).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
}
