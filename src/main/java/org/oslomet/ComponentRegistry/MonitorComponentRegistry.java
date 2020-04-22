package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.oslomet.ComponentClasses.MonitorModel;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MonitorComponentRegistry implements ComponentRegistryMethods {

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
        monitorArray.remove(monitor);
    }

    public static void removeAll() {
        monitorArray.clear();
    }

    public static ArrayList returnArray() {
        ArrayList monitorList = new ArrayList();
        for (MonitorModel monitor : monitorArray) {
            monitorList.add(monitor);
        }
        return monitorList;
    }

    //Adds objects from jobj files to array (register) when they are read in filehandling
    public static  void addMonitorFromJobjToArray(ArrayList<MonitorModel> list) {
        for (MonitorModel monitor : list) {
            monitorArray.add(monitor);
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

    public static MonitorModel monitorExists(String monitorName) {

        for (MonitorModel monitor : monitorArray) {
            if (monitor.getName().equals(monitorName)) {
                return monitor;
            }
        }

        return null;
    }
}
