package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.CPUModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CPURegistry implements RegistryMethods, Serializable {
    //private static final long serialVersionUID = 1;

    //Initialize array
    private transient static ObservableList<CPUModel> cpuArray = FXCollections.observableArrayList();

    public static void attachTableView(TableView tv) {
        tv.setItems(cpuArray);
    }

    //Add component to array
    public static void addComponent(CPUModel cpu) {
        cpuArray.add(cpu);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(CPUModel cpu) {
        cpuArray.remove(cpu);
    }

    public static void removeAll() {
        cpuArray.clear();
    }

    public static ArrayList returnArray() {
        ArrayList cpuList = new ArrayList();
        for (CPUModel cpu : cpuArray) {
            cpuList.add(cpu);
        }
        return cpuList;
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
    

    public static  void addCPUFromJobjToArray(ArrayList<CPUModel> list) {
        for (CPUModel cpu : list) {
            cpuArray.add(cpu);
        }
    }
}
