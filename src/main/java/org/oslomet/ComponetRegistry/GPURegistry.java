package org.oslomet.ComponetRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.oslomet.ComponentClasses.GPUModel;

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
}



