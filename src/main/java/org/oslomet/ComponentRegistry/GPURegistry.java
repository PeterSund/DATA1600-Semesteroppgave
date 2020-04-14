package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.CPUModel;
import org.oslomet.ComponentClasses.GPUModel;

import java.util.stream.Collectors;

public class GPURegistry implements RegistryMethods {

    //Initialize array
    private static ObservableList<GPUModel> gpuArray = FXCollections.observableArrayList();

    public static void attachTableView(TableView tv) {
        tv.setItems(gpuArray);
    }


    //Add component to array
    public static void addComponent(GPUModel gpu) {
        gpuArray.add(gpu);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(GPUModel gpu) {
        for (GPUModel obj : gpuArray) {
            if (obj.getName().equals(gpu.getName())) {
                gpuArray.remove(gpu);
            }
        }
    }

    public static ObservableList returnArray() {
        return gpuArray;
    }

    public ObservableList<GPUModel> filterByName(String name) {
        return gpuArray.stream().filter(gpu -> gpu.getName().
                toLowerCase().matches(String.format("%s%s%s", ".*", name.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<GPUModel> filterByBrand(String brand) {
        return gpuArray.stream().filter(gpu -> gpu.getBrand().
                toLowerCase().matches(String.format("%s%s%s", ".*", brand.toLowerCase(),
                ".*"))).collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<GPUModel> filterByPrice(double price) {
        return gpuArray.stream().
                filter(cpu -> cpu.getPrice() == price).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<GPUModel> filterByPerformanceValue(double performanceValue) {
        return gpuArray.stream().
                filter(gpu -> gpu.getPerformanceValue() == performanceValue).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<GPUModel> filterByClockSpeed(double clockSpeed) {
        return gpuArray.stream().
                filter(gpu -> gpu.getPerformanceValue() == clockSpeed).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    public ObservableList<GPUModel> filterByMemory(int memory) {
        return gpuArray.stream().
                filter(gpu -> gpu.getMemory() == memory).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public static GPUModel gpuExists(String gpuName) {

        for (GPUModel gpu : gpuArray) {
            if (gpu.getName().equals(gpuName)) {
                return gpu;
            }
        }

        return null;
    }
}



