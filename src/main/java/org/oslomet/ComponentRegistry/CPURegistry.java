package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.oslomet.ComponentClasses.CPUModel;

public class CPURegistry implements RegistryMethods {

    //Initialize array
    private static ObservableList<CPUModel> cpuArray = FXCollections.observableArrayList();

    public static void attachTableView(TableView tv) {
        tv.setItems(cpuArray);
    }

    //Creates component
    public static void createComponent() {

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
}
