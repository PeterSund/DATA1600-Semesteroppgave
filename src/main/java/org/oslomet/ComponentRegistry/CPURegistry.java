package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.CPUModel;

import java.util.stream.Collectors;

public class CPURegistry implements RegistryMethods {

    //Initialize array
    private static ObservableList<CPUModel> cpuArray = FXCollections.observableArrayList();

    public static void attachTableView(TableView tv) {
        tv.setItems(cpuArray);
    }

    //Add component to array
    public static void addComponent(CPUModel cpu) {
        cpuArray.add(cpu);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(CPUModel cpu) {
        for (CPUModel obj : cpuArray) {
            if (obj.getName().equals(cpu.getName())) {
                cpuArray.remove(cpu);
            }
        }
    }

    public ObservableList<CPUModel> filterByName(String name) {
        return cpuArray.stream().filter(cpu -> cpu.getName().
                toLowerCase().matches(String.format("%s%s%s", ".*", name.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<CPUModel> filterByBrand(String brand) {
        return cpuArray.stream().filter(cpu -> cpu.getBrand().
                toLowerCase().matches(String.format("%s%s%s", ".*", brand.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<CPUModel> filterByPrice(double price) {
        return cpuArray.stream().
                filter(cpu -> cpu.getPrice() == price).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<CPUModel> filterByPerformanceValue(double performanceValue) {
        return cpuArray.stream().
                filter(cpu -> cpu.getPerformanceValue() == performanceValue).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<CPUModel> filterByClockSpeed(double clockSpeed) {
        return cpuArray.stream().
                filter(cpu -> cpu.getPerformanceValue() == clockSpeed).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<CPUModel> filterByCores(int cores) {
        return cpuArray.stream().
                filter(cpu -> cpu.getCores() == cores).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public static CPUModel cpuExists(String cpuName) {

        for (CPUModel cpu : cpuArray) {
            if (cpu.getName().equals(cpuName)) {
                return cpu;
            }
        }

        return null;
    }
}
