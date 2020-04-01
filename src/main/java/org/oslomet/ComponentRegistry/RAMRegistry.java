package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.RAMModel;

public class RAMRegistry implements RegistryMethods  {
    //Initialize array
    private static ObservableList<RAMModel> ramArray = FXCollections.observableArrayList();
    public static void attachTableView(TableView tv) {
        tv.setItems(ramArray);
    }

    //Creates component
    public static RAMModel createComponent(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new RAM component");

        TextField name = new TextField();
        name.setPromptText("Name");
        TextField brand = new TextField();
        brand.setPromptText("Brand");
        TextField price = new TextField();
        price.setPromptText("Price");
        TextField performanceValue = new TextField();
        performanceValue.setPromptText("Performance-value");
        TextField capacity = new TextField();
        capacity.setPromptText("Capacity (MB)");
        TextField memorySpeed = new TextField();
        memorySpeed.setPromptText("Memoryspeed (MHz)");

        grid.add(name, 1, 0);
        grid.add(brand, 1,1);
        grid.add(price, 1,2);
        grid.add(performanceValue, 1,3);
        grid.add(new Label("Capacity: "), 0, 4);
        grid.add(capacity, 1,4);
        grid.add(new Label("Memoryspeed (MHz): "), 0, 5);
        grid.add(memorySpeed, 1,5);


        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        double priceDouble = Double.parseDouble(price.getText());
        double pvDouble = Double.parseDouble(performanceValue.getText());
        int capacityInt = Integer.parseInt(capacity.getText());
        double memorySpeedDouble = Double.parseDouble(memorySpeed.getText());

        String info =  name.getText() + ", " + brand.getText() + "," + price.getText() + ", " + performanceValue.getText() + ", "
                + capacityInt + ", " + memorySpeedDouble + "\n";
        System.out.print(info);


        RAMModel obj = new RAMModel(name.getText(), brand.getText(), priceDouble, pvDouble, capacityInt, memorySpeedDouble);

        return obj;

    }

    //Add component to array
    public static void addComponent(RAMModel ram) {
        ramArray.add(ram);
    }

    //Removes selected component from array by comparing names
    public static void removeComponent(RAMModel ram) {
        for (RAMModel obj : ramArray) {
            if (obj.getName().equals(ram.getName())) {
                ramArray.remove(ram);
            }
        }
    }
}

