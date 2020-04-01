package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.GPUModel;

public class GPURegistry implements RegistryMethods {

    //Initialize array
    private static ObservableList<GPUModel> gpuArray = FXCollections.observableArrayList();

    public static void attachTableView(TableView tv) {
        tv.setItems(gpuArray);
    }

    //Creates component
    public static GPUModel createComponent(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new GPU component");

        TextField name = new TextField();
        name.setPromptText("Name");
        TextField brand = new TextField();
        brand.setPromptText("Brand");
        TextField price = new TextField();
        price.setPromptText("Price");
        TextField performanceValue = new TextField();
        performanceValue.setPromptText("Performance-value");
        TextField clockSpeed = new TextField();
        clockSpeed.setPromptText("Clockspeed (GHz)");
        TextField memory = new TextField();
        memory.setPromptText("Memory (MB)");

        grid.add(name, 1, 0);
        grid.add(brand, 1,1);
        grid.add(price, 1,2);
        grid.add(performanceValue, 1,3);

        grid.add(new Label("Clockspeed):"), 0, 4);
        grid.add(clockSpeed, 1,4);
        grid.add(new Label("Memory:"), 0, 5);
        grid.add(memory, 1,5);
        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        double priceDouble = Double.parseDouble(price.getText());
        double pvDouble = Double.parseDouble(performanceValue.getText());

        int clockSpeedInt = Integer.parseInt(clockSpeed.getText());
        int memoryInt = Integer.parseInt(memory.getText());

        GPUModel obj = new GPUModel(name.getText(), brand.getText(), priceDouble, pvDouble, clockSpeedInt, memoryInt);

        String info =  name.getText() + ", " + brand.getText() + "," + price.getText() + ", " + performanceValue.getText() + ", "
                + clockSpeedInt + ", " + memoryInt + "\n";
        System.out.print(info);

        return obj;
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



