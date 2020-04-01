package org.oslomet.ComponentRegistry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.oslomet.ComponentClasses.CPUModel;

public class CPURegistry implements RegistryMethods {

    //Initialize array
    private static ObservableList<CPUModel> cpuArray = FXCollections.observableArrayList();

    public static void attachTableView(TableView tv) {
        tv.setItems(cpuArray);
    }

    //Creates component
    public static CPUModel createComponent(Dialog addComponentDialog, GridPane grid) {
        addComponentDialog.setHeaderText("Create new CPU component");

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
        TextField cores = new TextField();
        cores.setPromptText("No. cores");

        grid.add(name, 1, 0);
        grid.add(brand, 1,1);
        grid.add(price, 1,2);
        grid.add(performanceValue, 1,3);

        grid.add(new Label("Clockspeed:"), 0, 4);
        grid.add(clockSpeed, 1,4);
        grid.add(new Label("No. cores:"), 0, 5);
        grid.add(cores, 1,5);
        addComponentDialog.getDialogPane().setContent(grid);
        addComponentDialog.showAndWait();

        double priceDouble = Double.parseDouble(price.getText());
        double pvDouble = Double.parseDouble(performanceValue.getText());

        int clockSpeedInt = Integer.parseInt(clockSpeed.getText());
        int coresInt = Integer.parseInt(cores.getText());

        String info = name.getText() + ", " + brand.getText() + "," + price.getText() + ", " + performanceValue.getText() + ", "
                + clockSpeed.getText() + ", " + cores.getText() + "\n";
        System.out.print(info);

        CPUModel obj = new CPUModel(name.getText(), brand.getText(), priceDouble, pvDouble,
                clockSpeedInt, 0, coresInt);

        return obj;
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
